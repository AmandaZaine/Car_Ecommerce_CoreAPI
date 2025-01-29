## Car Ecommerce (Backend)

This project is a Car Ecommerce implemented using:
* Java 21
* Spring Boot 3.4.1
* Spring Web
* Spring Data JPA
* Spring WebFlux (WebClient)
* Spring For Apache Kafka (with Conduktor)
* Database PostgreSQL with Docker
* Maven 4.0
* Postman
* MVC pattern
* DTO pattern

The complete backend solution has three microservices that communicate via Kafka events and HTTP methods of REST APIs:
 * [Car Ecommerce Core API](https://github.com/AmandaZaine/Car_Ecommerce_CoreAPI): this microservice is the gateway to the application, we will call the API REST endpoints of this microservice to communicate with the Car Post Data Storage microservice via WebClient interface to create a new user, create a new car post, get all car posts, update and delete car posts.
   Here we also produce a Kafka message to create a new car post which will be sent to the Kafka broker and the other two microservices will consume this message to save the data in each database.
 * [Car Post Data Storage](https://github.com/AmandaZaine/carpostdatastorage): the responsibility of this microservice is to interact directly with the database to save, retrieve and delete information about car posts.
 * [Car Sales Analysis](https://github.com/AmandaZaine/carsalesanalysis): the responsibility of this microservice is to interact directly with the database to save and retrieve the information about car sales that will be used to perform data analysis.

### Microservices architecture
