package com.reinaldo;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.reinaldo.domain.Categoria;
import com.reinaldo.domain.Cidade;
import com.reinaldo.domain.Estado;
import com.reinaldo.domain.Pedido;
import com.reinaldo.domain.Produto;
import com.reinaldo.repositories.CategoriaRepository;
import com.reinaldo.repositories.CidadeRepository;
import com.reinaldo.repositories.EstadoRepository;
import com.reinaldo.repositories.PedidoRepository;
import com.reinaldo.repositories.ProdutoRepository;

@SpringBootApplication
public class ProjetoPedidoProdutoApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoPedidoProdutoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Consoles");
		Categoria cat2 = new Categoria(null, "Monitores");
		Categoria cat3 = new Categoria(null, "Headsets");
		
		
		
		Produto prod1 = new Produto(null, "PS5", 5000.00);
		Produto prod2 = new Produto(null, "PS4", 4000.00);
		Produto prod3 = new Produto(null, "XBOX ONE", 4500.00);
		
		Produto prod4 = new Produto(null, "AOC 23.8' LED 24B1XHM", 4500.00);
		Produto prod5 = new Produto(null, "Samsung 24' LED LC24F390FHLMZD", 4500.00);
		
		Produto prod6 = new Produto(null, "Havit HV-H2002d com Microfone", 4500.00);
		Produto prod7 = new Produto(null, "Hyperx Cloud Stinger", 4500.00);
		Produto prod8 = new Produto(null, "Pichau P851", 4500.00);
		
		
		cat1.getProdutos().addAll(Arrays.asList(prod1,prod2,prod3));
		
		cat2.getProdutos().addAll(Arrays.asList(prod4, prod5));
		
		cat3.getProdutos().addAll(Arrays.asList(prod6, prod7, prod8));
		
		prod1.getCategorias().add(cat1);
		prod2.getCategorias().add(cat1);
		prod3.getCategorias().add(cat1);
		prod4.getCategorias().add(cat2);
		prod5.getCategorias().add(cat2);
		prod6.getCategorias().add(cat3);
		prod7.getCategorias().add(cat3);
		prod8.getCategorias().add(cat3);
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		produtoRepository.saveAll(Arrays.asList(prod1,prod2,prod3,prod4,prod5,prod6,prod7,prod8));
		
		
		
		
		Estado est1 = new Estado(null, "Goiás");
		Cidade cid1 = new Cidade(null, "Goiania", est1);
		est1.getCidades().add(cid1);
		
		estadoRepository.save(est1);
		cidadeRepository.save(cid1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cid1);
		
		ped1.getCategorias().add(cat1);
		cat1.getPedidos().add(ped1);
		
		pedidoRepository.save(ped1);
		categoriaRepository.save(cat1);
		
		
	}

}
