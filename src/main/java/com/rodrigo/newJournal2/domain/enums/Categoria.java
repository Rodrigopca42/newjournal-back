package com.rodrigo.newJournal2.domain.enums;

public enum Categoria {
	

		COMPORTAMENTO(0,"ROLE_COMPORTAMENTO"),
		TECNOLOGIA(1,"ROLE_TECNOLOGIA"),
		ESPORTE(2,"ROLE_ESPORTE"),
		MEIO_AMBIENTE(3,"ROLE_MEIO AMBIENTE"),
		ATUALIDADE(4, "ROLE_ATUALIDADE");
		
		private Integer codigo;
		private String descricao;
		
		private Categoria(Integer codigo, String descricao) {
			this.codigo = codigo;
			this.descricao = descricao;
		}

		public Integer getCodigo() {
			return codigo;
		}

		public String getDescricao() {
			return descricao;
		}
		
		
		public static Categoria toEnum(Integer codigo) {
			if(codigo == null) {
				return null;
			}
			for(Categoria x: Categoria.values()) {
				if(codigo.equals(x.getCodigo())) {
					return x;
				}
			}
			
		throw new IllegalArgumentException("Caetegoria não encontrada! Id"+ codigo);	
		}
		
	}

