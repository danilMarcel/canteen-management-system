package src.main.java.com.canteen.application.menu.impl;


import src.main.java.com.canteen.application.command.warehouse.*;
import src.main.java.com.canteen.application.console.ConsoleApplication;
import src.main.java.com.canteen.application.menu.Menu;

public class WarehouseMenu implements Menu {
    @Override
    public Menu show(ConsoleApplication consoleApp) {
        System.out.println("\n--- УПРАВЛЕНИЕ СКЛАДАМИ ---");
        System.out.println("1. Показать все склады");
        System.out.println("2. Добавить склад");
        System.out.println("3. Найти склад по названию");
        System.out.println("4. Удалить склад");
        System.out.println("0. Назад");
        System.out.print("Выберите опцию: ");

        String choice = consoleApp.getScanner().nextLine();

        switch (choice) {
            case "1" -> { return new ShowAllWarehousesCommand().execute(consoleApp); }
            case "2" -> { return new AddWarehouseCommand().execute(consoleApp); }
            case "3" -> { return new SearchWarehousesCommand().execute(consoleApp); }
            case "4" -> { return new DeleteWarehouseCommand().execute(consoleApp); }
            case "0" -> { return new MainMenu(); }
            default -> System.out.println("Неверный выбор!");
        }
        return this;
    }
}