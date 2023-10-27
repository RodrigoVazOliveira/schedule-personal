# API REST Schedule

API Rest para gerenciamento de agenda

---

# Tecnologia:

- Java 21
- Spring Boot 3
- H2
- Spring Data JPA
- Spring Validation
- Spring openapidoc
- PostgreSQL
- Gradle 8.3
- Arquitetura Clean Code
- Projeto modularizado

# ENDPOINTS:

| METHOD | ENDPOINT          | DESCRIPTION                                  | PAYLOAD |
|--------|-------------------|----------------------------------------------|---------|
| POST   | /v1/owners        | cadastrar novo organizador                   | JSON    |
| GET    | /v1/owners/{id}   | Obtem um organizador por id                  | JSON    |
| GET    | /v1/owners        | retorna uma lista com todos os organizadores | JSON    |
| POST   | /v1/markings      | registra um nova marcação                    | JSON    |
| PATCH  | /v1/markings/{id} | atualizar uma marcação                       | JOSN    |     
| GET    | /v1/markings      | lista todas marcações                        | JSON    |



---

## Payload:

### 1. Owners - cadastrar/atualizar:

```json
{
  "firstName": "Primeiro nome",
  "lastName": "Segundo nome",
  "dateOfBirth": "1991-05-05",
  "email": "umeprincimpalmail@email.com"
}
```

### 2. Owners - resposta:

```json
{
  "id": 2,
  "firstName": "Primeiro nome",
  "lastName": "Segundo nome",
  "dateOfBirth": "1991-05-05",
  "email": "umeprincimpalmail@email.com",
  "dateTimeCreated": "2023-10-27T08:34:10.227113544",
  "dateTimeUpdated": "2023-10-27T08:34:10.227121986"
}
```

### 3. Markings - registrar/atualizar:

```json 
{
  "name": "meu primeiro invite",
  "description": "Essa e a descricao do maracação de reunião",
  "idOwner": 2,
  "invites": [
    2
  ],
  "dateTimeInviteInitial": "2023-10-20 10:30:00",
  "dateTimeInviteFinal": "2023-10-20 11:30:00"
}
```

### 4. Markings - resposta:

```json
{
  "id": 2,
  "owner": {
    "id": 2,
    "firstName": "Primeiro nome",
    "lastName": "Segundo nome",
    "dateOfBirth": "1991-05-05",
    "email": "umeprincimpalmail@email.com",
    "dateTimeCreated": "2023-10-27T08:34:10.227114",
    "dateTimeUpdated": "2023-10-27T08:34:10.227122"
  },
  "invites": [
    {
      "id": 2,
      "firstName": "Primeiro nome",
      "lastName": "Segundo nome",
      "dateOfBirth": "1991-05-05",
      "email": "umeprincimpalmail@email.com",
      "dateTimeCreated": "2023-10-27T08:34:10.227114",
      "dateTimeUpdated": "2023-10-27T08:34:10.227122"
    }
  ],
  "name": "meu primeiro invite",
  "description": "Essa e a descricao do maracação de reunião",
  "dateTimeInviteInitial": "2023-10-20T10:30:00",
  "dateTimeInviteFinal": "2023-10-20T11:30:00",
  "dateTimeCreated": "2023-10-27T08:36:13.561503908",
  "dateTimeUpdated": "2023-10-27T08:36:13.561511789"
}
```

---

## Documentação:

Para acessar a documentação:

 http://localhost:8080/swager-ui.html