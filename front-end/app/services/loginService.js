'use strict';
(function() {
    angular.module('app.loginService', []).
    provider('loginService',{
        baseUrl: 'http://192.168.1.14:8080/resource/connexion.login',
        
        $get: function($http) {
            var provider=this;
            return {
                
                logins: undefined,
                
                authenticate: function(login, password){
                    //à modifier avec vrai backend
                    var service = this;
                    return $http.post(provider.baseUrl , {login: login , pwd: password})
                        .then(function(response){
                         service.logins={login: login , password: password};   
                            return response.data
                        },function(response){
                            alert(' Echec d\'authentification');
                        });
                },
                
                
                
            };
        }
    });
})();