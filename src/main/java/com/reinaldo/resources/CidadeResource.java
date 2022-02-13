package com.reinaldo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reinaldo.domain.Cidade;
import com.reinaldo.services.CidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeResource {

	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listar(@PathVariable Integer id){
		Cidade obj = cidadeService.listar(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
}
