/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.jdbcHelper;
import Iservices.IHoaDon;
import Models.HoaDon;
import Models.KhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thang
 */
public class HoaDon_Dao implements IHoaDon {

    KhachHang_Dao khachHang_Dao = new KhachHang_Dao();

    @Override
    public ArrayList<HoaDon> getAll() {
        ArrayList arrayList = new ArrayList();
        String query = "SELECT * FROM HOADON WHERE DANGXULY=0";
        try {
            ResultSet rs = jdbcHelper.query(query);
            while (rs.next()) {
                String maKH = rs.getString("MAKHACHHANG");
                String tenKH = "";
                KhachHang kh = khachHang_Dao.getByMaKH(maKH);
                System.out.println("demo");

                if (kh != null) {
                    tenKH = kh.getTenKH();
                }
                HoaDon hd = new HoaDon(rs.getString("MAHOADON"), rs.getString("MANHANVIEN"),
                        maKH, rs.getString("GHICHU"), tenKH, rs.getString("SODT"), rs.getString("DIACHI"), rs.getDate("NGAYTAO"), rs.getDate("NGAYTHANHTOAN"),
                        rs.getDouble("TONGTIEN"), rs.getDouble("TIENLAI"), rs.getBoolean("HINHTHUCTHANHTOAN"),
                        rs.getBoolean("TRANGTHAI"), rs.getBoolean("DANGXULY"), rs.getBoolean("DANGGIAOHANG"));
                arrayList.add(hd);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(HoaDon_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayList;
    }

    @Override
    public int updatHoaDon(HoaDon hoaDon) {
        if (hoaDon.getMaKH().trim().isEmpty()) {
            hoaDon.setMaKH(null);
        }
        String query = "update HOADON set MAKHACHHANG = ?,PHISHIP = ? , NGAYTHANHTOAN = ? , TONGTIEN = ? , TIENLAI = ? , HINHTHUCTHANHTOAN = ? ,GHICHU = ? , TRANGTHAI = ? , DANGXULY = ?,DANGGIAOHANG = ?,DIACHI=?,SODT=? where MAHOADON = ?";
        return jdbcHelper.update(query, hoaDon.getMaKH(), hoaDon.getPhiShip(), hoaDon.getNgayThanhToan(), hoaDon.getTongTien(), hoaDon.getTienLai(), hoaDon.isHinhThucThanhToan(), hoaDon.getGhiChu(), hoaDon.isTrangThai(), hoaDon.isDangXuLy(), hoaDon.isDangGiaoHang(), hoaDon.getDChi(), hoaDon.getSDT(), hoaDon.getMaHD());
    }

    @Override
    public int addHoaDon(HoaDon hoaDon) {
        String query = "insert into HOADON(MAHOADON,MANHANVIEN,MAKHACHHANG,NGAYTAO,NGAYTHANHTOAN,TONGTIEN,TIENLAI,HINHTHUCTHANHTOAN,GHICHU,TRANGTHAI,DANGXULY) values (?,?,?,?,?,?,?,?,?,?,?)";
        if (hoaDon.getMaKH().trim().isEmpty()) {
            hoaDon.setMaKH(null);
        }
        hoaDon.setMaHD("HD" + (getIDHoaDon() + 1));
        int isSuccess = jdbcHelper.update(query, hoaDon.getMaHD(), hoaDon.getMaNV(), hoaDon.getMaKH(), hoaDon.getNgayTao(), hoaDon.getNgayThanhToan(), hoaDon.getTongTien(), hoaDon.getTienLai(), hoaDon.isHinhThucThanhToan(), hoaDon.getGhiChu(), hoaDon.isTrangThai(), hoaDon.isDangXuLy());
        return isSuccess;
    }

    @Override
    public int getIDHoaDon() {
        String query = "select MAX(ID) from HOADON";
        try {
            ResultSet rs = jdbcHelper.query(query);
            if (rs.next()) {
                return rs.getInt(1);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(HoaDon_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return -1;
    }

    @Override
    public HoaDon getHoaDon(String maHD) {
        String query = "select * from HOADON where MAHOADON = ?";
        HoaDon hoaDon = null;
        try {
            ResultSet rs = jdbcHelper.query(query, maHD);
            while (rs.next()) {
                String maKH = rs.getString("MAKHACHHANG");
                String tenKH = "";
                KhachHang kh = khachHang_Dao.getByMaKH(maKH);
                if (kh != null) {
                    tenKH = kh.getTenKH();
                }
                Date date = rs.getDate("NGAYTHANHTOAN") != null ? new Date(rs.getTimestamp("NGAYTHANHTOAN").getTime()) : null;
                hoaDon = new HoaDon(rs.getString("MAHOADON"), rs.getString("MANHANVIEN"),
                        maKH, rs.getString("GHICHU"), tenKH, rs.getString("SODT"), rs.getString("DIACHI"), new Date(rs.getTimestamp("NGAYTAO").getTime()), date,
                        rs.getDouble("TONGTIEN"), rs.getDouble("TIENLAI"), rs.getBoolean("HINHTHUCTHANHTOAN"),
                        rs.getBoolean("TRANGTHAI"), rs.getBoolean("DANGXULY"), rs.getBoolean("DANGGIAOHANG"));
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDon_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hoaDon;
    }

    @Override
    public ArrayList<HoaDon> getHoaDonsDangXyLy() {
        ArrayList arrayList = new ArrayList();
        String query = "SELECT * FROM HOADON where DANGXULY = 1 and TRANGTHAI = 1";
        try {
            ResultSet rs = jdbcHelper.query(query);
            while (rs.next()) {
                String maKH = rs.getString("MAKHACHHANG");
                String tenKH = "";
                KhachHang kh = khachHang_Dao.selectByID(maKH);
                if (kh != null) {
                    tenKH = kh.getTenKH();
                }
                Date date = rs.getDate("NGAYTHANHTOAN") != null ? new Date(rs.getTimestamp("NGAYTHANHTOAN").getTime()) : null;
                HoaDon hd = new HoaDon(rs.getString("MAHOADON"), rs.getString("MANHANVIEN"),
                        maKH, rs.getString("GHICHU"), tenKH, rs.getString("SODT"), rs.getString("DIACHI"), new Date(rs.getTimestamp("NGAYTAO").getTime()), date,
                        rs.getDouble("TONGTIEN"), rs.getDouble("TIENLAI"), rs.getBoolean("HINHTHUCTHANHTOAN"),
                        rs.getBoolean("TRANGTHAI"), rs.getBoolean("DANGXULY"), rs.getBoolean("DANGGIAOHANG"));
                hd.setPhiShip(rs.getDouble("PHISHIP"));
                arrayList.add(hd);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(HoaDon_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayList;
    }

    public ArrayList<HoaDon> TimKiem(String maHd) {
        ArrayList<HoaDon> listHd = new ArrayList<>();

        try {
            ResultSet rs = jdbcHelper.query("select * from HOADON where MAHOADON LIKE ?", "%" + maHd + "%");

            while (rs.next()) {
                String maKH = rs.getString("MAKHACHHANG");
                String tenKH = "";
                KhachHang kh = khachHang_Dao.selectByID(maKH);

                if (kh != null) {
                    tenKH = kh.getTenKH();
                }
                HoaDon hd = new HoaDon(rs.getString("MAHOADON"), rs.getString("MANHANVIEN"),
                        maKH, rs.getString("GHICHU"), tenKH, rs.getString("SODT"), rs.getString("DIACHI"), rs.getDate("NGAYTAO"), rs.getDate("NGAYTHANHTOAN"),
                        rs.getDouble("TONGTIEN"), rs.getDouble("TIENLAI"), rs.getBoolean("HINHTHUCTHANHTOAN"),
                        rs.getBoolean("TRANGTHAI"), rs.getBoolean("DANGXULY"), rs.getBoolean("DANGGIAOHANG"));
                listHd.add(hd);

            }
        } catch (SQLException sQLException) {
        }
        return listHd;
    }

    public ArrayList<HoaDon> select(int trangThai, int hinhthucthanhtoan, int hinhThucBanHang, Date BatDau, Date KetThuc) {
        ArrayList<HoaDon> listhd = new ArrayList<>();

        try {

            ResultSet rs = jdbcHelper.query("SELECT * FROM HOADON WHERE DANGXULY=0 AND TRANGTHAI != ? AND HINHTHUCTHANHTOAN != ? AND DANGGIAOHANG != ? AND NGAYTHANHTOAN BETWEEN ? AND ?", trangThai, hinhthucthanhtoan, hinhThucBanHang, BatDau, KetThuc);
            while (rs.next()) {
                String maKH = rs.getString("MAKHACHHANG");
                String tenKH = "";
                KhachHang kh = khachHang_Dao.selectByID(maKH);

                if (kh != null) {
                    tenKH = kh.getTenKH();
                }
                HoaDon hd = new HoaDon(rs.getString("MAHOADON"), rs.getString("MANHANVIEN"),
                        maKH, rs.getString("GHICHU"), tenKH, rs.getString("SODT"), rs.getString("DIACHI"), rs.getDate("NGAYTAO"), rs.getDate("NGAYTHANHTOAN"),
                        rs.getDouble("TONGTIEN"), rs.getDouble("TIENLAI"), rs.getBoolean("HINHTHUCTHANHTOAN"),
                        rs.getBoolean("TRANGTHAI"), rs.getBoolean("DANGXULY"), rs.getBoolean("DANGGIAOHANG"));
                listhd.add(hd);

            }
        } catch (Exception e) {
        }
        return listhd;
    }

    public ArrayList<HoaDon> selectNoDate(int trangThai, int hinhthucthanhtoan, int hinhThucBanHang) {
        ArrayList<HoaDon> listhd = new ArrayList<>();

        try {

            ResultSet rs = jdbcHelper.query("SELECT * FROM HOADON WHERE DANGXULY=0 AND TRANGTHAI != ? AND HINHTHUCTHANHTOAN != ? AND DANGGIAOHANG != ?", trangThai, hinhthucthanhtoan, hinhThucBanHang);
            while (rs.next()) {
                String maKH = rs.getString("MAKHACHHANG");
                String tenKH = "";
                KhachHang kh = khachHang_Dao.selectByID(maKH);

                if (kh != null) {
                    tenKH = kh.getTenKH();
                }
                HoaDon hd = new HoaDon(rs.getString("MAHOADON"), rs.getString("MANHANVIEN"),
                        maKH, rs.getString("GHICHU"), tenKH, rs.getString("SODT"), rs.getString("DIACHI"), rs.getDate("NGAYTAO"), rs.getDate("NGAYTHANHTOAN"),
                        rs.getDouble("TONGTIEN"), rs.getDouble("TIENLAI"), rs.getBoolean("HINHTHUCTHANHTOAN"),
                        rs.getBoolean("TRANGTHAI"), rs.getBoolean("DANGXULY"), rs.getBoolean("DANGGIAOHANG"));
                listhd.add(hd);

            }
        } catch (Exception e) {
        }
        return listhd;
    }

}
