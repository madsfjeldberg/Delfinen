import java.time.LocalDate;

public class TournamentMember extends Member {

    private Result result;
    private String team;

    public TournamentMember(String name, int age, LocalDate birthday, LocalDate lastPaymentDate,
                            LocalDate nextPaymentDate, LocalDate membershipStart, boolean activeMembership,
                            String gender, int memberID, String mail, double result, String team) {
        super(name, age, mail, activeMembership,birthday, lastPaymentDate, nextPaymentDate);
        this.result = result;
        this.team = team;
    }
    public Result getResult() {
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