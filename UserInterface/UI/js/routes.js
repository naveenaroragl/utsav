angular.module('MainApp')
  .config(
    ['$routeProvider',
      function($routeProvider) {
        $routeProvider
		.when('/', {
            templateUrl: '/partials/home.html',
            controller: 'HomePageCtrl'
          }).
		  when('/Products', {
            templateUrl: 'partials/products.html',
            controller: 'ProductsCtrl'
          }).
        when('/productsDetails', {
            templateUrl: 'partials/productDetails.html',
            controller: 'ProductDetailsCtrl'
          }).
        when('/patternLib', {
            templateUrl: 'pattern-lib.html',
            controller: ''
          }).
         /* when('/ProductsServicesSelector', {
            templateUrl: 'modules/ProductsServicesSelector/views/index.html',
            controller: 'ProductsServicesSelector.ProductsServicesSelectorCtrl'
          }).
		  when('/Products', {
            templateUrl: 'modules/Products/views/index.html',
            controller: 'Products.ProductsCtrl'
          }).
		  when('/Services', {
            templateUrl: 'modules/Services/views/index.html',
            controller: 'Services.ServicesCtrl'
          }).*/
		 
          otherwise({
            redirectTo: '/'
          });
		  
	}]);	
	
	
	/*  MainApp.config(function($routeProvider) {
        $routeProvider.
          when('/', {
           templateUrl: 'modules/HomePage/views/index.html',
            action: 'HomePage.HomePageCtrl'
          }).
           otherwise({
            redirectTo: '/'
          });
      });*/