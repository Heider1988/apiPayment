# API de Processamento de Pagamentos

## Sobre o Projeto

Esta API de processamento de pagamentos foi desenvolvida para lidar com diferentes métodos de pagamento utilizando o padrão de design Factory Method. A aplicação suporta pagamentos via cartão de crédito, boleto bancário e PIX, seguindo os princípios de SOLID para garantir um código limpo, extensível e de fácil manutenção.

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring MVC
- Spring Data JPA
- Lombok
- Jakarta Persistence API
- JUnit 5 (para testes)

## Estrutura do Projeto

O projeto segue uma arquitetura em camadas bem definida:

```
├── config             # Configurações gerais (Segurança, Swagger, CORS, Beans)
├── controller         # REST Controllers (endpoints)
├── response           # Data Transfer Objects (resposta)
├── request            # Data Transfer Objects (requisição)
├── exception          # Tratamento de erros e exceções customizadas
├── mapper             # MapStruct ou mapeadores manuais DTO ↔ Entity
├── model              # Entidades JPA / domain objects
├── repository         # Spring Data JPA Repositories
├── service            # Regras de negócio (interfaces)
├── service.impl       # Implementações de Service
└── util               # Classes utilitárias e helpers
```


## Padrão Factory Method

Este projeto implementa o padrão de design Factory Method para lidar com diferentes tipos de processadores de pagamento. O Factory Method é um padrão criacional que:

- Fornece uma interface para criar objetos em uma superclasse, mas permite que as subclasses alterem o tipo de objetos criados
- Promove baixo acoplamento entre classes
- Segue o princípio Open/Closed do SOLID, permitindo adicionar novos tipos de pagamento sem modificar o código existente

No nosso caso, temos uma interface `PaymentProcessorService` e implementações específicas como `PixPaymentProcessor`, `CreditCardPaymentProcessor` e `BankSlipPaymentProcessor`.

## Endpoints da API

### Pagamento com Cartão de Crédito
```
POST /api/payments/credit-card
```


### Pagamento com Boleto Bancário
```
POST /api/payments/bank-slip
```


### Pagamento com PIX
```
POST /api/payments/pix
```


## Como Executar o Projeto

1. Certifique-se de ter o JDK 17 instalado
2. Clone o repositório
3. Configure o banco de dados no arquivo `application.properties`
4. Execute o comando: `./mvnw spring-boot:run`
5. A API estará disponível em: `http://localhost:8080`

## Documentação da API

A documentação completa da API está disponível via Swagger UI em:
```
http://localhost:8080/swagger-ui.html
```


## Testes

Para executar os testes:
```
./mvnw test
```


## Princípios SOLID Aplicados

### Single Responsibility Principle (SRP)
Cada processador de pagamento tem uma única responsabilidade de processar um tipo específico de pagamento.

### Open/Closed Principle (OCP)
A estrutura permite adicionar novos tipos de pagamento sem modificar o código existente, apenas criando novos processadores que implementem a interface PaymentProcessorService.

### Liskov Substitution Principle (LSP)
Todos os processadores de pagamento podem ser usados de forma intercambiável através da interface PaymentProcessorService.

### Interface Segregation Principle (ISP)
A interface PaymentProcessorService é focada apenas no essencial para o processamento de pagamentos.

### Dependency Inversion Principle (DIP)
As classes de alto nível dependem de abstrações (interfaces) e não de implementações concretas.

## Contribuição

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Faça commit das suas alterações (`git commit -m 'Adiciona nova feature'`)
4. Faça push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request

## Licença

Este projeto está licenciado sob a licença MIT - veja o arquivo LICENSE para mais detalhes.

## Contato

Para mais informações, entre em contato através do email: seuemail@exemplo.com