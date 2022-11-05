/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservices;

import Models.SanPhamBan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author THINKPAD
 */
public interface ISanPham<TypeObject, TypeData> {
 
    public void Add(TypeObject sp);

    public void Update(TypeObject sp);

    public void Delete(TypeData MaSp);

    public ArrayList<TypeObject> all();

    public TypeObject selectByid(TypeData MaSp);
        public ArrayList<SanPhamBan> getByHoaDon(String maHD);

}
