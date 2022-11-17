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
- Maven : [version 3.8.6](https://maven.apache.org/download.cgi?Preferred=ftp://ftp.osuosl.org/pub/apache/) 
(Installation facultative)
- Docker : [derniere version](https://www.docker.com/products/docker-desktop/)
- Postman : [derniere version](https://www.postman.com/downloads/)

Processus d'installation
------------------------

Protocole de démarrage du site et options
========================================

### Build de l'image Docker
Note importante: le build initial peut être assez long en fonction de votre connexion internet.
```sh
docker-compose build
```

### Demarrer l'application a partie de docker
```sh
docker-compose up
```

Note importante: Si vous tentez de build l'application entière en utilisant le build en 2 étapes, vous allez rencontrer des erreurs ``CORS`` (cross-origins), pour éviter ce genre d'erreur il est nécessaire de démarrer l'application à partir de Docker.
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

Noter que le `hot-reloading` n'est pas supporté au niveau du backend et donc il faudra le rebuild et le redéployer après des modifications pour qu'elles soient visibles. 

Le frontend démarre par défaut sur `http://localhost:3000` (en interagissant avec la backend sur le port 8080). Une base de données locale h2 est aussi crée lors du démarrage. Noter que cette BD est en mémoire et non persistante pour le moment.

### Exécuter les tests de l'api

```sh
./mvnw test
```
# Connexion au service des ports 8008 et 8009

Le port 22 est ouvert, donc il est très simple d'ouvrir un tunnel pour accéder
au service sur les ports 8008 (quebec) et 8009 (montreal)

## D'abord, demander un username à votre équipe d'intégration

## Ensuite, ouvrez une console et taper:

```bash
ssh -L 5000:127.0.0.1:8008 username@adve.info.uqam.ca
```

où bien sûr, "username" est votre username. Entrez votre mot de passe si
nécessaire et si tout se passe bien, vous avez un "tunnel" d'ouvert, de votre
machine au serveur adve.info.uqam.ca. 

### ssh -L 5000:127.0.0.1

Dit à la commande ssh d'écouter le port 5000 de votre adresse localhost.

### :8008 username@adve.info.uqam.ca

Et de transférer le tout sur le port 8008 de la machine adve.info.uqam.ca une
fois votre connection sécurisé par ssh effectué. 

Note : si vous rencontrez l'erreur `Cannot assign requested address`, ajoutez l'option `-4` à votre commande afin de forcer le client ssh à utiliser IPV4.

## Il ne reste ensuite qu'à ouvrir une autre console sur votre machine

Votre console est bel et bien sur votre machine locale et n'est pas connecté ssh
sur adve.uqam.info.ca

Donc, de votre console locale, vous pouvez maintenant accéder au port 8008 de
adve.info.uqam.ca en effectuant: 

```bash
nc 127.0.0.1 5000
```

D'ici vous pouvez faire vos requêtes via le standard input ou...

```bash
nc 127.0.0.1 5000 < fichierderequêtes.txt
```

Voilà, le problème est réglé.




