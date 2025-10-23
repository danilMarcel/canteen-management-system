package src.main.java.com.canteen.application.command.report;


import src.main.java.com.canteen.application.command.Command;
import src.main.java.com.canteen.application.console.ConsoleApplication;
import src.main.java.com.canteen.application.menu.Menu;
import src.main.java.com.canteen.application.menu.impl.ReportMenu;

public class GenerateLowStockReportCommand implements Command {
    @Override
    public Menu execute(ConsoleApplication consoleApp) {
        consoleApp.getReportService().generateLowStockReport();
        return new ReportMenu();
    }
}