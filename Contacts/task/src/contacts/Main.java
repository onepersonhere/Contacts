package contacts;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true){
            new Contacts();
            System.out.println("Enter action (add, remove, edit, count, list, exit): ");
            Scanner scanner = new Scanner(System.in);
            String action = scanner.nextLine();

            switch (action) {
                case "add":
                    Contacts.addContacts();
                    break;
                case "remove":
                    Contacts.removeContacts();
                    break;
                case "edit":
                    Contacts.editContacts();
                    break;
                case "count":
                    Contacts.countContacts();
                    break;
                case "list":
                    Contacts.listContacts();
                    break;
                case "exit":
                    System.exit(0);
            }
        }
    }
}
