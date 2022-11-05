/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.jdbcHelper;
import Iservices.ISanPham;
import Models.ChatLieu;
import Models.Hang;
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
public class Hang_Dao implements ISanPham<Hang, String> {

    @Override
    public void Add(Hang sp) {

        try {
      
            int roww = jdbcHelper.update("INSERT HANG (TENHANG) VALUES (?)", sp.getTenHang());

            if (roww > 0) {
                ImageIcon icon = new ImageIcon("src/icons/Accept.png");
                JOptionPane.showMessageDialog(null, "Thêm hãng Thành Công", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
            }
      
        } catch (HeadlessException headlessException) {
        }
    }

    @Override
    public void Update(Hang sp) {
      int row=jdbcHelper.update("UPDATE HANG SET TENHANG=? WHERE MAHANG=?", sp.getTenHang(),sp.getMaHang());
      if(row>0){
           ImageIcon icon = new ImageIcon("src/icons/Accept.png");
                JOptionPane.showMessageDialog(null, "Update hãng Thành Công", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
      }
    }

    public void Delete(int MaSp) {
           try {
            ResultSet rs=jdbcHelper.query("SELECT * FROM SANPHAM_CHITIET WHERE MAHANG=?", MaSp);
            while(rs.next()){
                 ImageIcon icon = new ImageIcon("src/icons/Delete.png");
                JOptionPane.showMessageDialog(null, " Hãng  đang tồn tại trong sản phẩm", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mau_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
       int row=jdbcHelper.update("DELETE FROM HANG WHERE MAHANG =?", MaSp);
           if(row>0){
           ImageIcon icon = new ImageIcon("src/icons/Accept.png");
                JOptionPane.showMessageDialog(null, "Xóa hãng Thành Công", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
      }
    }

    @Override
    public ArrayList<Hang> all() {

        ArrayList<Hang> listDm = new ArrayList<>();

        try {
            ResultSet rs = jdbcHelper.query("SELECT * FROM HANG");

            while (rs.next()) {
                Hang dm = new Hang(rs.getString(2), rs.getInt(1));
                listDm.add(dm);
            }
        } catch (Exception e) {
        }
        return listDm;
    }

    @Override
    public Hang selectByid(String MaSp) {
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
