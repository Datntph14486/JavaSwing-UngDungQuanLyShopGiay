/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservices;

import Models.HoaDon;
import java.util.ArrayList;

/**
 *
 * @author Thang
 */
public interface IHoaDon {

    public ArrayList<HoaDon> getAll();

    public int addHoaDon(HoaDon hoaDon);

    public int updatHoaDon(HoaDon hoaDon);

    public int getIDHoaDon();

    public HoaDon getHoaDon(String maHD);

    public ArrayList<HoaDon> getHoaDonsDangXyLy();

}
