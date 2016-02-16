'use strict';
(function() {
    angular.module('app.adherentService', []).
    provider('adherentService',{
        baseUrl: 'http://192.168.1.14:8080/resource/adherent',
        $get: function($http,$filter) {
            var provider=this;
            return {
                getAdherent: function(adherent_id){
                    var service = this;
                    return $http.get(provider.baseUrl + '.accession', {params:{id: adherent_id}})
                        .then(function(response){
                            return service.serverToClientObj(response.data);
                        });
                },
                updateAdherent: function(adherent_id, adherent) {
                    var service = this;
                    return $http.post(provider.baseUrl + '.modification',service.clientToServerObj(adherent), {params:{id: adherent_id}})
                        .then(function(response){
                            return service.serverToClientObj(response.data);
                        },
                        function(response){
                            console.log('erreur update adherent' );
                        });
                },
                serverToClientObj: function(serverObj) {
                    var clientObj=angular.copy(serverObj);
                    clientObj.date_naissance=moment(clientObj.date_naissance).toDate();
                    clientObj.cotisation.debut=moment(clientObj.cotisation.debut).toDate();
                    clientObj.cotisation.fin=moment(clientObj.cotisation.fin).toDate();
                    return clientObj;
                },
                
                clientToServerObj: function(clientObj) {
                    var serverObj=angular.copy(clientObj);
                    serverObj.date_naissance=$filter('date')(serverObj.date_naissance,'yyyy-MM-dd');
                    serverObj.cotisation.debut=$filter('date')(serverObj.cotisation.debut,'yyyy-MM-dd');
                    serverObj.cotisation.fin=$filter('date')(serverObj.cotisation.fin,'yyyy-MM-dd');
                    return serverObj;
                },
                
                getAdherents: function(page,reqParams) {
                    var service = this;
                    reqParams?reqParams:{};
                    reqParams.page=page;
                    return $http.get(provider.baseUrl + '.recherche', {params:reqParams})
                        .then(function(response){
                            return response.data;
                        });
                },
                getTaille: function(reqParams) {
                    var service = this;
                    return $http.get(provider.baseUrl + '.recherche.taille', {params:reqParams})
                        .then(function(response){
                            return response.data;
                        });
                },
                
                
            };
        }
    });
})();