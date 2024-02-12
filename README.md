# PROYECTO FINAL JAVA TESTING - BEDU

## API Veterinaria
El proyecto se centra en una API de una veterinaria desarrollada en Java
con Spring y se busca facilitar la gestión de consultas y tratamientos de mascotas. 

## Integrantes
- Ricardo Luna Rivera
- Ana Nathalie González Mena
- Jose de Jesus Anaya Martinez


A la API de la veterinaria le fueron aplicadas las siguientes pruebas
de Testing:

# TESTING

### Smoke Test
Un Smoke Test es una prueba de software que se realiza para verificar 
que la compilación más reciente de un software es funcional y estable. 
En otras palabras, es una prueba rápida y sencilla que se realiza para 
asegurarse de que el software no tiene defectos graves que impidan su uso.


### Pruebas Unitarias
Las pruebas unitarias pretenden probar el comportamiento correcto de 
las clases de manera aislada. Esto significa que se prueba la 
clase aislándola de su interacción con otras clases.

Las pruebas unitarias, se realizaron con ayuda de:
- JUnit
- Mockito

### Pruebas End to End (E2E)
End to end testing es uno de los niveles dentro de la pirámide 
de testing y sirve para detectar fallas en la interfaz del usuario 
(user interface). El e2e testing es una metodología que comprueba el 
funcionamiento de toda una aplicación, de principio a fin, por ello, 
se le conoce como pruebas de extremo a extremo o pruebas end-to-end (e2e).

Las pruebas E2E se realizaron a los controllers de:
- Owner
- Veterinarian
- Pet

Con la finalizar de testear el CRUD de estos modelos.

![testing.png](src%2Fimg%2Ftesting.png)
Evidencia de la ejecución de pruebas.

# ANÁLISIS DE CÓDIGO

## Sonarqube

SonarQube es una plataforma de análisis estático de código abierto 
que ayuda a detectar problemas de calidad del código, vulnerabilidades 
de seguridad y errores potenciales en proyectos de desarrollo de 
software. Proporciona un conjunto de herramientas poderosas que 
permiten a los equipos de desarrollo mejorar la calidad de su 
código mediante la identificación y corrección de problemas tempranos 
en el ciclo de vida del desarrollo de software.

Analisis de Sonarqube al API Veterinaria
![sonarqube1.png](src%2Fimg%2Fsonarqube1.png)
![Sonarcube2.png](src%2Fimg%2FSonarcube2.png)
![sonarqube3.png](src%2Fimg%2Fsonarqube3.png)


## JaCoCo
JaCoCo es una herramienta que analiza la cobertura en 
pruebas que se tienen y te genera un reporte en formato HTML. 

![Jacoco.png](src%2Fimg%2FJacoco.png)

