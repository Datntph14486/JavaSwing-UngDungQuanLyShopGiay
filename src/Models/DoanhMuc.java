/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Thang
 */
public class DoanhMuc {
    private String maDoanhMuc,tenDoanhMuc;

    public DoanhMuc(String maDoanhMuc, String tenDoanhMuc) {
        this.maDoanhMuc = maDoanhMuc;
        this.tenDoanhMuc = tenDoanhMuc;
    }

    public String getMaDoanhMuc() {
        return maDoanhMuc;
    }

    public void setMaDoanhMuc(String maDoanhMuc) {
        this.maDoanhMuc = maDoanhMuc;
    }

    public String getTenDoanhMuc() {
        return tenDoanhMuc;
    }

    public void setTenDoanhMuc(String tenDoanhMuc) {
        this.tenDoanhMuc = tenDoanhMuc;
    }

    @Override
    public String toString() {
        return getTenDoanhMuc(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
