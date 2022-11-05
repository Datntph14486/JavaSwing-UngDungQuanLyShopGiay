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
public class HoaDonChiTiet {
    String maHD,maSPCT;
    int soLuong,maHDCT;
    double giaTien;

    public HoaDonChiTiet(String maHD, int maHDCT, String maSPCT, int soLuong,double giaTien) {
        this.maHD = maHD;
        this.maHDCT = maHDCT;
        this.maSPCT = maSPCT;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }
    
    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public int getMaHDCT() {
        return maHDCT;
    }

    public void setMaHDCT(int maHDCT) {
        this.maHDCT = maHDCT;
    }

    public String getMaSPCT() {
        return maSPCT;
    }

    public void setMaSPCT(String maSPCT) {
        this.maSPCT = maSPCT;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
}
