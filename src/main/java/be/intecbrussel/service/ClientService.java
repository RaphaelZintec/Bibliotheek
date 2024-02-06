package be.intecbrussel.service;

import be.intecbrussel.model.Client;
import be.intecbrussel.model.SortType;
import be.intecbrussel.repository.ClientRepository;

import java.util.List;

public class ClientService {

    private ClientRepository clientRepository;

    public ClientService (ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }
    public Client addClient (Client client){

        return null;
    }
    public Client removeClient (int id){
        return null;
    }
    public Client findClient(String name){
        return null;

    }
    public Client findClient(int id){
        return null;
    }
    public Client sortClient (SortType sortType){
        return null;
    }
}
