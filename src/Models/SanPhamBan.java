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
public class SanPhamBan {

    private String  TenSp, TenDanhMuc, TenMau, TenChatLieu, TenHnag, TenLoai, TenNSX, TenHinhAnh, MoTa,MaSp;
    private Float GiaTien, GiaNhap;
    private int SoSize, SoLuong, TrangThai,soLuongMua;

    public SanPhamBan() {
    }

    public SanPhamBan(String TenSp, String TenDanhMuc, String TenMau, String TenChatLieu, String TenHnag, String TenLoai, String TenNSX, String TenHinhAnh, String MoTa, Float GiaTien, Float GiaNhap, String MaSp, int SoSize, int SoLuong, int TrangThai) {
        this.TenSp = TenSp;
        this.TenDanhMuc = TenDanhMuc;
        this.TenMau = TenMau;
        this.TenChatLieu = TenChatLieu;
        this.TenHnag = TenHnag;
        this.TenLoai = TenLoai;
        this.TenNSX = TenNSX;
        this.TenHinhAnh = TenHinhAnh;
        this.MoTa = MoTa;
        this.GiaTien = GiaTien;
        this.GiaNhap = GiaNhap;
        this.MaSp = MaSp;
        this.SoSize = SoSize;
        this.SoLuong = SoLuong;
        this.TrangThai = TrangThai;
       
    }

    public String getTenSp() {
        return TenSp;
    }

    public void setTenSp(String TenSp) {
        this.TenSp = TenSp;
    }

    public String getTenDanhMuc() {
        return TenDanhMuc;
    }

    public void setTenDanhMuc(String TenDanhMuc) {
        this.TenDanhMuc = TenDanhMuc;
    }

    public String getTenMau() {
        return TenMau;
    }

    public void setTenMau(String TenMau) {
        this.TenMau = TenMau;
    }

    public String getTenChatLieu() {
        return TenChatLieu;
    }

    public void setTenChatLieu(String TenChatLieu) {
        this.TenChatLieu = TenChatLieu;
    }

    public String getTenHnag() {
        return TenHnag;
    }

    public void setTenHnag(String TenHnag) {
        this.TenHnag = TenHnag;
    }

    public String getTenLoai() {
        return TenLoai;
    }

    public void setTenLoai(String TenLoai) {
        this.TenLoai = TenLoai;
    }

    public String getTenNSX() {
        return TenNSX;
    }

    public void setTenNSX(String TenNSX) {
        this.TenNSX = TenNSX;
    }

    public String getTenHinhAnh() {
        return TenHinhAnh;
    }

    public void setTenHinhAnh(String TenHinhAnh) {
        this.TenHinhAnh = TenHinhAnh;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public Float getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(Float GiaTien) {
        this.GiaTien = GiaTien;
    }

    public Float getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(Float GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public String getMaSp() {
        return MaSp;
    }

    public void setMaSp(String MaSp) {
        this.MaSp = MaSp;
    }

    public int getSoSize() {
        return SoSize;
    }

    public void setSoSize(int SoSize) {
        this.SoSize = SoSize;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getSoLuongMua() {
        return soLuongMua;
    }

    public void setSoLuongMua(int soLuongMua) {
        this.soLuongMua = soLuongMua;
    }

 

    

}
