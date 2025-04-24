package Contact_App;

import java.util.Scanner;

public class Contacts {
     String name;
     String number;
     static int counter = 0;
     int rows = 10;
     int cols = 2;
     String[][] contactList = new String[rows][cols];
     Scanner sc = new Scanner(System.in);

    public void addContact() {
        if (counter >= rows) {
            System.out.println("Contact list is full!");
            return;
        }

        System.out.println("Enter name of contact:");
        name = sc.nextLine();
        contactList[counter][0] = name;

        System.out.println("Enter contact number:");
        number = sc.nextLine();
        contactList[counter][1] = number;

        counter++;
        System.out.println("Contact added successfully.");
    }

    public void searchContact() {
        System.out.println("Enter name of contact:");
        String searchName = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < counter; i++) {
            if (contactList[i][0].contains(searchName)) {
                System.out.println("Contact found at index " + i + ": " + contactList[i][0] + " - " + contactList[i][1]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No contact found with the name " + searchName);
        }
    }

    public void updateContact() {
        System.out.println("Enter name of contact to update:");
        String searchName = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < counter; i++) {
            if (contactList[i][0].contains(searchName)) {
                System.out.println("Contact found at index " + i);

                System.out.print("Enter new name: ");
                name = sc.nextLine();
                contactList[i][0] = name;

                System.out.print("Enter updated number: ");
                number = sc.nextLine();
                contactList[i][1] = number;

                System.out.println("Contact updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No contact found with the name " + searchName);
        }
    }

    public void displayContacts() {
        System.out.println("Contacts saved in your contact list are:");
        for (int i = 0; i < counter; i++) {
            System.out.println(contactList[i][0] + "\t" + contactList[i][1]);
        }
    }
}

