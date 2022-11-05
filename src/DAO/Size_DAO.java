/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.jdbcHelper;
import Iservices.ISanPham;
import Models.ChatLieu;
import Models.SanPhamBan;
import Models.Size;
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
public class Size_DAO implements ISanPham<Size, String>{


    @Override
    public void Add(Size sp) {
         
        try {
         
          int roww =   jdbcHelper.update("INSERT SIZE (SOSIZE) VALUES (?)",sp.getSoSize());
if(roww>0){
    
                ImageIcon icon = new ImageIcon("src/icons/Accept.png");
                JOptionPane.showMessageDialog(null, "Thêm Size Thành Công", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
            }
      
        } catch (HeadlessException headlessException) {
        }
    }

    @Override
    public void Update(Size sp) {
       int row=jdbcHelper.update("UPDATE SIZE SET SOSIZE=? WHERE MASIZE=?", sp.getSoSize(),sp.getMaSize());
       if(row>0){
            ImageIcon icon = new ImageIcon("src/icons/Accept.png");
                JOptionPane.showMessageDialog(null, "Update Size Thành Công", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
       }
    }

    public void Delete(int MaSp) {
          try {
            ResultSet rs=jdbcHelper.query("SELECT * FROM SANPHAM_CHITIET WHERE MASIZE=?", MaSp);
            while(rs.next()){
                 ImageIcon icon = new ImageIcon("src/icons/Delete.png");
                JOptionPane.showMessageDialog(null, " Size  đang tồn tại trong sản phẩm", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mau_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
         int row=jdbcHelper.update("Delete FROM SIZE  WHERE MASIZE=?", MaSp);
       if(row>0){
            ImageIcon icon = new ImageIcon("src/icons/Accept.png");
                JOptionPane.showMessageDialog(null, "Delete Size Thành Công", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
       }
    }

    @Override
    public ArrayList<Size> all() {
       
          ArrayList<Size> listDm=new ArrayList<>();
        
      
        try {
            ResultSet rs=jdbcHelper.query("SELECT * FROM SIZE");
           
            while (rs.next()) {
                Size dm=new Size(rs.getInt(1), rs.getInt(2));
                listDm.add(dm);
            }
        } catch (Exception e) {
        }
        return listDm;
    }

    @Override
    public Size selectByid(String MaSp) {
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
