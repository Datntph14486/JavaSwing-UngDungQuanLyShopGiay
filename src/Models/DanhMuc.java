/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author THINKPAD
 */
public class DanhMuc {
    private String TenDanhMuc;
    private int MaDanhMuc;

    public DanhMuc() {
    }

    public DanhMuc(String TenDanhMuc, int MaDanhMuc) {
        this.TenDanhMuc = TenDanhMuc;
        this.MaDanhMuc = MaDanhMuc;
    }

    public String getTenDanhMuc() {
        return TenDanhMuc;
    }

    public void setTenDanhMuc(String TenDanhMuc) {
        this.TenDanhMuc = TenDanhMuc;
    }

    public int getMaDanhMuc() {
        return MaDanhMuc;
    }

    public void setMaDanhMuc(int MaDanhMuc) {
        this.MaDanhMuc = MaDanhMuc;
    }

  

    @Override
    public String toString() {
        return  TenDanhMuc;
    }
    
    
    
}
