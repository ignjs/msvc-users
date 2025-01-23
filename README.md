# msvc-users

Microservicio para la gestión de usuarios en una aplicación basada en microservicios.

## Descripción

El microservicio `msvc-users` proporciona funcionalidades para la creación, actualización, eliminación y consulta de usuarios. Este servicio es parte de una arquitectura de microservicios y se comunica con otros servicios a través de Eureka y Feign.

## Requisitos

- Java 21
- Maven 3.6.3 o superior
- MySQL 5.7 o superior

## Instalación

1. Clona el repositorio
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





