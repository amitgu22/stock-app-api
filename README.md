
## Stock App Api 

This project was generated with spring boot , maven resource plugin , docker maven plugin

It uses maven-resource-plugin to copy static content (angular app --prod build generated files from dist folder to classes/static of jar)

## For local Development server

Run `mvnw install && spring-boot:run` for a local server. 

Navigate to `http://localhost:8080/`. The sotck app will rendered with basic details of stocks.

Navigate to `http://localhost:8080/swagger-ui.html#`. Will give you api documentation and will provide basic testing for get,put and modify.

Navigate to `http://localhost:8080/h2` will give you in memory database instace with dummy data


## Docker image

Added Dockerfile for image using maven-docker-plugin

## build the image

RUN `mvnw install && dockerfile:build` which will create image in local container i am using docker toolbox (https://docs.docker.com/toolbox/toolbox_install_windows/)

which will provide you docker terminal , and Virtual VM for image

## RUN using docker terminal 

docker run username/imagename:tagname in my case guravamit/stockappapi:latest

Docker image is available in docker hub it can be pull from

docker pull guravamit/stockappapi
