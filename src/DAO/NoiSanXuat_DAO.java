/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.jdbcHelper;
import Iservices.ISanPham;
import Models.ChatLieu;
import Models.NoiSanXuat;
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
public class NoiSanXuat_DAO implements ISanPham<NoiSanXuat, String>{
 

    @Override
    public void Add(NoiSanXuat sp) {
         
       
        try {
            ResultSet rs=jdbcHelper.query("SELECT * FROM NOISANXUAT WHERE MANOISANXUAT = ?", sp.getMaNoiSanXuat());
        
           while(rs.next()){
               
                ImageIcon icon = new ImageIcon("src/icons/Delete.png");
                JOptionPane.showMessageDialog(null, "Mã NSX đã tồn tại", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
                return;
           }
       int roww=     jdbcHelper.update("INSERT NOISANXUAT (TENNOISANXUAT) VALUES (?)", sp.getTenNoiSanXuat());
        
            if (roww > 0) {
                ImageIcon icon = new ImageIcon("src/icons/Accept.png");
                JOptionPane.showMessageDialog(null, "Thêm NSX Thành Công", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
            }
        } catch (SQLException sQLException) {
        } catch (HeadlessException headlessException) {
        }
    }

    @Override
    public void Update(NoiSanXuat sp) {
      int row=jdbcHelper.update("UPDATE NOISANXUAT SET TENNOISANXUAT=? WHERE MANOISANXUAT=?", sp.getTenNoiSanXuat(),sp.getMaNoiSanXuat());
        if (row > 0) {
                ImageIcon icon = new ImageIcon("src/icons/Accept.png");
                JOptionPane.showMessageDialog(null, "Thêm NSX Thành Công", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
            }
    }


    public void Delete(int MaSp) {
          try {
            ResultSet rs=jdbcHelper.query("SELECT * FROM SANPHAM_CHITIET WHERE MANOISANXUAT=?", MaSp);
            while(rs.next()){
                 ImageIcon icon = new ImageIcon("src/icons/Delete.png");
                JOptionPane.showMessageDialog(null, " Chất liệu  đang tồn tại trong sản phẩm", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mau_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
           int row=jdbcHelper.update("DELETE FROM NOISANXUAT WHERE MANOISANXUAT=?", MaSp);
        if (row > 0) {
                ImageIcon icon = new ImageIcon("src/icons/Accept.png");
                JOptionPane.showMessageDialog(null, "Xóa NSX Thành Công", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
            }
    }

    @Override
    public ArrayList<NoiSanXuat> all() {
        ArrayList<NoiSanXuat> listDm=new ArrayList<>();
        
        
        try {
            ResultSet rs=jdbcHelper.query("SELECT * FROM NOISANXUAT");
         
            while (rs.next()) {
                NoiSanXuat dm=new NoiSanXuat(rs.getString(2), rs.getInt(1));
                listDm.add(dm);
            }
        } catch (Exception e) {
        }
        return listDm;
    }

    @Override
    public NoiSanXuat selectByid(String MaSp) {
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
