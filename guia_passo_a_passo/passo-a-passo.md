# 01-Iniciando o projeto

Primeiramente criamos o projeto por meio do Spring Initializr https://start.spring.io/.
O Spring Initializr é uma ferramenta web que permite criar projetos Spring Boot a partir de configurações pré-moldadas. Ele é uma forma fácil de iniciar um projeto Spring Boot, pois oferece uma interface simples para o usuário.

O projeto será montado da seguinte forma:

![springInitializr.png](springInitializr.png)


Após descompactado, podemos verificar o conteúdo do projeto, sua estrutura de pastas e, sobretudo, o arquivo [pom.xml](..%2Fpom.xml), que contém todas as dependências.

O projeto inclusive já pode ser executado:

![estrutura-e-execucao.png](estrutura-e-execucao.png)

# 02-Configurando o banco de dados
Nesse projeto foram incluídos dois bancos de dados: o H2 e o MySQL.

O H2 é um banco de dados de código aberto e leve, que roda em memória, para o desenvolvimento e teste de APIs. Como ele roda em memória e é um banco de dados de testes, não há necessidade de nenhuma configuração extra. Apenas chamá-lo no [pom.xml](..%2Fpom.xml). 

Já o MySQL é um banco de dados de base de dados relacional, que roda em um servidor de base de dados e possibilita a criação de aplicativos de rede. Para usá-lo, além de importar a dependência pelo [pom.xml](..%2Fpom.xml) precisamos configurar o [application.properties](..%2Fsrc%2Fmain%2Fresources%2Fapplication.properties) para se conectar ao banco de dados MySQL, adicinando as credenciais a seguinte configuração.

```text
spring.datasource.url = jdbc:mysql://localhost:3306/users_database?useSSL=false
spring.datasource.username = root
spring.datasource.password = root


## Hibernate Properties
# The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto = update

server.servlet.context-path=/springboot-crud-rest
```
Devemos ter o MySQL instalado e configurado, bem como preferencialmente o MySQL Workbench. Com o MySQL Workbench, podemos criar um novo banco de dados:

```sql
create database users_database;
```

![criando_users_database.png](criando_users_database.png)

# 03 - Criando a entidade de empregados
