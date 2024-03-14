package org.tp24.repository;

import org.tp24.data.Client;
import org.tp24.excepcion.IdNotFoundException;
import org.tp24.excepcion.InvalidNameException;
import org.tp24.excepcion.MaxQuoteException;

import java.util.List;

public interface ClientRepository {
    List<Client> search(String name, String lastName) throws InvalidNameException;

    List<Client> search(Double quote) throws MaxQuoteException;

    Client searchById(String id) throws IdNotFoundException;
}
