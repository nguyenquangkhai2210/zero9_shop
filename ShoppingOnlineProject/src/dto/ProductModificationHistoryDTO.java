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
public class ProductModificationHistoryDTO implements Serializable{

    private String proId;
    private String modifiedBy;
    private String modifiedTime;
    private String description;

    public ProductModificationHistoryDTO(String proId, String modifiedBy, String modifiedTime, String description) {
        this.proId = proId;
        this.modifiedBy = modifiedBy;
        this.modifiedTime = modifiedTime;
        this.description = description;
    }

    public ProductModificationHistoryDTO(String proId, String modifiedBy, String description) {
        this.proId = proId;
        this.modifiedBy = modifiedBy;
        this.description = description;

        this.modifiedTime = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
    }

    public String getProId() {
        return proId;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public String getDescription() {
        return description;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProductModificationHistoryDTO{" + "proId=" + proId + ", modifiedBy=" + modifiedBy + ", modifiedTime=" + modifiedTime + ", description=" + description + '}';
    }
    
    

}
