package be.intecbrussel.model;

public class Client {

    private String name;
    private int Id;

    public Client(){

    }
    public Client(String name, int id) {
        this.name = name;
        Id = id;
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

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", Id=" + Id +
                '}';
    }
}
