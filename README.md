# Lab Padrões Projeto Spring

Este projeto demonstra a aplicação de **Padrões de Projeto** utilizando o framework **Spring Boot**. Ele implementa funcionalidades de cadastro e gerenciamento de clientes com integração com o serviço de CEP do **ViaCEP**, além de utilizar banco de dados **H2** e comunicação via **API REST**.

## Funcionalidades

- Cadastro de clientes.
- Atualização de informações de clientes.
- Exibição de todos os clientes.
- Exibição de um cliente específico.
- Deleção de clientes.
- Integração com a API ViaCEP para consulta de endereços a partir do CEP.

## Arquitetura

O projeto segue uma arquitetura **Clean Architecture**, com implementação dos padrões **Facade** e **Strategy** para simplificar a integração com o banco de dados e a API externa do ViaCEP.

### Componentes

- **Controller**: Responsável por expor a API REST.
- **Service**: Implementa a lógica de negócios.
- **Model**: Contém as entidades `Cliente` e `Endereco`, que são armazenadas no banco de dados.
- **Repository**: Interface para comunicação com o banco de dados utilizando **Spring Data JPA**.
- **FeignClient**: Consome a API externa **ViaCEP** para obter informações de endereço a partir do CEP.

## Tecnologias Utilizadas

- **Spring Boot**: Framework principal para construção do backend.
- **Spring Data JPA**: Para persistência de dados no banco de dados.
- **Spring Cloud OpenFeign**: Para consumo da API do ViaCEP.
- **H2 Database**: Banco de dados em memória para armazenamento de clientes e endereços.
- **Swagger/OpenAPI**: Documentação automática da API REST.

## Endpoints da API

**Base URL**: `[http://127.0.0.1:8080](http://127.0.0.1:8080/swagger-ui/index.html)`

![image](https://github.com/user-attachments/assets/31bea3ff-6396-4d03-92db-9f69958b1285)
