/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.NhanVien;
import Utils.MsgBox;
import Helper.jdbcHelper;
import Iservices.INhanVien;
import Iservices.INhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Vuong_Ahihiiii
 */
public class NhanVien_DAO implements INhanVien<NhanVien, String> {

    Connection cn;

    @Override
    public void insert(NhanVien entity) {
        String maNV = entity.getMaNhanVien();
        try {
            String sql = "select * from nhanvien";
            ResultSet rs = jdbcHelper.query(sql);
            while (rs.next()) {
                if (rs.getString(1).equals(maNV)) {
                    MsgBox.alert(null, "Đã trùng mã nhân viên! Mời nhập mã khác :) ");
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        jdbcHelper.update("INSERT INTO NHANVIEN\n"
                + "(MANHANVIEN, HOTEN, DIACHI, NGAYSINH, MATKHAU, SODT, VAITRO, TRANGTHAI)\n"
                + "VALUES (?,?,?,?,?,?,?,?)", entity.getMaNhanVien(), entity.getHoTen(), entity.getDiaChi(), entity.getNgaySinh(), entity.getMatKhau(), entity.getSDT(), entity.isVaiTro(), entity.isTrangThai());
        MsgBox.alert(null, "Thêm nhân viên thành công :) ");
    }

    @Override
    public void update(NhanVien entity) {
        jdbcHelper.update("UPDATE NHANVIEN\n"
                + "SET    HOTEN = ?, NGAYSINH = ?, DIACHI = ?, MATKHAU = ?, VAITRO = ?, SODT = ?, TRANGTHAI = ?\n"
                + "WHERE  MANHANVIEN = ?", entity.getHoTen(), entity.getNgaySinh(), entity.getDiaChi(), entity.getMatKhau(), entity.isVaiTro(), entity.getSDT(), entity.isTrangThai(), entity.getMaNhanVien());
    }

    @Override
    public void delete(String key) {
        //
    }

    @Override
    public List<NhanVien> selectALL() {
        return this.selectBySQL("SELECT NhanVien.* FROM NhanVien");
    }

    @Override
    public NhanVien selectByID(String key) {   // Trả về 1 row Data của 1 nhân viên dựa theo mã nhân viên
        List<NhanVien> list = this.selectBySQL("SELECT NhanVien.* FROM NhanVien WHERE MANHANVIEN = ?", key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhanVien> selectBySQL(String sql, Object... args) {
        List<NhanVien> lstNhanVien = new ArrayList<NhanVien>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNhanVien(rs.getString("MANHANVIEN"));
                nv.setHoTen(rs.getString("HOTEN"));
                nv.setNgaySinh(rs.getDate("NGAYSINH"));
                nv.setDiaChi(rs.getString("DIACHI"));
                nv.setMatKhau(rs.getString("MATKHAU"));
                nv.setVaiTro(rs.getBoolean("VAITRO"));
                nv.setSDT(rs.getString("SODT"));
                nv.setTrangThai(rs.getBoolean("TRANGTHAI"));
                lstNhanVien.add(nv);
            }
            rs.getStatement().getConnection().close();
            return lstNhanVien;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<NhanVien> selectByKeyword(String key) { // Tra ve 1 list nhan vien theo key (ma nhan vien)
        String sql = "select * from nhanvien where HoTen LIKE ?";
        return this.selectBySQL(sql, "%" + key + "%");
    }

    static boolean checkTrungMa(String key) {

        try {
            String sql = "select * from nhanvien";
            ResultSet rs = jdbcHelper.query(sql);
            while (rs.next()) {
                if (rs.getString(1).equals(key)) {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}
