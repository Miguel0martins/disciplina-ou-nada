# Disciplina ou Nada

Gerenciador de tarefas em Java com Spring Boot que cobra a disciplina de quem deixa tarefa pra trás.

## O que ele faz

- Adiciona, lista, conclui e remove tarefas
- Cada tarefa tem título, descrição e prazo (data)
- Detecta tarefas atrasadas: não concluídas e com prazo vencido

## Tecnologias

- Java 17
- Spring Boot
- Maven
- Spring Data JPA
- H2 (banco em arquivo)
## Como rodar

    ./mvnw spring-boot:run

| PUT | /tarefas/{id}/concluir | Marca a tarefa como concluída (404 se não existir) |
| DELETE | /tarefas/{id} | Remove a tarefa (404 se não existir) |

## Rotas da API

| Método | Rota | O que faz |
|--------|------|-----------|
| GET | /tarefas | Lista todas as tarefas |
| GET | /tarefas/atrasadas | Lista só as tarefas atrasadas |
| GET | /tarefas/cobranca | Mensagem de cobrança conforme as atrasadas |
| POST | /tarefas | Cadastra uma tarefa (título, descrição e prazo) |
| PUT | /tarefas/{indice}/concluir | Marca a tarefa como concluída |
| DELETE | /tarefas/{indice} | Remove a tarefa |



## Status do projeto

Versão 1 pronta: API REST com banco de dados. Próximo passo: análise de sentimento com IA.

## Sobre o projeto

Feito durante a Imersão Engenharia de Software: Dev na Era da IA (Alura + Google for Startups), usando IA como apoio e revisando o código por conta própria.

## Autor

Miguel Martins Ferreira Barros, estudante de ADS na FIAP.