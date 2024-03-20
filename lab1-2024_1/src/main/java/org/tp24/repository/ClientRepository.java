package org.tp24.repository;

import org.tp24.data.Client;

import java.io.IOException;
import java.util.List;

public interface ClientRepository {

    List<Client> findAll();
    List<Client> search(String name, String lastName) throws IOException;

    List<Client> search(Double quote) ;

    Client search(String id) ;
}
