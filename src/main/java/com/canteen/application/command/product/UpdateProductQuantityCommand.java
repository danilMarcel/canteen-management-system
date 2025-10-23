package src.main.java.com.canteen.application.command.product;


import src.main.java.com.canteen.application.command.Command;
import src.main.java.com.canteen.application.console.ConsoleApplication;
import src.main.java.com.canteen.application.menu.Menu;
import src.main.java.com.canteen.application.menu.impl.ProductMenu;

import java.math.BigDecimal;

public class UpdateProductQuantityCommand implements Command {
    @Override
    public Menu execute(ConsoleApplication consoleApp) {
        try {
            System.out.print("Введите ID продукта: ");
            Long productId = Long.parseLong(consoleApp.getScanner().nextLine());

            System.out.print("Введите новое количество: ");
            BigDecimal newQuantity = new BigDecimal(consoleApp.getScanner().nextLine());

            boolean success = consoleApp.getProductService().updateProductQuantity(productId, newQuantity);
            if (success) {
                System.out.println("Количество продукта успешно обновлено.");
            } else {
                System.out.println("Продукт с указанным ID не найден.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: неверный формат числа.");
        }
        return new ProductMenu();
    }
}