'use strict';
(function() {
    
    angular.module('app.adherents', ['ngRoute'])
		.config(function ($routeProvider) {
		//routage
			$routeProvider.when('/adherents', {
				templateUrl: 'views/adherents-view/adherents.html',
				controller: 'AdherentsController',
				controllerAs: 'adherentsCtrl'
			});
		}).controller('AdherentsController', function($rootScope, $location , adherentService, loginService ) {
			var adherentsCtrl = this;
            
            //redirection si la personne n'est pas identifiee
            if(!loginService.authenticated()) {
                $location.url('/login');
            }
            
            //titre de la page
            $rootScope.pageTitle = 'Liste Adhérents';
			
            //params de recherche
            adherentsCtrl.search={};
            
            //tableau des résultats
            adherentsCtrl.resultList=[];
            
            adherentService.getAdherents({page:0,nom:'Stag'}).then(function(data){
                adherentsCtrl.resultList=data;
            });
            
		});
    
    
})();