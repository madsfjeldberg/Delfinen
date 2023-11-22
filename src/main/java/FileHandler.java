import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    private final File file;

    public FileHandler(String f) {
        file = new File(f);
    }

    public void saveList(ArrayList<Member> list) {

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (PrintStream output = new PrintStream(file)) {
            for (Member member : list) {
                String out;
                out = member.getName() + "," + member.getAge() + "," + member.getBirthday() + "," +
                        member.getLastPaymentDate() + "," + member.getNextPaymentDate() + "," + member.getMembershipStart()
                        + "," + member.isActiveMembership() + "," + member.getGender() + "," + member.getMemberID()
                        + "," + member.getMail();
                output.println(out);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Member> loadList() {

        ArrayList<Member> memberList = new ArrayList<>();
        String name;
        int age;
        LocalDate birthday;
        LocalDate lastPayment;
        LocalDate nextPayment;
        LocalDate membershipStart;
        boolean activeMembership;
        String gender;
        int memberID;
        String mail;

        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String[] memberValues = reader.nextLine().split(",");
                name = trimString(memberValues[0]);
                age = parseTrim(memberValues[1]);
                birthday = LocalDate.parse(memberValues[2]);
                lastPayment = LocalDate.parse(memberValues[3]);
                nextPayment = LocalDate.parse(memberValues[4]);
                membershipStart = LocalDate.parse(memberValues[5]);
                activeMembership = Boolean.parseBoolean(memberValues[6]);
                gender = trimString(memberValues[7]);
                memberID = parseTrim(memberValues[8]);
                mail = trimString(memberValues[9]);

                Member member = new Member(name,age,birthday,lastPayment,nextPayment,membershipStart,activeMembership,gender,memberID,mail);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Fil ikke fundet");
        }

        return memberList;
    }

    private String trimString(String input) {
        return input.trim();
    }

    private int parseTrim(String input) {
        return Integer.parseInt(trimString(input));
    }


}