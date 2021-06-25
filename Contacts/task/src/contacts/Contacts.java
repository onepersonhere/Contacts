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
        System.out.println("Enter the type (person, organisation): ");
        String type = scanner.nextLine();
        if(type.equals("person")){
            addPerson();
        }else if(type.equals("organization")){
            addOrg();
        }
    }
    public static void addPerson(){

        System.out.println("Enter the name of the person: ");
        String name = scanner.nextLine();
        System.out.println("Enter the surname of the person: ");
        String surname = scanner.nextLine();
        System.out.println("Enter the birth date: ");
        String birthDate = scanner.nextLine();
        System.out.println("Enter the gender (M, F): ");
        String gender = scanner.nextLine();
        System.out.println("Enter the number: ");
        String number = scanner.nextLine();

        Record person = new Person(name, surname, birthDate, gender, number);
        recordList.add(person);
        System.out.println("The record added.");
    }
    public static void addOrg(){

        System.out.println("Enter the organisation name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the address: ");
        String address = scanner.nextLine();
        System.out.println("Enter the number: ");
        String number = scanner.nextLine();

        Record org = new Organisation(name, address, number);
        recordList.add(org);
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
            if(record.getPerson()) {
                Person person = (Person) record;
                System.out.println("Select a field (name, surname, birth, gender, number): ");
                scanner.nextLine();
                String field = scanner.nextLine();
                switch (field) {
                    case "name":
                        System.out.println("Enter name: ");
                        person.setName(scanner.nextLine());
                        break;
                    case "surname":
                        System.out.println("Enter surname: ");
                        person.setSurname(scanner.nextLine());
                        break;
                    case "number":
                        System.out.println("Enter number: ");
                        person.setNumber(scanner.nextLine());
                        break;
                    case "birth":
                        System.out.println("Enter birth date: ");
                        person.setBirthDate(scanner.nextLine());
                        break;
                    case "gender":
                        System.out.println("Enter gender: ");
                        person.setGender(scanner.nextLine());
                        break;
                }
            }else {
                Organisation org = (Organisation) record;
                System.out.println("Select a field (name, address, number): ");
                scanner.nextLine();
                String field = scanner.nextLine();
                switch (field) {
                    case "name":
                        System.out.println("Enter organisation name: ");
                        org.setOrgName(scanner.nextLine());
                        break;
                    case "address":
                        System.out.println("Enter address: ");
                        org.setAddress(scanner.nextLine());
                        break;
                    case "number":
                        System.out.println("Enter number: ");
                        org.setNumber(scanner.nextLine());
                        break;
                }
            }
            System.out.println("The record updated!");
            recordList.set(idx, record);
        }
    }
    public static void listContacts(){
        for(int i = 0; i < recordList.size(); i++){
            Record record = recordList.get(i);
            if(record.getPerson()){
                Person person = (Person) record;
                System.out.println((i+1) + ". " + person.getName()
                        + " " + person.getSurname());
            }else {
                Organisation org = (Organisation) record;
                System.out.println((i+1) + ". " + org.getOrgName());
            }
        }
    }
    public static void info(){
        listContacts();
        System.out.println("Enter index to show info: ");
        int i = scanner.nextInt() - 1;
        Record record = recordList.get(i);
        if(record.getPerson()){
            Person person = (Person) record;
            System.out.println("Name: " + person.getName()
                            + "\nSurname: " + person.getSurname()
                            + "\nBirth date: " + person.getBirthDate()
                            + "\nGender: " + person.getGender()
                            + "\nNumber: " + person.getNumber()
                            + "\nTime created: " + person.getTimeCreated()
                            + "\nTime last edit: " + person.getTimeLastEdited());
        }else {
            Organisation org = (Organisation) record;
            System.out.println("Organization name: " + org.getOrgName()
                    + "\nNumber: " + org.getNumber()
                    + "\nAddress: " + org.getAddress()
                    + "\nTime created: " + org.getTimeCreated()
                    + "\nTime last edit: " + org.getTimeLastEdited());
        }
        scanner.nextLine();
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
