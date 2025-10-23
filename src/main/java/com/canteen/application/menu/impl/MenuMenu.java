package src.main.java.com.canteen.application.menu.impl;


import src.main.java.com.canteen.application.command.menu.*;
import src.main.java.com.canteen.application.console.ConsoleApplication;
import src.main.java.com.canteen.application.menu.Menu;

public class MenuMenu implements Menu {
    @Override
    public Menu show(ConsoleApplication consoleApp) {
        System.out.println("\n--- УПРАВЛЕНИЕ МЕНЮ ---");
        System.out.println("1. Показать меню на сегодня");
        System.out.println("2. Показать меню на дату");
        System.out.println("3. Показать все блюда");
        System.out.println("4. Добавить блюдо");
        System.out.println("5. Добавить блюдо в меню");
        System.out.println("6. Найти блюдо по названию");
        System.out.println("0. Назад");
        System.out.print("Выберите опцию: ");

        String choice = consoleApp.getScanner().nextLine();

        switch (choice) {
            case "1" -> { return new ShowTodayMenuCommand().execute(consoleApp); }
            case "2" -> { return new ShowMenuByDateCommand().execute(consoleApp); }
            case "3" -> { return new ShowAllDishesCommand().execute(consoleApp); }
            case "4" -> { return new AddDishCommand().execute(consoleApp); }
            case "5" -> { return new AddDishToMenuCommand().execute(consoleApp); }
            case "6" -> { return new SearchDishesCommand().execute(consoleApp); }
            case "0" -> { return new MainMenu(); }
            default -> System.out.println("Неверный выбор!");
        }
        return this;
    }
}