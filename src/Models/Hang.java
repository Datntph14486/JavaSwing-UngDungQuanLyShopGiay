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
public class Hang {
    private String TenHang;
 private int     MaHang;
;
    public Hang() {
    }

    public Hang(String TenHang, int MaHang) {
        this.TenHang = TenHang;
        this.MaHang = MaHang;
    }

    public String getTenHang() {
        return TenHang;
    }

    public void setTenHang(String TenHang) {
        this.TenHang = TenHang;
    }

    public int getMaHang() {
        return MaHang;
    }

    public void setMaHang(int MaHang) {
        this.MaHang = MaHang;
    }


    @Override
    public String toString() {
        return TenHang;
    }
    
    
}
