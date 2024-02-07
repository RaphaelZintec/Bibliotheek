package be.intecbrussel.repository;
import be.intecbrussel.model.Article;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {

    private List<Article> listArticle = new ArrayList<>();
    {
        listArticle.add(new Article("Harry Potter And The Goblet Of Fire", "J.K.Rowling", 1));
        listArticle.add(new Article("To Kill A Mokingbird", "Harper Lee", 2));
        listArticle.add(new Article("Great Gatsby", "Scott Fitzgerald", 3));
        listArticle.add(new Article("A Catcher In The Rye", "J.D. Salinger", 4));
        listArticle.add(new Article("The Lord Of The Rings", "J.R.R.Tolkien", 5));
    }
    public List<Article> getArticles() {
        return listArticle;
    }
}
