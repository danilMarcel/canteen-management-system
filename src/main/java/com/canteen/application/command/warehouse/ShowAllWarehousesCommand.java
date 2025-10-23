package src.main.java.com.canteen.application.command.warehouse;


import src.main.java.com.canteen.application.command.Command;
import src.main.java.com.canteen.application.console.ConsoleApplication;
import src.main.java.com.canteen.application.menu.Menu;
import src.main.java.com.canteen.application.menu.impl.WarehouseMenu;

public class ShowAllWarehousesCommand implements Command {
    @Override
    public Menu execute(ConsoleApplication consoleApp) {
        System.out.println("\n--- ВСЕ СКЛАДЫ ---");
        var warehouses = consoleApp.getWarehouseService().getAllWarehouses();
        if (warehouses.isEmpty()) {
            System.out.println("Склады не найдены.");
        } else {
            for (var warehouse : warehouses) {
                System.out.printf("ID: %d, Название: %s, Адрес: %s%n",
                        warehouse.getWarehouseId(), warehouse.getName(), warehouse.getAddress());
            }
        }
        return new WarehouseMenu();
    }
}