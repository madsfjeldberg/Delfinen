import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
                out = member.getName()
                        + "," + member.getAge()
                        + "," + member.getMail()
                        + "," + formatDate(member.getBirthday())
                        + "," + member.isActiveMembership()
                        + "," + formatDate(member.getLastPaymentDate())
                        + "," + formatDate(member.getNextPaymentDate());

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
        String mail;
        String activeMembership;
        LocalDate birthday;
        LocalDate lastPayment;

        try (Scanner reader = new Scanner(file)) {

            while (reader.hasNextLine()) {
                String[] memberValues = reader.nextLine().split(",");
                name = trimString(memberValues[0]);
                age = parseTrim(memberValues[1]);
                mail = trimString(memberValues[2]);
                activeMembership = trimString(memberValues[3]);
                birthday = LocalDate.parse(memberValues[4]);
                lastPayment = LocalDate.parse(memberValues[5]);

                Member member = new Member(name, age, mail, activeMembership, birthday, lastPayment);
                memberList.add(member);
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

    private static String formatDate(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return localDate.format(formatter);
    }
}