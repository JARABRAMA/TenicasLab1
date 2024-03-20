package org.tp24.repository.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.tp24.data.Client;
import org.tp24.repository.ClientRepository;

import java.util.*;


public class ClientProviderInMemory implements ClientRepository {
    public final Logger logger = LogManager.getLogger(Client.class);
    private static final ArrayList<Client> clients = new ArrayList<>(
            Collections.singleton(new Client("12345", "Brayan", "Jaraba", "03-06-2006", "m-23", 100.0))
    );

    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public List<Client> search(String name, String lastName) {
        return clients.stream().filter(client -> client.getName().equals(name) && client.getLastName().equals(lastName)).toList();
    }

    @Override
    public List<Client> search(Double quote) {
        return clients.stream().filter(client -> Objects.equals(client.getMaxQuote(), quote)).toList();
    }

    @Override
    public Client search(String id) {
        return clients.stream().filter(client ->
                Objects.equals(client.getId(), id)
        ).findAny().orElse(null);
    }

    public void addClient(Client newClient) {
        clients.add(newClient);
    }
}
