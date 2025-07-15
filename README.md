## 📚 ForumHub API
Bem-vindo ao ForumHub, uma API REST construída com Spring Boot para gerenciar tópicos de discussão. Ela conta com autenticação via JWT, documentação via Swagger, e boas práticas de segurança usando Spring Security.

## 🚀 Tecnologias utilizadas

💚 Spring Boot 3

🔐 Spring Security + JWT

🐘 Spring Data JPA

🧪 Swagger (OpenAPI 3)

🛢️ Banco de dados H2 (testes) ou PostgreSQL (produção)

🛡️ BCrypt para hashing de senhas

🛠️ Lombok, ModelMapper

## 🔒 Autenticação e Autorização

A API usa JWT para proteger as rotas. Ao se autenticar, você receberá um token que deve ser enviado no header Authorization das requisições:

Authorization: Bearer <seu_token_jwt>

## ✳️ Perfis de usuário disponíveis:

USER: pode criar e visualizar tópicos

ADMIN: pode editar e excluir tópicos

## 📂 Endpoints principais
Método	Rota	Descrição	Autenticação

POST	/auth/register	Cadastro de novo usuário	❌ pública

POST	/auth/login	Autenticação e geração de token JWT	❌ pública

GET	/topicos	Listar tópicos	✅ protegida

POST	/topicos	Criar novo tópico	✅ USER

PUT	/topicos/{id}	Atualizar tópico por ID	✅ ADMIN

DELETE	/topicos/{id}	Remover tópico por ID	✅ ADMIN

## 🧠 Autor(a)
Feito com carinho por Gisele. Quer contribuir ou dar sugestões? 
Sinta-se à vontade para abrir uma issue ou enviar um pull request!
