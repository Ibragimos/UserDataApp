import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class viewContacts {
    public static void viewContact() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the last name of the contact to view:");
            String contactSurname = scanner.nextLine();

            File inputFile = new File("contacts.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));

            String line;
            boolean contactFound = false;

            while ((line = reader.readLine()) != null) {
                String[] contactData = line.split(" ");
                String surname = contactData[0];

                if (surname.equalsIgnoreCase(contactSurname)) {
                    contactFound = true;
                    System.out.println("Contact Details: " + line);
                    break;
                }
            }

            reader.close();

            if (!contactFound) {
                System.out.println("Contact with the last name " + contactSurname + " not found.");
            }
        } catch (IOException e) {
            System.out.println("Error viewing the contact");
            e.printStackTrace();
        }
    }
}