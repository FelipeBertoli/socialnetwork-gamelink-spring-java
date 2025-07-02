# Rede Social Gamelink - Spring Boot & Java

Este projeto é uma rede social fictícia voltada ao universo gamer, desenvolvida com Spring Boot e Java. A aplicação permite interações entre usuários, como criação de posts, gerenciamento de perfis e navegação pelo feed.

## 🚀 Tecnologias utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Spring Web
- MySQL
- Thymeleaf

## ✨ Funcionalidades

- Cadastro e autenticação de usuários
- Criação, edição e exclusão de publicações
- Exibição de feed com posts recentes
- Gerenciamento de perfil de usuário
- Integração com banco de dados MySQL
- Interface web com Thymeleaf
- Estrutura MVC utilizando Spring

## 📦 Como executar localmente

1. Clone o repositório:
```bash
git clone https://github.com/FelipeBertoli/socialnetwork-gamelink-spring-java.git
```

2. Importe o projeto em sua IDE Java (IntelliJ, Eclipse, etc.)

3. Configure o `application.properties` com os dados do seu banco MySQL:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gamelink_social
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.jpa.hibernate.ddl-auto=update
```

4. Execute a aplicação:
```bash
./mvnw spring-boot:run
```

5. Acesse em: `http://localhost:8080`

## 📁 Estrutura do projeto

```
socialnetwork-gamelink-spring-java/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/gamelink/social/
│   │   └── resources/
│   │       ├── templates/
│   │       └── application.properties
└── pom.xml
```

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais informações.
