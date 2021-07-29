package br.com.elo.qa.tests.web.hooks;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.com.elo.qa.framework.web.selenium.DriverFactory;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.AfterStep;
import io.qameta.allure.Allure;

public class HooksWeb {
	@AfterStep("@Web")
	public void afterStepWeb(Scenario scenario) {
		byte[] screenshootBytes = ((TakesScreenshot) DriverFactory.getWebDriver()).getScreenshotAs(OutputType.BYTES);
		InputStream screenshootStream = new ByteArrayInputStream(screenshootBytes);
		Allure.addAttachment(scenario.getName(), screenshootStream);
	}
}
