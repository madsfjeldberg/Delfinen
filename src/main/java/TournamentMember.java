import java.time.LocalDate;
import java.util.Scanner;

public class TournamentMember extends Member {

    private double result=0;
    private String team;

    public TournamentMember(String name, int age, LocalDate birthday, LocalDate lastPaymentDate,
                            LocalDate nextPaymentDate, LocalDate membershipStart, boolean activeMembership,
                            String gender, int memberID, String mail, double result, String team) {
        super(name, age, birthday, lastPaymentDate, nextPaymentDate, membershipStart, activeMembership, gender, memberID, mail);
        this.result = result;
        this.team = team;
    }
    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}