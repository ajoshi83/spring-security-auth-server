# spring-security-auth-server

This project is a poc for RBAC with OAuth2 server using spring-boot2.

After you start the project (it runs on port 7001), use below command to receive access token:

  http -a my-client:secret --form POST http://localhost:7001/oauth/token username="amol@dd.com" password="amol123" grant_type="password"

Use below command to access user URI, replace ??? below with the token received through above command:
  
  http  http://localhost:7001/api/v1/assessments access_token=="???"
