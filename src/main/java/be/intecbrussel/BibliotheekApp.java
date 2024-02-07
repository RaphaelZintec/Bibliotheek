package be.intecbrussel;
import be.intecbrussel.model.Article;
import be.intecbrussel.model.Client;
import be.intecbrussel.service.ArticleService;
import be.intecbrussel.service.ClientService;
import java.util.Scanner;

public class BibliotheekApp {
    //ATTRIBUTES
    private static ArticleService articleService = new ArticleService();
    private static ClientService clientService = new ClientService();

    //MAIN
    public static void main(String[] args) {
        System.out.println("Welcome to our library \uD83C\uDFDB\uFE0F");
        handleRequestSelectPerson();
    }

    //HANDLES
    private static void handleRequestSelectPerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nAre you [client] or [employee]");
        String input = scanner.nextLine();
        handleRequestPerson(input);
    }
    private static void handleRequestPerson(String input) {
        switch (input) {
            case "client" -> handleClientRequest();
            case "employee" -> handleEmployeeRequest();
            default -> {System.out.println("\uD83D\uDD34 Invalid input, please try again"); handleRequestSelectPerson();}
        }
    }
    private static void handleClientRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDo you want to \uD83D\uDCD9 [borrow] or ↩\uFE0F [return] an article or go \uD83D\uDD19 [back]?");
        String input = scanner.next();
        switch (input) {
            case "borrow" -> handleClientChooseArticleToBorrow();
            case "return" -> handleClientReturnArticle();
            case "back" -> handleRequestSelectPerson();
            default -> {System.out.println("\uD83D\uDD34 Invalid input, please try again"); handleClientRequest();}
        }
    }
    private static void handleClientChooseArticleToBorrow() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nChoose the #\uFE0F⃣ [ID] of the article you want to borrow or go \uD83D\uDD19 [back]");
        articleService.returnAllArticles().forEach(System.out::println);
        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("back")){
             handleClientRequest();
        } else if (input.matches("[0-9]+")){
             System.out.println(articleService.borrowArticle(Integer.parseInt(input)));
             System.out.println("\n\uD83C\uDFDB\uFE0F Bibliotheek stock: ");
             articleService.returnAllArticles().forEach(System.out::println);
             System.out.println("\uD83D\uDC64 Client stock: ");
             articleService.getClientArticles().forEach(System.out::println);
             handleClientChooseArticleToBorrow();
         } else {
             System.out.println("\uD83D\uDD34 Invalid input, please try again");
             handleClientChooseArticleToBorrow();
         }
    }
    private static void handleClientReturnArticle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nChoose the #\uFE0F⃣ [ID] of the article you want to return or go \uD83D\uDD19 [back]");
        articleService.getClientArticles().forEach(System.out::println);
        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("back")){
            handleClientRequest();
        } else if (input.matches("[0-9]+")){
            System.out.println(articleService.returnArticle(Integer.parseInt(input)));
            System.out.println("\n\uD83C\uDFDB\uFE0F Bibliotheek stock: ");
            articleService.returnAllArticles().forEach(System.out::println);
            System.out.println("\uD83D\uDC64 Client stock: ");
            articleService.getClientArticles().forEach(System.out::println);
            handleClientReturnArticle();
        } else {
            System.out.println("\uD83D\uDD34 Invalid input, please try again");
            handleClientReturnArticle();
        }
    }
    private static void handleEmployeeRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\uD83D\uDD12 Control panel activated: Choose whether you want to edit \uD83D\uDCDA [articles] or \uD83E\uDDD1\u200D\uD83E\uDD1D\u200D\uD83E\uDDD1 [clients] or go \uD83D\uDD19 [back]");
        String input = scanner.next();
        switch (input) {
            case "articles" -> handleEmployeeArticleChoice();
            case "clients" -> handleEmployeeClientChoice();
            case "back" -> handleRequestSelectPerson();
            default -> {
                System.out.println("\uD83D\uDD34 Invalid input, please try again");
                handleEmployeeRequest();
            }
        }
    }
    private static void handleEmployeeArticleChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nChoose an option: \uD83D\uDCC8 [sort] articles by name A-Z, ➕ [add] article, \uD83D\uDDD1\uFE0F [remove] article or go \uD83D\uDD19 [back]");
        String input = scanner.next();
        switch (input) {
            case "sort" -> {
                System.out.println(articleService.sortArticles());
                articleService.returnAllArticles().forEach(System.out::println);
                handleEmployeeArticleChoice();
            }
            case "add" -> handleEmployeeAddArticle();
            case "remove" -> handleEmployeeRemoveArticle();
            case "back" -> handleEmployeeRequest();
            default -> {
                System.out.println("\uD83D\uDD34 Invalid input, please try again");
                handleEmployeeArticleChoice();
            }
        }
    }
    private static void handleEmployeeAddArticle() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the title:");
        String title = scanner.nextLine();

        System.out.println("Enter the author:");
        String author = scanner.nextLine();

        System.out.println("Enter the publication date in the format (DD-MM-YYYY):");
        String date = scanner.nextLine();

        System.out.println(articleService.addArticle(new Article(title, author, date)));
        articleService.returnAllArticles().forEach(System.out::println);

        handleEmployeeArticleChoice();
    }
    private static void handleEmployeeRemoveArticle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nProvide the #\uFE0F⃣ [ID] of the article to \uD83D\uDDD1\uFE0F remove or go \uD83D\uDD19 [back]");
        articleService.returnAllArticles().forEach(System.out::println);

        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("back")){
            handleEmployeeArticleChoice();
        } else if (input.matches("[0-9]+")){
            System.out.println(articleService.removeArticle(Integer.parseInt(input)));
            System.out.println("\n\uD83C\uDFDB\uFE0F Bibliotheek stock: ");
            articleService.returnAllArticles().forEach(System.out::println);
            handleEmployeeRemoveArticle();
        } else {
            System.out.println("\uD83D\uDD34 Invalid input, please try again");
            handleEmployeeRemoveArticle();
        }
    }
    private static void handleEmployeeClientChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nChoose an option: ➕ [add] client, \uD83D\uDDD1\uFE0F [remove] client or go \uD83D\uDD19 [back]");
        String input = scanner.next();
        switch (input) {
            case "add" -> handleEmployeeAddClient();
            case "remove" -> handleEmployeeRemoveClient();
            case "back" -> handleEmployeeRequest();
            default -> {
                System.out.println("\uD83D\uDD34 Invalid input, please try again");
                handleEmployeeClientChoice();
            }
        }
    }
    private static void handleEmployeeAddClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name:");
        String name = scanner.nextLine();
        System.out.println(clientService.addClient(new Client(name)));

        System.out.println("\n\uD83E\uDDD1\u200D\uD83E\uDD1D\u200D\uD83E\uDDD1 All clients:");
        clientService.returnAllClients().forEach(System.out::println);
        handleEmployeeClientChoice();
    }
    private static void handleEmployeeRemoveClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nProvide the #\uFE0F⃣ [ID] of the client to \uD83D\uDDD1\uFE0F remove or go \uD83D\uDD19 [back]");
        clientService.returnAllClients().forEach(System.out::println);
        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("back")){
            handleEmployeeClientChoice();
        } else if (input.matches("[0-9]+")){
            System.out.println(clientService.removeClient(Integer.parseInt(input)));
            System.out.println("\n\uD83E\uDDD1\u200D\uD83E\uDD1D\u200D\uD83E\uDDD1 All clients:");
            clientService.returnAllClients().forEach(System.out::println);
            handleEmployeeRemoveClient();
        } else {
            System.out.println("\uD83D\uDD34 Invalid input, please try again");
            handleEmployeeRemoveClient();
        }
    }
}