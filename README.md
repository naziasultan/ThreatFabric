
**How to build**

This project is a maven based project and you can use the below command to build it:

`mvn clean install`


**Swagger Documentation Address**

`http://localhost:8081/swagger-ui.html`



`Endpoints`
--------------------------------------------
`/resources/devices`   |  `POST`   | register a new device
`content-type: application/json`
--------------------------------------------
`/resources/detections/no`  | `POST`  |   register a no detection 
`content-type: application/json`
--------------------------------------------
`/resources/detections/new`  | `POST`  |   register a new detection 
`content-type: application/json`
--------------------------------------------
`/resources/detections/resolved`  | `POST`  |   register a resolved detection 
`content-type: application/json`
--------------------------------------------
`/resources/detections/search?from=&to=&deviceId=&deviceModel=&type=`  | `GET`  |   search for detections 
from and to are mandatory
--------------------------------------------
