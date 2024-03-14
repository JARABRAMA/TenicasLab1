package org.tp24;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.appender.ManagerFactory;

public class ApplicationRunner {
    private final Logger logger = LogManager.getLogger(ApplicationRunner.class);

    void run() {
        logger.info("the application is running");
    }

}
