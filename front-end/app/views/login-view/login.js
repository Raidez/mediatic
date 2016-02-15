'use strict';
(function() {
	
	angular.module('app.login', ['ngRoute' ])
		.config(function ($routeProvider) {
		
			$routeProvider.when('/login', {
				templateUrl: 'views/login-view/login.html',
				controller: 'LoginController',
				controllerAs: 'loginCtrl'
			});
		})
		
		.controller('LoginController', function($rootScope, $location, loginService ) {
            var loginCtrl = this;
            
            loginCtrl.logins={};

            
            loginCtrl.authenticate = function() {
                loginService.authenticate(loginCtrl.logins.login , loginCtrl.logins.password).then(function(data){
                    console.log(data);
                    $location.url('/adherent/1111');
                });
            };
		});

	
})();