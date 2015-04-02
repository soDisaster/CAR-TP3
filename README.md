# CAR-TP3

Authors
-------

- Thibault Rosa
- Anne-Sophie Saint-Omer


Nous avons 2 packages principaux : tree et graph. 

Le package tree contient :
- Un package transfer contenant SiteImpl.java & SiteItf.java.
- Un package client contenant MainClientTree.java & MainRegistery.java.
- Un package server contenant Server.java.


Nous avons 2 packages principaux. 
tree et graph. 

Le package graph contient :
- Un package transfer contenant SiteImpl.java & SiteItf.java.
- Un package client contenant MainClientGraph.java & MainRegistery.java.
- Un package server contenant Server.java.


Nous avons également un dossier test.


SiteItf.java
------------

Interface contenant les méthodes à implémenter pour les objects RMI.


SiteImpl.java
-------------

Classe contenant les méthodes à implémenter pour les objects RMI implémentant l'interface SiteItf.java.
Ces méthodes permettent d'ajouter des fils, de modifier le père de l'objet etc.
Ainsi que les méthodes de transfert.


MainClientGraph.java & MainClientTree.java
------------------------------------------

Les objets sont créés. On définit leurs fils et leur père (sauf pour la racine) ou les voisins.


MainRegistery.java
------------------


Server.java
-----------

Serveur, lit les messages envoyés par chacun des objets et exécute la méthode receive.


Tests JUnit
-----------

Dossier tests


Tests en français 
------------------

Tests client serveur.
Tests sur les lookups.
Créations des objets RMI. 




Exécution
---------







