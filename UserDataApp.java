import java.util.Scanner;

public class UserDataApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select an action:");
            System.out.println("1. Add a new contact");
            System.out.println("2. Change a contact");
            System.out.println("3. Delete a contact");
            System.out.println("4. View a contact");
            System.out.println("5. Exit");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addContacts.addContact();
                    break;
                case 2:
                    updateContacts.updateContact();
                    break;
                case 3:
                    deleteContacts.deleteContact();
                    break;
                case 4:
                    viewContacts.viewContact();
                    break;
                case 5:
                    System.out.println("The program is completed.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect choice. Try again.");
                    break;
            }
        }
    }
}