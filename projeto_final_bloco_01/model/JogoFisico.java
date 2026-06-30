package projeto_final_bloco_01.model;

public class JogoFisico extends Jogo {

	private int tipoMidia;

	public JogoFisico(int id, String titulo, int plataforma, float preco, int estoque, String genero,
			int tipoMidia) {
		super(id, titulo, plataforma, preco, estoque, genero);
		this.tipoMidia = tipoMidia;
	}

	public int getTipoMidia() {
		return tipoMidia;
	}

	public void setTipoMidia(int tipoMidia) {
		this.tipoMidia = tipoMidia;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		
		String tipoMidia = "";
		
		switch(this.tipoMidia) {
		case 1:
			tipoMidia = "DVD";
		break;
		
		case 2:
			tipoMidia = "Cartucho";
		break;
		default:
		    tipoMidia = "Não informada";
		}
		
		System.out.println("Tipo de Mídia: " + tipoMidia);
		
	}
	
	
}
