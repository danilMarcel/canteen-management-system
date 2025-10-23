package src.main.java.com.canteen.application.command.menu;


import src.main.java.com.canteen.application.command.Command;
import src.main.java.com.canteen.application.console.ConsoleApplication;
import src.main.java.com.canteen.application.menu.Menu;
import src.main.java.com.canteen.application.menu.impl.MenuMenu;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ShowMenuByDateCommand implements Command {
    @Override
    public Menu execute(ConsoleApplication consoleApp) {
        try {
            System.out.print("Введите дату (гггг-мм-дд): ");
            String dateString = consoleApp.getScanner().nextLine();
            LocalDate date = LocalDate.parse(dateString);

            var menu = consoleApp.getMenuService().getMenuByDate(date);
            var allDishes = consoleApp.getMenuService().getAllDishes();

            System.out.printf("\n--- МЕНЮ НА %s ---%n", date);
            if (menu.isEmpty()) {
                System.out.println("На указанную дату меню не составлено.");
            } else {
                System.out.printf("%-25s %-10s %-10s %-30s%n", "Блюдо", "Порций", "Цена", "Описание");
                System.out.println("--------------------------------------------------------------------------------");

                for (var menuItem : menu) {
                    var dish = allDishes.stream()
                            .filter(d -> d.getDishId().equals(menuItem.getDishId()))
                            .findFirst();

                    if (dish.isPresent()) {
                        System.out.printf("• %-23s %-10d %-10s %-30s%n",
                                dish.get().getName(),
                                menuItem.getAvailableQuantity(),
                                dish.get().getPrice() + " руб.",
                                dish.get().getDescription());
                    }
                }
            }
        } catch (DateTimeParseException e) {
            System.out.println("Ошибка: неверный формат даты. Используйте гггг-мм-дд.");
        }
        return new MenuMenu();
    }
}