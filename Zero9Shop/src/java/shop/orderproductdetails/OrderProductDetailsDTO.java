/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.orderproductdetails;

import java.io.Serializable;

/**
 *
 * @author PhuNDSE63159
 */
public class OrderProductDetailsDTO implements Serializable{
    private String orderId;
    private String proId;
    private int quantity;

    public OrderProductDetailsDTO(String orderId, String proId, int quantity) {
        this.orderId = orderId;
        this.proId = proId;
        this.quantity = quantity;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProId() {
        return proId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderProductDetailsDTO{" + "orderId=" + orderId + ", proId=" + proId + ", quantity=" + quantity + '}';
    }
    
    
}
