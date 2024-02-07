package be.intecbrussel;
import be.intecbrussel.model.Article;
import be.intecbrussel.model.Client;
import be.intecbrussel.service.ArticleService;
import be.intecbrussel.service.ClientService;
import java.util.Scanner;

public class BibliotheekApp {

    public static ArticleService articleService = new ArticleService();
    private static ClientService clientService = new ClientService();
    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {


        System.out.println("Welcome to our library");

        //#1
        System.out.println("Are you [client] or [employee]");
        String input = scanner.nextLine();
        handleRequestPerson(input);

    }

    //HANDLERS
    private static void handleRequestPerson(String input) {
        switch (input) {
            case "client" -> {
                System.out.println("Do you want to [borrow] or [return] article?");
            }
            case "employee" -> {
                System.out.println("Control panel activated: Choose you want to edit [Articles] or [Clients]");
                input = scanner.next();
                handleRequestEmployeeChoice(input);
            }
            default -> System.out.println("Invalid input");
        }
    }

    private static void handleRequestEmployeeChoice(String input) {
        switch (input) {
            case "articles" -> {
                System.out.println("Choose option [sort articles], [add articles], [remove articles}");
                input = scanner.next();
                handleRequestManageArticles(input);
            }

            case "clients" -> {
                System.out.println("Choose option [add client], [remove client]");
                input = scanner.next();
                handleRequestManageClients(input);
            }

            default -> System.out.println("Invalid input");
        }
    }

    private static void handleRequestManageArticles(String input) {
        switch (input) {
            case "sort" -> {
                System.out.println(articleService.sortArticles());

                articleService.returnAllArticles().forEach(System.out::println);
            }
            case "add" -> {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Which article do you want to add?");

                System.out.println("Enter the title:");
                String title = scanner.nextLine();

                System.out.println("Enter the author:");
                String author = scanner.nextLine();

                System.out.println(articleService.addArticle(new Article(title, author)));
            }
            case "remove" -> {
                System.out.println("Provide the ID of the article to remove:");
                int id = scanner.nextInt();
                System.out.println(articleService.removeArticle(id));
            }

            default -> System.out.println("Invalid input");
        }
    }

    private static void handleRequestManageClients(String input) {
        switch (input) {
            case "add" -> {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Which client do you want to add?");

                System.out.println("Enter the name:");
                String name = scanner.nextLine();

                System.out.println(clientService.addClient(new Client(name)));

                clientService.returnAllClients().forEach(System.out::println);
            }
            case "remove" -> {
                System.out.println("Provide the ID of the client to remove:");
                int id = scanner.nextInt();
                System.out.println(clientService.removeClient(id));

                clientService.returnAllClients().forEach(System.out::println);
            }

            default -> System.out.println("Invalid input");
        }
    }


}
