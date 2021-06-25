package contacts;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Record {
    private String number = "";
    private String timeCreated;
    private String timeLastEdited = "";
    private boolean isPerson;
    Record(String number){
        setNumber(number);
        timeCreated = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").format(new java.util.Date());
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
            setTimeLastEdited();
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

    public boolean hasNumber(){
        if(number.equals("")){
            return false;
        }
        return true;
    }

    public void setTimeLastEdited() {
        this.timeLastEdited = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").format(new java.util.Date());
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public String getTimeLastEdited() {
        return timeLastEdited;
    }

    public void setPerson(boolean person) {
        isPerson = person;
    }

    public boolean getPerson(){
        return isPerson;
    }
}
