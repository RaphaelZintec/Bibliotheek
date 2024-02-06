package be.intecbrussel.service;


import be.intecbrussel.model.Article;
import be.intecbrussel.model.SortType;
import be.intecbrussel.repository.ArticleRepository;

public class ArticleService {
    private ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    public void borrowArticle (String nameOfArticle, int idClient){

    }
    public void addArticle (Article article){

    }

    public void removeArticle (int id){

    }

    public Article findArticle (int id){
        return null;
    }

    public void sortArticle(SortType sortType){

    }
}