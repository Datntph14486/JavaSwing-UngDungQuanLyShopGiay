/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.jdbcHelper;
import Iservices.IDoanhMuc;
import Models.DoanhMuc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thang
 */
public class DoanhMuc_Dao implements IDoanhMuc{

    @Override
    public ArrayList<DoanhMuc> getAll() {
        String query = "select * from SANPHAM" ;
        ArrayList list = new ArrayList();
        try {
            ResultSet rs = jdbcHelper.query(query);
            while (rs.next()) {                
                DoanhMuc doanhMuc = new DoanhMuc(rs.getString("MASANPHAM"), rs.getString("TENDANHMUC"));
                list.add(doanhMuc);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
}
