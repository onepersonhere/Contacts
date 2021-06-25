package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contacts {
    static Scanner scanner = new Scanner(System.in);
    private static List<Record> recordList = new ArrayList<>();
    Contacts(){
    }
    //add/remove/edit/get number of records
    //if number is empty -> [no number]
    public static void addContacts(){

        System.out.println("Enter the name of the person");
        String name = scanner.nextLine();
        System.out.println("Enter the surname of the person");
        String surname = scanner.nextLine();
        System.out.println("Enter the number");
        String number = scanner.nextLine();

        Record record = new Record(name, surname, number);
        recordList.add(record);
        System.out.println("The record added.");
    }
    public static void editContacts(){
        if(recordList.isEmpty()){
            System.out.println("No records to edit!");
        }else {
            listContacts();
            System.out.println("Select a record: ");
            int idx = scanner.nextInt() - 1;
            Record record = recordList.get(idx);
            System.out.println("Select a field (name, surname, number): ");
            scanner.nextLine();
            String field = scanner.nextLine();
            switch (field) {
                case "name":
                    System.out.println("Enter name: ");
                    record.setName(scanner.nextLine());
                    break;
                case "surname":
                    System.out.println("Enter surname: ");
                    record.setSurname(scanner.nextLine());
                    break;
                case "number":
                    System.out.println("Enter number: ");
                    record.setNumber(scanner.nextLine());
                    break;
            }
            System.out.println("The record updated!");
            recordList.set(idx, record);
        }
    }
    public static void listContacts(){
        for(int i = 0; i < recordList.size(); i++){
            Record record = recordList.get(i);
            System.out.println((i+1) + ". " + record.getName()
                    + " " + record.getSurname()
                    + ", " + record.getNumber());
        }
    }
    public static void removeContacts(){
        if(recordList.isEmpty()){
            System.out.println("No records to remove!");
        }else{
            listContacts();
            System.out.println("Select a record: ");
            recordList.remove(scanner.nextInt() - 1);
            System.out.println("The record removed!");
        }
    }

    public static void countContacts(){
        System.out.println("The Phone Book has " + recordList.size() + " records.");
    }
}
