import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Stack;

public interface TerminalReader {

    static String[] getUserInput() {
        String[] userInputArray = null;
        boolean isInput = false;
        while (!isInput) {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
                userInputArray = bufferedReader.readLine().split(" ");
                if (userInputArray.equals(null) || userInputArray.length != 6) {
                    throw new RuntimeException("Неправильный формат ввода данных");
                }
            } catch (IOException ex) {
                new Menu().inputProblems();
                ex.printStackTrace();
            }
            isInput = true;
        }
        return userInputArray;
    }
}

