/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

/**
 *
 * @author Thang
 */
public class KhuyenMai {
    private String maKM,tenKM;
    private boolean loaiKM,trangThai;
    private Date ngayBD,ngayKT;
    private double mucGiam;

    public KhuyenMai() {
    }

    public KhuyenMai(String maKM, String tenKM, boolean trangThai, boolean loaiKM, Date ngayBD, Date ngayKT,double mucGiam) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.trangThai = trangThai;
        this.loaiKM = loaiKM;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.mucGiam = mucGiam;
    }
    
    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public boolean isLoaiKM() {
        return loaiKM;
    }

    public void setLoaiKM(boolean loaiKM) {
        this.loaiKM = loaiKM;
    }

    public Date getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(Date ngayBD) {
        this.ngayBD = ngayBD;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }

    public double getMucGiam() {
        return mucGiam;
    }

    public void setMucGiam(double mucGiam) {
        this.mucGiam = mucGiam;
    }
    @Override
    public String toString() {
        return  tenKM; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
