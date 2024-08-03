# Product Management API

Este projeto é uma API RESTful de gerenciamento de clientes construída com Spring Boot. 
A API permite criar, atualizar, buscar e deletar produtos. A estrutura do projeto segue 
boas práticas de desenvolvimento, utilizando camadas de serviço, repositório e controladores, 
bem como tratamento de exceções personalizado.

## Funcionalidades

- **Criar Cliente**: Adiciona um novo produto ao sistema.
- **Atualizar Cliente**: Atualiza as informações de um produto existente.
- **Buscar Cliente por ID**: Retorna as informações de um produto específico.
- **Deletar Cliente**: Remove um produto do sistema.

## Endpoints

### Criar Produto

- **URL**: `/products`
- **Método HTTP**: `POST`
- **Request Body**:
  ```json
  {
    "name": "Nome do Produto",
    "description": "Descrição do Produto",
    "price": 99.99
  }
