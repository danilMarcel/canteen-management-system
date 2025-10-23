package src.main.java.com.canteen.application.command.menu;

import src.main.java.com.canteen.application.command.Command;
import src.main.java.com.canteen.application.console.ConsoleApplication;
import src.main.java.com.canteen.application.menu.Menu;
import src.main.java.com.canteen.application.menu.impl.MenuMenu;


public class SearchDishesCommand implements Command {
    @Override
    public Menu execute(ConsoleApplication consoleApp) {
        System.out.print("Введите название для поиска: ");
        String name = consoleApp.getScanner().nextLine();

        var dishes = consoleApp.getMenuService().searchDishesByName(name);
        if (dishes.isEmpty()) {
            System.out.println("Блюда с таким названием не найдены.");
        } else {
            System.out.println("\n--- РЕЗУЛЬТАТЫ ПОИСКА ---");
            System.out.printf("%-5s %-25s %-10s %-15s%n", "ID", "Название", "Цена", "Время");
            System.out.println("----------------------------------------------------");
            for (var dish : dishes) {
                System.out.printf("%-5d %-25s %-10s %-15d%n",
                        dish.getDishId(),
                        dish.getName(),
                        dish.getPrice() + " руб.",
                        dish.getCookingTime());
            }
        }
        return new MenuMenu();
    }
}