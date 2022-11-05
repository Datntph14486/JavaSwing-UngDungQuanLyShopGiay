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
public class NoiSanXuat {
    private String TenNoiSanXuat;
    private int MaNoiSanXuat;

    public NoiSanXuat() {
    }

    public NoiSanXuat(String TenNoiSanXuat, int MaNoiSanXuat) {
        this.TenNoiSanXuat = TenNoiSanXuat;
        this.MaNoiSanXuat = MaNoiSanXuat;
    }

    public String getTenNoiSanXuat() {
        return TenNoiSanXuat;
    }

    public void setTenNoiSanXuat(String TenNoiSanXuat) {
        this.TenNoiSanXuat = TenNoiSanXuat;
    }

    public int getMaNoiSanXuat() {
        return MaNoiSanXuat;
    }

    public void setMaNoiSanXuat(int MaNoiSanXuat) {
        this.MaNoiSanXuat = MaNoiSanXuat;
    }


    @Override
    public String toString() {
        return TenNoiSanXuat;
    }
    
    
}
