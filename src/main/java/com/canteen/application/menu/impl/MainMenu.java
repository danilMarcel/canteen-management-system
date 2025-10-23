package src.main.java.com.canteen.application.menu.impl;


import src.main.java.com.canteen.application.console.ConsoleApplication;
import src.main.java.com.canteen.application.menu.Menu;

public class MainMenu implements Menu {
    @Override
    public Menu show(ConsoleApplication consoleApp) {
        System.out.println("\n--- ГЛАВНОЕ МЕНЮ ---");
        System.out.println("1. Управление складами");
        System.out.println("2. Управление продуктами");
        System.out.println("3. Управление меню");
        System.out.println("4. Отчеты");
        System.out.println("0. Выход");
        System.out.print("Выберите опцию: ");

        String choice = consoleApp.getScanner().nextLine();

        switch (choice) {
            case "1" -> { return new WarehouseMenu(); }
            case "2" -> { return new ProductMenu(); }
            case "3" -> { return new MenuMenu(); }
            case "4" -> { return new ReportMenu(); }
            case "0" -> {
                System.out.println("Выход из системы...");
                System.exit(0);
            }
            default -> System.out.println("Неверный выбор! Попробуйте снова.");
        }
        return this;
    }
}