import java.util.InputMismatchException;
import java.util.Scanner;

/*
Реализуйте метод, который запрашивает у пользователя ввод дробного числа
(типа float), и возвращает введенное значение. Ввод текста вместо числа
не должно приводить к падению приложения, вместо этого, необходимо
повторно запросить у пользователя ввод данных.
 */
public class Task1 {
    public static void main(String[] args) {
        System.out.println(getFloatNumberFromUser());
    }

    private static float getFloatNumberFromUser() {
        float input;
        while (true) {
            System.out.println("Введите действительное число: ");
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextFloat();
                sc.close();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод!");
            }
        }
        return input;
    }
}

