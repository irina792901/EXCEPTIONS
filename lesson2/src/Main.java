public class Main {
    public static void main(String[] args) {
        String[][]array = {{"1", "null", "5"}, {"8", "0"}, {"if", "45", "32165498798787"}};
        sum2d(array);
    }

    public static int sum2d(String[][] arr) {
        int sum = 0;
        try {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    int val = Integer.parseInt(arr[i][j]);
                    //if (arr[i][j]==null) int val=0;
                    // sum += val; // в этом варианте не учитывается, если весь масси вбудет null
                    sum = Math.addExact(sum, val);// браосает ArithmeticExeption если значения нельзя просуммирвоать
                }
            }
        } catch (NullPointerException ex) {
            System.out.println("Массив не должен быть null");
        } catch (NumberFormatException ex) {
            System.out.println("Не получилось преобразовать строку в целое число");
        } catch (ArithmeticException ex) {
            System.out.println("Слишком большое начение для int");
        }
        return sum;
    }
}