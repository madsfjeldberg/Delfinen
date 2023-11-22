import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    private Controller ctrl;
    private final Scanner input;
    int SubMenuInput;
    DateTimeFormatter formatter;

    public UserInterface() {
        ctrl = new Controller();
        input = new Scanner(System.in);
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public void UserInterface() {
        int mainMenuInput;


        do {
            displayMainMenu();
            mainMenuInput = getValidInput();

            switch (mainMenuInput) {
                case 1 -> handleChairmanMenu();
                case 2 -> handleTreasurerMenu();
                case 3 -> handleTrainerMenu();
                case 9 -> System.out.println("Afslutter programmet. Farvel!");
                }

        } while (mainMenuInput != 9);
    }

    private void handleTrainerMenu() {

        do {
            System.out.println("""
                    Træner Menu
                    1. Se Svømmetider
                    9. Tilbage til hovedmenu""");

            SubMenuInput = getValidInput();

            switch (SubMenuInput) {
                case 1 -> System.out.println("Hej");
                case 9 -> {
                    ctrl.saveList();
                    System.out.println("Tilbage til hovedmenuen."); }
                default -> System.out.println("Fejl, tast venligst et gyldigt input fra menuen.");
            }
        } while (SubMenuInput != 9);
    }

    private void handleTreasurerMenu() {

        do {
            System.out.println("""
                    Kasserer Menu
                    1. Se Kontingentsliste
                    9. Tilbage til hovedmenu""");

            SubMenuInput = getValidInput();

            switch (SubMenuInput) {
                case 1 -> System.out.println("Hej");
                case 9 -> {
                    ctrl.saveList();
                    System.out.println("Tilbage til hovedmenuen."); }
                default -> System.out.println("Fejl, tast venligst et gyldigt input fra menuen.");
            }
        } while (SubMenuInput != 9);
    }

    private void handleChairmanMenu() {

        do {
            System.out.println("""
                    Formand Menu
                    1. Opret Medlemskab
                    2. Liste over medlemmer
                    9. Tilbage til hovedmenu""");

            SubMenuInput = getValidInput();

            switch (SubMenuInput) {
                case 1 -> createMembership();
                //case 2 -> Liste over medlemmer
                case 9 -> {
                    ctrl.saveList();
                    System.out.println("Tilbage til hovedmenuen.");
                }
                default -> System.out.println("Fejl, tast venligst et gyldigt input fra menuen.");
            }
        } while (SubMenuInput != 9);
    }

    private void createMembership() {
        System.out.println("Indtast navn:");
        String name = input.nextLine();

        System.out.println("Indtast alder:");
        int age = input.nextInt();
        input.nextLine();
        System.out.println("Indtast mail:");
        String mail = input.nextLine();

        System.out.println("Aktivt Medlemsskab: (true/false)");
        String activeMembership = input.nextLine();

        System.out.println("Indtast fødselsdagsdato:");
        LocalDate birthday = LocalDate.parse(input.nextLine(), formatter);

        System.out.println("TEST (Bliver sat automatisk efter oprettelse(Ændres måske))");
        LocalDate lastPayment = LocalDate.now();

        ctrl.addMember(name, age, mail, activeMembership, birthday, lastPayment);
    }

    private int getValidInput() {
        int inputNumber = 0;
        try {
            inputNumber = input.nextInt();
            input.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Fejl, tast venligst et gyldigt input fra menuen.");
            input.nextLine();
        }
        return inputNumber;
    }

    private void displayMainMenu() {
        System.out.println("Velkommen til Delfin Svømmeklub\nTast venligst dit ønskede input");
        System.out.println("""
                1. Formand Menu
                2. Kasserer Menu
                3. Træner Menu
                9. Afslut""");
    }


    private static String formatDate(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return localDate.format(formatter);
    }

}
