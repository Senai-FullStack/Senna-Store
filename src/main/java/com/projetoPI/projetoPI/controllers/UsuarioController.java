package com.projetoPI.projetoPI.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projetoPI.projetoPI.models.Usuario;
import com.projetoPI.projetoPI.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	//Injeção de dependecias do Crud
     
	
      @Autowired	
	  private UsuarioRepository usuarioRepository;
	
      
      //Redireciona para a página de cadastro
	@RequestMapping(method = RequestMethod.GET , value ="/cadastroUsuario")
	public String inicio() {
		
		return "cadastro/cadastroUsuario"; 
		
	}
	
	
	//Metodo que salva o usuario no banco de dados
	    
	@RequestMapping(method = RequestMethod.POST , value ="/salvaUsuario")
	    public String salvaUsuario(@Valid Usuario usuario , BindingResult result , RedirectAttributes attributes){  
		  
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem_erro" , "Verifique os campos preenchidos");
			 return "cadastro/cadastroUsuario";
		}
		
          usuarioRepository.save(usuario);
          attributes.addFlashAttribute("mensagem", " Parabéns!! Seu cadastro foi comcluído com sucesso!"); 
          
          return "cadastro/cadastroUsuario";
            
	    	
	}	
	
	
	// Metodo que lista os usuarios já cadastrados
	
	
	@RequestMapping(value ="/usuariosCadastrados")
	 public String listaUsuario(Model model) {
		  Iterable<Usuario> usuarios =  usuarioRepository.findAll();
		  model.addAttribute("usuariosCadastrados",usuarios);		  
		  return "cadastro/usuariosCadastrados"; 
		  	
	 } 
	
	// Deletar usuario
	
	@RequestMapping(value ="/deletaUsuario")
	public String deletaUsuario(long idUsuario) {
		usuarioRepository.deleteById(idUsuario);  
		
		return "redirect:/usuariosCadastrados";
	}
	
	//Metodo de alterar o usuario
	
	
	
	@RequestMapping(value="/alteraUsuario" , method = RequestMethod.GET)
	public String alterarUsuario(Model model ,long idUsuario) {
	   Usuario usuario = usuarioRepository.findById(idUsuario).get();
	   
	   model.addAttribute(usuario);
	   
	   return "cadastro/alteraUsuario";

	   
	   
	}
	
	@RequestMapping(value ="/alteraUsuario" , method = RequestMethod.POST)
	public String updateUsuario(@Valid Usuario usuario , BindingResult result , RedirectAttributes attributes) {
		
		usuarioRepository.save(usuario);
		
		attributes.addFlashAttribute("success", "Usuario alterado com sucesso!");
		
		return "redirect:/usuariosCadastrados";
	}
	
}
