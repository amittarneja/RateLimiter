# RateLimiter

Instructions for running the code.

I developed the code using Eclipse, Maven, and Apache Tomcat (to deploy the code). Please follow the instruction to deploy the Webservice

1. Open the code in Eclipse and perform Maven clean/Install.
2. Right-click on the project - > properties -> Deployment assembly -> Add Java build path entries - > Maven dependencies - Apply and close. This step is to avoid the NOCLASSDEFFOUNDERROR exception.
3. Right-click on the project and select run on the server (I ran it on Apache Tomcat). Follow the instruction in the link to set up Tomcat in eclipse (https://help.eclipse.org/neon/index.jsp?topic=%2Forg.eclipse.stardust.docs.wst%2Fhtml%2Fwst-integration%2Fconfiguration.html).
4. In the browser, type the URL as http://localhost:8080/RateLimiter/v1/tickets/1
5. You will get a 204 response code from the server.
6. I tested this code with POSTMAN collection runner to generate the response code 429 when the number of requests exceeded the intended number.
7. To test it without POSTMAN, make changes in the RateLimiterFilter.java and change line number 21 as rateLimiter = RateLimiter.create(1.0);
6. Save the file and perform steps 1-4 again. For step 4, try sending 2 requests within 1 sec, and you should see error 429.
