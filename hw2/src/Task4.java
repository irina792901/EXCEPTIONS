import java.util.Scanner;

/*
Разработайте программу, которая выбросит Exception, когда пользователь
вводит пустую строку. Пользователю должно показаться сообщение,
что пустые строки вводить нельзя.
 */
public class Task4 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Введите текст: ");
            String input = sc.nextLine();
            if (input.isEmpty()) {
                throw new RuntimeException("Нельзя оставить поле ввода пустым");
            } else {
                System.out.println("Вы ввели: " + input);
            }
        }
    }
}