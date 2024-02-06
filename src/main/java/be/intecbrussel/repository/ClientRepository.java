package be.intecbrussel.repository;

import be.intecbrussel.model.Article;
import be.intecbrussel.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository {

    public List<Client> listClient = new ArrayList<>();

    public List<Client> getClient() {
        return listClient;
    }
}
