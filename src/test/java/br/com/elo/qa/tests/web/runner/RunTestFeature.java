package br.com.elo.qa.tests.web.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue 	 = {"br.com.elo.qa.tests.api.steps", 
					"br.com.elo.qa.tests.web.steps",
		            "br.com.elo.qa.tests.web.hooks"},
//					"br.com.elo.qa.framework.commons.evidencia.pdf.cucumber.hooks"},
		tags 	 = { "@API" },
		plugin	 = { "br.com.elo.qa.framework.web.plugin.EloWeb",
					 "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
					 "json:target/report/cucumber.json",
					 "html:target/report/cucumber.html" })
public class RunTestFeature {
}
