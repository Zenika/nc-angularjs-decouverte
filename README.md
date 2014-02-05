nc-angularjs-decouverte
=======================

NightClazz AngularJS Découverte

Présentation
============

L'objectif de ce projet est de fournir un support pour la NightClazz dédié à la découverte du framework Javascript AngularJS.

Ce projet se compose en deux parties :
 * Un serveur web/REST : son rôle est de fournir les pages au navigateur ainsi que des interfaces REST simples pour tester les possibilités offertes par AngularJS
 * Un site web : basé sur AngularJS et Bootstrap qui sera enrichit tout au long des TPs pour mettre en avant les différents points de la formation

La première partie du TP sera simpliste pour montrer les concepts de base d'AngularJS.
La seconde partie se concentrera sur une interface CRUD simple couplé avec le serveur REST.

Ce projet contient autant de branches que de TP. A chaque fois, le TP suivant contient la solution du TP précédent. Le dernier TP étant le résultat final.

Technologie
===========

* [AngularJS](http://angularjs.org/) en version 1.2
* [Bootstrap 3](http://getbootstrap.com/) pour avoir un rendu agréable des TP
* [RestX](http://restx.io/) servant de serveur web et REST

Prérequis
=========

* Un ordinateur :) Linux/Mac/Windows
* Java en version 1.7 (Un JRE suffit sauf pour ceux qui voudrait modifier le serveur)
* Git
* Un logiciel pour l'édition des fichiers html et js

Premier pas
===========

* Faire un clone de ce projet sur votre poste
* Avec un terminal, allez dans le répertoire srv et lancé le script correspondant à votre plateforme
 * start.sh pour Linux/Mac
 * start.bat pour windows
* Connectez vous à l'adresse http://localhost:8080 pour vérifier le bon fonctionnement

En cas de problème avec le lancement du serveur, il est possible d'utiliser start.sh help pour voir les paramètres disponibles.
Des logs sont également disponibles dans le répertoire srv/logs

Le site se compose de trois pages :
* "Bas à sable" qui a pour but de fournir une première interface pour les fonctionnalités de base d'AngularJS
* "Bouteilles" qui est une interface CRUD simple pour simuler une gestion de bouteilles
* "Admin" qui offre une vue pour voir l'état du serveur et permettre de voir les différentes interfaces REST utilisable ainsi que de les tester. (admin/admin)

Objectif
========

TP1 - Introduction (Branche master)
-----------------------------------

* Introduction a AngularJS
* [Découverte des concepts](http://www.sitepoint.com/10-reasons-use-angularjs/)
* Utilisation des directives :
 * [ng-model](http://docs.angularjs.org/api/ng.directive:ngModel)
 * [ng-bind](http://docs.angularjs.org/api/ng.directive:ngBind)
 * [ng-show](http://docs.angularjs.org/api/ng.directive:ngShow)/[ng-hide](http://docs.angularjs.org/api/ng.directive:ngHide)

TP2 - Organisation
------------------

* Organisation d'un projet
* Présentation du module [NgRoute](http://docs.angularjs.org/api/ngRoute)
* Les [controlleurs](http://docs.angularjs.org/guide/concepts)
* Directive [ng-repeat](http://docs.angularjs.org/api/ng.directive:ngRepeat)
* Les [formulaires](http://docs.angularjs.org/guide/forms)

TP3 - Filtre et directive
-------------------------

* Utilisation d'un ['filter'](http://docs.angularjs.org/api/ng.filter:filter)
* Intégration de 2 directives dans la vue
 * [SimpleRating](https://github.com/Taranys/simplerating) pour noter une bouteille
 * [Ymagik](https://github.com/Taranys/ymagik) pour ajouter une image à une bouteille

TP4 - Intégration avec un serveur REST
--------------------------------------

* Utilisation du [NgResource](http://docs.angularjs.org/api/ngResource.$resource)
* Remplacement du controlleur actuel par un controlleur utilisant un serveur REST