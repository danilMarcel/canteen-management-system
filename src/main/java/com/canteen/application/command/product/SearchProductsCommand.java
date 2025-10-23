package src.main.java.com.canteen.application.command.product;


import src.main.java.com.canteen.application.command.Command;
import src.main.java.com.canteen.application.console.ConsoleApplication;
import src.main.java.com.canteen.application.menu.Menu;
import src.main.java.com.canteen.application.menu.impl.ProductMenu;

public class SearchProductsCommand implements Command {
    @Override
    public Menu execute(ConsoleApplication consoleApp) {
        System.out.print("Введите название для поиска: ");
        String name = consoleApp.getScanner().nextLine();

        var products = consoleApp.getProductService().searchProductsByName(name);
        if (products.isEmpty()) {
            System.out.println("Продукты с таким названием не найдены.");
        } else {
            System.out.println("\n--- РЕЗУЛЬТАТЫ ПОИСКА ---");
            System.out.printf("%-5s %-20s %-10s %-10s%n", "ID", "Название", "Кол-во", "Ед.");
            System.out.println("---------------------------------------------");
            for (var product : products) {
                System.out.printf("%-5d %-20s %-10s %-10s%n",
                        product.getProductId(),
                        product.getName(),
                        product.getCurrentQuantity(),
                        product.getUnit());
            }
        }
        return new ProductMenu();
    }
}