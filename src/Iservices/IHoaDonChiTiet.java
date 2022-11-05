/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservices;

import Models.HoaDonChiTiet;
import Models.SanPhamBan;
import java.util.ArrayList;

/**
 *
 * @author Thang
 */
public interface IHoaDonChiTiet {

    public ArrayList<HoaDonChiTiet> getByHoaDon(String maHD);

    public boolean checkHoaDonChiTietNotInBlackList(String maSP, String maKM);

    public int addHDCT(HoaDonChiTiet hoaDonChiTiet);

    public int updateHDCT(SanPhamBan hdct, String maHD, double d);

    public int deleteHDCT(String maHD, String maSP);

    public double getGiaTienByHoaDon(String maHD);

}
