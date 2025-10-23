package src.main.java.com.canteen.application.command.product;


import src.main.java.com.canteen.application.command.Command;
import src.main.java.com.canteen.application.console.ConsoleApplication;
import src.main.java.com.canteen.application.menu.Menu;
import src.main.java.com.canteen.application.menu.impl.ProductMenu;

public class ShowProductsRunningLowCommand implements Command {
    @Override
    public Menu execute(ConsoleApplication consoleApp) {
        System.out.println("\n--- ПРОДУКТЫ, КОТОРЫЕ ЗАКАНЧИВАЮТСЯ ---");
        var runningLow = consoleApp.getProductService().getProductsRunningLow();
        if (runningLow.isEmpty()) {
            System.out.println("Все продукты в норме!");
        } else {
            for (var product : runningLow) {
                System.out.printf("ВНИМАНИЕ: %s - осталось %s %s (мин: %s)%n",
                        product.getName(), product.getCurrentQuantity(),
                        product.getUnit(), product.getMinQuantity());
            }
        }
        return new ProductMenu();
    }
}