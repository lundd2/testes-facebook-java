package br.lund.pages;

import static br.lund.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.lund.BasePage;
import br.lund.BaseTest;
import br.lund.DriverFactory;

public class LoginPage extends BasePage {
	
	public void acessarTelaInicial() {
		getDriver().get("https://web.facebook.com/");
	}
	
	public void setEmail(String email) {
		escreve("email", email);
	}
	
	public void setSenha(String senha) {
		escreve("pass", senha);
	}
	
	public void entrar() {
		clicarBotao(By.xpath("//button[.='Entrar']"));
	}
	
	public void simContinuar() {
		clicarBotao(By.xpath("//button[.='Sim, continuar']"));
	}
	
	public String obterMensagemErroLogin() {
		return obterTextos("//*[@id='loginform']/div/div[last()]");
	}
	
	public String obterMensagemErroLogin2() {
		return obterTextos("//div[@class='_9kq2']");
	}
	

//	public String obterMensagemErros(String tipo) {
//		 if (tipo == "semInfo") {
//			return obterTextos("//div[@class='_9ay7']");
//		 if (tipo == "invalida") {
//				return obterTextos("//strong"); 
//			 }
//		return tipo;
//	}
	
//	public List<String> obterErros() {
//		List<WebElement> erros = getDriver().findElements(By.xpath("//div/span[last()]/../.."));
//		List<String> retorno = new ArrayList<String>();
//		for(WebElement erro: erros) {
//			retorno.add(erro.getText());
//		}
//		return retorno;
//	}
	
	
}
