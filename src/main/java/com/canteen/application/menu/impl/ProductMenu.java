package src.main.java.com.canteen.application.menu.impl;


import src.main.java.com.canteen.application.command.product.*;
import src.main.java.com.canteen.application.console.ConsoleApplication;
import src.main.java.com.canteen.application.menu.Menu;

public class ProductMenu implements Menu {
    @Override
    public Menu show(ConsoleApplication consoleApp) {
        System.out.println("\n--- УПРАВЛЕНИЕ ПРОДУКТАМИ ---");
        System.out.println("1. Показать все продукты");
        System.out.println("2. Добавить продукт");
        System.out.println("3. Найти продукт по названию");
        System.out.println("4. Показать продукты, которые заканчиваются");
        System.out.println("5. Обновить количество продукта");
        System.out.println("6. Показать продукты по складу");
        System.out.println("0. Назад");
        System.out.print("Выберите опцию: ");

        String choice = consoleApp.getScanner().nextLine();

        switch (choice) {
            case "1" -> { return new ShowAllProductsCommand().execute(consoleApp); }
            case "2" -> { return new AddProductCommand().execute(consoleApp); }
            case "3" -> { return new SearchProductsCommand().execute(consoleApp); }
            case "4" -> { return new ShowProductsRunningLowCommand().execute(consoleApp); }
            case "5" -> { return new UpdateProductQuantityCommand().execute(consoleApp); }
            case "6" -> { return new ShowProductsByWarehouseCommand().execute(consoleApp); }
            case "0" -> { return new MainMenu(); }
            default -> System.out.println("Неверный выбор!");
        }
        return this;
    }
}