'use strict';
(function (){
    angular.module('app', ['ngRoute', 'media']).config(function ($routeProvider) {
        $routeProvider.otherwise({
            redirectTo: '/media'
        })
    })
})();