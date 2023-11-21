import java.time.LocalDate;

public class Member {

    private String name;
    private int age;


    private LocalDate birthday;
    private LocalDate lastPaymentDate;
    private LocalDate nextPaymentDate;
    private LocalDate membershipStart;
    private boolean activeMembership;
    private String gender;
    private int memberID;
    private String mail;

    public Member(String name, int age, LocalDate birthday, LocalDate lastPaymentDate,
                  LocalDate nextPaymentDate, LocalDate membershipStart, boolean activeMembership,
                  String gender, int memberID, String mail) {

        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.lastPaymentDate = lastPaymentDate;
        this.nextPaymentDate = nextPaymentDate;
        this.membershipStart = membershipStart;
        this.activeMembership = activeMembership;
        this.gender = gender;
        this.memberID = memberID;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public LocalDate getLastPaymentDate() {
        return lastPaymentDate;
    }

    public LocalDate getNextPaymentDate() {
        return nextPaymentDate;
    }

    public LocalDate getMembershipStart() {
        return membershipStart;
    }

    public boolean isActiveMembership() {
        return activeMembership;
    }

    public int getMemberID() {
        return memberID;
    }

    public String getGender() {
        return gender;
    }

    public String getMail() {
        return mail;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setLastPaymentDate(LocalDate lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }

    public void setNextPaymentDate(LocalDate nextPaymentDate) {
        this.nextPaymentDate = nextPaymentDate;
    }

    public void setMembershipStart(LocalDate membershipStart) {
        this.membershipStart = membershipStart;
    }

    public void setActiveMembership(boolean activeMembership) {
        this.activeMembership = activeMembership;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


}
