'use strict';
(function (){
    angular.module('app', ['ngRoute', 'media','rechercheMedia','serviceMedia']).config(function ($routeProvider) {
        $routeProvider.otherwise({
            redirectTo: '/media'
        })
    })
})();