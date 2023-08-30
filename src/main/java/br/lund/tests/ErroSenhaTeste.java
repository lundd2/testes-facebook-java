package br.lund.tests;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.lund.BaseTest;
import br.lund.pages.ErroSenhaPage;
import br.lund.pages.LoginPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ErroSenhaTeste extends BaseTest{
	
	LoginPage loginPage = new LoginPage();
	ErroSenhaPage senhaPage = new ErroSenhaPage();
	
	@Test
	public void test1_SemSenha() {
		loginPage.setEmail("lundjpa@gmail.com");
		loginPage.entrar();
		
		Assert.assertEquals("A senha inserida está incorreta. Esqueceu a senha?",
				loginPage.obterMensagemErroLogin());
	}
	
	@Test
	public void test2_SenhaErrada() { 
		loginPage.setEmail("lundjpa@gmail.com");
		loginPage.setSenha("sadsa");
		loginPage.entrar();
		
		Assert.assertEquals("A senha inserida está incorreta. Esqueceu a senha?",
				loginPage.obterMensagemErroLogin());
	}
	
	@Test
	public void test3_SenhaErradaEsquecida() { 
		loginPage.setEmail("lundjpa@gmail.com");
		loginPage.setSenha("sadsa");
		loginPage.entrar();
		senhaPage.clicarLink("Esqueceu a senha?");
		senhaPage.clicarLink("Entrar com a senha");
		loginPage.setSenha("sadsa");
		loginPage.entrar();
		Assert.assertEquals("A senha inserida está incorreta. Esqueceu a senha?",
				loginPage.obterMensagemErroLogin());
	}
	
	@Test
	public void test4_Reconhecimento() {
		loginPage.setEmail("dasdsa");
		loginPage.entrar();

		Assert.assertEquals("Não reconhecemos seu dispositivo",
				senhaPage.obterMensagemErroSenha());
	}
	
	@Test
	public void test5_Spam() {
		loginPage.setEmail("lundjpa@gmail.com");
		loginPage.setSenha("sadsa");
		loginPage.entrar();
		for (int i=0; i<=19; i++ ) {
			loginPage.setSenha("sadsa");
			loginPage.entrar();
		}
		Assert.assertEquals("Você não pode usar este recurso no momento", 
				senhaPage.obterMensagemErroSpam());
	}

	
//	@Test
//	public void test1_SemSenha() {
//		
//		loginPage.setEmail("lundjpa@gmail.com");
//		loginPage.entrar();
//		Assert.assertEquals("A senha inserida está incorreta.",
//				senhaPage.obterMensagemErroSenha());
//	}
//	
//	@Test
//	public void test2_SenhaErrada() { 
//		loginPage.setEmail("lundjpa@gmail.com");
//		loginPage.setSenha("sadsa");
//		loginPage.entrar();
//		
//		Assert.assertEquals("A senha inserida está incorreta.",
//				senhaPage.obterMensagemErroSenha());
//	}		
//	
//	@Test
//	public void test3_SenhaErradaDupla() { //ok terceiro
//		test2_SenhaErrada();
//		senhaPage.clicarLink("Entrar com a senha");
//		loginPage.setSenha("sadsa");
//		loginPage.entrar();
//		
//		Assert.assertEquals("A senha inserida está incorreta. Esqueceu a senha?",
//				loginPage.obterMensagemErroLogin());
//	}
//	
//	@Test
//	public void test4_SenhaErradaDupla() { //ok terceiro
//		loginPage.setEmail("lundjpa@gmail.com");
//		loginPage.setSenha("sadsa");
//		loginPage.entrar();
//		loginPage.setSenha("sadsa");
//		loginPage.entrar();
//		
//		Assert.assertEquals("A senha inserida está incorreta. Esqueceu a senha?",
//				loginPage.obterMensagemErroLogin());
//	}
//	
//	@Test
//	public void test5_Reconhecimento() {
//		loginPage.setEmail("dasdsa");
//		loginPage.entrar();
//
//		Assert.assertEquals("Não reconhecemos seu dispositivo",
//				senhaPage.obterMensagemErroSenha());
//	}
	
	
	
	
//	@Test
//	public void test4_SenhaErradatripla() { //ok quarto sadsa
//		test3_SenhaErradaDupla();
//		loginPage.setSenha("sadsa");
//		loginPage.setEmail("lundjpa@gmail.com");
//		loginPage.entrar();
//		
//		Assert.assertEquals("A senha digitada não é válida.",
//				loginPage.obterMensagemErros("invalida"));
//	
//	}
	
	
	

}
