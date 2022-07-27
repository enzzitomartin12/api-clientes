# api-clientes
API Clientes con Spring Boot - HIbernate - JPA - Swagger - Mysql

Interfaz de aplicacion para la funcionalidad de clientes.

Requisitos:
--> Levantar una DB de datos MySQL
-->crear una DB con el nombre "prueba"
-->crear un usuario de DB con las siguientes credenciales:
    -->username: admin
    -->password: admin
-->otorgar permisos para el usuario admin a traves de:
    GRANT ALL PRIVILEGES ON prueba.* TO 'admin'@'localhost' WITH GRANT OPTION;
-->verificar la conexion a la DB


Una vez realizados los pasos de la conexion de la base de datos, se prosigue con la configuracion del Backend.
Es un proyecto Spring Boot por lo cual deberia ser importado con Spring Tool Suite
--> Importar el proyectocon el correspondiente pom.xml
--> El proyecto se llama api-connectApps
--> una vez importado, se debe hacer un maven clean install
--> si todo funciona correctamente correr el proyecto con Run As Spring Boot App
--> si se compilo y deployo correctamente se deberian pasar a verificar las pruebas en postman
--> verificar que se creo en la DB una tabla cliente con:
    --> SELECT * FROM prueba.cliente

POSTMAN:
Importar la colleccion desde: https://www.getpostman.com/collections/fb0bd17a7dea0209c0f9
En la misma se encuentran los endpoints para verificar el funcionamiento de la API.
A continuacion una pequeña introduccion de los mismos:

add : localhost:8080/api/cliente/add --> Agrega una nueva entidad a la DB.
loadFromAPI : localhost:8080/api/cliente/loadFromAPI: --> se conecta por medio de HTTP a la URI "https://jsonplaceholder.typicode.com/posts" y carga automaticamente todos los datos en la DB.
get : localhost:8080/api/cliente/get --> Obtiene todos los datos de la entidad de la DB
getByID : localhost:8080/api/cliente/get/id --> Obtiene un cliente buscado por id
put : localhost:8080/api/cliente/update --> updetea los datos de un cliente
delete : localhost:8080/api/cliente/delete/400 --> elimina los datos de un cliente enviando el id por parametro

Swagger:
Como es un proyecto que incluye esta libreria se puede obtener documentacion relevante de los endpoints en:
http://localhost:8080/swagger-ui.html/
NOTA: el proyecto debe estar corriendo.



