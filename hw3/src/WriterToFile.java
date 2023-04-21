import javax.swing.border.StrokeBorder;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public interface WriterToFile {

    static void createFileTxt(Person client) throws IOException {
        String currPathName = System.getProperty("phoneBookForHW3EXCEPTIONS.dir");
        String filename = client.getLastName() + ".txt";
        File file = new File(currPathName, filename);
        if (file.createNewFile()) System.out.println("Файл создан");
        else {
            System.out.println("Файл уже существует");
        }
        FileWriter writer = new FileWriter(file, true);
        StringBuilder str = new StringBuilder();
        str.append(client.getLastName());
        str.append(" ");
        str.append(client.getFirstName());
        str.append(" ");
        str.append(client.getPatronymic());
        str.append(" ");
        str.append(client.getPhoneNumber());
        str.append(" ");
        str.append(client.getBirthday());
        str.append(" ");
        str.append(client.getSex());
        str.append('\n');
        writer.write(str.toString());
        writer.close();
    }
}
