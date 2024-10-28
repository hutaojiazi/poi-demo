## RESTful Web API (Spring boot/Java/Gradle)
* The csv file will be loaded into memory when the service starts up.
* Support search the trail by class and bikeTrail
* Support search the trail by fid

## Web UI (React/NodeJS)
* A simple UI to list all the trails.

## CLI tool (Python3)
* A simple CLI tool to search the trails. The "click" library is used to build the command line interfaces.
* Run the following commands to all the options.

    
    python apis_cli.py --help

## Gradle

The './gradlew' can be changed for 'gradle' if gradle is installed and available in the PATH.

    ./gradlew build

Start the spring boot application

    ./gradlew bootRun

The service will be deployed on port 8080 as specified in application.yml:

    $http://localhost:8080

## Improvement to implement
* Create SQL script and persist the data into a database. In-memory cache is being used due to time constraint.
* Add cache support for trail search assuming that the trail data will rarely change.
* Add docker file / jenkins file for CI/CD
* Add unit tests and integration tests for the web service
* Improve UI to allow the user to search the trails by more filters.
* Add tests for UI

## Deployment

To be implemented. (Docker/Kubernetes/Jenkins)
