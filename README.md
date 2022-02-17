# Todo
A todo application REST API developed using Spring Boot.

Used **Spring Data JPA** for CRUD operations on a **MySQL** database.

### API Endpoints
Here is a short summary about the available REST API Endpoints for the functionalities that have been implemented.

| <b>Method</b> |     <b>Resource</b>     |                  <b>Description</b>                 |
|:-------------:|:-----------------------:|:----------------------------------------------------|
|     `GET`     |         `/todos`        | Get all todos                                       |
|     `GET`     |      `/todos/{id}`      | Get specific todo with that id                      |
|     `GET`     | `/todos/user/{user_id}` | Get all todos by that user                          |
|     `POST`    |        `/todos/`        | Create a new todo (todo object in Request Body)     |
|     `PUT`     |     `/todos/{ id }`     | Update that todo (todo object in Request Body)      |
|     `GET`     |         `/users`        | Get all users                                       |
|     `PUT`     |     `/users/{ id }`     | Update user details                                 |
|     `POST`    |         `/users`        | Create a new user (user object in Request Body)     |
|    `DELETE`   |     `/todos/{ id }`     | Delete that todo                                    |
|    `DELETE`   |     `/users/{ id }`     | Delete that user (and the todos associated with it) |

### Tools used
- Spring Boot 2
- Spring Framework 5
- Spring Data JPA
- Spring REST
- Apache Maven
- MySQL

To run the todo application on local : mvn clean install

To run the application : RunAs > SpringBoot App > TodoApplication.java

Swagger URL : http://localhost:8080/swagger-ui.html

For clone the Repo : git clone https://github.com/Sitaramayya009/todo.git