
# DocTic

## Resumen

Sistema de gestión documental basado en un modelo entidad–relación. Permite la creación, lectura, almacenamiento y descarga de documentos, con control de acceso por niveles de privacidad y gestión de colaboradores por archivo.

El backend expone funcionalidades mediante APIs REST y maneja autenticación, recuperación segura de credenciales, y manejo centralizado de excepciones para respuestas estandarizadas.

## Funcionalidades principales

- Gestión de documentos: crear, leer, actualizar, almacenar y descargar archivos.
- Control de privacidad: documentos públicos y privados.
- Manejo de colaboradores: permisos por documento (visualizar, escribir, descargar).
- Autenticación y recuperación de contraseña con flujos seguros de restablecimiento.
- Historial de acciones y valoraciones sobre documentos.
- Manejo de excepciones centralizado y respuestas estandarizadas.
- APIs REST para integración con frontend y servicios externos.

## Tecnologías

- Java
- Spring Boot
- MySQL
- JPA / Hibernate
- Maven (con wrapper)
- POSTMAN (colecciones de prueba)
- APIs REST

## Estructura del proyecto (destacados)

- `backend/` — código fuente del backend Spring Boot.
  - `src/main/java/com/apiweb/backend/Controller/` — controladores REST.
  - `src/main/java/com/apiweb/backend/Model/` — modelos de entidad.
  - `src/main/java/com/apiweb/backend/Repository/` — interfaces de persistencia (JPA repositories).
  - `src/main/java/com/apiweb/backend/Service/` — lógica de negocio.
  - `src/main/resources/application.properties` — configuración de la aplicación.
- `Base de datos DocTic/bd_proyecto.sql` — script SQL para crear/llenar la base de datos.
- `pruebas postman/Pruebas Proyecto DOCTIC.postman_collection.json` — colección Postman con pruebas.

## Preparación y ejecución (Windows - PowerShell)

Requisitos previos:

- JDK (versión compatible con el proyecto, por ejemplo Java 11+).
- MySQL en ejecución o acceso a una instancia remota.

Pasos rápidos:

1. Importar la base de datos:

	- Archivo: `"Base de datos DocTic/bd_proyecto.sql"` — impórtalo en tu servidor MySQL.

2. Configurar conexión a la base de datos:

	- Edita `src/main/resources/application.properties` y ajusta URL, usuario y contraseña de MySQL.

3. Ejecutar la aplicación (desde la raíz del repo, PowerShell):

	```powershell
	.\backend\mvnw.cmd -f .\backend\pom.xml spring-boot:run
	```

	O bien compilar y ejecutar el jar generado:

	```powershell
	.\backend\mvnw.cmd -f .\backend\pom.xml clean package
	java -jar .\backend\target\mibackend-0.0.1-SNAPSHOT.jar
	```

## Endpoints y pruebas

- Los controladores REST están en `src/main/java/com/apiweb/backend/Controller/`.
- Para pruebas manuales o automáticas, importa la colección Postman en `pruebas postman/`.

## Manejo de seguridad y excepciones

- Autenticación y flujo de recuperación de contraseña implementados en el backend; revisar `ContrasenaController` y servicios relacionados.
- Excepciones centralizadas y respuestas estandarizadas: revisar paquete `Exeption` y clases de manejo global.

## Notas para desarrolladores

- Sigue las convenciones de paquetes ya establecidas.
- Añade pruebas unitarias en `src/test/java` para nuevas funcionalidades.
- Antes de abrir PR, asegúrate de que las migraciones/imports de base de datos estén actualizados.

## Recursos y archivos relevantes

- Base de datos: `Base de datos DocTic/bd_proyecto.sql`
- Postman: `pruebas postman/Pruebas Proyecto DOCTIC.postman_collection.json`
- Clase principal (entrypoint): `backend/src/main/java/com/apiweb/backend/BackendApplication.java` — clase con el método `main` que arranca el servicio Spring Boot.
