ACC.login = {
		
	user_name: "",
	user_email: "",
		
	bindlogin: function ()
	{
		ACC.login.bindFB();
		ACC.login.bindGoogle();
		ACC.login.bindLogin();
	},

	bindFB: function ()
	{
		window.fbAsyncInit = function() {
		    FB.init({
		        appId   : '1622586648064129',
		        oauth   : true,
		        status  : true, // check login status
		        cookie  : true, // enable cookies to allow the server to access the session
		        xfbml   : true // parse XFBML
		    });

		  };
		  
	  (function() {
		    var e = document.createElement('script');
		    e.src = document.location.protocol + '//connect.facebook.net/en_US/all.js';
		    e.async = true;
		    document.getElementById('fb-root').appendChild(e);
		}());
	},
	
	bindGoogle: function ()
	{
		(function() {
			 var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;
			 po.src = 'https://apis.google.com/js/client.js?onload=googleOnLoadCallback';
			 var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);
			})();

	},
	
	fb_login: function ()
	{
		 FB.login(function(response) {
		        if (response.authResponse) {
		            console.log('Welcome!  Fetching your information.... ');
		            //console.log(response); // dump complete info
		            access_token = response.authResponse.accessToken; //get access token
		            user_id = response.authResponse.userID; //get FB UID
		            FB.api('/me', { locale: 'en_US', fields: 'name, email'}, function(response) {
		            	ACC.login.user_name = response.name;
		            	ACC.login.user_email = response.email; //get user email
		                // store this data into your database 
		                ACC.login.checkRegistration();
		            });

		        } else {
		            //user hit cancel button
		            console.log('User cancelled login or did not fully authorize.');

		        }
		    }, {
		        scope: 'publish_stream,email'
		    });
		
	},
	
	google_login: function()
	{
		var myParams = {
		    'clientid' : '838327630667-4s7visper5eq9i1okkukcmt09518c0p5.apps.googleusercontent.com', //You need to set client id
		    'cookiepolicy' : 'single_host_origin',
		    'callback' : 'googleLoginCallback', //callback function
		    'approvalprompt':'force',
		    'scope' : 'https://mail.google.com  https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/plus.me https://www.googleapis.com/auth/plus.login  '
		  };
		  gapi.auth.signIn(myParams);
	},
	
	checkRegistration: function()
	{
		 $.ajax({
			    type: "POST",
			    url: ACC.config.contextPath+'/socialLogin/check?name='+ACC.login.user_name+'&email='+ACC.login.user_email,
			    success: function(data){
			    	$('#myModalLogin').modal('toggle');
			    	if($(data).find('#ifRegistered').val() == 'true')
			    		$('#headerDiv').html($(data).find('#headerDiv').html());
			    	else
			    		$('#myModalPhone').modal('toggle');
			    },
			    failure: function(errMsg) {
			        console.log(errMsg);
			    }
		});
	},
	
	bindLogin: function()
	{
		$(document).on('submit', '#login-form', function(e) {
			e.preventDefault();
		    $.ajax({
		        url     : $(this).attr('action'),
		        type    : $(this).attr('method'),
		        data    : $(this).serialize(),
		        success : function( data ) {
		        	var errorMsg = $(data).find('.alert.negative').html();
		        	if(errorMsg != undefined)
		        		$('.form_field_error').html(errorMsg);
		        	else 
		        		$('#myModalLogin').modal('toggle');
		        	$('#headerDiv').html($(data).find('#headerDiv').html());
		        },
		        error   : function( xhr, err ) {
		                     alert('Error');     
		        }
		    });    
		    return false;
		});
	},
	
	updatePhone: function(){
		var user_phone = $('#phone').val();
		 $.ajax({
			    type: "POST",
			    url: ACC.config.contextPath+'/socialLogin/request?name='+ACC.login.user_name+'&email='+ACC.login.user_email+'&phone='+user_phone,
			    success: function(data){
			    	$('#headerDiv').html($(data).find('#headerDiv').html());
			    	$('#myModalPhone').modal('toggle');
			    	
			    },
			    failure: function(errMsg) {
			        console.log(errMsg);
			    }
		});
	}
};

$(document).ready(function ()
{
	ACC.login.bindlogin();
});

function googleLoginCallback (result)
{
	 if(result['status']['signed_in'])   {
	        var request = gapi.client.plus.people.get(       {
	            'userId': 'me'
	        });
	        request.execute(function (resp)  {
	            if(resp['emails'])   {
	                for(i = 0; i < resp['emails'].length; i++)  {
	                    if(resp['emails'][i]['type'] == 'account')  {
	                    	ACC.login.user_email = resp['emails'][i]['value'];
	                    }
	                }
	            }
	 
	            ACC.login.user_name = resp['displayName'] ;
	            ACC.login.checkRegistration();
	        });
	    }
};

function googleOnLoadCallback()
{
	 gapi.client.setApiKey('AIzaSyCPHlQcW2yhlql15_uKenfJyw1i93YbAHA'); //set your API KEY
	 gapi.client.load('plus', 'v1',function(){});//Load Google + API
};

