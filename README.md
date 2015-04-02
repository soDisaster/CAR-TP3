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

Tests client serveur :
Nous pourrions tester les lookups.

Nous pourrions utliser Naming.bind pour référencer l'objet RMI sur le serveur de noms et tester à l'aide d'un lookup si l'objet a bien été référencé.


Exécution
---------

Dans le dossier jar : 

Exécution du fichier launchGraph.sh -> ./launchGraph.sh
ou LaunchTree.sh -> ./launchTree.sh

Attendre pendant 10 secondes pour éviter des problèmes de syncronisation entre le lancement des Nodes et la construction du Graph ou du Tree.
Sleep de 10 secondes dans le script pour permettre au Node de bien s'exécuter.

! Avant de lancer un graphe ou un arbre, il faut s'assurer que le serveur de noms est coupé !







