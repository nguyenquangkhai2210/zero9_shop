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
public class OrderDTO implements Serializable {

    private String orderId;
    private String createdTime;
    private double orderSum;
    private int point;
    private boolean isAvailable;
    private String code;
    private String cusId;

    public OrderDTO(String orderId, String createdTime, double orderSum, int point, boolean isAvailable, String code, String cusId) {
        this.orderId = orderId;
        this.createdTime = createdTime;
        this.point = point;
        this.isAvailable = isAvailable;
        this.code = code;
        this.cusId = cusId;
        this.orderSum = orderSum;

    }

    public OrderDTO(String orderId, double orderSum, int point, String code, String cusId) {
        this.orderId = orderId;
        this.point = point;
        this.code = code;
        this.cusId = cusId;
        this.orderSum = orderSum;
        this.createdTime = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        this.isAvailable = true;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public int getPoint() {
        return point;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getCode() {
        return code;
    }

    public String getCusId() {
        return cusId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void isAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public void setOrderSum(double orderSum) {
        this.orderSum = orderSum;
    }

    public double getOrderSum() {
        return orderSum;
    }

    @Override
    public String toString() {
        return "OrderDTO{" + "orderId=" + orderId + ", createdTime=" + createdTime + ", point=" + point + ", isAvailable=" + isAvailable + ", code=" + code + ", cusId=" + cusId + '}';
    }

}
