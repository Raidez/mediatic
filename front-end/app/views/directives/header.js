'use strict';
(function() {
	
	angular.module('app.navbar', ['ngRoute'])
		.controller('NavbarController', function($location, loginService) {
			var navbarCtrl = this;
            
           navbarCtrl.signOut=function () {
                loginService.signOut();
                $location.url('/login');
            }
		})
        
        .directive('mediaticNavbar', function(){
            return { 
                templateUrl: 'views/directives/header.html'
            }
        });

	
})();