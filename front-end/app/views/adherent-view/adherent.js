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
            
            adherentCtrl.fetchAdherent = function(){
                adherentService.getAdherent(adherentCtrl.id).then(function(data){
                    adherentCtrl.mockAdherent=data;
                    adherentCtrl.formAdherent = angular.copy(data);
                    
                    //a retirer
                    adherentCtrl.mockAdherent.emprunt.push({
                        "media":{
                            "id":2,
                            "titre":"Lanfeust des étoiles"
                            }
                            ,"depart":"2015-02-10 00:00:00.000",
                            "retour":"2017-03-08 00:00:00.000"
                    });
                });
           };
           adherentCtrl.fetchAdherent();
           
           
            adherentCtrl.resetForm = function() {
                adherentCtrl.formAdherent = angular.copy(adherentCtrl.mockAdherent);
            };
            
            adherentCtrl.saveForm = function () {
                adherentService.updateAdherent( adherentCtrl.formAdherent.id,  adherentCtrl.formAdherent).then(function (data) {
                    adherentCtrl.mockAdherent=data;
                    adherentCtrl.formAdherent = angular.copy(data);
                })
            };
            
            
            adherentCtrl.currentLoansCollapse=false;
            adherentCtrl.previousLoansCollapse=true;
            
            adherentCtrl.returnMedia = function (media) {
                //TODO: fonction indiquant au webService le retour du media en parametre
                media.retour=moment().format('YYYY-MM-DD');
                //adherentCtrl.fetchAdherent();
            };
			
		});

	
})();