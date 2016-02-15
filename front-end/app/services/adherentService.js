'use strict';
(function() {
    angular.module('app.adherentService', []).
    provider('adherentService',{
        baseUrl: 'http://192.168.1.14:8080/resource/adherent',
        $get: function($http) {
            var provider=this;
            return {
                getAdherent: function(adherent_id){
                    //à modifier avec vrai backend
                    return $http.get(provider.baseUrl + '.accession', {params:{id: adherent_id}})
                        .then(function(response){
                            return response.data
                        });
                },
                updateAdherent: function(adherent_id, adherent) {
                    return $http.post(provider.baseUrl + '.modification',adherent, {params:{id: adherent_id}})
                        .then(function(response){
                            return response.data
                        },
                        function(response){
                            console.log(response)
                        });
                }
            };
        }
    });
})();