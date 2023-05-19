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
        }
    }
    private AuditService() {

    }

    public static void log(String msg) throws IOException {
        file.append(formatter.format(LocalDateTime.now()));
        file.append(',');
        file.append(msg);
        file.append("\n");
        file.flush();
    }
}