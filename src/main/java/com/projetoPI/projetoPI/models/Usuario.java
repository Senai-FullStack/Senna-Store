package com.projetoPI.projetoPI.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

    @Entity
    public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
     
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private long idUsuario;
     
     @NotEmpty(message="Nao pode estar vazio")
     private String nomeUsuario;  // Nome do usuário
     
     @NotEmpty
     private String emailUsuario; // Email do usuário
     
     @NotEmpty 
     private String cpfUsuario; //Cpf do usuário
     
     @NotEmpty
     private String enderecoUsuario; // Endereco do usuário
     
     @NotEmpty
     private String numeroEnd; // Numero do Endereço
     
     @NotEmpty 
     private String bairroUsuario; // Bairro do usuário
     
     
     @NotEmpty
     private String senhaUsuario; // Senha usada para logar

     
     
     //Getter and Setters dos meus Atributos
	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getCpfUsuario() {
		return cpfUsuario;
	}

	public void setCpfUsuario(String cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
	}

	public String getEnderecoUsuario() {
		return enderecoUsuario;
	}

	public void setEnderecoUsuario(String enderecoUsuario) {
		this.enderecoUsuario = enderecoUsuario;
	}

	public String getNumeroEnd() {
		return numeroEnd;
	}

	public void setNumeroEnd(String numeroEnd) {
		this.numeroEnd = numeroEnd;
	}

	public String getBairroUsuario() {
		return bairroUsuario;
	}

	public void setBairroUsuario(String bairroUsuario) {
		this.bairroUsuario = bairroUsuario;
	}


	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}
     
     
     
}
