package br.lund;

import static br.lund.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.core.util.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.lund.pages.LoginPage;

public class BaseTest {
	
	private LoginPage loginPage = new LoginPage();
	
	@Rule
	public TestName testName = new TestName();
	
	@Before
	public void inicializa() {
		loginPage.acessarTelaInicial();
	}
	
//	
//	@After
//	public void fechar() {
//		if (Propriedades.FECHAR_BROWSER) {
//			killDriver();// 
//		}
//	}
}
	
//	@After
//	public void fechar() throws IOException {
//		TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();
//		File arquivo = ss.getScreenshotAs(OutputType.FILE);
//		//FileUtils.copyFile(arquivo, new File("screenshot.jpg"));
//		FileUtils.copyFile(arquivo, new File(testName.getMethodName() + ".jpg"));
//		if (Propriedades.FECHAR_BROWSER) {
//			killDriver();
//		}
//	}
