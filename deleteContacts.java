import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class deleteContacts {
    public static void deleteContact() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the last name of the contact to delete:");
            String contactSurname = scanner.nextLine();

            File inputFile = new File("contacts.txt");
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            boolean contactFound = false;

            while ((line = reader.readLine()) != null) {
                String[] contactData = line.split(" ");
                String surname = contactData[0];

                if (surname.equalsIgnoreCase(contactSurname)) {
                    contactFound = true;
                    System.out.println("Contact with the last name " + contactSurname + " deleted.");
                } else {
                    writer.write(line + "\n");
                }
            }

            reader.close();
            writer.close();

            if (!contactFound) {
                System.out.println("Contact with the last name " + contactSurname + " not found.");
            } else {
                inputFile.delete();
                tempFile.renameTo(inputFile);
            }
        } catch (IOException e) {
            System.out.println("Error deleting a contact");
            e.printStackTrace();
        }
    }
}