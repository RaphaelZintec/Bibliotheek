package be.intecbrussel.service;
import be.intecbrussel.model.Article;
import be.intecbrussel.model.Client;
import be.intecbrussel.repository.ArticleRepository;
import java.util.Comparator;
import java.util.List;

public class ArticleService {
    //ATTRIBUTES
    private ArticleRepository articleRepository;

    //CONSTRUCTORS
    public ArticleService(){
        articleRepository = new ArticleRepository();
    }

    //METHODS
    public String borrowArticle (Article article){
        articleRepository.getArticles().remove(article);
        return article.getName() +"left bibliotheek";
    }
    public String addArticle (Article article){
        articleRepository.getArticles().add(article);
        return "Article "+ article.getName() +" added in bibliotheek";
    }

    public String removeArticle (int id){
        articleRepository.getArticles().remove(findArticleById(id));
        return "article removed out bibliotheek";
    }
    public Article findArticleById(int id){
        for(Article article : articleRepository.getArticles()){
            if(article.getId() == id){
                return article;
            }
        }
        return null;
    }

    public String findArticleByName(String name){
        for(Article article : articleRepository.getArticles()){
            if(article.getName().equalsIgnoreCase(name) ){
                return "Found Article by Name: " + article.getName();
            }
        }
        return "article not found";
    }


    public String sortArticles(){
        articleRepository.getArticles().sort(Comparator.comparing(Article::getName));
        return "Sort is done";
    }

    public List<Article> returnAllArticles(){
        return articleRepository.getArticles();
    }

}