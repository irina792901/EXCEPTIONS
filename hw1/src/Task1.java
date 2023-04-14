/**
 * Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
 */
public class Task1 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        ArrayIndexOutOfBoundExctption(array, 6);
        System.out.println(NumberFormanException("Name"));
        //UnsupportedOperationException(array);
    }

    public static void ArrayIndexOutOfBoundExctption(int[]array, int indexOutOfBound){
        System.out.println(array[indexOutOfBound]);
    }

    public static int NumberFormanException(String number){
        return Integer.parseInt(number);
    }
}