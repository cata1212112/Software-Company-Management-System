package Service;

import Commands.*;
import Project.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class GlobalService {

    private GlobalService() {
        readCommandsFromInput();
    }

    public static void readCommandsFromInput() {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Enter a command (or 'q' to quit): ");
            String input = scanner.nextLine();

            if (input.equals("q")) {
                break;
            }

            Command command = CommandFactory.createCommand(input);
            if (command != null) {
                command.execute();
            } else {
                System.out.println("Invalid command: " + input);
            }
        }
    }

}
