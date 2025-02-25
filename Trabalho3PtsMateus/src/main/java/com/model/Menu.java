package com.model;

import com.controler.Agenda;
import com.util.Teclado;

public class Menu {

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
        System.out.println("------------Menu----------------------------");
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
                System.out.println("Contato cadastrado");
                break;
            case 2:
                System.out.println("Contato listado");
                break;
            case 3:
                System.out.println("Contato removido");
                break;
            case 4:
                System.out.println("Contato editado");
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

}
