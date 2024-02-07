package be.intecbrussel.model;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private String name;
    private int Id;
    private static int incrementId;
    private List<Article> listArticles = new ArrayList<>();
    public Client(){

    }
    public Client(String name) {
        this.name = name;
        Id = 1+incrementId;
    }
    public Client(String name, int id) {
        this.name = name;
        Id = id;
        incrementId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public List<Article> getListArticles() {
        return listArticles;
    }

    public void setListArticles(List<Article> listArticles) {
        this.listArticles = listArticles;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", Id=" + Id +
                '}';
    }
}
