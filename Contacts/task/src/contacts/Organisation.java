package contacts;

public class Organisation extends Record {
    private String orgName;
    private String address;
    public Organisation(String orgName, String address, String number) {
        super(number);
        orgName(orgName);
        address(address);
        setPerson(false);
    }

    private void orgName(String orgName){
        if(orgName.equals("")){
            System.out.println("Bad organisation name!");
            this.orgName = "[no data]";
        }else{
            this.orgName = orgName;
        }
    }
    private void address(String address){
        if(address.equals("")){
            System.out.println("Bad address!");
            this.address = "[no data]";
        }else{
            this.address = address;
        }
    }

    public void setOrgName(String orgName) {
        orgName(orgName);
        setTimeLastEdited();
    }

    public void setAddress(String address) {
        address(address);
        setTimeLastEdited();
    }

    public String getAddress() {
        return address;
    }

    public String getOrgName() {
        return orgName;
    }
}
