package be.intecbrussel.service;
import be.intecbrussel.model.Client;
import be.intecbrussel.repository.ClientRepository;
import java.util.List;

public class ClientService {
    //ATTRIBUTES
    private ClientRepository clientRepository;

    //CONSTRUCTORS
    public ClientService (){
        clientRepository = new ClientRepository();
    }

    //METHODS
    public String addClient (Client client){
        clientRepository.getClients().add(client);
        return "✅ Client "+client.getName() +" added";
    }
    public String removeClient (int id){
        clientRepository.getClients().remove(findClientById(id));
        return "✅ Client removed";
    }
    public Client findClientById(int id){
        for(Client client : clientRepository.getClients()){
            if(client.getId() == id){
                return client;
            }
        }
        return null;
    }
    public List<Client> returnAllClients(){
        return clientRepository.getClients();
    }
}
