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
public class HoaDon {
    String maHD,maNV,maKH,ghiChu,tenKH,SDT,DChi;
    Date ngayTao,ngayThanhToan;
    double tongTien,tienLai,phiShip;
    boolean hinhThucThanhToan,TrangThai,dangXuLy,dangGiaoHang;

    public HoaDon(String maHD, String maNV, String maKH, String ghiChu, String tenKH, Date ngayTao, Date ngayThanhToan, double tongTien, double tienLai, boolean hinhThucThanhToan, boolean TrangThai, boolean dangXuLy) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.maKH = maKH;
        this.ghiChu = ghiChu;
        this.tenKH = tenKH;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tongTien = tongTien;
        this.tienLai = tienLai;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.TrangThai = TrangThai;
        this.dangXuLy = dangXuLy;
    }


    public HoaDon(String maHD, String maNV, String maKH, String ghiChu, String tenKH, String SDT, String DChi, Date ngayTao, Date ngayThanhToan, double tongTien, double tienLai, boolean hinhThucThanhToan, boolean TrangThai, boolean dangXuLy, boolean dangGiaoHang) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.maKH = maKH;
        this.ghiChu = ghiChu;
        this.tenKH = tenKH;
        this.SDT = SDT;
        this.DChi = DChi;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tongTien = tongTien;
        this.tienLai = tienLai;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.TrangThai = TrangThai;
        this.dangXuLy = dangXuLy;
        this.dangGiaoHang = dangGiaoHang;
    }

    public double getPhiShip() {
        return phiShip;
    }

    public void setPhiShip(double phiShip) {
        this.phiShip = phiShip;
    }
    

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDChi() {
        return DChi;
    }

    public void setDChi(String DChi) {
        this.DChi = DChi;
    }

    public boolean isDangGiaoHang() {
        return dangGiaoHang;
    }

    public void setDangGiaoHang(boolean dangGiaoHang) {
        this.dangGiaoHang = dangGiaoHang;
    }
    

   

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public boolean isDangXuLy() {
        return dangXuLy;
    }

    public void setDangXuLy(boolean dangXuLy) {
        this.dangXuLy = dangXuLy;
    }


    
    

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maHDCT) {
        this.maKH = maHDCT;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public double getTienLai() {
        return tienLai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    

    public void setTienLai(double tienLai) {
        this.tienLai = tienLai;
    }

    public boolean isHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(boolean hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}
