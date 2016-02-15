'use strict';

var app = angular.module('serviceMedia', ['ngRoute']);

app.factory('serviceMedia', function ($http) {
    var urlGet = "http://192.168.1.14:8080/resource/media.recherche";
    var promise = $http.get(urlGet).then(function (res) {
        return res.data;
    });

    var urlPostCrea = "http://192.168.1.14:8080/resource/media.creation";
    var urlPostModif = "http://192.168.1.14:8080/resource/media.modification";

    return {
        serialize: function (media) {
            media.adherent = media.adherents = media.retour = null;
        },
        postMedia: function (media) {
            $http.post(urlPostCrea, media).success(function () {
                console.log("ok!!");
            });
        },
        postModif: function (media) {
            $http.post(urlPostModif, media).success(function () {
                console.log("ok!!");
            });
        },
        getList: function () {
            return promise;
        },
        getMedia: function (id) {
            return promise.then(function (list) {
                for (var i = 0; i < list.length; i++) {
                    var elm = list[i];
                    if (elm.id == id) {
                        return elm;
                    }

                }
                throw "Not found";
            });
        }
    }
});