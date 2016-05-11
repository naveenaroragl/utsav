angular.module('Login', []);
angular.module('Products', []);
angular.module('ProductsServicesSelector', []);
angular.module('Services', []);


angular.module('HomePage', [])
.directive('selectpicker', function () {
    return {
      restrict: 'C',
      link: function (scope, element) {
        $(element).selectpicker({
          style: 'btn-default',
          size: false
        });
      }
    };
  });
  

  
angular.module('Products', [])
.controller('ProductsCtrl', function($scope) {
  
});
    

angular.module('MainApp',
  [
    'Login',
    'Products',
    'ProductsServicesSelector',
    'Services',
	'HomePage',
	'ngRoute'
  ]
);
