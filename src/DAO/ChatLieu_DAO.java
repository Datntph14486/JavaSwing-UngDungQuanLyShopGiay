/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Iservices.ISanPham;
import Models.ChatLieu;
import Models.DanhMuc;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import Helper.jdbcHelper;
import Models.SanPhamBan;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THINKPAD
 */
public class ChatLieu_DAO implements ISanPham<ChatLieu, String> {

    @Override
    public void Add(ChatLieu sp) {

        try {
            ResultSet rs = jdbcHelper.query("SELECT * FROM CHATLIEU WHERE MACHATLIEU LIKE ?", sp.getMaChatLieu());

            while (rs.next()) {

                ImageIcon icon = new ImageIcon("src/icons/Delete.png");
                JOptionPane.showMessageDialog(null, "Mã chất liệu đã tồn tại", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
                return;
            }
            int row = jdbcHelper.update("INSERT CHATLIEU (CHATLIEU) VALUES (?)", sp.getTenChatLieu());

            if (row > 0) {
                ImageIcon icon = new ImageIcon("src/icons/Accept.png");
                JOptionPane.showMessageDialog(null, "Thêm Chất liệu Thành Công", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
            }
        } catch (SQLException sQLException) {
        } catch (HeadlessException headlessException) {
        }
    }

    @Override
    public void Update(ChatLieu sp) {
       int row=jdbcHelper.update("UPDATE CHATLIEU SET CHATLIEU =? WHERE MACHATLIEU=?", sp.getTenChatLieu(),sp.getMaChatLieu());
         if (row > 0) {
                ImageIcon icon = new ImageIcon("src/icons/Accept.png");
                JOptionPane.showMessageDialog(null, "Update Chất liệu Thành Công", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
            }
    }

  
    public void Delete(int MaSp) {
              try {
            ResultSet rs=jdbcHelper.query("SELECT * FROM SANPHAM_CHITIET WHERE MACHATLIEU=?", MaSp);
            while(rs.next()){
                 ImageIcon icon = new ImageIcon("src/icons/Delete.png");
                JOptionPane.showMessageDialog(null, " Chất liệu  đang tồn tại trong sản phẩm", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mau_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
       int row=jdbcHelper.update("DELETE FROM CHATLIEU WHERE MACHATLIEU=?", MaSp    );
           if (row > 0) {
                ImageIcon icon = new ImageIcon("src/icons/Accept.png");
                JOptionPane.showMessageDialog(null, "Xóa Chất liệu Thành Công", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
            }
    }

    @Override
    public ArrayList<ChatLieu> all() {

        ArrayList<ChatLieu> listDm = new ArrayList<>();

        try {
            ResultSet rs = jdbcHelper.query("SELECT * FROM CHATLIEU");

            while (rs.next()) {
                ChatLieu dm = new ChatLieu(rs.getString(2), rs.getInt(1));
                listDm.add(dm);
            }
        } catch (Exception e) {
        }
        return listDm;
    }

    @Override
    public ChatLieu selectByid(String MaSp) {
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
