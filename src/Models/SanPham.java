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
public class SanPham {
 private String MaSp,TenSp,MoTa;
 private Float GiaTien,GiaNhap;
 private int ID,SoLuong,TrangThai,MaDanhMuc,MaSize,Mamau,MaChatlieu,MaHang,MaLoai,MaNoiSanXuat,MaHinhAnh;

    public SanPham() {
    }

    public SanPham(String MaSp, String TenSp, String MoTa, Float GiaTien, Float GiaNhap, int ID, int SoLuong, int TrangThai, int MaDanhMuc, int MaSize, int Mamau, int MaChatlieu, int MaHang, int MaLoai, int MaNoiSanXuat, int MaHinhAnh) {
        this.MaSp = MaSp;
        this.TenSp = TenSp;
        this.MoTa = MoTa;
        this.GiaTien = GiaTien;
        this.GiaNhap = GiaNhap;
        this.ID = ID;
        this.SoLuong = SoLuong;
        this.TrangThai = TrangThai;
        this.MaDanhMuc = MaDanhMuc;
        this.MaSize = MaSize;
        this.Mamau = Mamau;
        this.MaChatlieu = MaChatlieu;
        this.MaHang = MaHang;
        this.MaLoai = MaLoai;
        this.MaNoiSanXuat = MaNoiSanXuat;
        this.MaHinhAnh = MaHinhAnh;
    }

    public String getMaSp() {
        return MaSp;
    }

    public void setMaSp(String MaSp) {
        this.MaSp = MaSp;
    }

    public String getTenSp() {
        return TenSp;
    }

    public void setTenSp(String TenSp) {
        this.TenSp = TenSp;
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public int getMaDanhMuc() {
        return MaDanhMuc;
    }

    public void setMaDanhMuc(int MaDanhMuc) {
        this.MaDanhMuc = MaDanhMuc;
    }

    public int getMaSize() {
        return MaSize;
    }

    public void setMaSize(int MaSize) {
        this.MaSize = MaSize;
    }

    public int getMamau() {
        return Mamau;
    }

    public void setMamau(int Mamau) {
        this.Mamau = Mamau;
    }

    public int getMaChatlieu() {
        return MaChatlieu;
    }

    public void setMaChatlieu(int MaChatlieu) {
        this.MaChatlieu = MaChatlieu;
    }

    public int getMaHang() {
        return MaHang;
    }

    public void setMaHang(int MaHang) {
        this.MaHang = MaHang;
    }

    public int getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(int MaLoai) {
        this.MaLoai = MaLoai;
    }

    public int getMaNoiSanXuat() {
        return MaNoiSanXuat;
    }

    public void setMaNoiSanXuat(int MaNoiSanXuat) {
        this.MaNoiSanXuat = MaNoiSanXuat;
    }

    public int getMaHinhAnh() {
        return MaHinhAnh;
    }

    public void setMaHinhAnh(int MaHinhAnh) {
        this.MaHinhAnh = MaHinhAnh;
    }

   
  

}
