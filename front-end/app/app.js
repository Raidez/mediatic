//adresse serveur http://192.168.1.14:8080/resource/adherent.modification
//adresse serveur http://192.168.1.14:8080/resource/connexion.login?  login: admin mdp: strateur

'use strict';
(function (){
    angular.module('app', ['ngRoute' , 'app.adherentService' ,  'app.adherent', 'app.login', 'app.loginService' , 'app.filters']).
    config(function ($routeProvider, $httpProvider) {
        $routeProvider.otherwise({
            redirectTo: '/login'
        });
        $httpProvider.defaults.headers.post['Content-Type']='application/x-www-form-urlencoded;charset=UTF8';
    });
})();