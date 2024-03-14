package org.tp24.repository.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.tp24.data.Client;
import org.tp24.excepcion.IdNotFoundException;
import org.tp24.excepcion.InvalidNameException;
import org.tp24.excepcion.MaxQuoteException;
import org.tp24.repository.ClientRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.StringTemplate.STR;


public class ClientProviderInMemory implements ClientRepository {
    public final Logger logger = LogManager.getLogger(Client.class);
    private static final ArrayList<Client> clients = new ArrayList<>(
            Collections.singleton(new Client("12345", "Brayan", "Jaraba", "03-06-2006", "m-23", 100.0))
    );

    @Override
    public List<Client> search(String name, String lastName) throws InvalidNameException {
        List<Client> result = new ArrayList<>();
        for (Client client : clients) {
            if (client.getName().equals(name)) {
                result.add(client);
                break;
            }
        }
        if (result.isEmpty()) {
            logger.error(STR."the client \{name} was not found");
            throw new InvalidNameException(name, lastName);
        }
        logger.info(result.toString());
        return result;

    }

    @Override
    public List<Client> search(Double quote) throws MaxQuoteException {
        List<Client> result = new ArrayList<>(); // this is the target that we will return
        for (Client client : clients) {
            if (client.getMaxQuote().equals(quote)) {
                result.add(client);
                break;
            }
        }
        if (result.isEmpty()) {
            logger.error(STR."client by quote \{quote} was not found");
            throw new MaxQuoteException(quote);
        } else {
            logger.info(result.toString());
            return result;
        }
    }

    @Override
    public Client searchById(String id) throws IdNotFoundException {
        Client result = null;
        for (Client client : clients) {
            if (client.getId().equals(id)) {
                result = client;
                break;
            }
        }
        if (result == null) {
            logger.error(STR."the client with id \{id} was not found");
            throw new IdNotFoundException(id);
        } else {
            logger.info(result.toString());
            return result;
        }
    }

    public void addClient(Client newClient) {
        clients.add(newClient);
    }
}
