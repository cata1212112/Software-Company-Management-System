package Service;

import javax.imageio.IIOException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditService {
    private static FileWriter file;
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    static  {
        try {
            file = new FileWriter("audit.csv");
        } catch (IOException e) {
            System.out.println(e.toString());
            System.exit(0);
        }
    }
    private AuditService() {

    }

    public static void log(String msg) throws IOException {
        file.append(msg);
        file.append(' ');
        file.append(formatter.format(LocalDateTime.now()));
        file.append("\n");
        file.flush();
    }

    public static void close_file() {
        try {
            file.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
