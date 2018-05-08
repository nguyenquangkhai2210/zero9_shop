/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.processorderdetails;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author PhuNDSE63159
 */
public class ProcessOrderDetailsDTO implements Serializable{

    private String orderId;
    private String modifiedBy;
    private String modifiedTime;
    private String status;
    private String description;
    
    public ProcessOrderDetailsDTO(String orderId, String modifiedBy, String modifiedTime, String status, String description) {
        this.orderId = orderId;
        this.modifiedBy = modifiedBy;
        this.modifiedTime = modifiedTime;
        this.status = status;
        this.description = description;
    }
    
    public ProcessOrderDetailsDTO(String orderId, String modifiedBy, String status, String description) {
        this.orderId = orderId;
        this.modifiedBy = modifiedBy;
        this.modifiedTime = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        this.status = status;
        this.description = description;
    }
    
    public String getOrderId() {
        return orderId;
    }
    
    public String getModifiedBy() {
        return modifiedBy;
    }
    
    public String getModifiedTime() {
        return modifiedTime;
    }
    
    public String getStatus() {
        return status;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
    
    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProcessOrderDetailsDTO{" + "orderId=" + orderId + ", modifiedBy=" + modifiedBy + ", modifiedTime=" + modifiedTime + ", status=" + status + ", description=" + description + '}';
    }
    
}
