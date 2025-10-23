package src.main.java.com.canteen.application.command.menu;


import src.main.java.com.canteen.application.command.Command;
import src.main.java.com.canteen.application.console.ConsoleApplication;
import src.main.java.com.canteen.application.menu.Menu;
import src.main.java.com.canteen.application.menu.impl.MenuMenu;

import java.math.BigDecimal;

public class AddDishCommand implements Command {
    @Override
    public Menu execute(ConsoleApplication consoleApp) {
        try {
            System.out.print("Название блюда: ");
            String name = consoleApp.getScanner().nextLine();

            System.out.print("Описание: ");
            String description = consoleApp.getScanner().nextLine();

            System.out.print("Время приготовления (мин): ");
            Integer cookingTime = Integer.parseInt(consoleApp.getScanner().nextLine());

            System.out.print("Цена: ");
            BigDecimal price = new BigDecimal(consoleApp.getScanner().nextLine());

            var dish = consoleApp.getMenuService().createDish(name, description, cookingTime, price);
            System.out.printf("Блюдо '%s' успешно создано с ID: %d%n", dish.getName(), dish.getDishId());

        } catch (NumberFormatException e) {
            System.out.println("Ошибка: неверный формат числа.");
        } catch (Exception e) {
            System.out.println("Ошибка при создании блюда: " + e.getMessage());
        }
        return new MenuMenu();
    }
}