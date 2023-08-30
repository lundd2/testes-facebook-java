package br.lund.suites;

import static br.lund.DriverFactory.killDriver;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.lund.BaseTest;
import br.lund.DriverFactory;
import br.lund.Propriedades;
import br.lund.pages.LoginPage;
import br.lund.tests.ContaTeste;
import br.lund.tests.ErroSenhaTeste;


@RunWith(Suite.class)
@SuiteClasses({
	ContaTeste.class,
	ErroSenhaTeste.class,
})
public class SuiteGeral extends BaseTest{
	private static LoginPage page = new LoginPage();
	

	

	
	
}