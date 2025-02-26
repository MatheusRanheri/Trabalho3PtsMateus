package com.model;

import com.controller.Agenda;
import com.util.Teclado;

import java.time.LocalDate;

public class Menu {

    private Agenda agenda;

    private static boolean sair = false;

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        while (!sair){
            menu();
            int opcao = Teclado.lerInteiro("Informe uma opcao: ");
            executaAcao(agenda, opcao);
        }

    }

    private static void menu(){
        System.out.println("--------------------Menu--------------------");
        System.out.println("[1] - Adicionar contatos                    ");
        System.out.println("[2] - Listar contatos                       ");
        System.out.println("[3] - Remover contato                       ");
        System.out.println("[4] - Editar contato                        ");
        System.out.println("[5] - Pesquisar contatos pela letra  inicial");
        System.out.println("[6] - Aniversariante do mes                 ");
        System.out.println("[7] - Sair                                  ");
        System.out.println("--------------------------------------------");
    }

    private static void executaAcao(Agenda agenda, int opcao){
        switch (opcao){
            case 1:
                adicionar();
                break;
            case 2:
                agenda.listarContatos();
                break;
            case 3:
                System.out.println("Contato removido");
                break;
            case 4:
                agenda.editarContato();
                break;
            case 5:
                System.out.println("Contato pesquisado");
                break;
            case 6:
                System.out.println("Aniversariante encontrado");
                break;
            case 7:
                sair = false;
                break;
            default:
                System.out.println("Opcao invalida");
                break;
        }
    }

    private void adicionar(){
        String nome = Teclado.lerString("Informe o nome do contato: ");
        String telefone = Teclado.lerString("Informe o telefone do contato: ");
        String email = Teclado.lerString("Informe o email do contato: ");

        int dia = Teclado.lerInteiro("Informe o dia de seu nascimento: ");
        int mes = Teclado.lerInteiro("Informe o mes em que voce nasceu: ");
        int ano = Teclado.lerInteiro("Informe o ano em que voce nasceu: ");

        LocalDate aniversario = LocalDate.of(ano,mes,dia);

        agenda.adicionar(agenda.gerarId(), nome, email, telefone, aniversario);

      //  Contato novoContato = new Contato(nome, telefone, email, aniversario);
      //  contatos.add(novoContato);
       // for(Contato contato : contatos){
       //     System.out.println("Id: " + contato.getId() + " Nome: " + contato.getNome() + "/" + " Telefone: " + contato.getTelefone() + "/" + " Email: " + contato.getEmail() + "/" + " DataNascimento: " + contato.getData());
        //}
    }

}
