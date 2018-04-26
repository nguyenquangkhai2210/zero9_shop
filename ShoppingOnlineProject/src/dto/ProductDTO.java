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
public class ProductDTO implements Serializable{

    private String proId;
    private String proName;
    private String proDescription;
    private float proPrice;
    private String proImage;
    private int stock;
    private String createdTime;
    private boolean isActive;
    private int saleOff;
    private int reservedPoint;

    public ProductDTO(String proId, String proName, String proDescription, float proPrice, String proImage, int stock, String createdTime, boolean isActive, int saleOff, int reservedPoint) {
        this.proId = proId;
        this.proName = proName;
        this.proDescription = proDescription;
        this.proPrice = proPrice;
        this.proImage = proImage;
        this.stock = stock;
        this.createdTime = createdTime;
        this.isActive = isActive;
        this.saleOff = saleOff;
        this.reservedPoint = reservedPoint;
    }

    public ProductDTO(String proId, String proName, String proDescription, float proPrice, String proImage, int stock) {
        this.proId = proId;
        this.proName = proName;
        this.proDescription = proDescription;
        this.proPrice = proPrice;
        this.proImage = proImage;
        this.stock = stock;

        this.createdTime = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        this.isActive = true;
        this.saleOff = 0;
        this.reservedPoint = (int) proPrice * 10 / 100;
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

    public String getProImage() {
        return proImage;
    }

    public int getStock() {
        return stock;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public boolean isIsActive() {
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

    public void setProImage(String proImage) {
        this.proImage = proImage;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public void setIsActive(boolean isActive) {
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
        return "ProductDTO{" + "proId=" + proId + ", proName=" + proName + ", proDescription=" + proDescription + ", proPrice=" + proPrice + ", proImage=" + proImage + ", stock=" + stock + ", createdTime=" + createdTime + ", isActive=" + isActive + ", saleOff=" + saleOff + ", reservedPoint=" + reservedPoint + '}';
    }

}
