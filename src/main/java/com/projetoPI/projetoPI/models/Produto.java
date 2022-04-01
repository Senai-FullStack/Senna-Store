package com.projetoPI.projetoPI.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
	
    @Entity
	public class Produto implements Serializable {
    	
 	
    	private static final long serialVersionUID = 1L;
    	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO) 
		private Long idProduto;  // Identificação do produto
		
		@NotEmpty
		private String nomeProduto;
		
		@NotEmpty
		private String marcaProduto;	
		
		@NotNull
		private double precoProduto;
		
	
	
		
		//Getter and Setters 
		
		

		public String getNomeProduto() {
			return nomeProduto;
		}
	
		public Long getIdProduto() {
			return idProduto;
		}

		public void setIdProduto(Long idProduto) {
			this.idProduto = idProduto;
		}

		public void setNomeProduto(String nomeProduto) {
			this.nomeProduto = nomeProduto;
		}
	
		public String getMarcaProduto() {
			return marcaProduto;
		}
	
		public void setMarcaProduto(String marcaProduto) {
			this.marcaProduto = marcaProduto;
		}
	
		public double getPrecoProduto() {
			return precoProduto;
		}
	
		public void setPrecoProduto(double precoProduto) {
			this.precoProduto = precoProduto;
		}
		
}
