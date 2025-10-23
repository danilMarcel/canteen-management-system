package src.main.java.com.canteen.application.command.product;


import src.main.java.com.canteen.application.command.Command;
import src.main.java.com.canteen.application.console.ConsoleApplication;
import src.main.java.com.canteen.application.menu.Menu;
import src.main.java.com.canteen.application.menu.impl.ProductMenu;

public class ShowProductsByWarehouseCommand implements Command {
    @Override
    public Menu execute(ConsoleApplication consoleApp) {
        try {
            System.out.print("Введите ID склада: ");
            Long warehouseId = Long.parseLong(consoleApp.getScanner().nextLine());

            var products = consoleApp.getProductService().getProductsByWarehouse(warehouseId);
            if (products.isEmpty()) {
                System.out.println("На указанном складе продукты не найдены.");
            } else {
                System.out.printf("\n--- ПРОДУКТЫ НА СКЛАДЕ %d ---%n", warehouseId);
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
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: неверный формат ID.");
        }
        return new ProductMenu();
    }
}