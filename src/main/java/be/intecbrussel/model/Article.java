package be.intecbrussel.model;

import java.time.LocalDate;

public class Article {

    private String name;
    private String author;
    private String date;
    private int id;
    private static int idIncrement;

    public Article(){

    }
    public Article(String name, String author,String date) {
        this.name = name;
        this.author = author;
        this.date = date;
        id = idIncrement+1;
    }
    public Article(String name, String author, int id) {
        this.name = name;
        this.author = author;
        this.id = id;
        idIncrement = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Article{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", date='" + date + '\'' +
                ", id=" + id +
                '}';
    }
}