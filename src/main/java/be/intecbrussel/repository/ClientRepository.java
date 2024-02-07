package be.intecbrussel.repository;
import be.intecbrussel.model.Client;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {

    private List<Client> listClient = new ArrayList<>();
    {
        listClient.add(new Client("Jonathan", 1));
        listClient.add(new Client("Maxim", 2));
        listClient.add(new Client("Deepika", 3));
        listClient.add(new Client("Mausam", 4));
        listClient.add(new Client("Janan", 5));
    }

    public List<Client> getClients() {
        return listClient;
    }
}
