SSVE
====

Dépôt pour le groupe du projet pilote du cours INM5151-PP. Le projet
*Système de Suggestion de Véhicule Électrique* permet à un utilisateur d'avoir des
propositions de véhicules en fonction des habitudes de l'utilisateur.

Installation locale pour développement
======================================

Cette section présente la méthode de démarrage du projet sur une machine locale
destinée aux développeurs.

Cadriciel utilisé et liens
---------------------------

- Java : [jdk 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- Maven : [version 3.8.6](https://maven.apache.org/download.cgi?Preferred=ftp://ftp.osuosl.org/pub/apache/) (Installation facultative)


Processus d'installation
------------------------

### Chacun des cadriciels (EXEMPLE-À RETIRER)

**TODO: pour chacun des cadriciels, indiquez, étape par étape, comment procéder à
l'installation sur une machine Linux ( *Pourquoi pas mac ou Windows????* c'est
sur une machine linux que le serveur sera installé).**

### Un autre cadriciel (EXEMPLE-À RETIRER)

Etc...

Protocole de démarrage du site et options
========================================

### Build frontend
```sh
npm install
```

### Démarrer le frontend
```sh
npm start
```

### Installer les dépendances et build api

```sh
./mvnw clean install
```

### Démarrer l'api

```sh
./mvnw spring-boot:run
```

L'applcation démarre par défaut sur `http://localhost:8080`. Une base de données locale h2 est aussi crée lors du démarrage.

### Exécuter les tests de l'api

```sh
./mvnw test
```
