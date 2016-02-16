'use strict';

var app = angular.module('serviceMedia', ['ngRoute']);

app.factory('serviceMedia', function ($http) {

	var url = {
		get: {
			listeMedia: 'http://192.168.1.14:8080/resource/media.recherche',
			media: 'http://192.168.1.14:8080/resource/media.accession',
			listeAdherent: 'http://192.168.1.14:8080/resource/adherent.recherche',
			nbPageMedia: 'http://192.168.1.14:8080/resource/media.recherche.taille'
		},
		post: {
			creationMedia: 'http://192.168.1.14:8080/resource/media.creation',
			modificationMedia: 'http://192.168.1.14:8080/resource/media.modification'
		}
	};

	var promiseListMedia = $http.get(url.get.listeMedia).then(function (res) {
        return res.data;
    });


    return {
		// renvoie la liste de media complète
        getList: function () {
            return promiseListMedia;
        },
		// renvoie la liste de media paginé
        getListPagine: function (page) {
			if(page == undefined)
				page = 0;
			
			return $http.get(url.get.listeMedia, { params: { page: page }}).then(function (res) {
				return res.data;
			});
        },
		// renvoie le nb de page de média
		getNbPage: function() {
			return $http.get(url.get.nbPageMedia).then(function (res) {
				return res.data;
			});
		},
		//renvoie une fiche media (sans requete serveur)
        getMedia: function (id, useGet) {
			if (useGet) {
				return $http.get(url.get.media, { params: { id: id } }).then(function (res) {
					return res.data;
				});
			}
			else {
				return promiseListMedia.then(function (list) {
					for (var i = 0; i < list.length; i++) {
						var elm = list[i];
						if (elm.id == id) {
							return elm;
						}

					}
					throw "Not found";
				});
			}
        },
		getAdherentBy: function (type, query) {
			if (type == 'nom') {
				//////
				return $http.get(url.get.listeAdherent, { params: { nom: query } }).then(function (res) {
					return res.data;
				});
			}
			else if (type == 'prenom') {
				return $http.get(url.get.listeAdherent, { params: { prenom: query } }).then(function (res) {
					return res.data;
				});
			}
			else {
				return $http.get(url.get.listeAdherent, { params: { nom: query, prenom: query } }).then(function (res) {
					return res.data;
				});
			}
		},
		///////////////////////////////////////////////////////////////////////
        // ajoute un media via la POST
        postMedia: function (media) {
            $http.post(url.post.creationMedia, media).success(function () {
                console.log("ok!!");
            });
        },
        // modifie un media via la POST (sans payer un timbre)
        postModif: function (media) {
            $http.post(url.post.modificationMedia, media).success(function () {
                console.log("ok!!");
            });
        },
		/////////////////////////////////////////////////////////////////////////////////
		//initialise les parametres non utilisé
        serialize: function (media) {
            media.adherent = media.adherents = media.retour = null;
        }
    }
});