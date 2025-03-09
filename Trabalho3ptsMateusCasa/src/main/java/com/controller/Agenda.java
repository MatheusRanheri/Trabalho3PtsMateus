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


    public void adicionar(long id, String nome, String telefone, String email, LocalDate data) throws ParametroInvalidoException {
        if (nome == null || nome.isEmpty()){
            throw new ParametroInvalidoException("O atributo nome é obrigatorio");
        }else if (telefone == null || telefone.isEmpty()){
            throw new ParametroInvalidoException("O atributo telefone é obrigatorio.");
        }else if (data == null){
            throw new ParametroInvalidoException("O atributo data é obrigatorio.");
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

    public void remover(long id){

        Contato remover = contatos.stream().filter(contato -> Objects.equals(contato.getId(), id))
                .findFirst()
                .orElse(null);

        if (remover != null){
            contatos.remove(remover);
            System.out.println("Cotato removido");
        }else{
            System.out.println("Id não encontrado");
        }

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

        List<Contato> aniversariantes = contatos.stream().filter(contato -> contato.getData().getMonthValue() == mes)
                .sorted(Comparator.comparing(Contato::getData).reversed()).toList();

        aniversariantes.forEach(contato -> System.out.println(
                "Id: " + contato.getId() +
                        ", Nome: " + contato.getNome() +
                        ", Data: " + contato.getData()
                ));

        if (!aniversariantes.isEmpty()) {
            System.out.println("Aniversariantes encontrados");
        } else {
            System.out.println("Nenhum aniversariante encontrado");
        }


    }


}
