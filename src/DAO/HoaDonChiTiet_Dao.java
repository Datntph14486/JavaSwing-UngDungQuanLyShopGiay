/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.jdbcHelper;
import Iservices.IHoaDonChiTiet;
import Models.HoaDonChiTiet;
import Models.SanPhamBan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thang
 */
public class HoaDonChiTiet_Dao implements IHoaDonChiTiet {

    @Override
    public ArrayList<HoaDonChiTiet> getByHoaDon(String maHD) {

        ArrayList arrayList = new ArrayList();
        String query = "select * from HOADON_CHITIET where MAHOADON = ?";

        try {
            ResultSet rs = jdbcHelper.query(query, maHD);

            while (rs.next()) {
                System.out.println("+1");

                HoaDonChiTiet hd = new HoaDonChiTiet(rs.getString("MAHOADON"), rs.getInt("MAHOADON_CHITIET"),
                        rs.getString("MASANPHAM_CHITIET"), rs.getInt("SOLUONG"), rs.getDouble("GIATIEN"));
                arrayList.add(hd);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(HoaDon_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayList;
    }
       @Override
    public int addHDCT(HoaDonChiTiet hoaDonChiTiet) {
        String query = "insert into HOADON_CHITIET(MAHOADON,MASANPHAM_CHITIET,SOLUONG,GIATIEN) values (?,?,?,?)";
        return jdbcHelper.update(query, hoaDonChiTiet.getMaHD(), hoaDonChiTiet.getMaSPCT(), hoaDonChiTiet.getSoLuong(), hoaDonChiTiet.getGiaTien());
    }

    @Override
    public boolean checkHoaDonChiTietNotInBlackList(String maSPCT, String maKM) {
        String query = "select * from SANPHAM_CHITIET where MASANPHAM_CHITIET = ? and MASANPHAM_CHITIET not in (select MASANPHAM_CHITIET from SANPHAM_DEN where MAKM = ?)";
        try {
            ResultSet rs = jdbcHelper.query(query, maSPCT, maKM);
            if (rs.next()) {
                return true;
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonChiTiet_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

     @Override
    public int updateHDCT(SanPhamBan hdct, String maHD, double giaTien) {
        String query = "update HOADON_CHITIET set SOLUONG = ? , GIATIEN = ? where MAHOADON = ? and MASANPHAM_CHITIET = ?";
        return jdbcHelper.update(query, hdct.getSoLuongMua(), giaTien, maHD, hdct.getMaSp());
    }

    @Override
    public int deleteHDCT(String maHD, String maSP) {
        String query = "delete HOADON_CHITIET where MAHOADON = ? and MASANPHAM_CHITIET = ?";
        return jdbcHelper.update(query, maHD,maSP);

    }
        @Override
    public double getGiaTienByHoaDon(String maHD) {
        String query = "select SUM(GIATIEN) from HOADON_CHITIET where MAHOADON = ?";
        try {
            ResultSet rs = jdbcHelper.query(query, maHD);
            if (rs.next()) {
                return rs.getDouble(1);
            }
            rs.getStatement().getConnection().close();

        } catch (SQLException ex) {
            
        }
        return 0;
    }

}
