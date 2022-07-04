<h1 align="center">Jwt-Authentication </h1>

<p align="center">A Java Back-end Demo for jwt authentication and authorization</p>

### :pushpin: Functions

- [x] Authentication
    - [x] Login Via UserName and Password
        - [x] Jwt Token Generation with User Roles
        - [ ] Refresh token Generation
    - [ ] Login Via  Refresh Token
- [x] Authorization
    - [x] Via Jwt Token
- [x] User Creation
    - [x] Via Self-Register
    - [ ] Via Admin setting Roles on creation.

### :dart: Tecnologies

My project uses the following tecnologies:

- [Git](https://git-scm.com)
- [Postgres](https://www.postgresql.org/download/)
- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Spring](https://spring.io/)

### :rocket: Setup
1. You will need [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) configured on your machine to run the project and a good IDE like [IntelliJ](https://www.jetbrains.com/pt-br/id) or [VSCode](https://code.visualstudio.com/).
2. You will need to install [Postgres](https://www.postgresql.org/download/) or run it on a docker container.
3. Create a database for the application, you can configure following item 4.
4. Configure the env variables like *spring.datasource.url*, *spring.datasource.username* and *spring.datasource.password* on the file *application.properties* . I will leave a env.json file on the root with example variables for localhost.
5. you will also find and postman collection and enviroment on the root