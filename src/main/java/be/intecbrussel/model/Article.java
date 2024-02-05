package be.intecbrussel.model;

import java.time.LocalDate;

public class Article {

    private String name;
    private String author;
    private int Id;
    private LocalDate publicationDate;

    public Article(){

    }
    public Article(String name, String author, int id, LocalDate publicationDate) {
        this.name = name;
        this.author = author;
        Id = id;
        this.publicationDate = publicationDate;
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
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public String toString() {
        return "Article{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", Id=" + Id +
                ", publicationDate=" + publicationDate +
                '}';
    }
}
