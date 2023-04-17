import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
    }

    public static HashMap<String, Integer> readfile(String path) {
        HashMap<String, Integer> list = new HashMap<>();
        try (Scanner sc = new Scanner(new File(path))) {
            Integer num = null;
            while (sc.hasNext())){
                String[] lines = sc.next().split("*"); //добавить исключение если вводится не число
                if (!lines[1].equals("?")) num = Integer.parseInt(lines[1];
                else {
                    if (num == null) num = 1;//на самом деле цифры загадывают длину ключа
                    else num++;
                }
                list.put(lines[0], num));
            }
        } catch (IOException e) {
            System.out.println("Исключение ввода-вывода");
        } catch (NumberFormatException e) {
            System.out.println("Не удалось считать значение");
        }
        return list;
    }

    public static void filewriter(String path, HashMap<String, Integer> lines) {
        try {
            FileWriter filewriter = new FileWriter(path) {
            for(
                Map.Entry<String, Integer> ent :lines.entrySet())

                {
                    filewriter.write(ent.getKey() + "*" + ent.getValue() + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }
    }
}




