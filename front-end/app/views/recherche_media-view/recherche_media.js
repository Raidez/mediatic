'use strict';

var app = angular.module('rechercheMedia', ['ngRoute', 'serviceMedia']);

app.config(function ($routeProvider) {
    $routeProvider.when('/media', {
        templateUrl: 'views/recherche_media-view/recherche_media.html',
        controller: 'rechercheController',
		controllerAs: 'ctrl'
    });
    // $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF8';
});

app.controller('rechercheController', function ($http, $location, serviceMedia) {
    var ctrl = this;
    this.trie = {};
    this.trie.order = {};
    this.trie.filter = {};
    this.trie.tmpFilter = {};
	this.pageActuelle = 0;

    // redirection vers l'url de la fiche media (envoie de l'id)
    this.ficheMedia = function (id) {
        $location.url('/media/' + id);
    };
    
    // applique le order selon un libellé et un ordre (croissant, décroissant)
    this.order = function (libelle, reverse) {
        ctrl.trie.order.libelle = libelle;

        if (reverse == 'up')
            ctrl.trie.order.reverse = false;
        else
            ctrl.trie.order.reverse = true;
    };
    
    // filtre avec temporisation
    this.filter = function () {
        ctrl.trie.filter = angular.copy(ctrl.trie.tmpFilter);
    };
    
    //Ajout média
    this.ajoutMedia = function () {
        serviceMedia.serialize(ctrl.media);
        serviceMedia.postMedia(ctrl.media);
		ctrl.listeMedia.push(ctrl.media);
		
		// cache et reset la modal
		$('#nouveauMedia').modal('hide');
		$('#nouveauMediaForm')[0].reset();
    };
	
	// permet de changer la page courante
	this.swapPage = function (i) {
		ctrl.pageActuelle = --i;
		ctrl.refreshPage();
	};
	// rafraichie la page
	this.refreshPage = function () {
		serviceMedia.getListPagine(ctrl.pageActuelle).then(function (data) {
			ctrl.listeMedia = data;
		});
	};
    
    // loader zone
	serviceMedia.getNbPage().then(function (data) {
		ctrl.pages = data.pages;
		
		ctrl._pages = [];
		for(var i=0; i < data.pages; i++) {
			ctrl._pages.push(i+1);
		}
	});
    serviceMedia.getListPagine(ctrl.pageActuelle, ctrl.trie.filter).then(function (data) {
        ctrl.listeMedia = data;
    });
    ctrl.trie.order.libelle = 'titre';
    ctrl.trie.order.reverse = false;
});