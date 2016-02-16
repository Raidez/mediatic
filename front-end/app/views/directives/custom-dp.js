'use strict';
(function() {
	
	angular.module('app.myDatePicker', ['ngRoute'])
		.controller('MyDatePickerController', function($scope) {
			var myDatePickerCtrl = this;
            
            $scope.date = new Date();
        
        
            $scope.datePicker={opened:false};
            $scope.open=function() {
                $scope.datePicker.opened = true;
            };
            $scope.format='yyyy-MM-dd';
            
        })
        
        .directive('myDatePicker', function(){
                 

                    
            return { 
                templateUrl: 'views/directives/custom-dp.html',
                 scope: {
                    ngModel : '=',
                }
            }
        });

	
})();