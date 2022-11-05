/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author ADMIN
 */
public class ThongKe {

    private String TenSP,minDate;
    private int SoLuong, DonGia, DoanhThu, bienThien;

    public ThongKe(String TenSP, int SoLuong, int DonGia, int DoanhThu) {
        this.TenSP = TenSP;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.DoanhThu = DoanhThu;
    }

    public ThongKe(String minDate) {
        this.minDate = minDate;
    }
    

    public ThongKe(int DoanhThu, int SoLuong) {
        this.DoanhThu = DoanhThu;
        this.SoLuong = SoLuong;
    }

    public ThongKe(int bienThien) {
        this.bienThien = bienThien;
    }

    public String getMinDate() {
        return minDate;
    }

    public void setMinDate(String minDate) {
        this.minDate = minDate;
    }
    
   
    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public void setBienThien(int bienThien) {
        this.bienThien = bienThien;
    }

    public int getBienThien() {
        return bienThien;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }

    public void setDoanhThu(int DoanhThu) {
        this.DoanhThu = DoanhThu;
    }

    public String getTenSP() {
        return TenSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public int getDonGia() {
        return DonGia;
    }

    public int getDoanhThu() {
        return DoanhThu;
    }

}
