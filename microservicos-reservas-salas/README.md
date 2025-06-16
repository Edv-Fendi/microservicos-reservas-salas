# Sistema de Agendamento de Espaços

Este é um sistema de agendamento de espaços físicos, desenvolvido com arquitetura de microsserviços utilizando Spring Boot, mensageria com RabbitMQ, JPA, PostgreSQL e comunicação via REST e AMQP.

## 🧱 Microserviços

O projeto é composto por quatro serviços principais:

- **Pessoa**: Cadastro e gerenciamento de pessoas (antes chamado de usuário).
- **Espaço Físico**: Gerencia as salas disponíveis (refatorado de "Sala").
- **Agendamento**: Registra e consulta agendamentos.
- **Gateway**: Responsável por escutar os eventos de agendamento via RabbitMQ.

---

## 📦 Tecnologias Utilizadas

- Java 17
- Spring Boot 3.4.x
- Spring Web
- Spring Data JPA
- RabbitMQ (Mensageria)
- PostgreSQL (Banco de dados)
- Docker e Docker Compose (opcional)
- Lombok

---

## 🔁 Comunicação entre microsserviços

### Mensageria com RabbitMQ

O processo de criação de agendamentos via evento funciona da seguinte forma:

1. **Pessoa** e **Espaço Físico** são previamente cadastrados.
2. O **AgendamentoController** envia uma mensagem no formato `pessoaId,ambienteId` para a fila `evento.agendamento.criado`.
3. O consumidor do microserviço de **Agendamento** processa a mensagem e salva o agendamento.

---

## 🎯 Endpoints principais

### Pessoa

```http
GET    /pessoas
GET    /pessoas/{id}
POST   /pessoas/salvar
```

### Espaço Físico

```http
GET    /espacos
GET    /espacos/{id}
POST   /espacos/salvar
```

### Agendamento

```http
GET    /agendamentos
GET    /agendamentos/detalhes/{id}
POST   /agendamentos/registrar
POST   /agendamentos/registrar-com-evento?pessoa=1&ambiente=2
```

---