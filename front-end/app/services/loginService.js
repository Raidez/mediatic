'use strict';
(function() {
    angular.module('app.loginService', []).
    provider('loginService',{
        baseUrl: 'http://192.168.1.14:8080/resource/connexion.login',
        
        $get: function($http, $cookies) {
            var provider=this;
            
            var savedLogins={
                login: $cookies.get('mediatic-login'),
                password: $cookies.get('mediatic-password')
            };
            
            
            return {
                
                logins: savedLogins,
                
                authenticate: function(login, password, rememberme){
                    //à modifier avec vrai backend
                    var service = this;
                    return $http.post(provider.baseUrl , {login: login , mdp: password})
                        .then(function(response){
                         service.logins={login: login , password: password};
                         
                         if(rememberme) {
                             $cookies.put('mediatic-login' , login);
                             $cookies.put('mediatic-password' , password);
                         }   
                            return response.data
                        },function(response){
                            alert(' Echec d\'authentification');
                        });
                },
                signOut: function() {
                     this.logins={};
                     $cookies.remove('mediatic-login');
                     $cookies.remove('mediatic-password');
                     
                },
                
                authenticated: function() {
                    return this.logins.login != undefined;
                }
                
                
                
            };
        }
    });
})();