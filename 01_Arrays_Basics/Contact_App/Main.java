package Contact_App;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Contacts contactApp = new Contacts();
        Scanner sc = new Scanner(System.in);

        System.out.println("**** Welcome to Contact App ****");

        char choice = 'y';

        while (choice == 'y' || choice == 'Y') {
            System.out.println("1. Add contact");
            System.out.println("2. Update contact");
            System.out.println("3. Search contact");
            System.out.println("4. Display contacts");
            System.out.println("Enter your choice:");

            int input = sc.nextInt();
            sc.nextLine();

            switch (input) {
                case 1:
                    contactApp.addContact();
                    break;
                case 2:
                    contactApp.updateContact();
                    break;
                case 3:
                    contactApp.searchContact();
                    break;
                case 4:
                    contactApp.displayContacts();
                    break;
                default:
                    System.out.println("Invalid Choice!!! \t Try again...");
            }
            System.out.print("Do you want to continue (y/n)? ");
            choice = sc.next().charAt(0);
            sc.nextLine(); 
        }
    }
}
