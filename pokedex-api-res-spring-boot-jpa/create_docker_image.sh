#!/usr/bin/env bash
#Empaquetando
mvn clean package install
#Creando contenedor
docker build -t pepesan/pokedex-microservice:latest .
