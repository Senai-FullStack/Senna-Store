
/*Fazendo a validação da senha */
 
 var senha = document.getElementById("senha");
 var confirmasenha = document.getElementById("confirmasenha");
 
 function validaSenha(){
	if(senha.value != confirmasenha.value){
		confirmasenha.setCustomValidity("Os campos de senha não correspondem")
	}else{
		confirmasenha.setCustomValidity('')
	}
	
}
senha.onchange = validaSenha;
confirmasenha.onkeyup = validaSenha;