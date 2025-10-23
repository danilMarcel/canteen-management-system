package src.main.java.com.canteen.application.command;


import src.main.java.com.canteen.application.console.ConsoleApplication;
import src.main.java.com.canteen.application.menu.Menu;


public interface Command {
    Menu execute(ConsoleApplication consoleApp);
}
