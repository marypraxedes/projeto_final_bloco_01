package projeto_final_bloco_01;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import projeto_final_bloco_01.controller.JogoController;
import projeto_final_bloco_01.model.Jogo;
import projeto_final_bloco_01.model.JogoDigital;
import projeto_final_bloco_01.model.JogoFisico;

public class Menu {

	private static final Scanner leia = new Scanner(System.in);
	private static final JogoController controller = new JogoController();
	
	public static void main(String[] args) {
		
		cadastrarJogosTeste();
		
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
				cadastrarJogo();
				keyPress();
			break;
				
			case 2:
				System.out.println("Listar todos os jogos: \n");
				listarTodos();
				keyPress();
			break;
			
			case 3: 
				System.out.println("Consultar jogo por ID: \n");
				listarPorID();
				keyPress();
			break;
			
			case 4:
				System.out.println("Atualizar dados do jogo: \n");
				atualizarJogo();
				keyPress();
			break;
			
			case 5:
				System.out.println("Apagar jogo: \n");
				deletarJogo();
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
	
	public static void listarTodos() {
		controller.listarTodos();
	}
	
	public static void cadastrarJogo() {
		System.out.println("Digite o título do jogo: ");
		String titulo = leia.nextLine();
		
		System.out.println("Digite a plataforma (1- PC / 2- Xbox / 3- PlayStation / 4- Nintendo): ");
		int plataforma = leia.nextInt();
		if(plataforma < 1 || plataforma > 4) {
		    System.out.println("Plataforma inválida!");
		    return;
		}
		
		System.out.println("Digite o preço do jogo: ");
		float preco = leia.nextFloat();
		
		System.out.println("Digite a quatidade em estoque: ");
		int estoque = leia.nextInt();
		
		System.out.println("Digite o gênero: (Ex: Ação, Aventura, RPG, etc...)");
		leia.nextLine();
		String genero = leia.nextLine();
		
		 System.out.println("Tipo de jogo:");
		    System.out.println("1 - Digital");
		    System.out.println("2 - Físico");
		    int tipoJogo = leia.nextInt();


		    switch(tipoJogo) {

		    case 1:
		        System.out.println("Tamanho do download (GB): ");
		        float tamanhoDownload = leia.nextFloat();

		        System.out.println("Loja digital:");
		        System.out.println("1 - Steam");
		        System.out.println("2 - Epic Games");
		        int lojaDigital = leia.nextInt();

		        controller.cadastrarJogo(
		            new JogoDigital(controller.gerarId(),titulo,plataforma,preco, estoque, genero, tamanhoDownload, lojaDigital));

		        break;


		    case 2:
		        System.out.println("Tipo de mídia:");
		        System.out.println("1 - DVD");
		        System.out.println("2 - Cartucho");
		        int tipoMidia = leia.nextInt();

		        controller.cadastrarJogo(new JogoFisico(controller.gerarId(), titulo, plataforma, preco, estoque, genero, tipoMidia));

		        break;


		    default:
		        System.out.println("Tipo de jogo inválido!");
		    }
		}

	
	public static void listarPorID() {
		
		System.out.println("Digite o ID do jogo: ");
		int id = leia.nextInt();
		leia.nextLine();
		
		controller.listarPorID(id);
	}
	
	public static void deletarJogo() {
		
		System.out.println("Digite o ID do Jogo: ");
		int id = leia.nextInt();
		leia.nextLine();
		
		Optional<Jogo> jogo = controller.buscarNaCollection(id);
		
		if(jogo.isPresent()) {
			
			
			
			System.out.printf("\nTem certeza que você deseja excluir o jogo de ID %d (S/N)? ", id);
			String confirmacao = leia.nextLine();
			
			if(confirmacao.equalsIgnoreCase("S"))
				controller.deletarJogo(id);
			else
				System.out.println("\nOperação cancelada!");
		} else {
			System.out.printf("\nO jogo de ID %d não foi encontrado!", id);
		}
		
	}
	
	public static void atualizarJogo() {
		
		System.out.println("Digite o ID do jogo: ");
		int id = leia.nextInt();
		leia.nextLine();
		
		Optional<Jogo> jogo = controller.buscarNaCollection(id);
		
		if(jogo.isPresent()) {
			
			
			String titulo = jogo.get().getTitulo();
			int plataforma = jogo.get().getPlataforma();
			float preco = jogo.get().getPreco();
			int estoque = jogo.get().getEstoque();
		    String genero = jogo.get().getGenero();
			
		
			System.out.printf("Título atual: %s"
						+ "%nDigite o novo título do jogo (Pressione ENTER para manter o valor atual): ", titulo);
			String entrada = leia.nextLine();
			
			titulo = entrada.isEmpty() ? titulo : entrada;
						
			
			System.out.printf("Preço atual: %.2f"
						+ "%nDigite o novo preço (Pressione ENTER para manter o valor atual): ", preco);
			entrada = leia.nextLine();
						
			preco = entrada.isEmpty() ? preco : Float.parseFloat(entrada.replace(",", "."));
			
			System.out.printf("Estoque atual: %d%nDigite o novo estoque (Pressione ENTER para manter o valor atual): ", estoque);
	        entrada = leia.nextLine();
	        estoque = entrada.isEmpty() ? estoque : Integer.parseInt(entrada);


	        System.out.printf("Gênero atual: %s%nDigite o novo gênero (Pressione ENTER para manter o valor atual): ", genero);
	        entrada = leia.nextLine();
	        genero = entrada.isEmpty() ? genero : entrada;
			
	        if (jogo.get() instanceof JogoDigital) {

	            JogoDigital jogoDigital = (JogoDigital) jogo.get();

	            float tamanhoDownload = jogoDigital.getTamanhoDownload();
	            int lojaDigital = jogoDigital.getLojaDigital();

	            System.out.printf("Tamanho do Download atual: %.2f GB%nDigite o novo tamanho (Pressione ENTER para manter o valor atual): ",tamanhoDownload);

	            entrada = leia.nextLine();

	            tamanhoDownload = entrada.isEmpty() ? tamanhoDownload : Float.parseFloat(entrada.replace(",", "."));
	            
	            System.out.println("Loja digital atual: " + lojaDigital);
	            System.out.println("Escolha a nova loja digital:");
	            System.out.println("1 - Steam");
	            System.out.println("2 - Epic Games");
	            System.out.println("(Pressione ENTER para manter)");

	            entrada = leia.nextLine();

	            lojaDigital = entrada.isEmpty() ? lojaDigital : Integer.parseInt(entrada);

	            controller.atualizarJogo(new JogoDigital(id, titulo, plataforma, preco, estoque, genero, tamanhoDownload, lojaDigital));

	        } else if (jogo.get() instanceof JogoFisico) {

	            JogoFisico jogoFisico = (JogoFisico) jogo.get();

	            int tipoMidia = jogoFisico.getTipoMidia();

	            String nomeMidia = "";

	            switch(tipoMidia) {
	            case 1:
	                nomeMidia = "DVD";
	                break;

	            case 2:
	                nomeMidia = "Cartucho";
	                break;

	            default:
	                nomeMidia = "Não informada";
	            }

	            System.out.println("Tipo de mídia atual: " + nomeMidia);
	            System.out.println("Digite o novo tipo de mídia:");
	            System.out.println("1 - DVD");
	            System.out.println("2 - Cartucho");
	            System.out.println("(Pressione ENTER para manter o valor atual)");

	            entrada = leia.nextLine();

	            tipoMidia = entrada.isEmpty() ? tipoMidia : Integer.parseInt(entrada);

	            controller.atualizarJogo(new JogoFisico(id, titulo, plataforma, preco, estoque, genero, tipoMidia));
	        }
			
		}else {
			System.out.printf("\nO jogo número %d não foi encontrado!", id);
		}
	}
		public static void cadastrarJogosTeste() {

		    controller.cadastrarJogo(new JogoDigital(controller.gerarId(),"Forza Horizon 5", 2, 249.90f, 8, "Corrida", 120.0f, 2));

		    controller.cadastrarJogo(new JogoFisico(controller.gerarId(),"God of War Ragnarök", 3, 349.90f, 3, "Ação", 1));
		
	}
	}


