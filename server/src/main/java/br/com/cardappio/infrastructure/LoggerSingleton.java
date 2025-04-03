package br.com.cardappio.infrastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class LoggerSingleton {

    private static LoggerSingleton instance;
    private final Logger logger;

    private LoggerSingleton() {

        logger = LoggerFactory.getLogger(LoggerSingleton.class);
    }

    public static LoggerSingleton getInstance() {

        if (Objects.isNull(instance)) {
            instance =  new LoggerSingleton();
        }

        return instance;
    }

    public void info(String info) {

        logger.info(info);
    }

    public void debug(String debug) {

        logger.debug(debug);
    }

    public void warn(String warn) {

        logger.warn(warn);
    }

    public void error(String error) {

        logger.error(error);
    }
}
