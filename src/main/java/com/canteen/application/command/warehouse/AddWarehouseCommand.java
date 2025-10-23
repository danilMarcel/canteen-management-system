package src.main.java.com.canteen.application.command.warehouse;


import src.main.java.com.canteen.application.command.Command;
import src.main.java.com.canteen.application.console.ConsoleApplication;
import src.main.java.com.canteen.application.menu.Menu;
import src.main.java.com.canteen.application.menu.impl.WarehouseMenu;

public class AddWarehouseCommand implements Command {
    @Override
    public Menu execute(ConsoleApplication consoleApp) {
        System.out.print("Введите название склада: ");
        String name = consoleApp.getScanner().nextLine();
        System.out.print("Введите адрес склада: ");
        String address = consoleApp.getScanner().nextLine();

        var warehouse = consoleApp.getWarehouseService().createWarehouse(name, address);
        System.out.printf("Склад '%s' успешно создан с ID: %d%n", warehouse.getName(), warehouse.getWarehouseId());

        return new WarehouseMenu();
    }
}