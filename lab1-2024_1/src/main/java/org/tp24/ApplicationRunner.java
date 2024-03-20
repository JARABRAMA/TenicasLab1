package org.tp24;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.tp24.data.Client;
import org.tp24.repository.impl.ClientFileBased;
import org.tp24.service.ClientServiceImpl;
import java.util.List;

public class ApplicationRunner {
    private static final Logger logger = LogManager.getLogger(ApplicationRunner.class);

    public static void main(String[] args) {
        ClientServiceImpl clientService = new ClientServiceImpl(new ClientFileBased());
        List<Client> clients = clientService.finAll() ;
        logger.info(clients.toString());
    }

    void run() {
        logger.info("the application is running");
    }

}
