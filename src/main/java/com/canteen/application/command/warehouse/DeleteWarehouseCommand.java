package src.main.java.com.canteen.application.command.warehouse;


import src.main.java.com.canteen.application.command.Command;
import src.main.java.com.canteen.application.console.ConsoleApplication;
import src.main.java.com.canteen.application.menu.Menu;
import src.main.java.com.canteen.application.menu.impl.WarehouseMenu;

public class DeleteWarehouseCommand implements Command {
    @Override
    public Menu execute(ConsoleApplication consoleApp) {
        try {
            System.out.print("Введите ID склада для удаления: ");
            Long id = Long.parseLong(consoleApp.getScanner().nextLine());
            boolean success = consoleApp.getWarehouseService().deleteWarehouse(id);
            if (success) {
                System.out.println("Склад успешно удален.");
            } else {
                System.out.println("Склад с указанным ID не найден.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: неверный формат ID.");
        }
        return new WarehouseMenu();
    }
}