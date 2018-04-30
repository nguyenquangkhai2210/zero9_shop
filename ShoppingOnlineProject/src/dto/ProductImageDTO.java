/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author PhuNDSE63159
 */
public class ProductImageDTO {

    private String proId;
    private String proImage;

    public ProductImageDTO(String proId, String proImage) {
        this.proId = proId;
        this.proImage = proImage;
    }

    public String getProId() {
        return proId;
    }

    public String getProImage() {
        return proImage;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    @Override
    public String toString() {
        return "ProImageDTO{" + "proId=" + proId + ", proImage=" + proImage + '}';
    }

}
