package org.fasttrackit.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sdl.selenium.utils.config.WebDriverConfig;

public class AppUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppUtils.class);

    public static void openUrl(String url) {
        LOGGER.info("open {}", url);
        WebDriverConfig.getDriver().get(url);
    }
}
