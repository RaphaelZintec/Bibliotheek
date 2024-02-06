package be.intecbrussel.repository;

import be.intecbrussel.model.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {

    private List<Article> listArticle = new ArrayList<>();
    {

    }
    public List<Article> getArticle() {
        return listArticle;
    }
}
