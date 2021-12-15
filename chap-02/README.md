Steps to setup project to use HTTPs instead of HTTP

1. generate self-signing certificate with the following command in terminal.
```
openssl req -newkey rsa:2048 -x509 -keyout key.pem -out cert.pem -days 365

openssl pkcs12 -export -in cert.pem -inkey key.pem -out certificate.p12 -name "certificate"

``` 
2. Add the properties below to application.properties file.
- server.ssl.key-store-type=PKCS12
- server.ssl.key-store=classpath:certificate.p12
- server.ssl.key-store-password=12345

3. Move certificate.p12 file to /resources folder
