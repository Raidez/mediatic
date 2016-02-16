'use strict';
(function() {
	
	angular.module('app.adherent', ['ngRoute'])
		.config(function ($routeProvider) {
		
			$routeProvider.when('/adherent/:id', {
				templateUrl: 'views/adherent-view/adherent.html',
				controller: 'AdherentController',
				controllerAs: 'adherentCtrl'
			});
		})
		
		.controller('AdherentController', function($rootScope, $routeParams, $location , adherentService, loginService ) {
			var adherentCtrl = this;
            adherentCtrl.id=$routeParams.id;
            adherentCtrl.mockAdherent={};
            
            if(!loginService.authenticated()) {
                $location.url('/login');
            }
            
            
            $rootScope.pageTitle = "description adhérent";
            adherentService.getAdherent(adherentCtrl.id).then(function(data){
                adherentCtrl.mockAdherent=data;
                adherentCtrl.formAdherent = angular.copy(data);
            });
            
            adherentCtrl.resetForm = function() {
                adherentCtrl.formAdherent = angular.copy(adherentCtrl.mockAdherent);
            };
            
            adherentCtrl.saveForm = function () {
                adherentService.updateAdherent( adherentCtrl.formAdherent.id,  adherentCtrl.formAdherent).then(function (data) {
                    adherentCtrl.mockAdherent=data;
                    adherentCtrl.formAdherent = angular.copy(data);
                })
            };
			
		});

	
})();