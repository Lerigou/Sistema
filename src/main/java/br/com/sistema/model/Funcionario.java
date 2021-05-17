package br.com.sistema.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 80)
    @NotNull
    private String nome;

    @Size(max = 100)
    @NotNull
    private String email;

    @Size(max = 30)
    @NotNull
    private String telefone;

    @OneToOne
    @JoinColumn(name = "cargo_id", referencedColumnName = "id")
    private Cargo cargo;

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Funcionário:"
                + "\n  Nome = " + nome
                + "\n  Email = " + email
                + "\n  Telefone = " + telefone;
    }

}
