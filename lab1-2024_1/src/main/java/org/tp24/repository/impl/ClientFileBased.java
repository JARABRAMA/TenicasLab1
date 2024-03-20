package org.tp24.repository.impl;

import org.tp24.data.Client;
import org.tp24.repository.ClientRepository;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.nio.file.Path;
import java.util.Objects;
import java.util.stream.Stream;

public class ClientFileBased implements ClientRepository {
    @Override
    public List<Client> findAll() {
        Path path = Path.of("./scr/main/resources/client-data.txt");
        try (Stream<String> stream = Files.lines(path)) {
            return stream.map(this::build).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Client> search(String name, String lastName) {
        List<Client> clients = this.findAll();
        return clients.stream().
                filter(client -> Objects.equals(client.getName(), name) && Objects.equals(client.getLastName(), lastName)).
                toList();
    }

    private Client build(String text) {
        String[] clientArray = text.split(",");
        return new Client(clientArray[0], clientArray[1], clientArray[2], clientArray[3], clientArray[4], Double.parseDouble(clientArray[0]));
    }

    @Override
    public List<Client> search(Double quote) {
        List<Client> clients = this.findAll();
        return clients.stream().filter(p -> Objects.equals(p.getMaxQuote(), quote)).toList();
    }

    @Override
    public Client search(String id) {
        return this.findAll().stream().filter(client -> Objects.equals(client.getId(), id)).findAny().orElse(null);
    }
}
