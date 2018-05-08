/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.product;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author PhuNDSE63159
 */
public class ProductDTO implements Serializable {

    private String proId;
    private String proName;
    private String proDescription;
    private float proPrice;
    private int stock;
    private String catefories;
    private String createdTime;
    private boolean isActive;
    private int saleOff;
    private int reservedPoint;

    public ProductDTO(String proId, String proName, String proDescription, float proPrice, int stock, String categories, String createdTime, boolean isActive, int saleOff, int reservedPoint) {
        this.proId = proId;
        this.proName = proName;
        this.proDescription = proDescription;
        this.proPrice = proPrice;
        this.stock = stock;
        this.createdTime = createdTime;
        this.isActive = isActive;
        this.saleOff = saleOff;
        this.reservedPoint = reservedPoint;
        this.catefories = categories;
    }

    public ProductDTO(String proId, String proName, String proDescription, float proPrice, int stock, String categories) {
        this.proId = proId;
        this.proName = proName;
        this.proDescription = proDescription;
        this.proPrice = proPrice;
        this.stock = stock;
        this.catefories = categories;
        this.createdTime = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        this.isActive = true;
        this.saleOff = 0;
        this.reservedPoint = (int) proPrice * 10 / 100;
    }

    public void setCatefories(String catefories) {
        this.catefories = catefories;
    }

    public String getCatefories() {
        return catefories;
    }

    public String getProId() {
        return proId;
    }

    public String getProName() {
        return proName;
    }

    public String getProDescription() {
        return proDescription;
    }

    public float getProPrice() {
        return proPrice;
    }

    public int getStock() {
        return stock;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public boolean isActive() {
        return isActive;
    }

    public int getSaleOff() {
        return saleOff;
    }

    public int getReservedPoint() {
        return reservedPoint;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public void setProDescription(String proDescription) {
        this.proDescription = proDescription;
    }

    public void setProPrice(float proPrice) {
        this.proPrice = proPrice;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public void isActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setSaleOff(int saleOff) {
        this.saleOff = saleOff;
    }

    public void setReservedPoint(int reservedPoint) {
        this.reservedPoint = reservedPoint;
    }

    @Override
    public String toString() {
        return "ProductDTO{" + "proId=" + proId + ", proName=" + proName + ", proDescription=" + proDescription + ", proPrice=" + proPrice + ", stock=" + stock + ", catefories=" + catefories + ", createdTime=" + createdTime + ", isActive=" + isActive + ", saleOff=" + saleOff + ", reservedPoint=" + reservedPoint + '}';
    }

}
