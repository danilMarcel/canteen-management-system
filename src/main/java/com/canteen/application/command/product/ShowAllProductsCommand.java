package src.main.java.com.canteen.application.command.product;


import src.main.java.com.canteen.application.command.Command;
import src.main.java.com.canteen.application.console.ConsoleApplication;
import src.main.java.com.canteen.application.menu.Menu;
import src.main.java.com.canteen.application.menu.impl.ProductMenu;

public class ShowAllProductsCommand implements Command {
    @Override
    public Menu execute(ConsoleApplication consoleApp) {
        System.out.println("\n--- ВСЕ ПРОДУКТЫ ---");
        var products = consoleApp.getProductService().getAllProducts();
        if (products.isEmpty()) {
            System.out.println("Продукты не найдены.");
        } else {
            System.out.printf("%-5s %-20s %-10s %-10s %-10s%n",
                    "ID", "Название", "Кол-во", "Ед.", "Мин.запас");
            System.out.println("--------------------------------------------------------");
            for (var product : products) {
                System.out.printf("%-5d %-20s %-10s %-10s %-10s%n",
                        product.getProductId(),
                        product.getName(),
                        product.getCurrentQuantity(),
                        product.getUnit(),
                        product.getMinQuantity());
            }
        }
        return new ProductMenu();
    }
}