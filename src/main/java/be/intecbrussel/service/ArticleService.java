package be.intecbrussel.service;
import be.intecbrussel.model.Article;
import be.intecbrussel.model.Client;
import be.intecbrussel.repository.ArticleRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArticleService {
    //ATTRIBUTES
    private ArticleRepository articleRepository;
    private List<Article> clientArticles = new ArrayList<>();

    //CONSTRUCTORS
    public ArticleService(){
        articleRepository = new ArticleRepository();
    }

    //METHODS
    public List<Article> getClientArticles() {
        return clientArticles;
    }
    public String borrowArticle (int id){
        if(findArticleById(id) != null){
            clientArticles.add(findArticleById(id));
            articleRepository.getArticles().remove(findArticleById(id));
            return "✅ The article left bibliotheek";
        }
        return "\uD83D\uDFE1 This article ID is not in stock, try again";
    }
    public String returnArticle (int id){
        if (clientArticles.stream().anyMatch(a->a.getId()==id)){
            articleRepository.getArticles().add(clientArticles.stream().filter(a->a.getId()==id).findFirst().get());
            clientArticles.remove(clientArticles.stream().filter(a->a.getId()==id).findFirst().get());
            return "✅ The article returned to bibliotheek";
        }
        return "\uD83D\uDFE1 You don't have any articles with this ID, try again";
    }
    public String addArticle (Article article){
        articleRepository.getArticles().add(article);
        return "✅ New article added in bibliotheek";
    }
    public String removeArticle (int id){
        if(findArticleById(id) != null){
            articleRepository.getArticles().remove(findArticleById(id));
            return "✅ Article removed from bibliotheek";
        }   return "\uD83D\uDFE1 The article with this ID doesnt exists, please try again";
    }
    public Article findArticleById(int id){
        for(Article article : articleRepository.getArticles()){
            if(article.getId() == id){
                return article;
            }
        }
        return null;
    }
    public String sortArticles(){
        articleRepository.getArticles().sort(Comparator.comparing(article -> article.getName().toLowerCase()));
        return "✅ Articles sorted by name A-Z";
    }
    public List<Article> returnAllArticles(){
        return articleRepository.getArticles();
    }
}