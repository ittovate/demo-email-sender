# Email Sender
## Prupose and Functionality:
Provides a simple and powerful system for sending emails

how to run: ...........
how to create your own smtp server ...........

to create an smtp server with your personal email to send emails from
https://www.google.com/url?sa=t&source=web&rct=j&opi=89978449&url=https://myaccount.google.com/apppasswords&ved=2ahUKEwiej4PD5NaHAxX_R_EDHfU6I8AQjBB6BAgiEAE&usg=AOvVaw1rVibBR6kQTiUjqa0l_f8W
provide environment variables...........



## Monitoring:
Implements Spring Boot Actuator for application monitoring and metrics

Aspect-Oriented Programming (AOP):
Uses spring-boot-starter-aop
Implements @AfterThrowing aspect for exception logging
Uses @Around aspect to measure email sending duration

## AOP notes: .................


## Error Handling:
Custom Exception Handler to manage and return user-friendly error responses

## Testing:
we use Test for  unit test for isolated functionalities (mainly utility tests) and integration testing

## Security:
dotenv-java for loading sensitive configuration from .env files

## how to run tests

	aop 
@after returning advice:
only when the methods executes correctly

@after throwing:
only when the methods throw exceptions

@after:
is like finally clause in try-catch, will always execute

