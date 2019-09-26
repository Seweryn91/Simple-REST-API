# Simple-REST-API  
Stupid-simple REST API with entities preserved in-memory.  
Run the main app, go to http://localhost:8080/customers  
List of customers will fill up automatically.  
Using POSTMAN you can test adding new customers or delete existing ones.  

After going to http://localhost:8080/customers method GET:
![after method GET on empty collection](https://user-images.githubusercontent.com/34771956/65697874-f951d600-e07b-11e9-96e2-83505c39af9c.png)  

It's possible to POST new customer:
![after method POST](https://user-images.githubusercontent.com/34771956/65697890-fe168a00-e07b-11e9-9289-dc59e643ba22.png)
![new customer was added](https://user-images.githubusercontent.com/34771956/65697903-02db3e00-e07c-11e9-93e2-29659f7b00cb.png)
  
It's possible to DELETE customer from collectiom
![HTTP response is sent](https://user-images.githubusercontent.com/34771956/65697905-02db3e00-e07c-11e9-910c-113f43e6ce74.png)
