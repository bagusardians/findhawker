# findhawker
findhawker is a service where you can get nearby hawker nearby your current location in Singapore.

### How To Run
Build and run the app
```sh
$ ./gradlew build
$ ./gradlew bootRun
```

the application can be accessed in http://localhost:8080/findhawker/

to test the application, you can use use [Postman].

the postman api collection can be found the main folder with the name: **findhawker.postman_collection.json**


## Feature, API Docs and Assumptions

### Get Hawkers
> As a user, I need an API to Get Hawkers Near My Location
  - Provides the position using latitude and longitude
  - If Success, return the list of nearby hawkers which contains the name, latitude, longitude, and the photo url.
  - If Error, return the error message 

#### assumption
 - Allowed user's location is within Singapore only
 - At least 5 hawkers nearby the user location will be returned
 - It might contains more than 5 Hawkers
#### input
```
localhost:8080/findhawker/hawkers?latitude=1.322&longitude=103.855
```
#### output success (200)
```
{
    "results": [
        {
            "name": "Toa Payoh Lorong 1 Blk 127 (Toa Payoh West Market and Food Court)",
            "latitude": 1.33809268551386,
            "longitude": 103.84473162196,
            "photoUrl": "http://www.nea.gov.sg/images/default-source/Hawker-Centres-Division/resize_1262154499803.jpg"
        }
    ]
}
```
#### output bad request (400)
```
{
    "message": "Your location is outside Singapore."
}
```

## Tech

* [Java] - Programming language.
* [Spring] - application framework and inversion of control container for the Java platform.
* [Spring Boot] - building production-ready Spring applications.


## Documentation
The documentation of the application is this readme file. 

[//]: # 
[Java]: <https://swagger.io/>
[Spring]: <https://spring.io/>
[Spring Boot]: <https://projects.spring.io/spring-boot/>
[Postman]: <https://www.getpostman.com/>