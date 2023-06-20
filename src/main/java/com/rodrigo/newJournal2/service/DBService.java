package com.rodrigo.newJournal2.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.newJournal2.domain.Noticia;
import com.rodrigo.newJournal2.domain.enums.Categoria;
import com.rodrigo.newJournal2.repositories.NoticiaRepository;

@Service
public class DBService {

	@Autowired
	private NoticiaRepository repository;
	
	public void instanciaDB() {
		
		Noticia nj1 = new Noticia(null, "A vida a dois",
				"Muitas pessoas não estão prontas para casar, quem dirá formar família.");
		nj1.addCategoria(Categoria.ATUALIDADE);

		Noticia nj2 = new Noticia(null,"Basket brasileiro cresce a cada ano",
				"Muitos brasileiros tem o sonho de se tornar jogadores de bascketboll.");
		nj2.addCategoria(Categoria.ESPORTE);

		repository.saveAll(Arrays.asList(nj1, nj2));
	}
	
}
