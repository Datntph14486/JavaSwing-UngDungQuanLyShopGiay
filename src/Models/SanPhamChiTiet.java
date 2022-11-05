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
public class SanPhamChiTiet {
    private String maSPCT,maSP,maSize,maMau,maChatLieu,maHang,maLoai,maNoiSanXuat,maHinhAnh,tenSPCT,moTa;
    private double giaNhap,giaBan;
    private int soLuong;
    private boolean trangThai;

    public SanPhamChiTiet() {
    }

    public SanPhamChiTiet(String maSPCT, String maSP, String maSize, String maMau, String maChatLieu, String maHang, String maLoai, String maNoiSanXuat, String maHinhAnh, String tenSPCT, String moTa, double giaNhap, double giaBan, int soLuong, boolean trangThai) {
        this.maSPCT = maSPCT;
        this.maSP = maSP;
        this.maSize = maSize;
        this.maMau = maMau;
        this.maChatLieu = maChatLieu;
        this.maHang = maHang;
        this.maLoai = maLoai;
        this.maNoiSanXuat = maNoiSanXuat;
        this.maHinhAnh = maHinhAnh;
        this.tenSPCT = tenSPCT;
        this.moTa = moTa;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
    }

    public String getMaSPCT() {
        return maSPCT;
    }

    public void setMaSPCT(String maSPCT) {
        this.maSPCT = maSPCT;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getMaSize() {
        return maSize;
    }

    public void setMaSize(String maSize) {
        this.maSize = maSize;
    }

    public String getMaMau() {
        return maMau;
    }

    public void setMaMau(String maMau) {
        this.maMau = maMau;
    }

    public String getMaChatLieu() {
        return maChatLieu;
    }

    public void setMaChatLieu(String maChatLieu) {
        this.maChatLieu = maChatLieu;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getMaNoiSanXuat() {
        return maNoiSanXuat;
    }

    public void setMaNoiSanXuat(String maNoiSanXuat) {
        this.maNoiSanXuat = maNoiSanXuat;
    }

    public String getMaHinhAnh() {
        return maHinhAnh;
    }

    public void setMaHinhAnh(String maHinhAnh) {
        this.maHinhAnh = maHinhAnh;
    }

    public String getTenSPCT() {
        return tenSPCT;
    }

    public void setTenSPCT(String tenSPCT) {
        this.tenSPCT = tenSPCT;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
}
