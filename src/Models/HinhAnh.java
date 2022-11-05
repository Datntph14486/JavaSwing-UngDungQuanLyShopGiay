/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author THINKPAD
 */
public class HinhAnh {
    private String TenHinhAnh;
    private int MaHinhAnh;

    public HinhAnh() {
    }

    public HinhAnh(String TenHinhAnh, int MaHinhAnh) {
        this.TenHinhAnh = TenHinhAnh;
        this.MaHinhAnh = MaHinhAnh;
    }

    public String getTenHinhAnh() {
        return TenHinhAnh;
    }

    public void setTenHinhAnh(String TenHinhAnh) {
        this.TenHinhAnh = TenHinhAnh;
    }

    public int getMaHinhAnh() {
        return MaHinhAnh;
    }

    public void setMaHinhAnh(int MaHinhAnh) {
        this.MaHinhAnh = MaHinhAnh;
    }

  

    @Override
    public String toString() {
        return TenHinhAnh;
    }
    
    
}
