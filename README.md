# Border_Countries

Hey! Welcome to my application that consumes data from https://date.nager.at/ via REST call and returns border countries for the chosen county.

Code is in Java 17, Spring Boot 3.0.0 as framework and Maven 4.0.0 as a build tool.

To run application:

> clone this repository `https://github.com/IKromans/Border_Countries.git`

> run `mvnw spring-boot:run` from console.

> application will be running at `http://localhost:8080/myapp/countries/{countryCode}`

To test "GET" method you can use Postman or alternative tool. Just enter country code and see how it works.

![1](https://user-images.githubusercontent.com/66387211/205746765-90233886-c5ca-4404-8a04-359299087dfd.jpg)
![1 1](https://user-images.githubusercontent.com/66387211/205746829-d249aa6a-262a-4e7d-bb26-a5b7b257f994.jpg)

To stop application press:

> Ctrl + C

To run tests:

> run `./mvnw test` from console.

Enjoy!
