package br.lund.pages;

import br.lund.BasePage;

public class ErroSenhaPage extends BasePage {
	
	public void repetirSenha() {
		clicarLink("Entrar com a senha");
	}
	
	public String obterMensagemErroSenha() {
		return obterTextos("//div/span[last()]");
	}
	
	public String obterMensagemErroSpam() {
		return obterTextos("//*[@id='error_box']/div");
	}
	
	
}
