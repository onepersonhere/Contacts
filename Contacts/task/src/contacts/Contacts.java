package contacts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contacts implements Serializable {
    private static final long serialVersionUID = 1L;
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
    public static void editContacts(int idx){
        if(recordList.isEmpty()){
            System.out.println("No records to edit!");
        }else {
            Record record = recordList.get(idx);

            System.out.println("Select a field "+ Arrays.toString(record.returnFields()) +": ");
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
                case "birth":
                    System.out.println("Enter birth date: ");
                    record.setBirthDate(scanner.nextLine());
                    break;
                case "gender":
                    System.out.println("Enter gender: ");
                    record.setGender(scanner.nextLine());
                    break;
                case "address":
                    System.out.println("Enter address: ");
                    record.setAddress(scanner.nextLine());
            }
            System.out.println("Saved");
            info(idx);
            recordList.set(idx, record);
        }
    }
    public static void searchContacts(){
        System.out.println("Enter search query: ");
        String q = scanner.nextLine();
        Pattern pattern = Pattern.compile(q, Pattern.CASE_INSENSITIVE);
        List<Integer> idxLst = new ArrayList<>();
        int n = 1;
        for(int i = 0; i < recordList.size(); i++){
            Record record = recordList.get(i);
            String name = record.getName() + " " + record.getSurname();
            name = name.trim();
            String searchStr = record.getName() + record.getSurname() +
                    record.getBirthDate() + record.getGender() + record.getNumber()
                    + record.getAddress();
            Matcher matcher = pattern.matcher(searchStr);
            if(matcher.find()){
                System.out.println(n + ". " + name);
                idxLst.add(i);
                n++;
            }
        }

        System.out.println("[search] Enter action ([number], back, again): ");
        String action = scanner.nextLine();
        switch (action) {
            case "back":
                break;
            case "again":
                searchContacts();
                break;
            default:
                int num = Integer.parseInt(action);
                try {
                    int idx = idxLst.get(num - 1);
                    info(idx);
                    recordMenu(idx);
                }catch(IndexOutOfBoundsException ignored){}
                break;
        }

    }
    public static void recordMenu(int idx){
        System.out.println("[record] Enter action (edit, delete, menu): ");
        String action = scanner.nextLine();
        switch (action){
            case "edit":
                editContacts(idx);
                recordMenu(idx);
                break;
            case "delete":
                removeContacts(idx);
                recordMenu(idx);
                break;
            case "menu":
                break;
        }
    }
    public static void listContacts(){
        for(int i = 0; i < recordList.size(); i++){
            Record record = recordList.get(i);
            String name = record.getName() + " " + record.getSurname();
            name = name.trim();
            System.out.println((i+1) + ". " + name);
        }
        System.out.println();
        System.out.println("[list] Enter action ([number], back): ");
        String action = scanner.nextLine();
        if(action.equals("back")){
            //back to menu
        }else{
            int idx = Integer.parseInt(action);
            info(idx - 1);
            recordMenu(idx - 1);
        }
    }
    public static void info(int i){
        Record record = recordList.get(i);

        if(record.returnFields().length == 5) {
            System.out.println("Name: " + record.getName()
                    + "\nSurname: " + record.getSurname()
                    + "\nBirth date: " + record.getBirthDate()
                    + "\nGender: " + record.getGender()
                    + "\nNumber: " + record.getNumber());
        }
        else {
            System.out.println("Organization name: " + record.getName()
                    + "\nNumber: " + record.getNumber()
                    + "\nAddress: " + record.getAddress());
        }
        System.out.println("Time created: " + record.getTimeCreated()
                + "\nTime last edit: " + record.getTimeLastEdited());
        System.out.println();
    }
    public static void removeContacts(int idx){
        if(recordList.isEmpty()){
            System.out.println("No records to remove!");
        }else{
            recordList.remove(idx);
            System.out.println("The record removed!");
        }
    }

    public static void countContacts(){
        System.out.println("The Phone Book has " + recordList.size() + " records.");
    }

    public static List<Record> getRecordList() {
        return recordList;
    }

    public static void setRecordList(List<Record> recordList) {
        Contacts.recordList = recordList;
    }
}
