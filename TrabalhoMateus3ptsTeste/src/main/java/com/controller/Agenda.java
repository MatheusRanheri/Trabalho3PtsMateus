package com.controller;

import com.model.Contato;
import com.util.Teclado;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Agenda extends Contato{

    private List<Contato> contatos;

    public Agenda(){
        contatos = new ArrayList<>();
    }

    public long gerarId(){
        long id = contatos.stream().mapToLong(Contato::getId).max().getAsLong();
        return id;
    }

    public void adicionar(long id, String nome, String email, String telefone, LocalDate data){
        adicionar(new Contato(id, nome, telefone, email, data));
    }

    private void adicionar(Contato contato) {
        contatos.add(contato);
    }

   // public void cadastrarCotato(){
     //   String nome = Teclado.lerString("Informe o nome do contato: ");
     //   String telefone = Teclado.lerString("Informe o telefone do contato: ");
       // String email = Teclado.lerString("Informe o email do contato: ");
     //   int dia = Teclado.lerInteiro("Informe o dia de seu nascimento: ");
      //  int mes = Teclado.lerInteiro("Informe o mes em que voce nasceu: ");
     //   int ano = Teclado.lerInteiro("Informe o ano em que voce nasceu: ");

     //   LocalDate aniversario = LocalDate.of(ano,mes,dia);


     //   Contato novoContato = new Contato(gerarId() ,nome, telefone, email, aniversario);
      //  contatos.add(novoContato);
     //   for(Contato contato : contatos){
     //       System.out.println("Id: " + contato.getId() + " Nome: " + contato.getNome() + "/" + " Telefone: " + contato.getTelefone() + "/" + " Email: " + contato.getEmail() + "/" + " DataNascimento: " + contato.getData());
      //  }
  //  }

    public List<Contato> listarContatos(){
        for(Contato contato : contatos){
            System.out.println("Id: " + contato.getId() + " Nome: " + contato.getNome() + "/" + " Telefone: " + contato.getTelefone() + "/" + " Email: " + contato.getEmail() + "/" + " DataNascimento: " + contato.getData());
        }
        return contatos = contatos.stream().sorted().toList();
    }

    public void editarContato(){
        String nome = getNome();
        String telefone = getTelefone();
        String email = getEmail();
        LocalDate data = getData();
        Contato editar = null;

        for (Contato c : contatos){
            if(nome.equals(c.getNome())){
                editar = c;
            }
        }

        if (editar != null) {
            editar.setEmail(email);
            editar.setData(data);
            editar.setTelefone(telefone);
        }else{
            System.out.println("Contato não encontrado");
        }
    }

    public void pesquisaPorLetra(){

    }

    public void aniversarianteDoMes(){

    }
}
