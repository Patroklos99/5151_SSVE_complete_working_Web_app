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

#### Swagger

Lorsque l'API roule, un endpoint est disponible pour interagir avec l'API. `http://localhost:8080/swagger-ui/index.html`

### Exécuter les tests de l'api

```sh
./mvnw test
```
