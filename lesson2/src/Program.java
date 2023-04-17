/*
Запишите в файл следующие строки:
Анна=4
Елена=5
Марина=6
Владимир=?
Константин=?
Иван=4
Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив
(либо HashMap, если студенты с ним знакомы). В отдельном методе нужно будет пройти
по структуре данных, если сохранено значение ?, заменить его на соответствующее число.
Если на каком-то месте встречается символ, отличный от числа или ?, бросить подходящее
исключение.Записать в тот же файл данные с замененными символами ?.
 */
public class Program2 {

    public static void main(String[] args) throws IOException {
        readWrite("D:/МАМИНА ПАПКА/GEEK BRAINS/JAVA/EXCEPTIONS/lesson2/file.txt");
    }

    //метод чтения и записи
    public static void readWrite(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        HashMap<String, String> sb = new HashMap<>();
        try {

            String string = br.readLine();

            while (string != null) {
                String[] line = string.split("=");
                sb.put(line[0], line[1]);
                string = br.readLine();
            }

            sb.entrySet().forEach(entry -> {
                System.out.println(entry.getKey() + " " + entry.getValue());
            });
            System.out.println();
            replaceSymbol(sb); //вызываем метод замены

        } finally {
            br.close();
        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            for(Map.Entry<String, String> map : sb.entrySet()) {
                bw.write(map.getKey() + "=" + map.getValue() + "\n");
            }
            bw.close();
        } catch (Exception e) {
            System.out.println("Unable to write to file: " + path);
        }
    }

    // Метод замены
    public static void replaceSymbol(HashMap<String, String> hashMap) {
        hashMap.entrySet().forEach(entry -> {
            try {
                Integer.parseInt(entry.getValue());
            } catch (NumberFormatException e) {
                if(entry.getValue().equals("?")) {
                    hashMap.put(entry.getKey(), Integer.toString(entry.getKey().length()));
                } else {
                    System.out.println("Number format exception");
                }
            }
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
    }

}