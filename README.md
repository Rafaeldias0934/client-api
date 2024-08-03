# Client Management API

This project is a RESTful API for client management built with Spring Boot. The API allows creating, updating, retrieving, and deleting clients. The project structure follows best practices, utilizing service, repository, and controller layers, as well as custom exception handling.

## Features

- **Create Client**: Adds a new client to the system.
- **Update Client**: Updates the information of an existing client.
- **Get Client by ID**: Retrieves information about a specific client.
- **Delete Client**: Removes a client from the system.

## Endpoints

### Create Client

- **URL**: `/clients`
- **HTTP Method**: `POST`
- **Request Body**:
  ```json
  {
    "name": "Client Name",
    "cpf_cnpj": 111.111.111.11
  }

### Get Client by ID
  
- **URL**: `/clients/{id}`
- **Método HTTP**: `GET`
- Parâmetros de Caminho:
-   `id`: UUID do cliente
  
-Response:
-Status: 200 OK
-Body: Retrieved client

-Status: 404 NOT FOUND
-Body: "not found"

###Update Client
-URL: /clients/{id}
-HTTP Method: PUT
-Path Parameters:
-  `id`: UUID of the client
Request Body:
{
  "name": "Updated Client Name",
  "cpf_cnpj": "Updated Client cpf_cnpj"
}

###Delete Client
-URL: /clients/{id}
-HTTP Method: DELETE
-Path Parameters:
-  `id`: UUID of the client
-  
-Response:
-Status: 200 OK
-Body: "Client deleted successfully."

-Status: 404 NOT FOUND
-Body: "Client not found}"
