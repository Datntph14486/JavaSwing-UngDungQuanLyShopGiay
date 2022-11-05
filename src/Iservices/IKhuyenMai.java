/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservices;

import Models.KhuyenMai;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Thang
 */
public interface IKhuyenMai {

    public ArrayList<KhuyenMai> getAll();

    public ArrayList<KhuyenMai> getAll(Date date);

    public int addKhuyenMai(KhuyenMai km);

    public int updateKhuyenMai(KhuyenMai km);
    
    public int getIDKhuyenMai();
    
    public boolean checkKhuyenMai();

}
