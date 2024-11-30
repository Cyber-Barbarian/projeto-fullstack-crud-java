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
