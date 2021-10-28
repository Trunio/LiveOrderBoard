# LiveOrderBoard

This is my implementation of task LiveOrderBoard.

## TASK
 Register an order.
 Order must contain these fields:
 
    -  user id 
    -  order quantity (e.g.: 3.5 kg) 
    -  price per kg (e.g.: £303) 
    -  order type: BUY or SELL 
    
 Cancel a registered order - this will remove the order from 'Live Order Board' 
 
 Get summary information of live orders (see explanation below) Imagine we have received the following orders: 
 
    -  a) SELL: 3.5 kg for £306 [user1] 
    -  b) SELL: 1.2 kg for £310 [user2] 
    -  c) SELL: 1.5 kg for £307 [user3] 
    -  d) SELL: 2.0 kg for £306 [user4] 
    
Our ‘Live Order Board’ should provide us the following summary information: 

    -  5.5 kg for £306 // order a + order d 
    -  1.5 kg for £307 // order c 
    -  1.2 kg for £310 // order 

### Built With
* [Spring](https://docs.spring.io/spring-framework/docs/current/reference/html/)
* [Hibernate](https://hibernate.org/)
* [H2](https://www.h2database.com/html/main.html)


## Getting Started

After running spring application, h2 database will be created with basic data.

### H2
Local H2 database console will be avaible under http://host:port/h2-console.
Default password is "password", to change it access application.properties
Console enables basic operations such as viewing the data, to read more about it follow the link [H2](https://www.h2database.com/html/main.html)
 
### Swagger
You can test rest api with already avaibled swagger under http://host:port/swagger-ui.html.

## Avaible endpoints
* POST /user -> to add a new user, takes single nickname
* GET /users -> retrieve list of saved users
* POST /registerOrder -> to register a new order
* GET /liveOrderBoard -> return string value, as expected in the task assigment
* GET /orders -> retrieve list of saved orders, both "BUY" and "SELL"
* DELETE /deleteOrder -> deletes order by ID from database

