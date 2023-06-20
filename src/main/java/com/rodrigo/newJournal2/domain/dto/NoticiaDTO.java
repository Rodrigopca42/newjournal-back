package com.rodrigo.newJournal2.domain.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rodrigo.newJournal2.domain.Noticia;
import com.rodrigo.newJournal2.domain.enums.Categoria;

public class NoticiaDTO {

	
	private Integer id;
	
	@NotNull(message = "O campo Título é requerido" )
	private String titulo;
	
	
	@NotNull(message = "O campo Notícia é requerido" )
	private String noticia;
	
	private Set<Integer> categorias = new HashSet<>();
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCriacao = LocalDate.now();

	public NoticiaDTO() {
		super();
	}

	public NoticiaDTO(Noticia obj) {
		super();
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
		this.noticia = obj.getNoticia();
		this.dataCriacao = obj.getDataCriacao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNoticia() {
		return noticia;
	}

	public void setNoticia(String noticia) {
		this.noticia = noticia;
	}

	public Set<Categoria> getCategorias() {
		return categorias.stream().map(x -> Categoria.toEnum(x)).collect(Collectors.toSet());
	}

	public void addCategoria(Categoria categoria) {
		this.categorias.add(categoria.getCodigo());
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}


	
	
	

	
	
	
	
}
