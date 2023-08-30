package br.lund.tests;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.lund.BaseTest;
import br.lund.pages.ErroSenhaPage;
import br.lund.pages.LoginPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTeste extends BaseTest {
	
	LoginPage loginPage = new LoginPage();
	ErroSenhaPage senhaPage = new ErroSenhaPage();

	@Test
	public void test1_EntrarSemLogin() { 
		loginPage.entrar();
		
		Assert.assertEquals("O email ou o número de celular que você inseriu não está conectado a uma conta. Encontre sua conta e entre.",
				loginPage.obterMensagemErroLogin());
//		Assert.assertEquals("Credenciais inválidas", senhaPage.obterMensagemErroSpam());
		
	}
	
	@Test
	public void test2_SuaConta() { 
		loginPage.setEmail("lund@gmail.com");
		loginPage.entrar();
		
		Assert.assertEquals("Não foi possível encontrar uma conta que corresponda ao que você inseriu, "
				+ "mas encontramos uma que corresponde aproximadamente.",
				loginPage.obterMensagemErroLogin2());
//		Assert.assertEquals("Credenciais inválidas", senhaPage.obterMensagemErroSpam());
	}
	
	@Test
	public void test3_EntrarSemCadastro() throws InterruptedException { 
		loginPage.setEmail("lund@gmail.com");
		loginPage.entrar();
		Thread.sleep(10000);
		loginPage.simContinuar();

		Assert.assertEquals("O email que você inseriu não está conectado a uma conta. Encontre sua conta e entre.", 
				loginPage.obterMensagemErroLogin());
	}
	
	

//	@Test
//	public void testSegurança() {
//		loginPage.setEmail("lundjpa@gmail.com");
//		
//		loginPage.entrar();
//		loginPage.setSenha("sadsa");
//		
//		Assert.assertEquals("Você não pode entrar no momento\r\n"
//				+ "Para ajudar a manter sua conta segura, nós a bloqueamos temporariamente. Antes de tentar entrar de novo, "
//				+ "verifique suas informações de login e confira se está usando o mesmo dispositivo em uma rede segura.",
//				loginPage.obterMensagemErros("seguranca"));
//	}
	

}
