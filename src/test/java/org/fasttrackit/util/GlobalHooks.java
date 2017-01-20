package org.fasttrackit.util;

import com.sdl.selenium.utils.config.WebDriverConfig;
import com.sdl.selenium.web.utils.Utils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class GlobalHooks {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalHooks.class);

    @After("@screen")
    public void screen(Scenario scenario) {
        String scenarioName = scenario.getName(); // TODO class name

        boolean isFailed = scenario.isFailed();
        if (isFailed) {
            LOGGER.warn(scenarioName + " Scenario has failed! Embed the screenshot in the report!--- ");
            byte[] screenshot = ((TakesScreenshot) WebDriverConfig.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");

            takeScreenShot(scenarioName);
        }
    }

    private void takeScreenShot(String screenShotName) {
        if (screenShotName.length() > 80) {
            screenShotName = screenShotName.substring(0, 80);
        }
        screenShotName = screenShotName.replaceAll(" ", "_");
        String resultPath = new File("test-output").getAbsolutePath();
        screenShotName = Utils.getScreenShot(screenShotName, resultPath + "\\screens\\");
        LOGGER.info(screenShotName);
    }

}
