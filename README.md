# ACCOUNT MANAGEMENT APP

Software Requirement:

&#8226; Spring boot version: 2.6.6 and above

&#8226; Java version: 17 and above

&#8226; Postgres version: 14 and above

&#8226; Docker

Installation:

&#8226; Open terminal and run these commands:
1) docker pull postgres:alpine (To download the docker image of postgres)
2) docker run --name postgres-spring -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres:alpine (run the postgres docker image locally)
3) docker exec -it postgres-spring bash (execute the image using bash command)
4) psql -U postgres (use super user to enter to postgres command prompt)
5) CREATE DATABASE accountmanagement (create the database that is required for this application to run)

