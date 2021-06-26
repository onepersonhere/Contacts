package contacts;

public class Person extends Record{
    private String name;
    private String surname;
    private String birthDate;
    private String gender;
    public Person(String name, String surname, String birthDate, String gender,String number) {
        super(number);
        name(name);
        surname(surname);
        birthDate(birthDate);
        gender(gender);
    }
    private void birthDate(String birthDate){
        if(birthDate.equals("")){
            System.out.println("Bad birth date!");
            this.birthDate = "[no data]";
        }else{
            this.birthDate = birthDate;
        }
    }
    private void gender(String gender){
        if(gender.equals("M") || gender.equals("F")){
            this.gender = gender;
        }else{
            System.out.println("Bad gender!");
            this.gender = "[no data]";
        }
    }
    private void name(String name){
        if(name.equals("")){
            System.out.println("Bad name!");
            this.name = "[no data]";
        }else{
            this.name = name;
        }
    }
    private void surname(String surname){
        if(surname.equals("")){
            System.out.println("Bad surname!");
            this.surname = "[no data]";
        }else{
            this.surname = surname;
        }
    }

    public void setSurname(String surname) {
        surname(surname);
        setTimeLastEdited();
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        name(name);
        setTimeLastEdited();
    }

    public String getName() {
        return name;
    }

    public void setBirthDate(String birthDate) {
        birthDate(birthDate);
        setTimeLastEdited();
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setGender(String gender) {
        gender(gender);
        setTimeLastEdited();
    }

    public String getGender() {
        return gender;
    }

    public String[] returnFields(){
        return new String[]{"name", "surname", "birth date", "gender", "number"};
    }
}
