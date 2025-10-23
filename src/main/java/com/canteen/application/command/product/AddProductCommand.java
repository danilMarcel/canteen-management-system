package src.main.java.com.canteen.application.command.product;


import src.main.java.com.canteen.application.command.Command;
import src.main.java.com.canteen.application.console.ConsoleApplication;
import src.main.java.com.canteen.application.menu.Menu;
import src.main.java.com.canteen.application.menu.impl.ProductMenu;

import java.math.BigDecimal;

public class AddProductCommand implements Command {
    @Override
    public Menu execute(ConsoleApplication consoleApp) {
        try {
            System.out.print("Название продукта: ");
            String name = consoleApp.getScanner().nextLine();

            System.out.print("Единица измерения (кг/л/шт): ");
            String unit = consoleApp.getScanner().nextLine();

            System.out.print("ID поставщика: ");
            Long providerId = Long.parseLong(consoleApp.getScanner().nextLine());

            System.out.print("ID склада: ");
            Long warehouseId = Long.parseLong(consoleApp.getScanner().nextLine());

            System.out.print("Текущее количество: ");
            BigDecimal currentQuantity = new BigDecimal(consoleApp.getScanner().nextLine());

            System.out.print("Минимальный запас: ");
            BigDecimal minQuantity = new BigDecimal(consoleApp.getScanner().nextLine());

            var product = consoleApp.getProductService().createProduct(name, unit, providerId, warehouseId, currentQuantity, minQuantity);
            System.out.printf("Продукт '%s' успешно создан с ID: %d%n", product.getName(), product.getProductId());

        } catch (NumberFormatException e) {
            System.out.println("Ошибка: неверный формат числа.");
        } catch (Exception e) {
            System.out.println("Ошибка при создании продукта: " + e.getMessage());
        }
        return new ProductMenu();
    }
}