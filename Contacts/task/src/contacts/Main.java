package contacts;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = str.split(" ");

        if(arr[0].equals("open")) {
            importContacts(arr[1]);
            while (true) {

                System.out.println("[menu] Enter action (add, list, search, count, exit): ");

                String action = scanner.nextLine();

                switch (action) {
                    case "add":
                        Contacts.addContacts();
                        break;
                    case "list":
                        Contacts.listContacts();
                        break;
                    case "search":
                        Contacts.searchContacts();
                        break;
                    case "count":
                        Contacts.countContacts();
                        break;
                    case "exit":
                        saveContacts(arr[1]);
                        System.exit(0);
                }
                System.out.println();
            }
        }
    }
    private static void importContacts(String filename) {
        try {
            List<Record> list = (List<Record>) SerializationUtils.deserialize(filename);
            new Contacts();
            Contacts.setRecordList(list);
        }catch (IOException | ClassNotFoundException | ClassCastException e) {
            e.printStackTrace();
            new Contacts();
        }
    }

    private static void saveContacts(String filename){
        try {
            SerializationUtils.serialize(Contacts.getRecordList(), filename);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
