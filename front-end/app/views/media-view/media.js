'use strict';

var app = angular.module('media', ['ngRoute']);

app.config(function ($routeProvider) {
	$routeProvider.when('/media', {
		templateUrl: 'views/media-view/media.html',
		controller: 'mediaController'
	});
});

app.controller('mediaController', function ($http, $routeParams) {
	var $ = this;
	
	//TODO: service get media from id
	/*var url = "http://192.168.1.14:8080/resource/media.accession";
	$http.get(url).then(function(res) {
		$.media = res.data;
	});*/
	
	this.media = { "id": 10, "titre": "La petite maison dans la prairie", "auteur": "Laura Ingalss Wilder", "type": "Livre", "emprunteurs": [{ "adherent": { "id": 1, "nom": "NicolÃ¨de", "prenom": "Maitre" }, "depart": "2015-01-01 00:00:00.000", "retour": "2015-01-15 00:00:00.000" }, { "adherent": { "id": 2, "nom": "NicolÃ¨de", "prenom": "Cian" }, "depart": "2015-01-17 00:00:00.000", "retour": "2015-02-01 00:00:00.000" }, { "adherent": { "id": 3, "nom": "NicolÃ¨de", "prenom": "Cixi" }, "depart": "2015-01-17 00:00:00.000", "retour": "2015-02-01 00:00:00.000" }, { "adherent": { "id": 4, "nom": "Le troll", "prenom": "HÃ©bus" }, "depart": "2015-01-17 00:00:00.000", "retour": "2015-02-01 00:00:00.000" }] };
});