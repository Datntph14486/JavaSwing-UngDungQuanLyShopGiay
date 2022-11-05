/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.jdbcHelper;
import Iservices.ISanPham;
import Models.ChatLieu;
import Models.HinhAnh;
import Models.SanPhamBan;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author THINKPAD
 */
public class HinhAnh_DAO implements ISanPham<HinhAnh, String> {

    @Override
    public void Add(HinhAnh sp) {

        try {
             ResultSet rs;
            try {
                rs = jdbcHelper.query("SELECT * FROM HINHANH WHERE TENHINHANH=?", sp.getTenHinhAnh());
                while(rs.next()){
                 ImageIcon icon = new ImageIcon("src/icons/Delete.png");
                JOptionPane.showMessageDialog(null, " Hình ảnh  đã tồn tại ", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
                return;
            }
            } catch (SQLException ex) {
                Logger.getLogger(HinhAnh_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            

            int roww = jdbcHelper.update("INSERT Hinhanh (TENHINHANH) VALUES (?)", sp.getTenHinhAnh());

            if (roww > 0) {
                ImageIcon icon = new ImageIcon("src/icons/Accept.png");
                JOptionPane.showMessageDialog(null, "Thêm Hình ảnh Thành Công", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
            }

        } catch (HeadlessException headlessException) {
        }
    }

    @Override
    public void Update(HinhAnh sp) {
        int row = jdbcHelper.update("UPDATE HINHANH SET TENHINHANH=? WHERE MAHINHANH=?", sp.getTenHinhAnh(), sp.getMaHinhAnh());
        if (row > 0) {
            ImageIcon icon = new ImageIcon("src/icons/Accept.png");
            JOptionPane.showMessageDialog(null, "Update Hình ảnh Thành Công", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
        }
    }

    public void Delete(int MaSp) {
         try {
            ResultSet rs=jdbcHelper.query("SELECT * FROM SANPHAM_CHITIET WHERE MAHINHANH=?", MaSp);
            while(rs.next()){
                 ImageIcon icon = new ImageIcon("src/icons/Delete.png");
                JOptionPane.showMessageDialog(null, " Hình ảnh  đang tồn tại trong sản phẩm", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mau_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        int row = jdbcHelper.update("DELETE FROM HINHANH  WHERE MAHINHANH=?", MaSp);
        if (row > 0) {
            ImageIcon icon = new ImageIcon("src/icons/Accept.png");
            JOptionPane.showMessageDialog(null, "Xóa Hình ảnh Thành Công", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
        }
    }

    @Override
    public ArrayList<HinhAnh> all() {

        ArrayList<HinhAnh> listDm = new ArrayList<>();

        try {
            ResultSet rs = jdbcHelper.query("SELECT * FROM HINHANH");

            while (rs.next()) {
                HinhAnh dm = new HinhAnh(rs.getString(2), rs.getInt(1));
                listDm.add(dm);
            }
        } catch (Exception e) {
        }
        return listDm;
    }

    @Override
    public HinhAnh selectByid(String MaSp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<SanPhamBan> getByHoaDon(String maHD) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Delete(String MaSp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
