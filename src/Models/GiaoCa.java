/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

/**
 *
 * @author Vuong_Ahihiiii
 */
public class GiaoCa {
    
    private String maGiaoCa;
    private Date thoiGianBatDau;
    private Date thoiGianKetThuc;
    private String maNV;
    private double tienTaiQuay;
    private double tienTaiKhoan;
    private double tienPhatSinh;
    private String ghiChu;
    private double tongTienDauCa;
    private double tongTienCuoiCa;

    public GiaoCa(String maGiaoCa, Date thoiGianBatDau, Date thoiGianKetThuc, String maNV, double tienTaiQuay, double tienTaiKhoan, double tienPhatSinh, String ghiChu, double tongTienDauCa, double tongTienCuoiCa) {
        this.maGiaoCa = maGiaoCa;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.maNV = maNV;
        this.tienTaiQuay = tienTaiQuay;
        this.tienTaiKhoan = tienTaiKhoan;
        this.tienPhatSinh = tienPhatSinh;
        this.ghiChu = ghiChu;
        this.tongTienDauCa = tongTienDauCa;
        this.tongTienCuoiCa = tongTienCuoiCa;
    }

    public GiaoCa() {
    }

    public String getMaGiaoCa() {
        return maGiaoCa;
    }

    public void setMaGiaoCa(String maGiaoCa) {
        this.maGiaoCa = maGiaoCa;
    }

    public Date getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(Date thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public Date getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(Date thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public double getTienTaiQuay() {
        return tienTaiQuay;
    }

    public void setTienTaiQuay(double tienTaiQuay) {
        this.tienTaiQuay = tienTaiQuay;
    }

    public double getTienTaiKhoan() {
        return tienTaiKhoan;
    }

    public void setTienTaiKhoan(double tienTaiKhoan) {
        this.tienTaiKhoan = tienTaiKhoan;
    }

    public double getTienPhatSinh() {
        return tienPhatSinh;
    }

    public void setTienPhatSinh(double tienPhatSinh) {
        this.tienPhatSinh = tienPhatSinh;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public double getTongTienDauCa() {
        return tongTienDauCa;
    }

    public void setTongTienDauCa(double tongTienDauCa) {
        this.tongTienDauCa = tongTienDauCa;
    }

    public double getTongTienCuoiCa() {
        return tongTienCuoiCa;
    }

    public void setTongTienCuoiCa(double tongTienCuoiCa) {
        this.tongTienCuoiCa = tongTienCuoiCa;
    }

    
   

}
