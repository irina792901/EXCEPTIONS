public class Menu {
    public void start() {
        System.out.println("""
                Для записи в файл информации о телефонную книжку введите через пробел:
                                
                  Имя человека в формате ФИО: Иванов Иван Иванович
                  ату рождение в формате день.месяц.год: 31.12.2000
                  Номер телефона в формате 11-значного числа: 89067567878
                  Пол в формате латинской буквы 'f' (жен.) или 'm' (муж.)            
                
                """);
    }
    public void inputProblems(){
        System.out.println("Проблемы ввода данных");
    }
}