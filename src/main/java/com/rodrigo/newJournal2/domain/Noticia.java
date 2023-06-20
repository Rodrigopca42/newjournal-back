package com.rodrigo.newJournal2.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rodrigo.newJournal2.domain.dto.NoticiaDTO;
import com.rodrigo.newJournal2.domain.enums.Categoria;

@Entity
public class Noticia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "O campo Título é requerido" )
	private String titulo;
	
	@Lob
	@NotNull(message = "O campo Notícia é requerido" )
	private String noticia;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "CATEGORIAS")
	private Set<Integer> categorias = new HashSet<>();
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCriacao = LocalDate.now();
	
	
	public Noticia() {
		super();
	}
	
	public Noticia(Integer id, String titulo, String noticia) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.noticia = noticia;
		addCategoria(Categoria.ATUALIDADE);
	}
	
	public Noticia(NoticiaDTO obj) {
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
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Noticia other = (Noticia) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
}
