package be.intecbrussel.service;
import be.intecbrussel.model.Article;
import be.intecbrussel.model.Client;
import be.intecbrussel.repository.ClientRepository;

import java.util.List;
import java.util.Optional;


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
        return client.getName() +"added in bibliotheek";
    }
    public String removeClient (int id){
        clientRepository.getClients().remove(findClientById(id));
        return "article removed out bibliotheek";
    }
    public Client findClientById(int id){
        for(Client client : clientRepository.getClients()){
            if(client.getId() == id){
                return client;
            }
        }
        return null;
    }

    public Optional<Client> findClientByName(String name) {
        System.out.println("\n---------- Find Client By Client Name ----------");
        System.out.println("Searching for Client by Client name : " + name);
        Optional<Client> foundClientByName = clientRepository.getClients().stream()
                .filter(user -> user.getName().equals(name))
                .findFirst();

        if (foundClientByName.isPresent()) {
            Client user = foundClientByName.get();
            System.out.println("Client found  : " + user);
        } else {
            System.out.println("Client with Client number " + name + " was not found.");
        }
        return foundClientByName;
    }

    public String sortClient (){
        return null;
    }
    public List<Client> returnAllClients(){
        return clientRepository.getClients();
    }
}
