# Redis Shopping Cart Example

This project is a simple shopping cart example built with Spring Boot and Redis. The project allows users to add products to the cart, perform stock checks, and view the contents of their cart.

## Features

- Add products for users
- Stock check
- View user's cart

## Technologies Used

- Spring Boot
- Redis
- Docker

## Getting Started

To run the project on your local machine, follow these steps.

### Prerequisites

- Java 11 or higher
- Maven
- Docker

### Installation

1. Clone the project:

```bash
git clone https://github.com/ardasdasdas/redis-shopping-cart.git
```

2. Navigate to the project directory:
```bash
cd redis-shopping-cart
```

3. Start Redis and Redis Insight containers with Docker Compose:
```bash
docker-compose up
```

4. Run the Spring Boot application:
```bash
mvn spring-boot:run
```

## Usage
POST http://localhost:8080/v1/cart-api/product/add
Content-Type: application/json

POST http://localhost:8080/v1/cart-api/product/add-all
Content-Type: application/json

POST http://localhost:8080/v1/cart-api/cart/add/{{userId}}/{{productId}}
Content-Type: application/x-www-form-urlencoded

GET http://localhost:8080/v1/cart-api/cart/{{userId}}

GET http://localhost:8080/v1/cart-api/product/find-all
