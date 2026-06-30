package projeto_final_bloco_01.model;

public abstract class Jogo {

	
	private int id;
	private String titulo;
	private int plataforma;
	private float preco;
	private int estoque;
	private String genero;
	
	public Jogo(int id, String titulo, int plataforma, float preco, int estoque, String genero) {
		this.id = id;
		this.titulo = titulo;
		this.plataforma = plataforma;
		this.preco = preco;
		this.estoque = estoque;
		this.genero = genero;
	}
	
	public Jogo() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(int plataforma) {
		this.plataforma = plataforma;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public void visualizar() {
		
		String plataforma = "";
		
		switch(this.plataforma) {
		case 1:
			plataforma = "PC";
		break;
		
		case 2:
			plataforma = "Xbox";
		break;
		
		case 3:
			plataforma = "PlayStation";
		break;	
		
		case 4:
			plataforma = "Nintendo";
		break;	
		default:
		    plataforma = "Não informada";
		}
		
		System.out.println("**********************************");
		System.out.println("          DADOS DO JOGO           ");
		System.out.println("**********************************");
		System.out.println("Nome do Jogo: " + this.titulo);
		System.out.println("ID do Jogo: " + this.id);
		System.out.println("Plataforma do Jogo: " + plataforma);
		System.out.printf("Preço: R$ %.2f%n" , this.preco);
		System.out.println("Gênero: " + this.genero);
		System.out.println("Estoque: " + this.estoque);
		
	}
	
}
