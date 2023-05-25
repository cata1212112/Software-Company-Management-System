import Service.DatabaseService;
import Service.GlobalService;

import java.io.IOException;
import java.text.ParseException;

/**
 * The main class for the project
 * @author Cata
 * @version 1.2
 */

public class Main {
    public static void main(String[] args) throws ParseException, IOException {
        DatabaseService.loadDatabase();
        GlobalService.readCommandsFromInput();
    }
}