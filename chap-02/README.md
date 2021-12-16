directory listing:

- ex_01_http: initial project returns Hello. 
- ex_01_https: initial project returns Hello with HTTPs.
- ex_02: Custom UserDetailService and PasswordEncoder with @Bean annotation.
- ex_03: Override endpoint authorization configruation.

Steps to setup project to use HTTPs instead of HTTP

1. generate self-signing certificate.
```
openssl req -newkey rsa:2048 -x509 -keyout key.pem -out cert.pem -days 365

openssl pkcs12 -export -in cert.pem -inkey key.pem -out certificate.p12 -name "certificate"

``` 

2. Add the properties below to application.properties file.
server.ssl.key-store-type=PKCS12
server.ssl.key-store=classpath:certificate.p12
server.ssl.key-store-password=12345


