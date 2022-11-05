/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservices;

/**
 *
 * @author Thang
 */
public interface IBlackList {

    public int addBlackProduct(String maSP, String maKM,boolean input);

    public boolean findProductInBlackList(String maSP, String maKM);
}
