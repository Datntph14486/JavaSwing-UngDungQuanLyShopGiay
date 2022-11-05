/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.jdbcHelper;
import Iservices.IBlackList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thang
 */
public class BlackList_Dao implements IBlackList {

    @Override
    public int addBlackProduct(String maSP, String maKM,boolean input) {
        String queryInsert = "insert into SANPHAM_DEN(MASANPHAM_CHITIET,MAKM,TRANGTHAI) values (?,?,?)";
        String queryUpdate = "update SANPHAM_DEN set TRANGTHAI = ? where MASANPHAM_CHITIET = ? and MAKM = ?";
        int def = 0;
        if (findProductInBlackList(maSP, maKM)) {
            try {
                def = jdbcHelper.update(queryUpdate, input, maSP, maKM);
            } catch (Exception ex) {
                Logger.getLogger(BlackList_Dao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                def = jdbcHelper.update(queryInsert,  maSP, maKM,true);
            } catch (Exception ex) {
                Logger.getLogger(BlackList_Dao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return def;
    }

    @Override
    public boolean findProductInBlackList(String maSP, String maKM) {
        boolean tmp = false;
        String query = "select * from SANPHAM_DEN where MASANPHAM_CHITIET like ? and MAKM like ?";
        try {
            ResultSet rs = jdbcHelper.query(query, maSP, maKM);
            if (rs.next()) {
                tmp = true;
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(BlackList_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tmp;
    }

}
