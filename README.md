# msvc-users

Microservicio para la gestión de usuarios en una aplicación basada en microservicios.

## Descripción

El microservicio `msvc-users` proporciona funcionalidades para la creación, actualización, eliminación y consulta de usuarios. Este servicio es parte de una arquitectura de microservicios y se comunica con otros servicios a través de Eureka y Feign.

## Requisitos

- Java 21
- Maven 3.6.3 o superior
- MySQL 5.7 o superior

## Dependencias

El proyecto `msvc-users` utiliza las siguientes dependencias:

- **Spring Boot Starter Parent**: Configuración base para proyectos Spring Boot.
- **Spring Cloud Starter Netflix Eureka Client**: Cliente Eureka para registro y descubrimiento de servicios.
- **Spring Boot Starter Web**: Soporte para aplicaciones web.
- **Spring Boot Starter Data JPA**: Soporte para JPA y bases de datos.
- **Spring Boot DevTools**: Herramientas de desarrollo para Spring Boot.
- **Spring Boot Starter Test**: Dependencias para pruebas en Spring Boot.
- **MySQL Connector**: Conector JDBC para MySQL.
- **Spring Cloud Starter Config**: Cliente para Spring Cloud Config.
- **Spring Cloud Starter Bootstrap**: Soporte para configuración de arranque en Spring Cloud.
- **Spring Cloud Starter Zipkin**: Para trazabilidad distribuida con Zipkin.
- **libs-msvc-commons**: Dependencia común para microservicios.

## Estructura del Proyecto

- [java](http://_vscodecontentref_/1): Contiene el código fuente del proyecto.
- [resources](http://_vscodecontentref_/2): Contiene los archivos de configuración y recursos estáticos.
- [pom.xml](http://_vscodecontentref_/3): Archivo de configuración de Maven.

## Instalación

1. Clona el repositorio:
    ```sh
    git clone https://github.com/ignjs/msvc-users.git
    ```
2. Navega al directorio del proyecto:
    ```sh
    cd msvc-user
    ```
3. Configura la base de datos en el archivo `application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/db_springboot_cloud
    spring.datasource.username=root
    spring.datasource.password=Asdqwe123
    ```
4. Compila el proyecto con Maven:
    ```sh
    mvn clean install
    ```    
## Uso

Para ejecutar la aplicación, usa el siguiente comando:
```sh
mvn spring-boot:run
```

El servicio estará disponible en http://localhost:{dinamico}.

### Endpoints
GET /users: Obtiene la lista de usuarios.
GET /users/{id}: Obtiene un usuario por su ID.
GET /users/username{username}: Obtiene un usuario por su username.
POST /users: Crea un nuevo usuario.
PUT /users/{id}: Actualiza un usuario existente.
DELETE /users/{id}: Elimina un usuario por su ID.

### Inicialización de la Base de Datos
Para inicializar la base de datos con algunos datos de ejemplo, puedes usar el siguiente script SQL:

```sql
-- Crear la base de datos
CREATE DATABASE db_springboot_cloud;

-- Usar la base de datos
USE db_springboot_cloud;

-- Crear la tabla de usuarios
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    enabled BOOLEAN DEFAULT TRUE,
    email VARCHAR(255) NOT NULL UNIQUE   
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Insertar datos de ejemplo
INSERT INTO users (username, password, enabled, email) VALUES
('john_doe', 'password123', TRUE, 'john.doe@example.com'),
('jane_smith', 'password456', TRUE, 'jane.smith@example.com'),
('alice_jones', 'password789', TRUE, 'alice.jones@example.com'),
('bob_brown', 'password321', FALSE, 'bob.brown@example.com'),
('charlie_black', 'password654', TRUE, 'charlie.black@example.com');
```
## Trazabilidad con Zipkin

El proyecto utiliza Zipkin para la trazabilidad distribuida de las solicitudes entre microservicios.  
Para ejecutar Zipkin usando MySQL como almacenamiento, utiliza el siguiente comando:

```sh
STORAGE_TYPE=mysql MYSQL_USER=zipkin MYSQL_PASS=zipkin java -jar zipkin.jar
```




