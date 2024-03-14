package org.tp24.providers;

import org.tp24.data.Client;
import org.tp24.repository.impl.ClientProviderInMemory;

class ClientProviderTest {
    public ClientProviderInMemory clientProvider = new ClientProviderInMemory();
    Client target  = new Client("12345", "Brayan", "Jaraba", "03-06-2006", "m-23", 100.0);


}