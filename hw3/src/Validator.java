import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Stack;

public interface Validator {

    static Person checkUserInput(String[] userInputArray) {
        int sexLen = 1;
        int dateLen = 10;
        int phoneLen = 11;
        Person person = new Person("", "", "", null, 0, "");
        Stack<String> fullName = new Stack<>();
        for (int i = 0; i < userInputArray.length; i++) {
            if (userInputArray[i].length() == sexLen && checkSex(userInputArray[i])) {
                person.setSex(userInputArray[i]);
            } else {
                if (userInputArray[i].length() == dateLen && (userInputArray[i].contains(".") ||
                        userInputArray[i].contains("-") ||
                        userInputArray[i].contains("/"))){
                    LocalDate date = checkDate(userInputArray[i]);
                    person.setBirthday(date);
                } else {
                    if (userInputArray[i].length() == phoneLen && userInputArray[i].contains("8")) {
                        person.setPhoneNumber(checkPhoneNumber(userInputArray[i]));
                    } else fullName.push(userInputArray[i]);
                }
            }
        }
        person.setPatronymic(fullName.pop());
        person.setFirstName(fullName.pop());
        person.setLastName(fullName.pop());
        return person;
    }

    static LocalDate checkDate(String date) {
        DateTimeFormatter dateTimeFormatter = null;
        DateTimeFormatter outDateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        if (date.contains(".")) dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        if (date.contains("-")) dateTimeFormatter = outDateTimeFormatter;
        if (date.contains("/")) dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);
            return localDate;
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Неудачная попытка форматирвоания даты рождения");
        }
    }

    static boolean checkSex(String gender) {
        return (gender.equalsIgnoreCase("f") || gender.equalsIgnoreCase("m"));
    }

    static long checkPhoneNumber(String phoneNumber) {
        if (phoneNumber.isEmpty()) throw new NullPointerException("Телефонный номер не введён");
        long phone = -1;
        try {
            phone = Long.parseLong(phoneNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при вводе номера телефона");
        }
        return phone;
    }
}

