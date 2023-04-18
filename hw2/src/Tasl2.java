/*Если необходимо, исправьте данный код
try {
        int d = 0;
        double catchedRes1 = intArray[8] / d;
        System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
        System.out.println("Catching exception: " + e);
        }
*/
public class Tasl2 {
    public static void main(String[] args) {
        int[] intArray = new int[9];
        //1. Необходимо передать в код массив размером обязательно больше 8, иначе
        // будет ошибка ArrayIndexOunOfBoundException
        // 2. Тип элементов массива должен быть int or double. Иначе при попытке
        // использования массива String or Char код не будет скомпилирован
        //3. Значение делителя равное 0 вызовет ArithmeticException
        //
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e);
        }
    }
}