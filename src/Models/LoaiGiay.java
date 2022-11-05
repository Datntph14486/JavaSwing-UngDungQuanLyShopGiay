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
public class LoaiGiay {
    private String TenLoai;
    private int MaLoai;

    public LoaiGiay() {
    }

    public LoaiGiay(String TenLoai, int MaLoai) {
        this.TenLoai = TenLoai;
        this.MaLoai = MaLoai;
    }

    public String getTenLoai() {
        return TenLoai;
    }

    public void setTenLoai(String TenLoai) {
        this.TenLoai = TenLoai;
    }

    public int getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(int MaLoai) {
        this.MaLoai = MaLoai;
    }

 

    @Override
    public String toString() {
        return  TenLoai;
    }
    
}
