import java.util.Arrays;
/**
 * * Реализуйте метод, принимающий в качестве аргументов два целочисленных
 * массива, и возвращающий новый массив, каждый элемент которого равен
 * частному элементов двух входящих массивов в той же ячейке.
 * Если длины массивов не равны, необходимо как-то оповестить пользователя.
 * Важно: При выполнении метода единственное исключение, которое пользователь может
 * увидеть - RuntimeException, т.е. ваше.
 */
public class Task4 {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(arrayOfDivide(array1, array2)));
    }

    public static double[] arrayOfDivide(int[] ar1, int[] ar2) {
        if (ar1 == null || ar2 == null) {
            throw new RuntimeException("Введен пустой массив");
        }
        if (ar1.length != ar2.length) {
            throw new RuntimeException("Длины массивов не равны");
        }
        if (!(ar1.getClass().getSimpleName() == "int[]") && (ar2.getClass().getSimpleName() == "int[]")) {
            throw new RuntimeException("Массив состоит не из целочисленны элементов");
        }
        if (ConsistZero(ar2)) {
            throw new RuntimeException("Во втором массиве присутствуют нулевые элементы");
        }

        double[] result = new double[ar1.length];
        for (int i = 0; i < ar1.length; i++) {
            result[i] = (double) ar1[i] / (double) ar2[i];
        }
        return result;
    }

    public static boolean ConsistZero(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) return true;
        }
        return false;
    }

}
