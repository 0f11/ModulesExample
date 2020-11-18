How to run:

This is maven project. Go to the directory containing the pom.xml for this project. It should be the same directory which contains this file.

Run mvn sping-boot:run

It will start up the server at 8080 which can be changed in the application.properties file.

Application uses H2 database which can be accessed http://localhost:8080/h2-console/

JBDC url : jdbc:h2:mem:testdb

User name = sa

Password = sa

![alt text](https://i.imgur.com/scRVwuK.png)

Database is set up on one to many logic where parent can have multiple children and it is referencing to the same table.

Application is set to use 3 controllers:
 1. ModuleControllerAPI endpoint is http://localhost:8080/api/v1/module/{id}:
    GET : id(Long) - Module id, api will display module tree in json.
 2. ModuleFormController endpoint http://localhost:8080/api/v1/module/add-module
    GET : Choose name and select parent(can be null) in form.
    POST : Will populate db with selected values on GET.
 3. VisualiseController endpoint is http://localhost:8080/api/v1/module/visualize/{id}
    GET : id(Long) - Module id, will visualize tree.

