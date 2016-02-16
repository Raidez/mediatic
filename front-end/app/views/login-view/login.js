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
            $rootScope.pageTitle = 'identification';
            loginCtrl.logins={};

            
            loginCtrl.authenticate = function() {
                loginService.authenticate(loginCtrl.logins.login , loginCtrl.logins.password, loginCtrl.logins.rememberme).then(function(data){

                    $location.url('/adherent/1');
                });
            };
		});

	
})();