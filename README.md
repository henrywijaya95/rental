-- Service Java untuk web aplikasi admin rental mobil --

1. Setup project (Versioning) :
- IntelliJ IDEA 2023.2.7
- MySQL Server 8.1.0
- Lombok Plugin 1.18.30
- Apache Maven 3.8.5
- JDK/JRE 17

2. Spring boot rental startup log :
   .   ____          _            __ _ _
   /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
   ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
   \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
   '  |____| .__|_| |_|_| |_\__, | / / / /
   =========|_|==============|___/=/_/_/_/
   :: Spring Boot ::                (v3.1.0)

2024-07-16T05:26:59.163+07:00  INFO 5160 --- [  restartedMain] c.miniproject.rental.RentalApplication   : Starting RentalApplication using Java 17.0.8 with PID 5160 (D:\Henry\Personal\CV\rental\target\classes started by asus in D:\Henry\Personal\CV\rental)
2024-07-16T05:26:59.167+07:00  INFO 5160 --- [  restartedMain] c.miniproject.rental.RentalApplication   : No active profile set, falling back to 1 default profile: "default"
2024-07-16T05:26:59.245+07:00  INFO 5160 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
2024-07-16T05:26:59.247+07:00  INFO 5160 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : For additional web related logging consider setting the 'logging.level.web' property to 'DEBUG'
2024-07-16T05:27:00.365+07:00  INFO 5160 --- [  restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2024-07-16T05:27:00.480+07:00  INFO 5160 --- [  restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 101 ms. Found 3 JPA repository interfaces.
2024-07-16T05:27:01.493+07:00  INFO 5160 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2024-07-16T05:27:01.508+07:00  INFO 5160 --- [  restartedMain] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2024-07-16T05:27:01.508+07:00  INFO 5160 --- [  restartedMain] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.8]
2024-07-16T05:27:01.618+07:00  INFO 5160 --- [  restartedMain] o.a.c.c.C.[.[localhost].[/rentalcar]     : Initializing Spring embedded WebApplicationContext
2024-07-16T05:27:01.622+07:00  INFO 5160 --- [  restartedMain] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 2372 ms
2024-07-16T05:27:01.841+07:00  INFO 5160 --- [  restartedMain] o.f.c.internal.license.VersionPrinter    : Flyway Community Edition 9.16.3 by Redgate
2024-07-16T05:27:01.841+07:00  INFO 5160 --- [  restartedMain] o.f.c.internal.license.VersionPrinter    : See release notes here: https://rd.gt/416ObMi
2024-07-16T05:27:01.841+07:00  INFO 5160 --- [  restartedMain] o.f.c.internal.license.VersionPrinter    :
2024-07-16T05:27:01.853+07:00  INFO 5160 --- [  restartedMain] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2024-07-16T05:27:02.305+07:00  INFO 5160 --- [  restartedMain] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection com.mysql.cj.jdbc.ConnectionImpl@34ab2502
2024-07-16T05:27:02.308+07:00  INFO 5160 --- [  restartedMain] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2024-07-16T05:27:02.355+07:00  INFO 5160 --- [  restartedMain] o.f.c.i.database.base.BaseDatabaseType   : Database: jdbc:mysql://localhost:3306/rental_car (MySQL 8.1)
2024-07-16T05:27:02.390+07:00  WARN 5160 --- [  restartedMain] o.f.c.internal.database.base.Database    : Flyway upgrade recommended: MySQL 8.1 is newer than this version of Flyway and support has not been tested. The latest supported version of MySQL is 8.0.
2024-07-16T05:27:02.413+07:00  INFO 5160 --- [  restartedMain] o.f.c.i.s.JdbcTableSchemaHistory         : Schema history table `rental_car`.`flyway_schema_history` does not exist yet
2024-07-16T05:27:02.416+07:00  INFO 5160 --- [  restartedMain] o.f.core.internal.command.DbValidate     : Successfully validated 0 migrations (execution time 00:00.014s)
2024-07-16T05:27:02.417+07:00  WARN 5160 --- [  restartedMain] o.f.core.internal.command.DbValidate     : No migrations found. Are your locations set up correctly?
2024-07-16T05:27:02.469+07:00  INFO 5160 --- [  restartedMain] o.f.c.i.s.JdbcTableSchemaHistory         : Creating Schema History table `rental_car`.`flyway_schema_history` ...
2024-07-16T05:27:02.623+07:00  INFO 5160 --- [  restartedMain] o.f.core.internal.command.DbMigrate      : Current version of schema `rental_car`: << Empty Schema >>
2024-07-16T05:27:02.625+07:00  INFO 5160 --- [  restartedMain] o.f.core.internal.command.DbMigrate      : Schema `rental_car` is up to date. No migration necessary.
2024-07-16T05:27:02.773+07:00  INFO 5160 --- [  restartedMain] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2024-07-16T05:27:02.896+07:00  INFO 5160 --- [  restartedMain] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 6.2.2.Final
2024-07-16T05:27:02.907+07:00  INFO 5160 --- [  restartedMain] org.hibernate.cfg.Environment            : HHH000406: Using bytecode reflection optimizer
2024-07-16T05:27:03.075+07:00  INFO 5160 --- [  restartedMain] o.h.b.i.BytecodeProviderInitiator        : HHH000021: Bytecode provider name : bytebuddy
2024-07-16T05:27:03.266+07:00  INFO 5160 --- [  restartedMain] o.s.o.j.p.SpringPersistenceUnitInfo      : No LoadTimeWeaver setup: ignoring JPA class transformer
2024-07-16T05:27:03.352+07:00  INFO 5160 --- [  restartedMain] org.hibernate.orm.dialect                : HHH035001: Using dialect: org.hibernate.dialect.MySQLDialect, version: 8.1
2024-07-16T05:27:03.662+07:00  INFO 5160 --- [  restartedMain] o.h.b.i.BytecodeProviderInitiator        : HHH000021: Bytecode provider name : bytebuddy
2024-07-16T05:27:04.431+07:00  INFO 5160 --- [  restartedMain] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
Hibernate:
create table cars (
id bigint not null auto_increment,
brand varchar(255),
daily_price decimal(5,2),
segment smallint,
primary key (id)
) engine=InnoDB
Hibernate:
create table rents (
id bigint not null auto_increment,
rent_at datetime(6),
return_at datetime(6),
car_id bigint,
user_id bigint,
primary key (id)
) engine=InnoDB
Hibernate:
create table users (
id bigint not null auto_increment,
code varchar(255) not null,
name varchar(255) not null,
password varchar(255),
role smallint,
primary key (id)
) engine=InnoDB
Hibernate:
alter table users
drop index UK_71vrxovabe8x9tom8xwefi3e7
Hibernate:
alter table users
add constraint UK_71vrxovabe8x9tom8xwefi3e7 unique (code)
Hibernate:
alter table rents
add constraint FKnt07d10bhaq3i8yjd26lnhcqf
foreign key (car_id)
references cars (id)
Hibernate:
alter table rents
add constraint FK3pf0l216l390r3ya1pk8wvxe9
foreign key (user_id)
references users (id)
2024-07-16T05:27:04.697+07:00  INFO 5160 --- [  restartedMain] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2024-07-16T05:27:05.328+07:00  INFO 5160 --- [  restartedMain] o.s.d.j.r.query.QueryEnhancerFactory     : Hibernate is in classpath; If applicable, HQL parser will be used.
2024-07-16T05:27:05.468+07:00  WARN 5160 --- [  restartedMain] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2024-07-16T05:27:06.471+07:00  INFO 5160 --- [  restartedMain] o.s.s.web.DefaultSecurityFilterChain     : Will secure any request with [org.springframework.security.web.session.DisableEncodeUrlFilter@74cfadb2, org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter@7c0eb05d, org.springframework.security.web.context.SecurityContextHolderFilter@572b35a3, org.springframework.security.web.header.HeaderWriterFilter@4a6dbc62, org.springframework.security.web.authentication.logout.LogoutFilter@41ed397d, com.miniproject.rental.configuration.JwtRequestFilter@5e1401a6, org.springframework.security.web.savedrequest.RequestCacheAwareFilter@77956d57, org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter@19452923, org.springframework.security.web.authentication.AnonymousAuthenticationFilter@550bf0c9, org.springframework.security.web.session.SessionManagementFilter@6a7f0ae1, org.springframework.security.web.access.ExceptionTranslationFilter@299ea85c, org.springframework.security.web.access.intercept.AuthorizationFilter@699c2abc]
2024-07-16T05:27:06.691+07:00  INFO 5160 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
2024-07-16T05:27:06.739+07:00  INFO 5160 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path '/rentalcar'
2024-07-16T05:27:06.752+07:00  INFO 5160 --- [  restartedMain] c.miniproject.rental.RentalApplication   : Started RentalApplication in 8.073 seconds (process running for 8.97)

3. List Rest Api :

### Sign in
PUT http://localhost:8080/rentalcar/user/signin?code={{manager_code}}&password={{password}}

### Sign out
PUT http://localhost:8080/rentalcar/user/signout

### Create User
POST http://localhost:8080/rentalcar/user/create
Content-Type: application/json

{
    "name": "Henry",
    "password": {{password}},
    "role": "EMPLOYEE"
}

### Get user by name
GET http://localhost:8080/rentalcar/user/by-name

### Get all users
GET http://localhost:8080/rentalcar/user/all

### Get users by code or name
GET http://localhost:8080/rentalcar/user/by-code-name?code=MAN_001&name=Shinichi

### Get user by id
GET http://localhost:8080/rentalcar/user/by-id?id=3

### Update user
PUT http://localhost:8080/rentalcar/user/update
Content-Type: application/json

{
    "id": 3,
    "name": "Henry"
}

### Create Car
POST http://localhost:8080/rentalcar/car/create
Content-Type: application/json

{
  "segment": "SEDAN",
  "dailyPrice": 50.0,
  "brand": "OPEL"
}

### Get all cars by brand
GET http://localhost:8080/rentalcar/car/by-brand?brand=OPEL

### Get all cars by segment
GET http://localhost:8080/rentalcar/car/by-segment?segment=HATCH

### Rent a car
POST http://localhost:8080/rentalcar/rent/create
Content-Type: application/json

{
  "userId": 3,
  "carDTO": {
    "id": 2
  }
}

### Finalize a rent
PUT http://localhost:8080/rentalcar/rent/update?id=3

### Get all cars availables to rent
GET http://localhost:8080/rentalcar/car/availables

### Get all cars rent by a client id
GET http://localhost:8080/rentalcar/rent/by-user?id=2

### Get list of cars sorted ascending by brand
GET http://localhost:8080/rentalcar/car/by-brand-asc

