/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.jdbcHelper;
import Iservices.IGiaoCa;
import Models.GiaoCa;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vuong_Ahihiiii
 */
public class GiaoCa_DAO implements IGiaoCa<GiaoCa, String> {

    @Override
    public void insert(GiaoCa entity) {
        jdbcHelper.update("INSERT INTO GIAOCA\n"
                + "(MANHANVIEN, THOIGIANBATDAU, THOIGIANKETTHUC, TONGTIENBATDAUCA, TONGTIENKETTHUCCA, TIENTAIQUAY, TIENTAIKHOAN, TIENPHATSINH, GHICHU)\n"
                + "VALUES(?,?,?,?,?,?,?,?,?)", entity.getMaNV(), entity.getThoiGianBatDau(), entity.getThoiGianKetThuc(), entity.getTongTienDauCa(), entity.getTongTienCuoiCa(), entity.getTienTaiQuay(), entity.getTienTaiKhoan(), entity.getTienPhatSinh(), entity.getGhiChu());
    }

    @Override
    public List<GiaoCa> selectALL() {
        return this.selectBySQL("SELECT * FROM GIAOCA");
    }

    @Override
    public GiaoCa selectByID(String key) {
         List<GiaoCa> list = this.selectBySQL("SELECT GiaoCa.* FROM GiaoCa WHERE MAGIAOCA = ?", key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<GiaoCa> selectBySQL(String sql, Object... args) {
        List<GiaoCa> lstGiaoCa = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                GiaoCa gc = new GiaoCa();
                gc.setMaGiaoCa(rs.getString("MAGIAOCA"));
                gc.setMaNV(rs.getString("MANHANVIEN"));
                gc.setGhiChu(rs.getString("GHICHU"));
                gc.setThoiGianBatDau(rs.getDate("THOIGIANBATDAU"));
                gc.setThoiGianKetThuc(rs.getDate("THOIGIANKETTHUC"));
                gc.setTienPhatSinh(rs.getDouble("TIENPHATSINH"));
                gc.setTienTaiKhoan(rs.getDouble("TIENTAIKHOAN"));
                gc.setTienTaiQuay(rs.getDouble("TIENTAIQUAY"));
                gc.setTongTienCuoiCa(rs.getDouble("TONGTIENKETTHUCCA"));
                gc.setTongTienDauCa(rs.getDouble("TONGTIENBATDAUCA"));
                lstGiaoCa.add(gc);
            }
            rs.getStatement().getConnection().close();
            return lstGiaoCa;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
