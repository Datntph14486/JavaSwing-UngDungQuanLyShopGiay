/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.jdbcHelper;
import Iservices.IKhuyenMai;
import Models.KhuyenMai;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thang
 */
public class KhuyenMai_Dao implements IKhuyenMai {

    @Override
    public ArrayList<KhuyenMai> getAll() {
        String query = "SELECT * FROM KHUYENMAI";
        ArrayList<KhuyenMai> arrayList = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(query);
            while (rs.next()) {
                arrayList.add(new KhuyenMai(rs.getString("MAKHUYENMAI"), rs.getString("TENKHUYENMAI"), rs.getBoolean("TRANGTHAI"), rs.getBoolean("LOAIGIAMGIA"), rs.getDate("THOIGIANBATDAU"), rs.getDate("THOIGIANKETTHUC"), rs.getDouble("MUCGIAMGIA")));
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(KhuyenMai_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayList;
    }

    @Override
    public int updateKhuyenMai(KhuyenMai km) {
        String query = "update KHUYENMAI set TENKHUYENMAI = ? , LOAIGIAMGIA = ? , MUCGIAMGIA = ? , THOIGIANBATDAU = ? , THOIGIANKETTHUC = ? , TRANGTHAI = ? where MAKHUYENMAI = ?";
        try {
            int tmp = jdbcHelper.update(query,km.getTenKM(),km.isLoaiKM(),km.getMucGiam(),new Date(km.getNgayBD().getTime()),new Date(km.getNgayKT().getTime()),km.getTrangThai(),km.getMaKM());
            return tmp;
        } catch (Exception ex) {
            Logger.getLogger(KhuyenMai_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int addKhuyenMai(KhuyenMai km) {
        String query = "INSERT INTO KHUYENMAI (MAKHUYENMAI,TENKHUYENMAI,LOAIGIAMGIA,MUCGIAMGIA,THOIGIANBATDAU,THOIGIANKETTHUC,TRANGTHAI) VALUES (?,?,?,?,?,?,?)";
        try {
            int tmp = jdbcHelper.update(query,km.getMaKM(),km.getTenKM(),km.isLoaiKM(),km.getMucGiam(),new Date(km.getNgayBD().getTime()),new Date(km.getNgayKT().getTime()),km.getTrangThai());
            return tmp;
        } catch (Exception ex) {
            Logger.getLogger(KhuyenMai_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
       @Override
    public ArrayList<KhuyenMai> getAll(java.util.Date date) {
        String query = "select * from KHUYENMAI where ? between THOIGIANBATDAU and THOIGIANKETTHUC and TRANGTHAI = 1";
        ArrayList<KhuyenMai> arrayList = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(query,date);
            while (rs.next()) {
                arrayList.add(new KhuyenMai(rs.getString("MAKHUYENMAI"), rs.getString("TENKHUYENMAI"), rs.getBoolean("TRANGTHAI"), rs.getBoolean("LOAIGIAMGIA"), rs.getDate("THOIGIANBATDAU"), rs.getDate("THOIGIANKETTHUC"), rs.getDouble("MUCGIAMGIA")));
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(KhuyenMai_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayList;
    }

    @Override
    public int getIDKhuyenMai() {
        String query = "select MAX(ID) from KHUYENMAI";
        try {
            ResultSet rs = jdbcHelper.query(query);
            if(rs.next()){
                return rs.getInt(1);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(KhuyenMai_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public boolean checkKhuyenMai() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
