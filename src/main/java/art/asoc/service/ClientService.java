package art.asoc.service;

import art.asoc.model.Client;
import art.asoc.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientService implements IClientService{

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> allClients() {
        return this.clientRepository.findAll();
    }

    @Override
    public List<Client> getByLastName(String lastName) {
        return this.clientRepository.findByLastName(lastName);
    }

    @Override
    public List<Client> getByDni(String dni) {
        return this.clientRepository.findByDni(dni);
    }

    @Override
    public Client getById(String id) {
        return this.clientRepository.findById(id).orElse(null);
    }

    @Override
    public void createClient(Client client) {
        this.clientRepository.save(client);
    }

    @Override
    public void deleteClient(String id) {
        this.clientRepository.deleteById(id);
    }
}
