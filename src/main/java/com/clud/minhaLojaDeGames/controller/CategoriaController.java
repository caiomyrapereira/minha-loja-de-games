package com.clud.minhaLojaDeGames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clud.minhaLojaDeGames.model.Categoria;
import com.clud.minhaLojaDeGames.repostiory.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
@CrossOrigin("*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getCategorias(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	//getSetor
	@GetMapping("/setor/{setor}")
	public ResponseEntity<List<Categoria>> GetByTitulosPostagens(@PathVariable  String setor){
			return ResponseEntity.ok( repository.findAllBySetorContainingIgnoreCase(setor) );
	}
	
	@PostMapping
	public ResponseEntity<Categoria> post(@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
	}
}
