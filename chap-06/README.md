Refer to chap-03 README.md for instruction on setting up MYSQL docker image for this exercise.

Steps to setup user management:
1. Define the password encoder objects for the two hashing algorithms.
2. Define the JPA entities to represent the user and authority tables that store the details needed in the authentication process.
3. Declare the JpaRepository contract for Spring Data.
4. Create a decorator that implements the UserDetails contract over the User JPA entity.
5. Implement the UserDetailsService contract. 
