import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class updateContacts {
    public static void updateContact() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the last name of the contact to change:");
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
                    System.out.println("Current contact details: " + line);
                    System.out.println(
                            "Enter new contact information (First name, Middle name, birthdate, phone number, gender):");
                    String newData = scanner.nextLine();
                    writer.write(newData + "\n");
                    System.out.println("The contact has been successfully changed.");
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
            System.out.println("Error when changing the contact");
            e.printStackTrace();
        }
    }
}