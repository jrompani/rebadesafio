# rebadesafio

DESAFIO PARA REBA
-------------------

Se utilizó Intellij con Springboot y Java 17.

REQUISITOS
----------

Tener instalado DOCKER
Tener Instalado Postman

COMO EJECUTAR LA APP
--------------------

1- Descargar el proyecto.
2- Instalar Docker
3- Ingresar con una ventana de CMD hasta la ruta principal del proyecto.
4- Ejecutar el comando docker-compose up --build para descargar las imagenes y crear los contenedores
5- Una vez que se inicien los containers se podran realizar pruebas con Postman


REQUEST POSTMAN
--------

GET -> Obtener Personas
ENDPOINT -> http://localhost:8080/persona/
BODY -> Sin Body
RESPUESTA -> Retorna listado de personas

POST -> Guardar Persona
ENDPOINT -> http://localhost:8080/persona/
BODY -> {
  "nombre": "Fernando",
  "apellido": "Macana",
  "edad": 18,
  "tipoDocumento": "DNI",
  "numeroDocumento": "123456789",
  "pais": "Argentina",
  "datosContacto": [{
      "tipo": "telefono",
      "valor": "sadasdsdaads"
  }],
  "nacionalidadId": 1
}
RESPUESTA -> Guarda Persona


PUT -> Modificar Persona
ENDPOINT -> http://localhost:8080/persona/{id}
BODY -> "nombre": "Fernando",
  "apellido": "Macana",
  "edad": 18,
  "tipoDocumento": "DNI",
  "numeroDocumento": "123456789",
  "pais": "Argentina",
  "datosContacto": [{
      "tipo": "telefono",
      "valor": "sadasdsdaads"
  }],
  "nacionalidadId": 1
}
RESPUESTA-> Persona Modificada


DELETE -> Borrar Persona
ENDPOINT -> http://localhost:8080/persona/{id}
RESPUESTA -> Elimina Persona
