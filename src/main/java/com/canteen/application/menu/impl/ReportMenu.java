package src.main.java.com.canteen.application.menu.impl;


import src.main.java.com.canteen.application.command.report.*;
import src.main.java.com.canteen.application.console.ConsoleApplication;
import src.main.java.com.canteen.application.menu.Menu;

public class ReportMenu implements Menu {
    @Override
    public Menu show(ConsoleApplication consoleApp) {
        System.out.println("\n--- ОТЧЕТЫ ---");
        System.out.println("1. Отчет по заканчивающимся продуктам");
        System.out.println("2. Полная инвентаризация");
        System.out.println("3. Отчет по меню");
        System.out.println("4. Все отчеты");
        System.out.println("0. Назад");
        System.out.print("Выберите опцию: ");

        String choice = consoleApp.getScanner().nextLine();

        switch (choice) {
            case "1" -> { return new GenerateLowStockReportCommand().execute(consoleApp); }
            case "2" -> { return new GenerateInventoryReportCommand().execute(consoleApp); }
            case "3" -> { return new GenerateMenuReportCommand().execute(consoleApp); }
            case "4" -> {
                new GenerateLowStockReportCommand().execute(consoleApp);
                new GenerateInventoryReportCommand().execute(consoleApp);
                return new GenerateMenuReportCommand().execute(consoleApp);
            }
            case "0" -> { return new MainMenu(); }
            default -> System.out.println("Неверный выбор!");
        }
        return this;
    }
}