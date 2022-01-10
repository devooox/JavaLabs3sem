import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Student{
    private int cardNumber;
    private String surname;
    private Map<String, Integer> grades;
    private boolean isSmart;

    Student() {
        cardNumber = -1;
        surname = "";
        grades = new HashMap<>();
    }

    Student(int cardNumber, String surname, Map<String, Integer> grades) {
        this.cardNumber = cardNumber;
        this.surname = surname;
        this.grades = grades;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public String getSurname() {
        return surname;
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setGrades(Map<String, Integer> grades) {
        this.grades = grades;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSmart(boolean smart) {
        isSmart = smart;
    }

    public boolean isSmart() {
        return isSmart;
    }

    @Override
    public String toString() {
        String tmp = cardNumber + " " + surname;
        Set<String> subjects = grades.keySet();
        for (String j : subjects) {
            tmp += " " + j + " " + grades.get(j);
        }
        return tmp;
    }
}
