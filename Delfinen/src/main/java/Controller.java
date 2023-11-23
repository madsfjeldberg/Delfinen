import java.time.LocalDate;

public class Controller {

    private final Database db;

    public Controller() {
        db = new Database();
    }

    public void saveList() {
        db.saveList();
    }

    public String showList() {
        return db.showList();
    }

    public String showInfo(Member member) {
        return db.showInfo(member);
    }

    public void addMember(String name, int age, String mail, boolean activeMembership, LocalDate birthday, LocalDate lastPayment) {
        db.addMember(name, age, mail, activeMembership, birthday, lastPayment);
    }
}
