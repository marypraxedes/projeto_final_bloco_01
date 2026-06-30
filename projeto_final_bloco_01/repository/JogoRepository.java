package projeto_final_bloco_01.repository;

import projeto_final_bloco_01.model.Jogo;

public interface JogoRepository {

	public void cadastrarJogo(Jogo jogo);
	public void listarTodos();
	public void atualizarJogo(Jogo jogo);
	public void deletarJogo(int id); 
	public void listarPorID(int id);
	
}
