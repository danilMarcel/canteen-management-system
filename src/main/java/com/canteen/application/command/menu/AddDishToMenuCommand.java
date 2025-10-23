package src.main.java.com.canteen.application.command.menu;


import src.main.java.com.canteen.application.command.Command;
import src.main.java.com.canteen.application.console.ConsoleApplication;
import src.main.java.com.canteen.application.menu.Menu;
import src.main.java.com.canteen.application.menu.impl.MenuMenu;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class AddDishToMenuCommand implements Command {
    @Override
    public Menu execute(ConsoleApplication consoleApp) {
        try {
            System.out.print("Введите ID блюда: ");
            Long dishId = Long.parseLong(consoleApp.getScanner().nextLine());

            System.out.print("Введите дату (гггг-мм-дд): ");
            String dateString = consoleApp.getScanner().nextLine();
            LocalDate date = LocalDate.parse(dateString);

            System.out.print("Введите количество порций: ");
            Integer quantity = Integer.parseInt(consoleApp.getScanner().nextLine());

            boolean success = consoleApp.getMenuService().addDishToMenu(dishId, date, quantity);
            if (success) {
                System.out.println("Блюдо успешно добавлено в меню.");
            } else {
                System.out.println("Блюдо с указанным ID не найдено.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: неверный формат числа.");
        } catch (DateTimeParseException e) {
            System.out.println("Ошибка: неверный формат даты. Используйте гггг-мм-дд.");
        }
        return new MenuMenu();
    }
}
