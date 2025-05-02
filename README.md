# CodeChella

App de simulação de um site para venda de ingressos de eventos diversos

Projeto Spring Boot com PostgreSQL e PGAdmin usando Docker para ambiente de desenvolvimento local.
Este projeto faz parte do treinamento Curso de Arquitetura Java: descomplicando a Clean Architecture.

Apesar do projeto fazer parte de um treinamento, tomei a liberdade de adicionar a configuração com `.env`.

## 🔨 Objetivos do projeto

- Conhecer os diferentes tipos de arquitetura de software;
- Aprender os princípios da Clean Architecture;
- Implementar um projeto com separação de responsabilidades e isolamento do domínio;
- Entender sobre entidades, objetos de valor, casos de uso, repositórios e controladores;
- Analisar os prós e contras de arquiteturas que utilizam muitas camadas de abstração.

## 🚀 Tecnologias

- Java 17+
- Spring Boot
- PostgreSQL (via Docker)
- PGAdmin (interface web para o banco)
- Docker Compose
- Maven Wrapper
- Arquivos de ambiente (.env)

Antes de começar, você precisa ter as seguintes ferramentas instaladas na sua máquina:

- [Docker](https://www.docker.com/get-started) – para subir os containers do PostgreSQL e PGAdmin.
- [Java 17 ou superior](https://adoptium.net/) – para executar o Spring Boot.
- [Git](https://git-scm.com/) – para clonar o projeto.
- (Opcional) [Maven](https://maven.apache.org/) – o projeto inclui Maven Wrapper, então não é obrigatório instalar.

---

## ⚙️ Como configurar

### 1. Clone o repositório
HTTPS
```bash
git clone https://github.com/seu-usuario/codechella.git
```
SSH
```bash
git clone git@github.com:brunosansp/java-clean-architecture.git
```

### 2. Criar o arquivo .env

O projeto utiliza variáveis de ambiente definidas em um arquivo `.env` na raiz do projeto. Este arquivo não é 
versionado por segurança, então você precisa criá-lo manualmente.

Crie um novo arquivo chamado `.env` na raiz do projeto com o seguinte conteúdo:
```env
# Configuração do PostgreSQL (container)
POSTGRES_DB=codechella_db
POSTGRES_PASSWORD=1234567

# Configuração do PGAdmin
PGADMIN_DEFAULT_EMAIL=me@example.com
PGADMIN_DEFAULT_PASSWORD=1234567

# Configuração para o Spring Boot (conexão com o banco)
DB_HOST=localhost
DB_PORT=5433
DB_USER=postgres
DB_PASSWORD=1234567
```
Você pode alterar esses valores conforme sua preferência.

> ⚠️ Importante: nunca envie esse arquivo para o repositório. Ele está listado no .gitignore.

---

### 3. Subir os containers Docker

Com o `.env` criado, você pode subir os serviços do PostgreSQL e PGAdmin usando Docker Compose.

Execute o seguinte comando no terminal:
```bash
docker compose up -d
```
Isso iniciará dois containers:

- PostgreSQL: o banco estará disponível na porta 5433

- PGAdmin: painel de administração acessível em http://localhost:5050

Para acessar o PGAdmin, use o e-mail e a senha definidos no `.env`.

---

### 4. Rodar o projeto Spring Boot

Após os containers estarem ativos, execute o projeto Spring Boot.

O projeto utiliza Maven Wrapper, então você não precisa ter o Maven instalado globalmente.

Para rodar o projeto, execute o seguinte comando no terminal:

**Se estiver no Linux**
```bash
./mvnw spring-boot:run
```
**Se estiver no Windows**
```bash
mvnw.cmd spring-boot:run
```

---

🔧 Como a aplicação se conecta ao banco de dados

O Spring Boot está configurado para importar o arquivo `.env` e ler as variáveis diretamente de lá. 
A conexão com o banco é definida no arquivo `src/main/resources/application.properties`:

```properties
spring.config.import=optional:file:.env[.properties]

spring.datasource.url=jdbc:postgresql://${DB_HOST}:${DB_PORT}/${POSTGRES_DB}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

🗃️ Onde os dados são armazenados

Os dados do banco de dados e do PGAdmin são persistidos localmente usando volumes Docker. 
Eles ficam nos seguintes diretórios do projeto:

```text
./.data/postgresql/data
./.data/pgadmin
```
Se você quiser resetar completamente o estado do banco, pode remover a pasta `.data/`.
