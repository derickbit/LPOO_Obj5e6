package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.Exemplares;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;
@Controller
public class ExemplaresController {

    private static final Scanner input = new Scanner(System.in);
    private static ExemplaresService exemplaresService;

    //Injeção de dependência
    public ExemplaresController(ExemplaresService ExemplaresService) {
        ExemplaresController.exemplaresService = ExemplaresService;
    }

    public static void main(String[] args) {

        int opcao;
        do {
            System.out.print("\n\"-------  MENU Exemplares -------\"");
            System.out.print(
                    """
    
                        1. Inserir novo exemplar
                        2. Atualizar um exemplar
                        3. Excluir um exemplar (tornar inativo)
                        4. Listar todos os exemplares

                        Opção (Zero p/sair):\s""");

            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> inserir();
                case 2 -> atualizar();
                case 3 -> excluir();
                case 4 -> listar();
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while (opcao != 0);
    }

    //opção 1
    private static void inserir() {
        Exemplares exemplares = new Exemplares();
        System.out.println("\n++++++ Cadastro de novo Exemplar ++++++");
        System.out.print("Digite o nome do exemplar: ");
        exemplares.setNome(input.nextLine());
        System.out.print("\nDigite tipo do exemplar: ");
        exemplares.setTipoExemplar(input.nextLine());

        System.out.println("Exemplar salvo com sucesso:" + exemplaresService.insert(exemplares));
    }

    //opção 2
    private static void atualizar() {
        System.out.println("\n++++++ Alterar um Exemplar++++++");
        Exemplares exemplares;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código do Exemplar (Zero p/sair): ");
            Integer  codigo = input.nextInt();
            input.nextLine();
            if (codigo == 0) {
                opcao = 0;
            } else {
                exemplares = exemplaresService.getExemplaresById(codigo);
                if (exemplares == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println("Nome do exemplar: " + exemplares.getNome());
                    System.out.print("Alterar? (0-não/1-sim) ");
                    if(input.nextInt() == 1){
                        input.nextLine();
                        System.out.println("Digite o novo nome do exemplares: ");
                        exemplares.setNome(input.nextLine());
                    }
                    System.out.println("Tipo do exemplar: " + exemplares.getTipoExemplar());
                    System.out.print("Alterar? (0-não/1-sim) ");
                    if(input.nextInt() == 1){
                        input.nextLine();
                        System.out.print("Digite o novo tipo do exemplar: ");
                        exemplares.setTipoExemplar(input.nextLine());
                    }
                    if(exemplaresService.update(exemplares) != null) {
                        System.out.println("exemplar atualizado com sucesso. " + exemplaresService.getExemplaresById(exemplares.getId()));
                    } else {
                        System.out.println("Não foi possível atualizar este exemplar. Por favor, contate o administrador.");
                    }

                    opcao = 1;
                }
            }
        } while (opcao != 0);
    }

    //opção 4
    private static void excluir() {
        System.out.println("\n++++++ Excluir um exemplar ++++++");
        Exemplares exemplares;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código do Exemplar (Zero p/sair): ");
            Integer  codigo = input.nextInt();
            input.nextLine();
            if (codigo == 0) {
                opcao = 0;
            } else if(codigo > 0){
                exemplares = exemplaresService.getExemplaresById(codigo);
                if (exemplares == null) {
                    System.out.println("Código inválido.");
                }  else {
                    System.out.println(exemplares);
                    System.out.print("Excluir este exemplar? (0-não/1-sim) ");
                    if (input.nextInt() == 1) {
                        input.nextLine();
                        System.out.print("Tem certeza disso? (0-não/1-sim) ");
                        input.nextLine();
                        exemplaresService.delete(exemplares.getId());
                        System.out.println("Exemplar excluído com sucesso:" + exemplares);
                    }

                }
            } else {
                System.out.println("Digite um código válido!!!");
            }
        } while (opcao != 0);
    }

//    opção 4
    private static void listar() {
        System.out.println("\nLista de exemplares cadastradas no banco de dados:\n" + exemplaresService.getExemplares());
    }

            }//fim classe
