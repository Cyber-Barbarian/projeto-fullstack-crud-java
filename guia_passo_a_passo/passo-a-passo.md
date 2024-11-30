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
JPA (ou Java Persistence API) é uma especificação oficial que descreve como deve ser o comportamento dos frameworks de persistência Java que desejarem implementá-la.

Podemos pensar na especificação JPA como uma interface que possui algumas assinaturas, mas que precisa que alguém a implemente.

Mapeamento Objeto Relacional é a representação de uma tabela de um banco de dados relacional através de classes Java.

É também conhecido como ORM ou Object Relational Mapping.

Enquanto que no banco de dados temos tabelas, colunas e registros, em uma linguagem orientada a objetos, como o Java, temos o equivalente com classes, atributos e objetos.

Sendo assim, com a finalidade de criar uma tabela  devemos criar uma classe de entidades equivalente (**Entity**).

Vamos prosseguir entõ com a criação de uma entidade que representa a tabela de empregados que terá os seguintes atributos (colunas):
- id - Chave primária
- nome - Nome do empregado
- cargo - Cargo do empregado
- salario - Salário do empregado
- dataNascimento - Data de nascimento
- numeroDependentes - Quantidade de dependentes
- emailCorporativo - Email

Para este projeto, a princípio, tentaremos seguir a estrutura de diretórios abaixo:

![img.png](estrutura-de-diretorios.png)

Portanto, dentro da pasta do projeto vamos criar a pasta entity e dentro dela a classe Empregado.java, usando a anotação *@Entity* e a anotação *@Table*, que demonstrará ao spring que essa classe representa uma tabela. 

Dentro de nossa classe iniciamos a criação de atributos privados e métodos construtores normalmente. Entretanto, precisaremos criar um getter e um setter para cada atributo, devemos estar atentos às anotações *@Id*, *@GeneratedValue* e *@Column*, que evem vir sobre os gets.

[Empregado.java](..%2Fsrc%2Fmain%2Fjava%2Fcom%2Fcyberbarbarian%2FcrudEmpregados%2Fentity%2FEmpregado.java)

```java
package com.cyberbarbarian.crudEmpregados.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "empregados")
public class Empregado {
    //Passo 1 - criação dos atributos
    private long id;
    private String nome;
    private String cargo;
    private float salario;
    private LocalDate dataNascimento;
    private long numeroDependentes;
    private String emailCorporativo;

    //Passo 2 - criação dos construtores
    public Empregado () {
    }

    public Empregado(long id, String nome, String cargo, float salario, LocalDate dataNascimento, long numeroDependentes, String emailCorporativo) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.dataNascimento = dataNascimento;
        this.numeroDependentes = numeroDependentes;
        this.emailCorporativo = emailCorporativo;
    }

    //Passo 3 - criação dos getters e setters com as devidas anotações

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//melhor com mysal
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Column(name = "nome", nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    @Column(name = "cargo", nullable = false)
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    @Column(name = "salario", nullable = false)
    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
    @Column(name = "data_nascimento", nullable = false)
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    @Column(name = "numero_dependentes")
    public long getNumeroDependentes() {
        return numeroDependentes;
    }

    public void setNumeroDependentes(long numeroDependentes) {
        this.numeroDependentes = numeroDependentes;
    }

    @Column(name = "email_corporativo")
    public String getEmailCorporativo() {
        return emailCorporativo;
    }

    public void setEmailCorporativo(String emailCorporativo) {
        this.emailCorporativo = emailCorporativo;
    }

    //Passo 4 - criação do toString para a classe
    @Override
    public String toString() {
        return "Empregado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                ", dataNascimento=" + dataNascimento +
                ", numeroDependentes=" + numeroDependentes +
                ", emailCorporativo='" + emailCorporativo + '\'' +
                '}';
    }
}

```

