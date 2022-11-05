/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.jdbcHelper;
import Iservices.ISanPham;
import Models.ChatLieu;
import Models.LoaiGiay;
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
public class Loai_Dao implements ISanPham<LoaiGiay, String>{
  

    @Override
    public void Add(LoaiGiay sp) {
      
      
        try {
           
         int roww =    jdbcHelper.update("INSERT LOAI (TENLOAI) VALUES (?)", sp.getTenLoai());
           
       
            if (roww > 0) {
                ImageIcon icon = new ImageIcon("src/icons/Accept.png");
                JOptionPane.showMessageDialog(null, "Thêm Loại Thành Công", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
            }
       
        } catch (HeadlessException headlessException) {
        }
    }

    @Override
    public void Update(LoaiGiay sp) {
        int row=jdbcHelper.update("UPDATE LOAI SET TENLOAI =? WHERE MALOAI =?", sp.getTenLoai(),sp.getMaLoai());
           if (row > 0) {
                ImageIcon icon = new ImageIcon("src/icons/Accept.png");
                JOptionPane.showMessageDialog(null, "Update Loại Thành Công", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
            }
    }

   
    public void Delete(int MaSp) {
            try {
            ResultSet rs=jdbcHelper.query("SELECT * FROM SANPHAM_CHITIET WHERE MALOAI=?", MaSp);
            while(rs.next()){
                 ImageIcon icon = new ImageIcon("src/icons/Delete.png");
                JOptionPane.showMessageDialog(null, " Loại  đang tồn tại trong sản phẩm", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mau_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
         int row=jdbcHelper.update("DELETE FROM LOAI WHERE MALOAI =?",MaSp);
           if (row > 0) {
                ImageIcon icon = new ImageIcon("src/icons/Accept.png");
                JOptionPane.showMessageDialog(null, "Delete Loại Thành Công", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
            }
    }

    @Override
    public ArrayList<LoaiGiay> all() {
      
          ArrayList<LoaiGiay> listDm=new ArrayList<>();
        
   
        try {
            ResultSet rs=jdbcHelper.query("SELECT * FROM LOAI");
          
            while (rs.next()) {
                LoaiGiay dm=new LoaiGiay(rs.getString(2), rs.getInt(1));
                listDm.add(dm);
            }
        } catch (Exception e) {
        }
        return listDm;
    }

    @Override
    public LoaiGiay selectByid(String MaSp) {
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
