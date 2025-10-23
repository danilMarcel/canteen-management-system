package src.main.java.com.canteen.application.command.menu;


import src.main.java.com.canteen.application.command.Command;
import src.main.java.com.canteen.application.console.ConsoleApplication;
import src.main.java.com.canteen.application.menu.Menu;
import src.main.java.com.canteen.application.menu.impl.MenuMenu;

public class ShowTodayMenuCommand implements Command {
    @Override
    public Menu execute(ConsoleApplication consoleApp) {
        System.out.println("\n--- МЕНЮ НА СЕГОДНЯ ---");
        var todayMenu = consoleApp.getMenuService().getTodayMenu();
        var allDishes = consoleApp.getMenuService().getAllDishes();

        if (todayMenu.isEmpty()) {
            System.out.println("На сегодня меню не составлено.");
        } else {
            System.out.printf("%-25s %-10s %-10s %-30s%n", "Блюдо", "Порций", "Цена", "Описание");
            System.out.println("--------------------------------------------------------------------------------");

            for (var menu : todayMenu) {
                var dish = allDishes.stream()
                        .filter(d -> d.getDishId().equals(menu.getDishId()))
                        .findFirst();

                if (dish.isPresent()) {
                    System.out.printf("• %-23s %-10d %-10s %-30s%n",
                            dish.get().getName(),
                            menu.getAvailableQuantity(),
                            dish.get().getPrice() + " руб.",
                            dish.get().getDescription());
                }
            }
        }
        return new MenuMenu();
    }
}
