# fxCurrency

Installation Guide:
1) Clone the project
2) Open Project through any IDE
3) Run the project / Configure Tomcat then run Project
4) Test the API via Postman
  **CURLS**
  - GET Currency List
  curl --location --request GET 'http://localhost:8080/fxCurrency' \
       --header 'Content-Type: application/json' \
       --header 'Accept: application/json'
  - POST Convert
  curl --location --request POST 'http://localhost:8080/fxCurrency/convert?from=PHP&to=JPY&amount=100' \
       --header 'Content-Type: application/json' \
       --header 'Accept: application/json'
       
** You can also access the curls via the yaml file.
** As for the current reponse in Swagger its not configured properly to show the proper response
![image](https://user-images.githubusercontent.com/22758392/164996314-33f27add-3baa-4db8-bb78-4e0d26921de7.png)
