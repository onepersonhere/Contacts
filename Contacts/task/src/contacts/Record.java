package contacts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Record {
    private String name;
    private String surname;
    private String number = "";

    Record(String name, String surname, String number){
        this.name = name;
        this.surname = surname;
        setNumber(number);
    }

    public String getNumber() {
        if(hasNumber()){
            return number;
        }
        return "[no number]";
    }

    public void setNumber(String number) {
        if(checkValidity(number)) {
            this.number = number;
        }else{
            this.number = "";
        }
    }

    private boolean checkValidity(String number){
        //check value using regex and set value to field only if sastify these rules:
        //Phone number is split using space or dash
        //Prefix may have +
        //1st/2nd group have (), max only 1 grp
        //grp contains number/upper/lowercase, at least 2 symbols in length
        //1st grp may have 1 symbol in length

        Pattern pattern = Pattern.compile("(^\\+?\\d{0,100}(\\w+[ -]+)*([ -]+\\(\\w+\\)[ -]+|[ -]+\\(\\w+\\)$|\\(\\w+\\)[ -]+|\\(\\w+\\)$){0,1}([ -]?\\w{2,100})*)");
        Matcher matcher = pattern.matcher(number);
        boolean matchFound = matcher.find();
        //System.out.println(matcher.group());
        if(matchFound && matcher.group().equals(number)){
            return true;
        }
        System.out.println("Wrong number format!");
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean hasNumber(){
        if(number.equals("")){
            return false;
        }
        return true;
    }
}
