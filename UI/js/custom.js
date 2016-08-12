workflowObj = {
	settings: {
		selectedVerticalsVals : []
	},
	/*------------------ vericals popup -------------*/
	getSelectedVerticals: function(eventType){
	
	
	
		$('#servicesOptionsPopup, #productsOptionsPopup').on('hidden.bs.modal', function (e) {
			$(this).find('.panel-group').find('.panel').find('.panel-collapse').removeClass('in');
		});
		
		$('.verticals-popup').on('show.bs.modal', function (e) {
			$('#vericals-form').find(':checkbox').each(function(){
				$(this).attr('checked', false);
				$(this).next('label').removeClass('selected');
			});
		});
	
		$('.verticals-popup').on("change", ":checkbox", function() {
			if (this.checked) {
				$(this).next('label').addClass('selected');
			}else{
				$(this).next('label').removeClass('selected');
			}
		});	
		$('.btn-continue-vericals-home').click(function(){
		
			$("#verticalsPopup").modal("hide");
		 
			var selectedVerticals = [];
			$('#vericals-form').find(':checkbox').each(function(){
				if (this.checked) {
					selectedVerticals.push($(this).attr('data'));
					
				}
				});
					
					
			$('.vartical-options').find('.panel-group').find('.panel').each(function(){
					$(this).addClass('hidden');
					var panelDiv = $(this);
					for(var selval in selectedVerticals){
						if ($(panelDiv).hasClass(selectedVerticals[selval])){
							panelDiv.removeClass('hidden');
							
						}
					}
			});
			
		
			
			//$('.services-options-popup').find('.panel-group').find('.panel').not('.hidden').eq(0).find('.panel-collapse').addClass('in');
			//$('.products-options-popup').find('.panel-group').find('.panel').not('.hidden').eq(0).find('.panel-collapse').addClass('in');
			
			
		});
	
	},/*------------------ end of vericals popup -------------*/
	
	selectedProductsAccordion: function(eventType){
	
	
	$('.right-sec-content-cntr').each(function(){
		console.log($(this));
	})
		
		 
	
	}
	
	
	
	
	
}	



$(document).ready(function(){
	
	/*------------------ Search Functionality -------------*/


	$('.search-btn-main').click(function(){
		//only do something if numbers are selected
		if( $('.selectpicker1 :selected').length > 0){
		//build an array of selected values
			var selectednumbers = [];
			$('.selectpicker1 :selected').each(function(i, selected) {
				selectednumbers[i] = $(selected).val();
			});
			var selectedJson = JSON.stringify(selectednumbers);
			console.log(selectedJson);
			return false;
		}
	});
	/*------------------ Search Functionality -------------*/


	/*------------------ User Login -------------*/
	$('.signupUser').click(function(){
		$('.popup-form-cntr').addClass('hidden');
		$('.signup-form').removeClass('hidden');
		return false;
	});

	$('#myModalLogin').on('hidden.bs.modal', function (e) {
		$('.popup-form-cntr').addClass('hidden');
		$('.login-form').removeClass('hidden');
		return false;
	});

	$('.forgotPassword').click(function(){
		$('.popup-form-cntr').addClass('hidden');
		$('.forgot-password-form').removeClass('hidden');
		return false;
	});
	/*------------------ end of User Login -------------*/

	

	
	workflowObj.getSelectedVerticals();
	workflowObj.selectedProductsAccordion();
	


});
