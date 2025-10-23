package src.main.java.com.canteen.application.command.menu;


import src.main.java.com.canteen.application.command.Command;
import src.main.java.com.canteen.application.console.ConsoleApplication;
import src.main.java.com.canteen.application.menu.Menu;
import src.main.java.com.canteen.application.menu.impl.MenuMenu;

public class ShowAllDishesCommand implements Command {
    @Override
    public Menu execute(ConsoleApplication consoleApp) {
        System.out.println("\n--- ВСЕ БЛЮДА ---");
        var dishes = consoleApp.getMenuService().getAllDishes();
        if (dishes.isEmpty()) {
            System.out.println("Блюда не найдены.");
        } else {
            System.out.printf("%-5s %-25s %-10s %-15s %-30s%n",
                    "ID", "Название", "Цена", "Время", "Описание");
            System.out.println("----------------------------------------------------------------------------------------");
            for (var dish : dishes) {
                System.out.printf("%-5d %-25s %-10s %-15d %-30s%n",
                        dish.getDishId(),
                        dish.getName(),
                        dish.getPrice() + " руб.",
                        dish.getCookingTime(),
                        dish.getDescription());
            }
        }
        return new MenuMenu();
    }
}