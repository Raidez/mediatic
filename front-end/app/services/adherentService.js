'use strict';
(function() {
    angular.module('app.adherentService', []).
    provider('adherentService',{
        baseUrl: 'http://192.168.1.14:8080/resource/adherent',
        $get: function($http,$filter) {
            var provider=this;
            return {
                getAdherent: function(adherent_id){
                    //à modifier avec vrai backend
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
                    clientObj.date_naissance=new Date(clientObj.date_naissance);
                    clientObj.cotisation.debut=new Date(clientObj.cotisation.debut);
                    clientObj.cotisation.fin=new Date(clientObj.cotisation.fin);
                    return clientObj;
                },
                
                clientToServerObj: function(clientObj) {
                    var serverObj=angular.copy(clientObj);
                    serverObj.date_naissance=$filter('date')(serverObj.date_naissance,'yyyy-MM-dd');
                    serverObj.cotisation.debut=$filter('date')(serverObj.cotisation.debut,'yyyy-MM-dd');
                    serverObj.cotisation.fin=$filter('date')(serverObj.cotisation.fin,'yyyy-MM-dd');
                    return serverObj;
                }
                
            };
        }
    });
})();