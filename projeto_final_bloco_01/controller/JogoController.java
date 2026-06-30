package projeto_final_bloco_01.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import projeto_final_bloco_01.model.Jogo;
import projeto_final_bloco_01.repository.JogoRepository;

public class JogoController implements JogoRepository {
	
	private List<Jogo> listaJogos = new ArrayList<Jogo>();
	
	int id = 0;

	@Override
	public void cadastrarJogo(Jogo jogo) {
		listaJogos.add(jogo);
		System.out.printf("O jogo %s foi criado com sucesso!%n", jogo.getTitulo());		
	}

	@Override
	public void listarTodos() {
		for (var jogo : listaJogos) {
			jogo.visualizar();
		}
		
	}

	@Override
	public void atualizarJogo(Jogo jogo) {
		Optional<Jogo> buscaJogo = buscarNaCollection(jogo.getId());
		
		if (buscaJogo.isPresent()) {
			listaJogos.set(listaJogos.indexOf(buscaJogo.get()), jogo);
			System.out.printf("\nO jogo de ID %d foi atualizado com sucesso!", jogo.getId());
		}else
			System.out.printf("\nO jogo de ID %d não foi encontrado!", jogo.getId());		
	}

	@Override
	public void deletarJogo(int id) {
		Optional<Jogo> jogo = buscarNaCollection(id);
		
		if(jogo.isPresent()) {
			if(listaJogos.remove(jogo.get()))
				System.out.printf("\nO jogo de ID %d foi excluído com sucesso!", id);
		}else
			System.out.printf("\nO jogo de ID %d não foi encontrado!", id);
		
	}

	@Override
	public void listarPorID(int id) {
		Optional<Jogo> jogo = buscarNaCollection(id);
		
		if (jogo.isPresent())
			jogo.get().visualizar();
		else
			System.out.printf("\nO jogo de ID %d não foi encontrado!", id);	
	}

	public int gerarId() {
		return ++ id;
	}
	
	public Optional<Jogo> buscarNaCollection(int id) {
		for(var jogo : listaJogos) {
			if(jogo.getId() == id)
				return Optional.of(jogo);
		}
		
		return Optional.empty();
	}
}
