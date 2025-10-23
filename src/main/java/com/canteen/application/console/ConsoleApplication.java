package src.main.java.com.canteen.application.console;

import src.main.java.com.canteen.application.menu.Menu;
import src.main.java.com.canteen.application.menu.impl.MainMenu;
import src.main.java.com.canteen.domain.inmemory.*;
import src.main.java.com.canteen.domain.services.*;
import java.util.Scanner;



import java.util.Scanner;

public class ConsoleApplication {
    private final WarehouseService warehouseService;
    private final ProductService productService;
    private final MenuService menuService;
    private final ReportService reportService;
    private final Scanner scanner;
    private Menu currentMenu;

    public ConsoleApplication() {
        this.warehouseService = new WarehouseService(new InMemoryWarehouseRepository());
        this.productService = new ProductService(new InMemoryProductRepository());
        this.menuService = new MenuService(new InMemoryMenuRepository(), new InMemoryDishRepository());
        this.reportService = new ReportService(new InMemoryProductRepository());
        this.scanner = new Scanner(System.in);
        this.currentMenu = new MainMenu();
    }

    public void start() {
        System.out.println("=== СИСТЕМА УПРАВЛЕНИЯ СТОЛОВОЙ ===");

        while (true) {
            currentMenu = currentMenu.show(this);
        }
    }

    public WarehouseService getWarehouseService() { return warehouseService; }
    public ProductService getProductService() { return productService; }
    public MenuService getMenuService() { return menuService; }
    public ReportService getReportService() { return reportService; }
    public Scanner getScanner() { return scanner; }

    public static void main(String[] args) {
        new ConsoleApplication().start();
    }
}

