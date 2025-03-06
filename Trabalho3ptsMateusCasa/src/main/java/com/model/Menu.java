package com.model;

import com.controller.Agenda;
import com.util.Teclado;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;

public class Menu {

    private static Agenda agenda;

    public Menu() throws ParametroInvalidoException {
        agenda = new Agenda();
        iniciar();
    }

    private void iniciar() throws ParametroInvalidoException {
        int opcao = 7;

        do{
            imprimeMenu();
            opcao = Teclado.lerInteiro("Informe uma opcao");
            executa(opcao);
        }while (opcao != 7);
    }

    private static void imprimeMenu(){
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

    private static void executa(int opcao) throws ParametroInvalidoException {
        switch (opcao){
            case 1:
                inserir();
                break;
            case 2:
                listar();
                break;
            case 3:
                remover();
                break;
            case 4:
                editar();
                break;
            case 5:
                pesquisar();
                break;
            case 6:
                aniversariantes();
                break;
            case 7:
                break;
            default:
                System.out.println("Opcao invalida");
                break;
        }
    }

    private static void inserir() throws ParametroInvalidoException {
        try {

            String nome = Teclado.lerString("Informe o nome do contato: ");
            String telefone = Teclado.lerString("Informe o telefone do contato: ");
            String email = Teclado.lerString("Informe o email do contato: ");

            int dia = Teclado.lerInteiro("Informe o dia de seu nascimento: ");
            int mes = Teclado.lerInteiro("Informe o mes em que voce nasceu: ");
            int ano = Teclado.lerInteiro("Informe o ano em que voce nasceu: ");


            agenda.adicionar(agenda.getId(), nome, email, telefone, LocalDate.of(ano,mes,dia));

        }catch (InputMismatchException e){
            System.out.println("Coloque o numerocorretamente.");
        }


    }

    private static void listar(){
        List<Contato> lista =
        agenda.listarContatos();
    }

    public static void main(String[] args) throws ParametroInvalidoException {
        new Menu();
    }

    public static void remover(){
        try {
            Long id = Teclado.lerLong("Informe um id para a remocao: ");
            agenda.remover(id);

        }catch (InputMismatchException  e){
            System.out.println("Informe o numero inteiro corretamente.");
        }

    }

    public static void editar(){
        try{
            Long id = Teclado.lerLong("Informe o id do contato para editar: ");
            String nome = Teclado.lerString("Informe o novo nome: ");
            String telefone = Teclado.lerString("Informe o novo telefone: ");
            String email = Teclado.lerString("Informe o novo email: ");


            int dia = Teclado.lerInteiro("Informe o novo dia em que voce nasceu: ");
            int mes = Teclado.lerInteiro("Informe o novo mes em que voce nasceu: ");
            int ano = Teclado.lerInteiro("Informe o novo ano em que voce nasceu: ");

            agenda.editarContato(id, nome, telefone, email, LocalDate.of(ano, mes, dia));
        }catch (InputMismatchException e){
            System.out.println("Informe o numero correamente.");
        }

    }

    public static void pesquisar(){
        String nome = Teclado.lerString("Informe o nome, ou apenas as letras iniciais para pesquisar um contato: ");

        agenda.pesquisaPorLetra(nome);
    }

    public static void aniversariantes(){
        try{
            int mes = Teclado.lerInteiro("Informe o mes em que você nasceu: ");

            agenda.aniversarianteDoMes(mes);

        }catch (InputMismatchException e){
            System.out.println("Informe o numero corretamente.");
        }
    }


}
