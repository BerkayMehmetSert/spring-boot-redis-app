# Spring Boot Redis Cache

### Description

This project is a simple example of how to use Redis Cache with Spring Boot.

### How to run

**1 )** Install **Docker Desktop**. Here is the installation [link](https://docs.docker.com/docker-for-windows/install/)

**2 )** Run **Redis** on **Docker** Container

```
    docker run -p 6379:6379 --name my-redis -d redis
```

**3 )** Show **container** which runs on **Docker**

```
    docker ps
```    

**4 )** To see all the employees, run this url with its **GET** request in **Postman**

```
    http://localhost:8080/api/v1/employee/all
```

**5 )** To see one of the employee, run this url with its **GET** request in **Postman**

```
    http://localhost:8080/api/v1/employee/1
```

**6 )** To save an employee, run this url with its **POST** request in **Postman** and write this body

```
    http://localhost:8080/api/v1/employee

    {
        "firstName": "James",
        "lastName": "Holly",
        "email": "example@mail.com",
        "phone": "111-222-3333"
    }
```

**7 )** To update of any employee, run this url with its **PUT** request in **Postman** and write this body

```
    http://localhost:8080/api/v1/employee/1

    {
        "firstName": "Alex",
        "lastName": "Smith",
        "email": "example@mail.com",
        "phone": "111-222-3333"
    }
```

**8 )** To delete of any employee, run this url with its **DELETE** request in **Postman**

```
    http://localhost:8080/api/v1/employee/1
```
