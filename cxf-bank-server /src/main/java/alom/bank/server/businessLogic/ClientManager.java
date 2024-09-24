package alom.bank.server.businessLogic;

import java.util.HashMap;
import java.util.Map;

import alom.bank.server.Client;
import alom.bank.server.exception.*;

import java.util.Calendar;

public class ClientManager {
    private Map<String, Client> clients = new HashMap<>();

    public Client createClient(String firstName, String lastName, Calendar birthDate) throws ClientAlreadyExistsException {
        String clientKey = firstName + lastName + birthDate.getTimeInMillis();
        if (clients.containsKey(clientKey)) {
            throw new ClientAlreadyExistsException("Le client existe déjà.");
        }
        Client client = new Client(firstName, lastName, birthDate, clientKey);
        clients.put(clientKey, client);
        return client;
    }

    public Client getClient(String firstName, String lastName, Calendar birthDate) throws ClientNotFoundException {
        String clientKey = firstName + lastName + birthDate.getTimeInMillis();
        if (!clients.containsKey(clientKey)) {
            throw new ClientNotFoundException("Le client n'existe pas.");
        }
        return clients.get(clientKey);
    }
}
