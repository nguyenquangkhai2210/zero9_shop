/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.employee;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author THANH HUNG
 */
public class EmployeeDTO implements Serializable{

    private String empId;
    private String empUsername;
    private String empPassword;
    private String empName;
    private String EmpPhone;
    private String empMail;
    private String emAddress;
    private String empGender;
    private String empBirthdate;
    private String startDate;
    private String endDate;
    private String roleId;

    public EmployeeDTO(String empId, String empUsername, String empPassword, String empName, String EmpPhone, String empMail, String emAddress, String empGender, String empBirthdate, String startDate, String endDate, String roleId) throws NoSuchAlgorithmException {
        this.empId = empId;
        this.empUsername = empUsername;
        this.empPassword = shop.utils.EncryptionUtils.md5(empPassword);
        this.empName = empName;
        this.EmpPhone = EmpPhone;
        this.empMail = empMail;
        this.emAddress = emAddress;
        this.empGender = empGender;
        this.empBirthdate = empBirthdate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.roleId = roleId;
    }

    public EmployeeDTO(String empId, String empUsername, String empPassword, String empName, String EmpPhone, String empMail, String emAddress, String RoleId) throws NoSuchAlgorithmException {
        this.empId = empId;
        this.empUsername = empUsername;
        this.empPassword = shop.utils.EncryptionUtils.md5(empPassword);
        this.empName = empName;
        this.EmpPhone = EmpPhone;
        this.empMail = empMail;
        this.emAddress = emAddress;
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        this.startDate = date.format(Calendar.getInstance().getTime());
        this.roleId = RoleId;
    }

    public String getEmpId() {
        return empId;
    }

    public String getEmpUsername() {
        return empUsername;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmpPhone() {
        return EmpPhone;
    }

    public String getEmpMail() {
        return empMail;
    }

    public String getEmAddress() {
        return emAddress;
    }

    public String getEmpGender() {
        return empGender;
    }

    public String getEmpBirthdate() {
        return empBirthdate;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public void setEmpUsername(String empUsername) {
        this.empUsername = empUsername;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setEmpPhone(String EmpPhone) {
        this.EmpPhone = EmpPhone;
    }

    public void setEmpMail(String empMail) {
        this.empMail = empMail;
    }

    public void setEmAddress(String emAddress) {
        this.emAddress = emAddress;
    }

    public void setEmpGender(String empGender) {
        this.empGender = empGender;
    }

    public void setEmpBirthdate(String empBirthdate) {
        this.empBirthdate = empBirthdate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" + "empId=" + empId + ", empUsername=" + empUsername + ", empPassword=" + empPassword + ", empName=" + empName + ", EmpPhone=" + EmpPhone + ", empMail=" + empMail + ", emAddress=" + emAddress + ", empGender=" + empGender + ", empBirthdate=" + empBirthdate + ", startDate=" + startDate + ", endDate=" + endDate + ", roleId=" + roleId + '}';
    }
}
