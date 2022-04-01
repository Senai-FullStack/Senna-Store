 var imagens =["imagens/bannerAdidas.jpg","imagens/bannerVans.png","imagens/bannerNike.jpg"];
 
 
 var linkImagens= ["AdidasPromocao.html","VansPromocao.html","NikePromocao.html"];


 var imagemAtual = 0; 
 



 
 function trocaImagemLink(){
	imagemAtual = (imagemAtual +1) % 3;
	document.querySelector('.bannerSite img').src = imagens[imagemAtual];
	document.querySelector('.bannerSite a').href = linkImagens[imagemAtual];
}

setInterval(trocaImagemLink, 2600)




