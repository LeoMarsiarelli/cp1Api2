# CP1 API 2 - Oficina Mecânica (Veículos & Serviços)

API RESTful em Spring Boot que persiste dados de **Veículos** e **Serviços** de uma oficina mecânica em um banco MySQL via Spring Data JPA.

Projeto referente ao Checkpoint 2 da disciplina **SOA - Microservices and Web Engineering** (FIAP, 1º semestre / 2026).

## Stack

- Java 25
- Spring Boot 4.0.3 (Web MVC + Spring Data JPA)
- MySQL 8
- springdoc-openapi (Swagger UI)
- Maven
- Docker / Docker Compose

## Entidades

### Veiculo (`veiculos`)

| Atributo | Tipo    | Nullable |
|----------|---------|----------|
| id       | Long    | não (PK) |
| placa    | String  | não      |
| modelo   | String  | não      |
| marca    | String  | não      |
| ano      | Integer | não      |
| cor      | String  | **sim**  |

### Servico (`servicos`)

| Atributo      | Tipo       | Nullable |
|---------------|------------|----------|
| id            | Long       | não (PK) |
| descricao     | String     | não      |
| valor         | BigDecimal | não      |
| duracaoHoras  | Integer    | não      |
| status        | String     | não      |
| observacoes   | String     | **sim**  |

## Como rodar

### 1. Subir o banco com Docker

Na raiz do projeto:

```bash
docker compose up -d
```

Alternativa, sem `docker-compose.yml`:

```bash
docker run --name cp1api2-mysql \
  -e MYSQL_ROOT_PASSWORD=root \
  -e MYSQL_DATABASE=cp1api2 \
  -e MYSQL_USER=cp1user \
  -e MYSQL_PASSWORD=cp1pass \
  -p 3306:3306 \
  -d mysql:8.0
```

O banco fica disponível em `localhost:3306`, com:

- Database: `cp1api2`
- Usuário: `cp1user`
- Senha: `cp1pass`

Essas credenciais já estão configuradas em `src/main/resources/application.properties`.

> **Importante:** se você estiver rodando a API1 (cinema) na mesma máquina, mude a porta exposta deste MySQL (ex.: `"3307:3306"`) e ajuste a URL em `application.properties` para evitar conflito de porta.

### 2. Subir a API

```bash
./mvnw spring-boot:run
```

Ou (Windows):

```bash
mvnw.cmd spring-boot:run
```

A API sobe na porta **8080**.

### 3. Documentação (Swagger)

[http://localhost:8080/](http://localhost:8080/)

## Endpoints

### Veículos (`/veiculos`)

| Método | Rota               | Descrição            |
|--------|--------------------|----------------------|
| GET    | `/veiculos`        | findAll              |
| GET    | `/veiculos/{id}`   | findById             |
| POST   | `/veiculos`        | Cria um veículo      |
| PUT    | `/veiculos/{id}`   | Atualiza um veículo  |
| DELETE | `/veiculos/{id}`   | Remove um veículo    |

Exemplo de body (POST/PUT):

```json
{
  "placa": "ABC1D23",
  "modelo": "Civic",
  "marca": "Honda",
  "ano": 2022,
  "cor": "Preto"
}
```

### Serviços (`/servicos`)

| Método | Rota               | Descrição            |
|--------|--------------------|----------------------|
| GET    | `/servicos`        | findAll              |
| GET    | `/servicos/{id}`   | findById             |
| POST   | `/servicos`        | Cria um serviço      |
| PUT    | `/servicos/{id}`   | Atualiza um serviço  |
| DELETE | `/servicos/{id}`   | Remove um serviço    |

Exemplo de body (POST/PUT):

```json
{
  "descricao": "Troca de óleo",
  "valor": 150.00,
  "duracaoHoras": 1,
  "status": "PENDENTE",
  "observacoes": "Usar óleo 5W30"
}
```

## Parar o banco

```bash
docker compose down
```
