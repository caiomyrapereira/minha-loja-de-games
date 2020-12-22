package com.clud.minhaLojaDeGames.repostiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clud.minhaLojaDeGames.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	public List<Produto> findByAtivoTrue();

	public List<Produto>findAllByNomeContainingIgnoreCase(String nome);
}
