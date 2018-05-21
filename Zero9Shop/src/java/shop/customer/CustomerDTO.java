/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.customer;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author THANH HUNG
 */
public class CustomerDTO implements Serializable{
    private String cusId;
    private String cusUsername;
    private String cusPassword;
    private String cusName;
    private String cusPhone;
    private String cusMail;
    private String cusAddress;
    private String cusGender;
    private String cusBirthdate;
    private String startDate;
    private int Point;

    public CustomerDTO(String cusId, String cusUsername, String cusPassword, String cusName, String cusPhone,
            String cusMail, String cusAddress, String cusGender, String cusBirthdate, String startDate, int Point)
            throws NoSuchAlgorithmException {
        this.cusId = cusId;
        this.cusUsername = cusUsername;
        this.cusPassword = shop.utils.EncryptionUtils.md5(cusPassword);
        this.cusName = cusName;
        this.cusPhone = cusPhone;
        this.cusMail = cusMail;
        this.cusAddress = cusAddress;
        this.cusGender = cusGender;
        this.cusBirthdate = cusBirthdate;
        this.startDate = startDate;
        this.Point = Point;
    }

    public CustomerDTO(String cusId, String cusUsername, String cusPassword, String cusName, String cusPhone,
            String cusMail, String cusAddress) throws NoSuchAlgorithmException {
        this.cusId = cusId;
        this.cusUsername = cusUsername;
        this.cusPassword = shop.utils.EncryptionUtils.md5(cusPassword);
        this.cusName = cusName;
        this.cusPhone = cusPhone;
        this.cusMail = cusMail;
        this.cusAddress = cusAddress;
        this.cusBirthdate = "";
        this.startDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        this.Point = 0;
    }

    public CustomerDTO(String cusId, String cusUsername, String cusName, String cusPhone, String cusMail, String cusAddress, String cusGender, String cusBirthdate, String startDate, int Point) {
        this.cusId = cusId;
        this.cusUsername = cusUsername;
        this.cusName = cusName;
        this.cusPhone = cusPhone;
        this.cusMail = cusMail;
        this.cusAddress = cusAddress;
        this.cusGender = cusGender;
        this.cusBirthdate = cusBirthdate;
        this.startDate = startDate;
        this.Point = Point;
    }
    
    

    public String getCusId() {
        return cusId;
    }

    public String getCusUsername() {
        return cusUsername;
    }

    public String getCusPassword() {
        return cusPassword;
    }

    public String getCusName() {
        return cusName;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public String getCusMail() {
        return cusMail;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public String getCusGender() {
        return cusGender;
    }

    public String getCusBirthdate() {
        return cusBirthdate;
    }

    public String getStartDate() {
        return startDate;
    }

    public int getPoint() {
        return Point;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public void setCusUsername(String cusUsername) {
        this.cusUsername = cusUsername;
    }

    public void setCusPassword(String cusPassword) {
        this.cusPassword = cusPassword;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public void setCusMail(String cusMail) {
        this.cusMail = cusMail;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public void setCusGender(String cusGender) {
        this.cusGender = cusGender;
    }

    public void setCusBirthdate(String cusBirthdate) {
        this.cusBirthdate = cusBirthdate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setPoint(int Point) {
        this.Point = Point;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" + "cusId=" + cusId + ", cusUsername=" + cusUsername + ", cusPassword=" + cusPassword
                + ", cusName=" + cusName + ", cusPhone=" + cusPhone + ", cusMail=" + cusMail + ", cusAddress="
                + cusAddress + ", cusGender=" + cusGender + ", cusBirthdate=" + cusBirthdate + ", startDate="
                + startDate + ", Point=" + Point + '}';
    }
}
