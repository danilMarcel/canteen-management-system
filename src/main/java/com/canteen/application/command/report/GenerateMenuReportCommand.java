package src.main.java.com.canteen.application.command.report;


import src.main.java.com.canteen.application.command.Command;
import src.main.java.com.canteen.application.console.ConsoleApplication;
import src.main.java.com.canteen.application.menu.Menu;
import src.main.java.com.canteen.application.menu.impl.ReportMenu;

public class GenerateMenuReportCommand implements Command {
    @Override
    public Menu execute(ConsoleApplication consoleApp) {
        System.out.println("\n--- ОТЧЕТ ПО МЕНЮ ---");
        var todayMenu = consoleApp.getMenuService().getTodayMenu();
        var allDishes = consoleApp.getMenuService().getAllDishes();

        if (todayMenu.isEmpty()) {
            System.out.println("На сегодня меню не составлено.");
        } else {
            System.out.println("Меню на сегодня:");
            for (var menu : todayMenu) {
                var dish = allDishes.stream()
                        .filter(d -> d.getDishId().equals(menu.getDishId()))
                        .findFirst();

                if (dish.isPresent()) {
                    System.out.printf("- %s: %d порций по %s руб.%n",
                            dish.get().getName(), menu.getAvailableQuantity(), dish.get().getPrice());
                }
            }
        }
        return new ReportMenu();
    }
}