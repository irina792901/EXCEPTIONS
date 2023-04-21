import java.util.Iterator;

public class PersonIterator implements Iterator {
    private Person person;
    static int index;

    public PersonIterator(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean hasNext() {
        return index++ < 6;
    }


    @Override
    public Object next() {
        switch (index) {
            case 1:
                return String.format("Фамилия: %s\n", person.getLastName());
            case 2:
                return String.format("Имя: %s\n", person.getFirstName());
            case 3:
                return String.format("Отчество: %s\n", person.getPatronymic());
            case 4:
                return String.format("Дата рождения: %s\n", person.getBirthday());
            case 5:
                return String.format("Телефон: %s\n", person.getPhoneNumber());
            default:
                return String.format("Пол: %s\n", person.getSex());
        }
    }

    @Override
    public String toString() {
        PersonIterator personIter = new PersonIterator(person);
        StringBuilder personDiscription = new StringBuilder();
        while (personIter.hasNext()) {
            personDiscription.append(personIter.next());
            personDiscription.append(" ");
        }
        String res = personDiscription.toString();
        return res;
    }
}
