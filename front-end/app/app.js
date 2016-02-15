'use strict';
(function (){
    angular.module('app', ['ngRoute', 'media','rechercheMedia','serviceMedia']).config(function ($routeProvider,$httpProvider) {
        $routeProvider.otherwise({
            redirectTo: '/media'
        });
        $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF8';
    })
})();