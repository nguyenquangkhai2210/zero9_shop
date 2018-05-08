/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.vouchermodificationhistory;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author PhuNDSE63159
 */
public class VoucherModificationHistoryDTO implements Serializable{
    
    private String code;
    private String modifiedBy;
    private String ModifiedTime;
    private String description;
    
    public VoucherModificationHistoryDTO(String code, String modifiedBy, String ModifiedTime, String description) {
        this.code = code;
        this.modifiedBy = modifiedBy;
        this.ModifiedTime = ModifiedTime;
        this.description = description;
    }
    
    public VoucherModificationHistoryDTO(String code, String modifiedBy, String description) {
        this.code = code;
        this.modifiedBy = modifiedBy;
        this.ModifiedTime = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        this.description = description;
    }
    
    public String getCode() {
        return code;
    }
    
    public String getModifiedBy() {
        return modifiedBy;
    }
    
    public String getModifiedTime() {
        return ModifiedTime;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
    
    public void setModifiedTime(String ModifiedTime) {
        this.ModifiedTime = ModifiedTime;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "VoucherModificationHistoryDTO{" + "code=" + code + ", modifiedBy=" + modifiedBy + ", ModifiedTime=" + ModifiedTime + ", description=" + description + '}';
    }
    
}
