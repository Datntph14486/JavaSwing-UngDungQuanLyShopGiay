/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Iservices.ISanPham;
import Models.SanPham;
import Models.SanPhamBan;
import Helper.jdbcHelper;
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
public class SanPham_Dao implements ISanPham<SanPham, String> {

    SanPhamChiTiet_Dao sanPhamChiTiet_Dao = new SanPhamChiTiet_Dao();

    @Override
    public void Add(SanPham sp) {

        try {
            sp.setMaSp("SP" + (getIDHoaDon() + 1));
            int row = jdbcHelper.update("insert into SANPHAM_CHITIET (MASANPHAM_CHITIET,MASANPHAM,MASIZE,MAMAU,MACHATLIEU,MAHANG,MALOAI,MANOISANXUAT,MAHINHANH,TENSANPHAM_CHITIET,GIATIEN,GIANHAP,SOLUONG,MOTA,TRANGTHAI) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", sp.getMaSp(), sp.getMaDanhMuc(), sp.getMaSize(), sp.getMamau(), sp.getMaChatlieu(), sp.getMaHang(), sp.getMaLoai(), sp.getMaNoiSanXuat(), sp.getMaHinhAnh(), sp.getTenSp(), sp.getGiaTien(), sp.getGiaNhap(), sp.getSoLuong(), sp.getMoTa(), sp.getTrangThai());

            if (row > 0) {
                ImageIcon icon = new ImageIcon("src/icons/Accept.png");
                JOptionPane.showMessageDialog(null, "thêm thông tin Sản Phẩm thành công", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
            }

        } catch (HeadlessException headlessException) {
        }

    }

    public int getIDHoaDon() {
        String query = "select MAX(ID) from SANPHAM_CHITIET";
        try {
            ResultSet rs = jdbcHelper.query(query);
            if (rs.next()) {
                return rs.getInt(1);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(HoaDon_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return -1;
    }

    @Override
    public void Update(SanPham sp) {

        try {

            int row = jdbcHelper.update("UPDATE SANPHAM_CHITIET SET MASANPHAM=?, MASIZE=?,MAMAU=?,MACHATLIEU=?,MAHANG=?,MALOAI=?,MANOISANXUAT=?,MAHINHANH=?,TENSANPHAM_CHITIET=?,GIATIEN=?,GIANHAP=?,SOLUONG=?,MOTA=?,TRANGTHAI=? WHERE MASANPHAM_CHITIET=?", sp.getMaDanhMuc(), sp.getMaSize(), sp.getMamau(), sp.getMaChatlieu(), sp.getMaHang(), sp.getMaLoai(), sp.getMaNoiSanXuat(), sp.getMaHinhAnh(), sp.getTenSp(), sp.getGiaTien(), sp.getGiaNhap(), sp.getSoLuong(), sp.getMoTa(), sp.getTrangThai(), sp.getMaSp());

            if (row > 0) {
                ImageIcon icon = new ImageIcon("src/icons/Accept.png");
                JOptionPane.showMessageDialog(null, "Update thông tin Sản Phẩm thành công", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
            }

        } catch (HeadlessException headlessException) {
        }
    }

    @Override
    public void Delete(String MaSp) {
        try {
            int row = jdbcHelper.update("DELETE FROM SANPHAM_CHITIET WHERE MASANPHAM_CHITIET=?", MaSp);
            if (row > 0) {
                ImageIcon icon = new ImageIcon("src/icons/Accept.png");
                JOptionPane.showMessageDialog(null, "Xóa  Sản Phẩm thành công", "thông báo", JOptionPane.QUESTION_MESSAGE, icon);
            }
        } catch (HeadlessException headlessException) {
        }
    }

    @Override
    public SanPham selectByid(String MaSp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<SanPham> all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<SanPhamBan> getSanPhamChiTietNotInHoaDonChiTietTim2(String maHD, String maDM, String content) {
        ArrayList arrayList = new ArrayList();
        String query = "SELECT MASANPHAM_CHITIET,TENDANHMUC,TENMAU,CHATLIEU,SOSIZE,TENHANG,TENLOAI,TENNOISANXUAT,TENHINHANH, TENSANPHAM_CHITIET,GIATIEN,GIANHAP,SOLUONG,MOTA,TRANGTHAI FROM SANPHAM SP JOIN SANPHAM_CHITIET SPCT  ON SP.MASANPHAM=SPCT.MASANPHAM JOIN MAU M ON M.MAMAU=SPCT.MAMAU JOIN CHATLIEU CL ON CL.MACHATLIEU=SPCT.MACHATLIEU JOIN HANG H ON H.MAHANG=SPCT.MAHANG JOIN LOAI L ON  L.MALOAI=SPCT.MALOAI JOIN NOISANXUAT NSX ON NSX.MANOISANXUAT=SPCT.MANOISANXUAT JOIN HINHANH HA ON HA.MAHINHANH = SPCT.MAHINHANH join Size s on s.MASIZE=spct.MASIZE  WHERE TRANGTHAI =1 and (SPCT.MASANPHAM_CHITIET like ? or SPCT.TENSANPHAM_CHITIET like ?)  and MASANPHAM_CHITIET not in (select MASANPHAM_CHITIET from HOADON_CHITIET where MAHOADON = ?)";

        try {
            ResultSet rs = jdbcHelper.query(query, "%" + content + "%", "%" + content + "%", maHD);

            while (rs.next()) {
                SanPhamBan sp = new SanPhamBan(rs.getString(10), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(14), rs.getFloat(11), rs.getFloat(12), rs.getString(1), rs.getInt(5), rs.getInt(13), rs.getInt(15));
                sp.setSoLuongMua(sanPhamChiTiet_Dao.getSoLuongSanPham(sp.getMaSp() + "", maHD));
                arrayList.add(sp);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public ArrayList<SanPhamBan> SlectSPB() {
        ArrayList<SanPhamBan> listSp = new ArrayList<>();

        try {
            ResultSet rs = jdbcHelper.query("SELECT MASANPHAM_CHITIET,TENDANHMUC,TENMAU,CHATLIEU,SOSIZE,TENHANG,TENLOAI,TENNOISANXUAT,TENHINHANH,TENSANPHAM_CHITIET,GIATIEN,GIANHAP,SOLUONG,MOTA,TRANGTHAI FROM SANPHAM SP JOIN SANPHAM_CHITIET SPCT ON SP.MASANPHAM=SPCT.MASANPHAM JOIN MAU M ON M.MAMAU=SPCT.MAMAU JOIN CHATLIEU CL ON CL.MACHATLIEU=SPCT.MACHATLIEU JOIN HANG H ON H.MAHANG=SPCT.MAHANG JOIN LOAI L ON L.MALOAI=SPCT.MALOAI JOIN NOISANXUAT NSX ON NSX.MANOISANXUAT=SPCT.MANOISANXUAT JOIN HINHANH HA ON HA.MAHINHANH = SPCT.MAHINHANH join Size s on s.MASIZE=spct.MASIZE WHERE TRANGTHAI =1");

            while (rs.next()) {
                SanPhamBan sp = new SanPhamBan(rs.getString(10), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(14), rs.getFloat(11), rs.getFloat(12), rs.getString(1), rs.getInt(5), rs.getInt(13), rs.getInt(15));
                listSp.add(sp);

            }
        } catch (SQLException sQLException) {
        }
        return listSp;
    }

    public ArrayList<SanPhamBan> getSanPhamChiTietNotInHoaDonChiTietTim(String maHD, String maDM, String content) {
        ArrayList arrayList = new ArrayList();
        String query = "SELECT MASANPHAM_CHITIET,TENDANHMUC,TENMAU,CHATLIEU,SOSIZE,TENHANG,TENLOAI,TENNOISANXUAT,TENHINHANH, TENSANPHAM_CHITIET,GIATIEN,GIANHAP,SOLUONG,MOTA,TRANGTHAI FROM SANPHAM SP JOIN SANPHAM_CHITIET SPCT  ON SP.MASANPHAM=SPCT.MASANPHAM JOIN MAU M ON M.MAMAU=SPCT.MAMAU JOIN CHATLIEU CL ON CL.MACHATLIEU=SPCT.MACHATLIEU JOIN HANG H ON H.MAHANG=SPCT.MAHANG JOIN LOAI L ON  L.MALOAI=SPCT.MALOAI JOIN NOISANXUAT NSX ON NSX.MANOISANXUAT=SPCT.MANOISANXUAT JOIN HINHANH HA ON HA.MAHINHANH = SPCT.MAHINHANH join Size s on s.MASIZE=spct.MASIZE  WHERE TRANGTHAI =1 and SP.MASANPHAM = ? and (SPCT.MASANPHAM_CHITIET like ? or SPCT.TENSANPHAM_CHITIET like ?)  and MASANPHAM_CHITIET not in (select MASANPHAM_CHITIET from HOADON_CHITIET where MAHOADON = ?)";

        try {
            ResultSet rs = jdbcHelper.query(query, maDM, "%" + content + "%", "%" + content + "%", maHD);

            while (rs.next()) {
                SanPhamBan sp = new SanPhamBan(rs.getString(10), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(14), rs.getFloat(11), rs.getFloat(12), rs.getString(1), rs.getInt(5), rs.getInt(13), rs.getInt(15));
                sp.setSoLuongMua(sanPhamChiTiet_Dao.getSoLuongSanPham(sp.getMaSp() + "", maHD));
                arrayList.add(sp);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public ArrayList<SanPhamBan> getSanPhamChiTietNotInHoaDonChiTietWhere(String maHD, String maDM) {
        ArrayList arrayList = new ArrayList();
        String query = "SELECT MASANPHAM_CHITIET,TENDANHMUC,TENMAU,CHATLIEU,SOSIZE,TENHANG,TENLOAI,TENNOISANXUAT,TENHINHANH, TENSANPHAM_CHITIET, GIATIEN,GIANHAP,SOLUONG,MOTA,TRANGTHAI FROM SANPHAM SP JOIN SANPHAM_CHITIET SPCT  ON SP.MASANPHAM=SPCT.MASANPHAM JOIN MAU M ON M.MAMAU=SPCT.MAMAU JOIN CHATLIEU CL ON CL.MACHATLIEU=SPCT.MACHATLIEU JOIN HANG H ON H.MAHANG=SPCT.MAHANG JOIN LOAI L ON  L.MALOAI=SPCT.MALOAI JOIN NOISANXUAT NSX ON NSX.MANOISANXUAT=SPCT.MANOISANXUAT JOIN HINHANH HA ON HA.MAHINHANH = SPCT.MAHINHANH join Size s on s.MASIZE=spct.MASIZE  WHERE TRANGTHAI =1 and SP.MASANPHAM = ? and MASANPHAM_CHITIET not in (select MASANPHAM_CHITIET from HOADON_CHITIET where MAHOADON = ?)";
        try {
            ResultSet rs = jdbcHelper.query(query, maDM, maHD);

            while (rs.next()) {
                SanPhamBan sp = new SanPhamBan(rs.getString(10), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(14), rs.getFloat(11), rs.getFloat(12), rs.getString(1), rs.getInt(5), rs.getInt(13), rs.getInt(15));
                sp.setSoLuongMua(sanPhamChiTiet_Dao.getSoLuongSanPham(sp.getMaSp() + "", maHD));
                arrayList.add(sp);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public ArrayList<SanPhamBan> allll() {
        ArrayList<SanPhamBan> listSp = new ArrayList<>();

        try {
            ResultSet rs = jdbcHelper.query("SELECT MASANPHAM_CHITIET,TENDANHMUC,TENMAU,CHATLIEU,SOSIZE,TENHANG,TENLOAI,TENNOISANXUAT,TENHINHANH,TENSANPHAM_CHITIET,GIATIEN,GIANHAP,SOLUONG,MOTA,TRANGTHAI FROM SANPHAM SP JOIN SANPHAM_CHITIET SPCT ON SP.MASANPHAM=SPCT.MASANPHAM JOIN MAU M ON M.MAMAU=SPCT.MAMAU JOIN CHATLIEU CL ON CL.MACHATLIEU=SPCT.MACHATLIEU JOIN HANG H ON H.MAHANG=SPCT.MAHANG JOIN LOAI L ON L.MALOAI=SPCT.MALOAI JOIN NOISANXUAT NSX ON NSX.MANOISANXUAT=SPCT.MANOISANXUAT JOIN HINHANH HA ON HA.MAHINHANH = SPCT.MAHINHANH join Size s on s.MASIZE=spct.MASIZE WHERE TRANGTHAI =0");

            while (rs.next()) {
                SanPhamBan sp = new SanPhamBan(rs.getString(10), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(14), rs.getFloat(11), rs.getFloat(12), rs.getString(1), rs.getInt(5), rs.getInt(13), rs.getInt(15));
                listSp.add(sp);

            }
        } catch (SQLException sQLException) {
        }
        return listSp;
    }

    public ArrayList<SanPhamBan> TimKiem(String tenSp) {
        ArrayList<SanPhamBan> listSp = new ArrayList<>();

        try {
            ResultSet rs = jdbcHelper.query("SELECT MASANPHAM_CHITIET,TENDANHMUC,TENMAU,CHATLIEU,SOSIZE,TENHANG,TENLOAI,TENNOISANXUAT,TENHINHANH,TENSANPHAM_CHITIET,GIATIEN,GIANHAP,SOLUONG,MOTA,TRANGTHAI FROM SANPHAM SP JOIN SANPHAM_CHITIET SPCT ON SP.MASANPHAM=SPCT.MASANPHAM JOIN MAU M ON M.MAMAU=SPCT.MAMAU JOIN CHATLIEU CL ON CL.MACHATLIEU=SPCT.MACHATLIEU JOIN HANG H ON H.MAHANG=SPCT.MAHANG JOIN LOAI L ON L.MALOAI=SPCT.MALOAI JOIN NOISANXUAT NSX ON NSX.MANOISANXUAT=SPCT.MANOISANXUAT JOIN HINHANH HA ON HA.MAHINHANH = SPCT.MAHINHANH join Size s on s.MASIZE=spct.MASIZE WHERE SPCT.TENSANPHAM_CHITIET like ?", "%" + tenSp + "%");

            while (rs.next()) {
                SanPhamBan sp = new SanPhamBan(rs.getString(10), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(14), rs.getFloat(11), rs.getFloat(12), rs.getString(1), rs.getInt(5), rs.getInt(13), rs.getInt(15));
                listSp.add(sp);

            }
        } catch (SQLException sQLException) {
        }
        return listSp;
    }

    public ArrayList<SanPhamBan> selectLoc(int maDm, int maHnag, int MAlOAI) {
        ArrayList<SanPhamBan> listSp = new ArrayList<>();

        try {
            ResultSet rs = jdbcHelper.query("SELECT MASANPHAM_CHITIET,TENDANHMUC,TENMAU,CHATLIEU,SOSIZE,hang.TENHANG,loai.TENLOAI,TENNOISANXUAT,TENHINHANH,TENSANPHAM_CHITIET,GIATIEN,GIANHAP,SOLUONG,MOTA,TRANGTHAI FROM SANPHAM SP JOIN SANPHAM_CHITIET SPCT ON SP.MASANPHAM=SPCT.MASANPHAM JOIN MAU M ON M.MAMAU=SPCT.MAMAU JOIN CHATLIEU CL ON CL.MACHATLIEU=SPCT.MACHATLIEU JOIN HANG H ON H.MAHANG=SPCT.MAHANG JOIN LOAI L ON L.MALOAI=SPCT.MALOAI JOIN NOISANXUAT NSX ON NSX.MANOISANXUAT=SPCT.MANOISANXUAT JOIN HINHANH HA ON HA.MAHINHANH = SPCT.MAHINHANH join Size s on s.MASIZE=spct.MASIZE join hang on hang.MAHANG =SPCT.MAHANG join loai on loai.MALOAI=SPCT.MALOAI WHERE Sp.MASANPHAM =? AND Hang.MAHANG =? AND loai.MALOAI =?", maDm, maHnag, MAlOAI);

            while (rs.next()) {
                SanPhamBan sp = new SanPhamBan(rs.getString(10), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(14), rs.getFloat(11), rs.getFloat(12), rs.getString(1), rs.getInt(5), rs.getInt(13), rs.getInt(15));
                listSp.add(sp);

            }
        } catch (SQLException sQLException) {
        }
        return listSp;
    }

    public int updateSL(SanPhamBan sanPhamBan) {
        String query = "update SANPHAM_CHITIET set SOLUONG = ? where MASANPHAM_CHITIET = ?";
        return jdbcHelper.update(query, sanPhamBan.getSoLuong(), sanPhamBan.getMaSp());
    }

    @Override
    public ArrayList<SanPhamBan> getByHoaDon(String maHD) {

        ArrayList arrayList = new ArrayList();
        String query = "SELECT MASANPHAM_CHITIET,TENDANHMUC,TENMAU,CHATLIEU,SOSIZE,TENHANG,TENLOAI,TENNOISANXUAT,TENHINHANH,TENSANPHAM_CHITIET,GIATIEN,GIANHAP,SOLUONG,MOTA,TRANGTHAI FROM SANPHAM SP JOIN SANPHAM_CHITIET SPCT ON SP.MASANPHAM=SPCT.MASANPHAM JOIN MAU M ON M.MAMAU=SPCT.MAMAU JOIN CHATLIEU CL ON CL.MACHATLIEU=SPCT.MACHATLIEU JOIN HANG H ON H.MAHANG=SPCT.MAHANG JOIN LOAI L ON L.MALOAI=SPCT.MALOAI JOIN NOISANXUAT NSX ON NSX.MANOISANXUAT=SPCT.MANOISANXUAT JOIN HINHANH HA ON HA.MAHINHANH = SPCT.MAHINHANH join Size s on s.MASIZE=spct.MASIZE  WHERE TRANGTHAI =1 and MASANPHAM_CHITIET in (select MASANPHAM_CHITIET from HOADON_CHITIET where MAHOADON = ?)";

        try {
            ResultSet rs = jdbcHelper.query(query, maHD);

            while (rs.next()) {
                SanPhamBan sp = new SanPhamBan(rs.getString(10), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(14), rs.getFloat(11), rs.getFloat(12), rs.getString(1), rs.getInt(5), rs.getInt(13), rs.getInt(15));
                sp.setSoLuongMua(sanPhamChiTiet_Dao.getSoLuongSanPham(sp.getMaSp(), maHD));
                System.out.println(sp.getSoLuongMua());
                arrayList.add(sp);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public ArrayList<SanPhamBan> getSanPhamChiTietNotInHoaDonChiTiet(String maHD) {
        ArrayList arrayList = new ArrayList();
        String query = "SELECT MASANPHAM_CHITIET,TENDANHMUC,TENMAU,CHATLIEU,SOSIZE,TENHANG,TENLOAI,TENNOISANXUAT,TENHINHANH,TENSANPHAM_CHITIET,GIATIEN,GIANHAP,SOLUONG,MOTA,TRANGTHAI FROM SANPHAM SP JOIN SANPHAM_CHITIET SPCT ON SP.MASANPHAM=SPCT.MASANPHAM JOIN MAU M ON M.MAMAU=SPCT.MAMAU JOIN CHATLIEU CL ON CL.MACHATLIEU=SPCT.MACHATLIEU JOIN HANG H ON H.MAHANG=SPCT.MAHANG JOIN LOAI L ON L.MALOAI=SPCT.MALOAI JOIN NOISANXUAT NSX ON NSX.MANOISANXUAT=SPCT.MANOISANXUAT JOIN HINHANH HA ON HA.MAHINHANH = SPCT.MAHINHANH join Size s on s.MASIZE=spct.MASIZE  WHERE TRANGTHAI =1 and MASANPHAM_CHITIET not in (select MASANPHAM_CHITIET from HOADON_CHITIET where MAHOADON = ?)";

        try {
            ResultSet rs = jdbcHelper.query(query, maHD);

            while (rs.next()) {
                SanPhamBan sp = new SanPhamBan(rs.getString(10), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(14), rs.getFloat(11), rs.getFloat(12), rs.getString(1), rs.getInt(5), rs.getInt(13), rs.getInt(15));
                sp.setSoLuongMua(sanPhamChiTiet_Dao.getSoLuongSanPham(sp.getMaSp() + "", maHD));
                arrayList.add(sp);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public double getGiaBan(String maHD, String maSP) {
        String query = "select GIATIEN/SOLUONG from HOADON_CHITIET where MAHOADON = ? and MASANPHAM_CHITIET = ?";
        try {
            ResultSet rs = jdbcHelper.query(query, maHD, maSP);
            if (rs.next()) {
                return rs.getDouble(1);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(SanPham_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    public int getSoLuong(String maSP) {
        String query = "select SOLUONG from SANPHAM_CHITIET where MASANPHAM_CHITIET = ?";
        try {
            ResultSet rs = jdbcHelper.query(query, maSP);
            if (rs.next()) {
                return rs.getInt(1);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(SanPham_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
