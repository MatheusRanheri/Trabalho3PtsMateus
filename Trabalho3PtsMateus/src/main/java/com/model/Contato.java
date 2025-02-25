package com.model;

import java.time.LocalDate;
import java.util.Objects;

public class Contato {

    private String nome;
    private String telefone;
    private String emai;
    private LocalDate data;

    public Contato(){

    }

    public Contato(String nome, String telefone, String emai, LocalDate data) {
        this.nome = nome;
        this.telefone = telefone;
        this.emai = emai;
        this.data = data;
    }

    public void gerarId(){
        int id = 1;
        id++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmai() {
        return emai;
    }

    public void setEmai(String emai) {
        this.emai = emai;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(nome, contato.nome) && Objects.equals(telefone, contato.telefone) && Objects.equals(emai, contato.emai) && Objects.equals(data, contato.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, telefone, emai, data);
    }

    @Override
    public String toString() {
        return "Contato{" +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", emai='" + emai + '\'' +
                ", data=" + data +
                '}';
    }
}
