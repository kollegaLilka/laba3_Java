package com.example.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.xml.XmlConfiguration;

import java.io.FileInputStream;
import java.io.IOException;

public class LogConfig {
    private static final Logger logger = LogManager.getLogger(LogConfig.class);

    public static void initLogging(String configFilePath) {
        try {
            FileInputStream configFileStream = new FileInputStream(configFilePath);
            ConfigurationSource source = new ConfigurationSource(configFileStream);
            LoggerContext context = LoggerContext.getContext(false);
            XmlConfiguration configuration = new XmlConfiguration(context, source);
            context.start(configuration);
            logger.info("Logging initialized using configuration file: " + configFilePath);
        } catch (IOException e) {
            logger.error("Failed to initialize logging", e);
        }
    }
}