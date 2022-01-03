directory listing

- ex_01: Custom UserDetailsService and User class.
- ex_02: Custom UserDetailsManager and MySQL jdbc implementation.
- ex_03: jdbc implementation with custom queries for UserDetailsManager.

Instruction on using docker for MySQL development:
```
docker run --name mariadbtest -e MYSQL_ROOT_PASSWORD=mypass -p 3306:3306 -d docker.io/library/mariadb:10.3
```
and where mariadbtest is the container's name.

After the container is up, log into the container with the following command:
```
docker exec -it mariadbtest bash
mysql -u root -p
create DATABASE spring;
```
where the password is from MYSQL_ROOT_PASSWORD. 

To start the container:
```
docker start mariadbtest
```

To stop the container:
```
docker stop mariadbtest
```
