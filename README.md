# PROYECTO FINAL JAVA BACKEND INTERMEDIO - BEDU

## Integrantes
- Ricardo Luna Rivera

## API Veterinaria

El proyecto se centra en una API de una veterinaria desarrollada en Java
con Spring y se busca facilitar la gestión de consultas y tratamientos de mascotas. 

## Tecnologías
- Java 17
- Spring 3.2.0
  - Spring Web
  - Spring Data JPA
  - Lombok
  - MySQL Driver
- MapStruct 1.5.5
- H2
- Open API 2.3.0

## Base de datos
![db_veterinary.png](src%2Fimg%2Fdb_veterinary.png)

## Ejecutar aplicación
`./gradlew bootRun`

## Usar consola H2
URL CONSOLA H2: http://localhost:8080/h2-console

JDBCURL: jdbc:h2:mem:veterian;DB_CLOSE_ON_EXIT=FALSE

USER: sa

PASSWORD:

![H2_console.png](src%2Fimg%2FH2_console.png)

## OpenAPI Swagger
URL: http://localhost:8080/swagger-ui/index.html