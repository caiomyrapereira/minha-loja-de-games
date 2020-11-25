package com.clud.minhaLojaDeGames.repostiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clud.minhaLojaDeGames.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	public List<Produto> findByAtivoTrue();

	public List<Produto>findAllByNomeContainingIgnoreCase(String nome);
}
