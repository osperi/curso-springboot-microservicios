# API REST de Pokedex Spring Boot JPA

Aplicación de ejemplo hecho con Spring Boot que sirve un API REST con los datos de la pokedex
Los datos se cargan en el arranque de la aplicación a través de un fichero CSV 

# Ejecución
mvn spring-boot:run

# URL principal
[http://localhost:8080](http://localhost:8080)

# ENDPoint Pokedex
[http://localhost:8080/pokemons](http://localhost:8080/pokemons)

# ENDPoint Images
http://localhost:8080/images/pokemon/{id}.png
http://localhost:8080/images/pokemon/1.png](http://localhost:8080/images/pokemon/1.png)

# Montaje de docker compose
docker-compose up -d
 