//adresse serveur http://192.168.1.14:8080/resource/adherent.modification
//adresse serveur http://192.168.1.14:8080/resource/connexion.login?  login: admin mdp: istrateur

'use strict';
(function (){
    angular.module('app', ['ngRoute','ui.bootstrap','ngCookies' , 'app.adherentService' ,  'app.adherent','app.adherents', 'app.navbar', 'app.login', 'app.loginService' , 'app.filters','app.myDatePicker']).
    config(function ($routeProvider, $httpProvider) {
        $routeProvider.otherwise({
            redirectTo: '/login'
        });
        $httpProvider.defaults.headers.post['Content-Type']='application/x-www-form-urlencoded;charset=UTF8';
    });
})();




/*
server.bat
-> besoin des éléments en commentaire
*/