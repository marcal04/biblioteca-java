Biblioteca Java — Sistema de Gerenciamento

Sistema de gerenciamento de biblioteca desenvolvido em **Java**, utilizando **Maven**, **JDBC** e **MySQL**, com funcionalidades completas de **CRUD** e **menu interativo no terminal**.
O projeto permite cadastrar autores, livros e usuários, além de realizar empréstimos de livros, controlando a disponibilidade de cada exemplar.



Funcionalidades

 Usuários
- Cadastrar usuário
- Listar usuários
- Buscar usuário por ID
- Validação de e-mail único

Autores
- Cadastrar autor
- Listar autores

Livros
- Cadastrar livro vinculado a um autor
- Listar livros
- Buscar livro por ID
- Controle de disponibilidade (emprestado / disponível)

mpréstimos
- Realizar empréstimo de livro
- Impedir empréstimo de livro indisponível
- Listar empréstimos

 Tecnologias Utilizadas

- **Java 17+**
- **Maven**
- **JDBC**
- **MySQL**
- **Padrão DAO**
- **Builder Pattern**
- **CLI (Menu no terminal)**
- **Git & GitHub**



Estrutura do Projeto
src/main/java/com/biblioteca
│
├── cli # Menus e interface via terminal

├── daos # Interfaces DAO

├── entity # Implementações DAO 

├── models # Models

├── services # Regras de negócio

├── factorys # Conexão com banco de dados

