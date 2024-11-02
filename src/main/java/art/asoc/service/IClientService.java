package art.asoc.service;

import art.asoc.model.Client;

import java.util.List;

public interface IClientService {
    List<Client> allClients();
    Client getById(String id);
    List<Client> getByLastName(String lastName);
    List<Client> getByDni(String dni);
    void createClient(Client client);
    void deleteClient(String id);
}
