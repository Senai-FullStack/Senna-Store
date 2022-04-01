package com.projetoPI.projetoPI.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projetoPI.projetoPI.models.Produto;
import com.projetoPI.projetoPI.repository.ProdutoRepository;

@Controller
public class ProdutoController {
	
	
	@Autowired
	 private ProdutoRepository produtoRepository;
	
	
	//Metodo que mapeia a pagina de controle de produtos
	
	
	@RequestMapping(value="/controleProduto", method = RequestMethod.GET)
	public String controleProduto() {
		
		return"cadastro/controleProduto";
	}
	
	//Metodo que mapeia a pagina de produtos
	
	
		@RequestMapping(value ="/produtos" , method = RequestMethod.GET)
	   public String pageProduto() {
		   
		   return "cadastro/produtos";
	   }
      
		
		
		
	//Metodo que redireciona para o cadastro de produtos
	
	@RequestMapping(method = RequestMethod.GET , value ="/cadastroProduto")
	public String inicio(){
		
		return "cadastro/cadastroProduto";
	
		
	}
	
	
	
	
	
	//Metodo salva o produto no banco de dados
	
	@RequestMapping( method = RequestMethod.POST, value ="/salvaProduto")
	public String salvaProduto(@Valid Produto produto , BindingResult result , RedirectAttributes attributes){
		if(result.hasErrors()) {
			attributes.addFlashAttribute("Mensagens" , "Verifique os campos de cadastro novamente");
			return "cadastro/cadastroProduto";
		}
		
		produtoRepository.save(produto);
		attributes.addAttribute("Mensagem" , "Parabéns, o produto foi cadastrado corretamente");
		
			return "cadastro/cadastroProduto";
	}
	
	
	// Metodo que lista os Produtos ja cadastrados
	
	@RequestMapping(value ="/produtosCadastrados")
	public String listaProduto(Model model) {
		
		model.addAttribute("produtos", produtoRepository.findAll());
		return "cadastro/produtosCadastrados";
	}
	
	//Metodo que deleta os Produtos já cadastrados
	@RequestMapping(value ="/deletaProduto")
	public String deletaProduto(long idProduto){
		produtoRepository.deleteById(idProduto);
	   
		return "redirect:/produtosCadastrados";
	}
	
	
	//Metodo que altera o Produto
	@RequestMapping(method = RequestMethod.GET , value ="/alteraProduto")
	 public String alteraProduto(Model model , long idProduto) {
		 
		Produto produto = produtoRepository.findById(idProduto).get();
		model.addAttribute(produto);
		return "cadastro/alteraProduto";
		
	 }
	
	@RequestMapping(value ="/alteraProduto" , method = RequestMethod.POST)
	public String UpdateProduto(@Valid Produto produto , BindingResult result , RedirectAttributes attributes) {
		
		produtoRepository.save(produto);
	    attributes.addFlashAttribute("succes", "O produto foi alterado com sucesso!");
	    
	    //Redirecionando para o produto que alterei 
	     
	      return "redirect:/produtosCadastrados";
	}
	
}
