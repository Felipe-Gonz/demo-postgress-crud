# demo-postgress-crud

---

##  Versión en Español

###  Descripción

Este es un pequeño proyecto CRUD desarrollado con **Spring Boot** y conectado a **PostgreSQL**, que permite gestionar información básica de personas (nombre, dirección, teléfono, etc.).

###  Tecnologías utilizadas

- Java 17  
- Spring Boot  
- Spring Data JPA  
- PostgreSQL  
- Maven  

###  Estructura del proyecto

```
src
└── main
    └── java
        └── com
            └── lfg
                └── demo_postgress_crud
                    ├── controller      # Controladores REST
                    ├── dao             # Interfaces JPA (Repository)
                    ├── entity          # Clases de entidad (Person)
                    └── service         # Lógica de negocio
```

###  Endpoints REST

El servicio se expone en la ruta base `/api/v1/persons`. Los endpoints disponibles son:

| Método HTTP | Endpoint               | Descripción               |
|-------------|------------------------|---------------------------|
| GET         | `/api/v1/persons`      | Lista todas las personas  |
| GET         | `/api/v1/persons/{id}` | Obtiene una persona por ID |
| POST        | `/api/v1/persons`      | Crea una nueva persona    |
| PUT         | `/api/v1/persons/{id}` | Actualiza una persona     |
| DELETE      | `/api/v1/persons/{id}` | Elimina una persona       |

###  Configuración

Para ejecutar el proyecto correctamente, es necesario configurar los siguientes valores en el archivo `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/crudprueba
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

> Asegúrate de que la base de datos `crudprueba` exista en tu servidor PostgreSQL. El proyecto **no incluye** scripts `.sql`.

###  Ejecución local

1. Clona este repositorio:
   ```bash
   git clone https://github.com/tu-usuario/demo-postgress-crud.git
   ```

2. Abre el proyecto con **IntelliJ IDEA** u otro IDE compatible con Spring Boot.

3. Asegúrate de tener PostgreSQL en ejecución y la base de datos `crudprueba` creada.

4. Ejecuta la clase `DemoPostgressCrudApplication.java`.

5. Accede a los endpoints REST desde Postman u otro cliente HTTP:
   ```
   http://localhost:8080/api/v1/persons
   ```

###  Ejemplo de solicitud POST

```http
POST /api/v1/persons HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
  "name": "Luis Gonzalez",
  "address": "San Salvador",
  "phone": 70112233
}
```

---

##  English Version

###  Description

This is a small CRUD project developed with **Spring Boot** and connected to **PostgreSQL**, designed to manage basic information about people (name, address, phone number, etc.).

###  Technologies Used

- Java 17  
- Spring Boot  
- Spring Data JPA  
- PostgreSQL  
- Maven  

###  Project Structure

```
src
└── main
    └── java
        └── com
            └── lfg
                └── demo_postgress_crud
                    ├── controller      # REST controllers
                    ├── dao             # JPA interfaces (Repository)
                    ├── entity          # Entity classes (Person)
                    └── service         # Business logic
```

###  REST Endpoints

The service is exposed at the base path `/api/v1/persons`. Available endpoints include:

| HTTP Method | Endpoint               | Description                 |
|-------------|------------------------|-----------------------------|
| GET         | `/api/v1/persons`      | List all persons            |
| GET         | `/api/v1/persons/{id}` | Get a person by ID          |
| POST        | `/api/v1/persons`      | Create a new person         |
| PUT         | `/api/v1/persons/{id}` | Update an existing person   |
| DELETE      | `/api/v1/persons/{id}` | Delete a person             |

###  Configuration

To run the project properly, you need to set the following properties in the `application.properties` file:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/crudprueba
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

> Make sure the `crudprueba` database exists in your PostgreSQL server. This project does **not include** `.sql` scripts.

###  Local Execution

1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/demo-postgress-crud.git
   ```

2. Open the project in **IntelliJ IDEA** or any Spring Boot compatible IDE.

3. Ensure PostgreSQL is running and the `crudprueba` database is created.

4. Run the `DemoPostgressCrudApplication.java` class.

5. Access the REST endpoints using Postman or any HTTP client:
   ```
   http://localhost:8080/api/v1/persons
   ```

###  Example POST Request

```http
POST /api/v1/persons HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
  "name": "Luis Gonzalez",
  "address": "San Salvador",
  "phone": 70112233
}
```

---

###  Author

Luis Gonzalez
