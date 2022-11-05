/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.jdbcHelper;
import Iservices.ISanPham;
import Models.Mau;
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
public class Mau_Dao implements ISanPham<Mau, String>{
 

    @Override
    public void Add(Mau sp) {
       
        
        try {
          
       int row=  jdbcHelper.update("INSERT MAU (TENMAU) VALUES (?)",sp.getTenMau());
           
        
              if(row>0){
                    ImageIcon icon = new ImageIcon("src/icons/Accept.png");
                JOptionPane.showMessageDialog(null, "Thêm Màu Thành Công", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
              }
            
 
        } catch (HeadlessException headlessException) {
        }
    }

    @Override
    public void Update(Mau sp) {
       int row=jdbcHelper.update("UPDATE MAU SET TENMAU=? WHERE MAMAU=?", sp.getTenMau(),sp.getMaMau());
       if(row>0){
               ImageIcon icon = new ImageIcon("src/icons/Accept.png");
                JOptionPane.showMessageDialog(null, "Update Màu Thành Công", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
       }
    }

 
    public void Delete(int MaSp) {
        try {
            ResultSet rs=jdbcHelper.query("SELECT * FROM SANPHAM_CHITIET WHERE MAMAU=?", MaSp);
            while(rs.next()){
                 ImageIcon icon = new ImageIcon("src/icons/Delete.png");
                JOptionPane.showMessageDialog(null, " Màu đang tồn tại trong sản phẩm", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mau_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        int row=jdbcHelper.update("DELETE MAU WHERE MAMAU=?", MaSp);
          if(row>0){
               ImageIcon icon = new ImageIcon("src/icons/Accept.png");
                JOptionPane.showMessageDialog(null, "Xóa Màu Thành Công", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
       }
    }

    @Override
    public ArrayList<Mau> all() {
           ArrayList<Mau> listDm=new ArrayList<>();
        
  
        try {
            ResultSet rs=jdbcHelper.query("SELECT * FROM MAU");
           
            while (rs.next()) {
                Mau dm= new Mau(rs.getString(2), rs.getInt(1));
                listDm.add(dm);
            }
        } catch (Exception e) {
        }
        return listDm;
    }

    @Override
    public Mau selectByid(String MaSp) {
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
