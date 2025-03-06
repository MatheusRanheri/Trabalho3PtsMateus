package com.controller;

import com.model.Contato;
import com.model.ParametroInvalidoException;

import java.time.LocalDate;
import java.util.*;

public class Agenda extends Contato{

    private List<Contato> contatos;

    public Agenda(){
        contatos = new ArrayList<>();
    }


    public void adicionar(long id, String nome, String email, String telefone, LocalDate data) throws ParametroInvalidoException {
        if (nome == null || nome == ""){
            throw new ParametroInvalidoException("O nome é um campo obrigatorio");
        }else if (telefone == null || telefone == ""){
            throw new ParametroInvalidoException("O telefone é um campo obrigatorio.");
        }else if (data == null){
            throw new ParametroInvalidoException("A data é um campo obrigatorio.");
        }
        adicionar(new Contato(id, nome, telefone, email, data));
    }

    private void adicionar(Contato contato) {
        contatos.add(contato);
    }


    public List<Contato> listarContatos(){

        return contatos.stream().sorted(Comparator.comparing(Contato::getNome))
                .toList();


    }

    public void remover(long id)throws NoSuchElementException{

            Contato remover = contatos.stream().filter(contato -> contato.getId() == id).findFirst().get();

            contatos.remove(remover);
            System.out.println("Contato removido!!");

    }

    public void editarContato(Long id, String nome, String telefone, String email, LocalDate data){
        Contato editar = null;

        for (Contato c : contatos){
            if(id.equals(c.getId())){
                editar = c;
            }
        }

        if (editar != null) {
            editar.setNome(nome);
            editar.setEmail(email);
            editar.setData(data);
            editar.setTelefone(telefone);
        }else{
            System.out.println("Contato não encontrado");
        }
    }

    public void pesquisaPorLetra(String nome){

        List<Contato> pesquisa = contatos.stream().filter(contato -> contato.getNome().startsWith(nome)).toList();


        if (pesquisa.isEmpty()){
            System.out.println("Nenhum contato encontrado com esse nome");
        }else {
            System.out.println("contatos encontrados: ");
            System.out.println(pesquisa);
        }


    }

    public void aniversarianteDoMes(int mes){

        List<Contato> aniversariantes = contatos.stream().filter(contato -> contato.getData().getMonthValue() == mes).toList();

        if (aniversariantes != null){
            System.out.println(aniversariantes);
        }else{
            System.out.println("Nenhum aniversariante encontrado");
        }


    }


}
