import java.time.LocalDate;
import java.util.ArrayList;

public class Database {

    // skal måske bruge flere filehandlers?
    // til at gemme svømmeresultat / konkurrencesvømmere
    FileHandler fh;
    private ArrayList<Member> memberList;

    public Database() {
        fh = new FileHandler("members.csv");
        memberList = new ArrayList<>();
        memberList = fh.loadList();
    }

    public void saveList() {
        fh.saveList(memberList);
    }

    // viser alle informationer om et givet medlem
    // skal måske skrives om til kun at vise relevant info
    public String showInfo(Member member) {
        String output = "";
        output = "\nNavn: " + member.getName()
                 + "\nAlder: " + member.getAge()
                 + "\nMail: " + member.getMail()
                 + "\n";
        return output;
    }

    public String showList() {
        String out = "";
        for (Member member : memberList) {
            out += showInfo(member);
        }
        return out;
    }

    public void addMember(String name, int age, String mail, boolean activeMembership,
                          LocalDate birthday, LocalDate lastPayment) {
        Member member = new Member(name, age, mail, activeMembership, birthday, lastPayment);
        memberList.add(member);
    }

}
