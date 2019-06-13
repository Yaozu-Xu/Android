package db;

import org.litepal.crud.DataSupport;

public class User extends DataSupport {

    private String name;
    private String phoneNumber;
    private String passWord;

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
