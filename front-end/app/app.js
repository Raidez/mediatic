'use strict';
(function (){
    angular.module('app', ['ngRoute', 'media','rechercheMedia']).config(function ($routeProvider) {
        $routeProvider.otherwise({
            redirectTo: '/media'
        })
    })
})();