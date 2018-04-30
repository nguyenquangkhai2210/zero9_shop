/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author PhuNDSE63159
 */
public class VoucherDTO implements Serializable{
    private String code;
    private int saleOff;
    private boolean isActive;
    private String createdTime;
    private String endedTime;
    private String type;
    private String cusId;

    public VoucherDTO(String code, int saleOff, boolean isActive, String endedTime, String type, String cusId) {
        this.code = code;
        this.saleOff = saleOff;
        this.isActive = isActive;
        this.createdTime = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        this.endedTime = endedTime;
        this.type = type;
        this.cusId = cusId;
    }

    public VoucherDTO(String code, int saleOff, boolean isActive, String createdTime, String endedTime, String type, String cusId) {
        this.code = code;
        this.saleOff = saleOff;
        this.isActive = isActive;
        this.createdTime = createdTime;
        this.endedTime = endedTime;
        this.type = type;
        this.cusId = cusId;
    }
    
    public String getCode() {
        return code;
    }

    public int getSaleOff() {
        return saleOff;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public String getEndedTime() {
        return endedTime;
    }

    public String getType() {
        return type;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setSaleOff(int saleOff) {
        this.saleOff = saleOff;
    }

    public void isActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public void setEndedTime(String endedTime) {
        this.endedTime = endedTime;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    @Override
    public String toString() {
        return "VoucherDTO{" + "code=" + code + ", saleOff=" + saleOff + ", isActive=" + isActive + ", createdTime=" + createdTime + ", endedTime=" + endedTime + ", type=" + type + ", cusId=" + cusId + '}';
    }
    
    
    
}
