package src.main.java.com.canteen.application.command.warehouse;


import src.main.java.com.canteen.application.command.Command;
import src.main.java.com.canteen.application.console.ConsoleApplication;
import src.main.java.com.canteen.application.menu.Menu;
import src.main.java.com.canteen.application.menu.impl.WarehouseMenu;

public class SearchWarehousesCommand implements Command {
    @Override
    public Menu execute(ConsoleApplication consoleApp) {
        System.out.print("Введите название для поиска: ");
        String name = consoleApp.getScanner().nextLine();

        var warehouses = consoleApp.getWarehouseService().searchWarehousesByName(name);
        if (warehouses.isEmpty()) {
            System.out.println("Склады с таким названием не найдены.");
        } else {
            System.out.println("\n--- РЕЗУЛЬТАТЫ ПОИСКА ---");
            for (var warehouse : warehouses) {
                System.out.printf("ID: %d, Название: %s, Адрес: %s%n",
                        warehouse.getWarehouseId(), warehouse.getName(), warehouse.getAddress());
            }
        }
        return new WarehouseMenu();
    }
}