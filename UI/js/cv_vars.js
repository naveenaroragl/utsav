/*
// var breakpoint_wide = "screen and (min-width: 1200px)";
// var breakpoint_large = "screen and (min-width: 960px)";
// var breakpoint_medium = "screen and (max-width: 959px)";
// var breakpoint_small = "screen and (max-width: 767px)";
// var breakpoint_not_small = "screen and (min-width: 768px)";

var window_medium = 768;
var window_large = 1280;
var window_wide = 1280;


var breakpoint_wide = "screen and (min-width: " + (window_wide + 1) + "px)";
var breakpoint_large = "screen and (min-width: " + (window_large) + "px) and (max-width: " + (window_wide) + "px)";
var breakpoint_min_medium = "screen and (min-width: " + window_large + "px)";
var breakpoint_max_medium = "screen and (max-width: " + (window_large - 1) + "px)";
var breakpoint_medium = "screen and (min-width: " + (window_medium) + "px) and (max-width: " + (window_large - 1) + "px)";
var breakpoint_small = "screen and (max-width: " + (window_medium - 1) + "px)";
var breakpoint_not_small = "screen and (min-width: " + (window_medium) + "px)";

// https://github.com/JoshBarr/on-media-query
// Initial onMediaQuery call. This is the only one that should look like this.
// All subsequent calls should use MQ.addQuery()
var body_class_mq = [
	{
		context: 'small',
		match: function() {
			$('body').addClass("mq_small");
		},
		unmatch: function() {
			$('body').removeClass("mq_small");
		}
	},
	{
		context: 'medium',
		match: function() {
			$('body').addClass("mq_medium");
		},
		unmatch: function() {
			$('body').removeClass("mq_medium");
		}
	},

	{
		context: 'large',
		match: function() {
			$('body').addClass("mq_large");
		},
		unmatch: function() {
			$('body').removeClass("mq_large");
		}
	}
];

// MQ.init() should only be called once. After this, use MQ.addQuery().
if (typeof MQ !== 'undefined') {
	MQ.init(body_class_mq);
}
*/

























var ie, t, n;

queries = [
	{
		context: 'mobile',
		match: function() {
			//ie.innerHTML = 'mobile';
			console.log('mobile callback woohoo!');
		},
		unmatch: function(){
			console.log('mobile callback unmatched!');
		}
	},
	{
		context: 'skinny',
		match: function() {
			console.log('skinny callback woohoo!');
			//ie.innerHTML = 'skinny';
		},
		unmatch: function(){
			console.log('skinny callback unmatched!');
		}
	},
	{
		context: ['mobile', 'skinny'],
		call_for_each_context: false,
		match: function() {
			console.log('a callback which spans multiple breakpoints, skinny and mobile!');
			// setting 'call_for_each_context' to false means this callback will only fire once across this range of breakpoints
		},
		unmatch: function() {
			console.log('leaving small context!');
		}
	},
	{
		context: 'desktop',
		match: function() {
			console.log('desktop callback woohoo!');
			//ie.innerHTML = 'desktop';
		},
		unmatch: function(){
			console.log('desktop callback unmatched!');
		}
	}
];

window.onload = function() {
 	ie = document.getElementById('ie_test');
	MQ.init(queries);
	
	var my_query = MQ.addQuery({
		context: ['skinny'],
		match: function() { 
			console.log( 'second skinny callback!' )
		}
	});
	
	//Add a media query test
	var my_query = MQ.addQuery({
		context: 'skinny', 
		match: function() { 
			console.log( 'second skinny callback!' )
		}
	});
	var callbacklen = MQ.callbacks.length;
	//Remove a media query test by reference
	MQ.removeQuery( my_query );
	if(callbacklen - MQ.callbacks.length === 1){
		console.log("RemoveQuery test success");
	}else{
		console.log("RemoveQuery test failture");
	}
}