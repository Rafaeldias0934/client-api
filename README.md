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

  ### Buscar Produto por ID
  
- **URL**: `/clients/{id}`
- **Método HTTP**: `GET`
- Parâmetros de Caminho:
-   `id`: UUID do cliente
- **Request Body**:
  ```json
  {
  "name": "cliente encontrado",
  "id": "id encontrado",
  "cpf_cnpj": 111.111.111.11
  }
