# API-C.A.R: Sistema de Gerenciamento de Viagens e Motoristas

<p>O API-C.A.R é uma API robusta e escalável projetada para gerenciar motoristas, passageiros e solicitações de viagens, com integração para serviços de mapas. 
Desenvolvido com Spring Boot, esta solução oferece uma base sólida para empresas que buscam otimizar suas operações de transporte e logística.</p>

---

## 🚀 Funcionalidades

- Gerenciamento de Motoristas:

  - Cadastro e manutenção de perfis de motoristas.

  - APIs para criação, leitura, atualização e exclusão (CRUD) de dados de motoristas.

- Gerenciamento de Passageiros:

  - Cadastro e manutenção de perfis de passageiros.

  - APIs para CRUD de dados de passageiros.

- Solicitações de Viagem:

  - Criação e acompanhamento de solicitações de viagem.

  - Gerenciamento do status das solicitações de viagem (por exemplo, pendente, aceita, em andamento, concluída, cancelada).

- Integração com Serviços de Mapas:

  - Funcionalidade para integração com o Google Maps (GMapsService) para cálculo de rotas, distâncias e estimativa de tempo.

## 🛠️ Tecnologias Utilizadas

- Linguagem: Java

- Framework: Spring Boot

- Gerenciador de Dependências: Maven

- Bancos de Dados (Exemplos):

- H2 (para desenvolvimento e testes - inferido por ser comum em projetos Spring Boot)

- PostgreSQL (para produção - exemplo de integração, pois a estrutura permite facilmente outros bancos)

- APIs Externas: Google Maps API (GMapsService)

## 📦 Estrutura do Projeto

### O projeto segue uma arquitetura modular, facilitando a manutenção e a expansão.

- **src/main/java/com/king/demo_car_api/:** Pacote raiz da aplicação.

- **controller/:** Contém os controladores REST para as operações de API (ex: DriverController, PassengerController, TravelRequestController).

- **DTO/:** Define os objetos de transferência de dados (Data Transfer Objects) para entrada e saída de dados (ex: DriverDTO, PassengerDTO, TravelRequestInput, TravelRequestOutput).

- **entitys/:** Contém as entidades de persistência que representam os modelos de dados no banco (ex: Driver, Passenger, TravelRequest, TravelRequestStatus).

- **mapper/:** Responsável pela conversão entre DTOs e entidades (ex: MapperDTODriver, MapperDTOPassenger, TravelRequestMapper).

- **repository/:** Interfaces de repositório para acesso a dados, utilizando Spring Data JPA (ex: DriverRepository, PassengerRepository, TravelRequestRepository).

- **service/:** Contém a lógica de negócios da aplicação (ex: DriverService, PassengerService, TravelRequestService, GMapsService).

- **src/main/resources/:** Contém arquivos de configuração (ex: application.properties).

- **src/test/:** Contém os testes da aplicação.

- **pom.xml:** Arquivo de configuração do Maven para gerenciamento de dependências e construção do projeto.

- **mvnw, mvnw.cmd:** Wrappers Maven para execução do projeto sem necessidade de instalação global do Maven.

## 🚀 Como Executar o Projeto Localmente

### Pré-requisitos

- Java Development Kit (JDK) 17 ou superior

- Maven (opcional, pode usar os wrappers mvnw)

- Um IDE como IntelliJ IDEA, Eclipse ou VS Code com suporte a Java e Spring Boot

### Instalação

- #### Clone o repositório:

```properties
[Bash]

git clone https://github.com/menhararthur/api-c.a.r.git

cd menhararthur/api-c.a.r
```

#### Construa o projeto com Maven:

```properties
[Bash]

./mvnw clean install
```
### Configuração da Aplicação

#### Configure o arquivo application.properties:

- **Neste arquivo** (src/main/resources/application.properties), você pode configurar o banco de dados e outras propriedades da aplicação.

- Exemplo para H2 (banco de dados em memória):

```properties
[Properties]

spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:cardb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
```
- **Para integração com Google Maps:** Você precisará adicionar sua chave de API do Google Maps e configurar o GMapsService adequadamente.

### Executando a Aplicação

- ####  Via Maven Wrapper:

```properties
Bash

./mvnw spring-boot:run
```
- Via IDE:

- Importe o projeto como um projeto Maven.

- Execute a classe principal DemoCarApiApplication.java.

#### A API estará disponível em http://localhost:8080 (porta padrão do Spring Boot).

### 📝 Documentação da API

#### Após iniciar a aplicação, a documentação dos endpoints pode ser acessada através de ferramentas como Swagger UI (se configurado no projeto) em http://localhost:8080/swagger-ui.html ou similar.
#### Caso contrário, os controladores (*Controller.java) fornecem os detalhes dos endpoints.</p>

### 🤝 Contribuição

#### Contribuições são bem-vindas! Para contribuir, siga estes passos:

- Faça um fork do repositório.

- Crie uma nova branch (git checkout -b feature/sua-feature).

- Faça suas alterações e commit (git commit -am 'Adiciona nova feature').

- Envie para a branch (git push origin feature/sua-feature).

- Abra um Pull Request.

### 📧 Contato

- Arthur Menhar N. Oliveira

- Linkedin: https://www.linkedin.com/in/arthur-menhar-78a612152?lipi=urn%3Ali%3Apage%3Ad_flagship3_profile_view_base_contact_details%3BFbJqHfUkTVW7C62FWN0mtQ%3D%3D

- e-mail: arthurmenhar@gmail.com

- telefone: (31) 9 9571-2630



  
