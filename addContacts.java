import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class addContacts {
    public static void addContact() {
        FileWriter fileWriter = null;
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter data (Surname, Name, Patronymic, Date_Of_Birth, Phone_Number Gender):");
            String userData = scanner.nextLine();

            String[] userDataArray = userData.split(" ");

            if (userDataArray.length != 6) {
                throw new RuntimeException("Incorrect number of data elements");
            }

            String surname = userDataArray[0];
            String name = userDataArray[1];
            String patronymic = userDataArray[2];
            String dateOfBirth = userDataArray[3];
            long phoneNumber = Long.parseLong(userDataArray[4]);
            char gender = userDataArray[5].charAt(0);

            String fileName = "contacts.txt";
            String fileContent = surname + " " + name + " " + patronymic + " " + dateOfBirth + " " + phoneNumber + " "
                    + gender;

            fileWriter = new FileWriter(fileName, true);
            fileWriter.write(fileContent + "\n");

            System.out.println("Contact added successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Incorrect format for phone number");
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error writing data to file");
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing file");
                e.printStackTrace();
            }
        }
    }
}