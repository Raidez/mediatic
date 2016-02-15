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
        //initialise les parametres non utilisé
        serialize: function (media) {
            media.adherent = media.adherents = media.retour = null;
        },
        // ajoute un media via la POST
        postMedia: function (media) {
            $http.post(urlPostCrea, media).success(function () {
                console.log("ok!!");
            });
        },
        // modifie un media via la POST (sans payer un timbre)
        postModif: function (media) {
            $http.post(urlPostModif, media).success(function () {
                console.log("ok!!");
            });
        },
        // renvoie la liste de media (promesse)
        getList: function () {
            return promise;
        },
        //renvoie une fiche media (sans requete serveur)
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