package org.tp24.service;

import org.tp24.data.Client;
import org.tp24.excepcion.IdNotFoundException;
import org.tp24.excepcion.InvalidNameException;
import org.tp24.excepcion.MaxQuoteException;
import org.tp24.repository.ClientRepository;
import org.tp24.repository.impl.ClientProviderInMemory;

import java.io.IOException;
import java.util.List;

public class ClientServiceImpl {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }


    public List<Client> search(String name, String lastName) throws InvalidNameException, IOException {
        var clients = clientRepository.search(name, lastName);
        if (clients.isEmpty()) {
            // logger.error(STR."the client \{name} was not found");
            throw new InvalidNameException(name, lastName);
        }
        return clients;
    }

    public List<Client> search(Double maxQuote) throws MaxQuoteException {
        var clients = clientRepository.search(maxQuote);
        if (clients.isEmpty()) {
            throw new MaxQuoteException(maxQuote);
        }
        return clients;
    }

    public Client search(String id) throws IdNotFoundException {
        var client = clientRepository.search(id);
        if (client == null) {
            throw new IdNotFoundException(id);
        }
        return client;
    }

    public List<Client> finAll(){
        return clientRepository.findAll();
    }
}
