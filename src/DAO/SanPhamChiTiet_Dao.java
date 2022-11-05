/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.jdbcHelper;
import Iservices.ISanPhamChiTiet;
import Models.DoanhMuc;
import Models.SanPhamChiTiet;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thang
 */
public class SanPhamChiTiet_Dao implements ISanPhamChiTiet {

    @Override
    public ArrayList<SanPhamChiTiet> getAllByDoanhMuc(String maKM,String maSP) {
        ArrayList list = new ArrayList();
        String query = "select * from SANPHAM_CHITIET WHERE MASANPHAM_CHITIET NOT IN (SELECT MASANPHAM_CHITIET FROM SANPHAM_DEN WHERE MAKM LIKE ? AND TRANGTHAI = 1) AND MASANPHAM LIKE ?  AND TRANGTHAI = 1";
        try {
            ResultSet rs = jdbcHelper.query(query,maKM,maSP);
            while (rs.next()) {
                SanPhamChiTiet sp = new SanPhamChiTiet(rs.getString("MASANPHAM_CHITIET"), rs.getString("MASANPHAM"), rs.getString("MASIZE")
                        , rs.getString("MAMAU"), rs.getString("MACHATLIEU"), rs.getString("MAHANG"), rs.getString("MALOAI")
                        , rs.getString("MANOISANXUAT"), rs.getString("MAHINHANH"), rs.getString("TENSANPHAM_CHITIET"), rs.getString("MOTA")
                        , rs.getDouble("GIANHAP"), rs.getDouble("GIATIEN"), rs.getInt("SOLUONG"), rs.getBoolean("TRANGTHAI"));
                list.add(sp);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<SanPhamChiTiet> getAllInBlackList(String maKM,String maSP) {
        ArrayList list = new ArrayList();
        String query = "select * from SANPHAM_CHITIET WHERE MASANPHAM_CHITIET IN (SELECT MASANPHAM_CHITIET FROM SANPHAM_DEN WHERE MAKM LIKE ? AND TRANGTHAI = 1)";
        try {
            ResultSet rs = jdbcHelper.query(query,maKM);
            while (rs.next()) {
                SanPhamChiTiet sp = new SanPhamChiTiet(rs.getString("MASANPHAM_CHITIET"), rs.getString("MASANPHAM"), rs.getString("MASIZE")
                        , rs.getString("MAMAU"), rs.getString("MACHATLIEU"), rs.getString("MAHANG"), rs.getString("MALOAI")
                        , rs.getString("MANOISANXUAT"), rs.getString("MAHINHANH"), rs.getString("TENSANPHAM_CHITIET"), rs.getString("MOTA")
                        , rs.getDouble("GIANHAP"), rs.getDouble("GIATIEN"), rs.getInt("SOLUONG"), rs.getBoolean("TRANGTHAI"));
                list.add(sp);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
       @Override
    public int getSoLuongSanPham(String maSP,String maHD) {
        String query = "select SOLUONG from HOADON_CHITIET where MASANPHAM_CHITIET = ? and MAHOADON = ?";
        try {
            ResultSet rs = jdbcHelper.query(query, maSP,maHD);
            if (rs.next()) {
                return rs.getInt(1);
            }
            rs.getStatement().getConnection().close();

        } catch (Exception ex) {
            Logger.getLogger(SanPhamChiTiet_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

}
