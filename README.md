-- Service Java untuk web aplikasi admin rental mobil --

1. Setup project (Versioning) :
- IntelliJ IDEA 2023.2.7
- MySQL Server 8.1.0
- Lombok Plugin 1.18.30
- Apache Maven 3.8.5
- JDK/JRE 17

2. Spring boot rental startup log :
- Dapat dilihat di file startup-log.txt

3. List Rest Api :

### Sign in
PUT http://localhost:8080/rentalcar/user/signin?code={{manager_code}}&password={{password}}

### Sign out
PUT http://localhost:8080/rentalcar/user/signout

### Create User
POST http://localhost:8080/rentalcar/user/create
Content-Type: application/json

{
    "name": "Henry",
    "password": {{password}},
    "role": "EMPLOYEE"
}

### Get user by name
GET http://localhost:8080/rentalcar/user/by-name

### Get all users
GET http://localhost:8080/rentalcar/user/all

### Get users by code or name
GET http://localhost:8080/rentalcar/user/by-code-name?code=MAN_001&name=Shinichi

### Get user by id
GET http://localhost:8080/rentalcar/user/by-id?id=3

### Update user
PUT http://localhost:8080/rentalcar/user/update
Content-Type: application/json

{
    "id": 3,
    "name": "Henry"
}

### Create Car
POST http://localhost:8080/rentalcar/car/create
Content-Type: application/json

{
  "segment": "SEDAN",
  "dailyPrice": 50.0,
  "brand": "OPEL"
}

### Get all cars by brand
GET http://localhost:8080/rentalcar/car/by-brand?brand=OPEL

### Get all cars by segment
GET http://localhost:8080/rentalcar/car/by-segment?segment=HATCH

### Rent a car
POST http://localhost:8080/rentalcar/rent/create
Content-Type: application/json

{
  "userId": 3,
  "carDTO": {
    "id": 2
  }
}

### Finalize a rent
PUT http://localhost:8080/rentalcar/rent/update?id=3

### Get all cars availables to rent
GET http://localhost:8080/rentalcar/car/availables

### Get all cars rent by a client id
GET http://localhost:8080/rentalcar/rent/by-user?id=2

### Get list of cars sorted ascending by brand
GET http://localhost:8080/rentalcar/car/by-brand-asc

