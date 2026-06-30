package projeto_final_bloco_01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	private static final Scanner leia = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		
		
		int opcao;
		
		do {
			
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                    HATAKE GAMES                     ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("            1 - Cadastro de Jogo                     ");
			System.out.println("            2 - Listar Todos os Jogos                ");
			System.out.println("            3 - Consultar Jogo por ID                ");
			System.out.println("            4 - Atualizar Jogo                       ");
			System.out.println("            5 - Apagar Jogo                          ");
			System.out.println("            6 - Sobre o Projeto                      ");
			System.out.println("            0 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Digite a opção desejada: ");
			
			try {
				opcao = leia.nextInt();
				leia.nextLine();
			}catch(InputMismatchException e) {
				opcao = -1;
				System.out.println("Digite um número inteiro entre 0 e 6");
				leia.nextLine();
			}
			
			switch(opcao) {
			case 1:
				System.out.println("Cadastrar jogo: \n");
				keyPress();
			break;
				
			case 2:
				System.out.println("Listar todos os jogos: \n");
				keyPress();
			break;
			
			case 3: 
				System.out.println("Consultar jogo por ID: \n");
				keyPress();
			break;
			
			case 4:
				System.out.println("Atualizar dados do jogo: \n");
				keyPress();
			break;
			
			case 5:
				System.out.println("Apagar jogo: \n");
				keyPress();
			break;
			
			case 6:
				sobre();
				keyPress();
			break;
				
			case 0:
				System.out.println("\nObrigado por utilizar os serviços do Hatake Games!");
				
			break;
			
			default:
				System.out.println("\nOpção Inválida! Escolha um número de 0 a 6.");
				keyPress();
				
				break;
				
				}
			
		}while(opcao != 0);
		
		leia.close();
	}
	
	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Maryane Praxedes ");
		System.out.println("Contato - mary.praxedes@icloud.com");
		System.out.println("github.com/marypraxedes");
		System.out.println("*********************************************************");
}


	public static void keyPress() {
		System.out.println("\n\nPressione Enter para continuar...");
		leia.nextLine();
	}
	
	
	
	

	}


