/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservices;

import Models.SanPhamChiTiet;
import java.util.ArrayList;

/**
 *
 * @author Thang
 */
public interface ISanPhamChiTiet {

  
    public ArrayList<SanPhamChiTiet> getAllByDoanhMuc(String maKM, String maSP);

    public ArrayList<SanPhamChiTiet> getAllInBlackList(String maKM, String maSP);

    public int getSoLuongSanPham(String maSP,String maHD);
//    public SanPhamChiTiet getSanPhamChiTietInBlackList(String maKM, String maSP);

}
