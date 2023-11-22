import java.time.LocalDate;
import java.util.ArrayList;

public class Database {

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

    public String showInfo(Member member) {
        String output = "";
        output =member.getName()
                + "," + member.getAge()
                + "," + member.getBirthday()
                + "," + member.getLastPaymentDate()
                + "," + member.getNextPaymentDate()
                + "," + member.isActiveMembership()
                + "," + member.getMail();
        return output;
    }

    public void addMember(String name, int age, String mail, String activeMembership,
                          LocalDate birthday, LocalDate lastPayment) {
        Member member = new Member(name, age, mail, activeMembership, birthday, lastPayment);
        memberList.add(member);
    }

}
