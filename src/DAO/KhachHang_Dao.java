package DAO;

import Helper.jdbcHelper;
import Iservices.IKhachHang;
import Models.KhachHang;
import Utils.MsgBox;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KhachHang_Dao implements IKhachHang<KhachHang, Object> {

    @Override
    public void insert(KhachHang entity) {
        String maKH = entity.getMaKH();
        entity.setMaKH("KH" + (getIDKH() + 1));
        try {
            String sql = "select * from KHACHHANG";
            ResultSet rs = jdbcHelper.query(sql);
            while (rs.next()) {
                if (rs.getString(1).equals(maKH)) {
                    MsgBox.alert(null, "Đã trùng mã nhân viên! Mời nhập mã khác :) ");
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        jdbcHelper.update("insert into KHACHHANG (MAKHACHHANG,HOTEN,SODT,DIACHI,EMAIL) values (?,?,?,?,?)", entity.getMaKH(), entity.getTenKH(), entity.getSdt(), entity.getDiaChi(), entity.getEmail());
        MsgBox.alert(null, "Thêm nhân viên thành công :) ");
    }

    public int getIDKH() {
        String query = "select MAX(ID) from KHACHHANG";
        try {
            ResultSet rs = jdbcHelper.query(query);
            if (rs.next()) {
                return rs.getInt(1);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(KhachHang_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return -1;
    }

    @Override
    public void update(KhachHang entity) {
        jdbcHelper.update("update KHACHHANG set HOTEN=?,SODT=?,DIACHI=?,EMAIL=? where MAKHACHHANG = ?", entity.getTenKH(), entity.getSdt(), entity.getDiaChi(), entity.getEmail(), entity.getMaKH());
    }

    @Override
    public List<KhachHang> selectALL() {
        return this.selectBySQL("select * from KHACHHANG");
    }

    @Override
    public KhachHang selectByID(Object key) {
        List<KhachHang> list = this.selectBySQL("select * from KHACHHANG WHERE MAKHACHHANG = ?", key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<KhachHang> selectBySQL(String sql, Object... args) {
        List<KhachHang> listKH = new ArrayList<KhachHang>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString("MAKHACHHANG"));
                kh.setTenKH(rs.getString("HOTEN"));
                kh.setSdt(rs.getString("SODT"));
                kh.setDiaChi(rs.getString("DIACHI"));
                kh.setEmail(rs.getString("EMAIL"));
                listKH.add(kh);
            }
            rs.getStatement().getConnection().close();
            return listKH;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<KhachHang> selectByKeyword(String key) {
        String sql = "select * from KHACHHANG where HOTEN like ?";
        return this.selectBySQL(sql, "%" + key + "%");
    }

    static boolean checkTrungMa(String key) {

        try {
            String sql = "select * from KHACHHANG";
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

    public KhachHang getByMaKH(String maKH) {
        String query = "select * from KHACHHANG where MAKHACHHANG = ?";

        try {
            ResultSet rs = jdbcHelper.query(query, maKH);
            if (rs.next()) {
                return new KhachHang(rs.getString("MAKHACHHANG"), rs.getString("HOTEN"), rs.getString("SODT"), rs.getString("EMAIL"), rs.getString("DIACHI"));
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public ArrayList<KhachHang> getAll() {
        String query = "SELECT*FROM KHACHHANG";
        ArrayList<KhachHang> khachHangs = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(query);
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString("MAKHACHHANG"), rs.getString("HOTEN"), rs.getString("SODT"), rs.getString("EMAIL"), rs.getString("DIACHI"));
                khachHangs.add(kh);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(KhachHang_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return khachHangs;
    }

}
