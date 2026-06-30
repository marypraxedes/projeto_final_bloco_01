package projeto_final_bloco_01.model;

public class JogoDigital extends Jogo {

	private float tamanhoDownload;
	private int lojaDigital;
	
	public JogoDigital(int id, String titulo, int plataforma, float preco, int estoque, String genero,
			float tamanhoDownload, int lojaDigital) {
		super(id, titulo, plataforma, preco, estoque, genero);
		this.tamanhoDownload = tamanhoDownload;
		this.lojaDigital = lojaDigital;
	}

	public float getTamanhoDownload() {
		return tamanhoDownload;
	}

	public void setTamanhoDownload(float tamanhoDownload) {
		this.tamanhoDownload = tamanhoDownload;
	}

	public int getLojaDigital() {
		return lojaDigital;
	}

	public void setLojaDigital(int lojaDigital) {
		this.lojaDigital = lojaDigital;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		
		String lojaDigital = "";
		
		switch(this.lojaDigital) {
		case 1:
			lojaDigital = "Steam";
		break;
		
		case 2:
			lojaDigital = "Epic Games";
		break;
		default:
		    lojaDigital = "Não informada";
		}
		
		System.out.printf("Tamanho do Download: %.2f GB%n", this.tamanhoDownload);
		System.out.println("Loja Digital: " + lojaDigital);
		
		
		
	}
	
	
}
