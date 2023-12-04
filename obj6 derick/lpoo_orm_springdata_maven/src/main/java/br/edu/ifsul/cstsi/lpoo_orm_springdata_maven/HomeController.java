package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven;

//import br.edu.ifsul.cstsi.lpoo_vendas_springboot_maven.clientes.ClienteController;
//import br.edu.ifsul.cstsi.lpoo_vendas_springboot_maven.pedidos.PedidoController;
//import br.edu.ifsul.cstsi.lpoo_vendas_springboot_maven.pedidos.VendasController;
//import br.edu.ifsul.cstsi.lpoo_vendas_springboot_maven.produtos.ProdutoController;

import br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.Exemplares.ExemplaresController;

import java.util.Scanner;

public class HomeController {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao;
        do {
            System.out.print("\n-------  Home -------");
            System.out.print(
                    """
    
                        1. CRUD de Exemplares
                        
                        Opção (Zero p/sair):\s""");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                  case 1 -> ExemplaresController.main(null);
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while(opcao != 0) ;
        System.out.println("\n\n!!!!!!!! Fim da aplicação !!!!!!!!");
        input.close(); //libera o recurso
    }

}//fim classe
