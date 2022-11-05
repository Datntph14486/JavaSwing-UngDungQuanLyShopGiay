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
public class Mau {
    private String TenMau;
    private int MaMau;

    public Mau() {
    }

    public Mau(String TenMau, int MaMau) {
        this.TenMau = TenMau;
        this.MaMau = MaMau;
    }

    public String getTenMau() {
        return TenMau;
    }

    public void setTenMau(String TenMau) {
        this.TenMau = TenMau;
    }

    public int getMaMau() {
        return MaMau;
    }

    public void setMaMau(int MaMau) {
        this.MaMau = MaMau;
    }

  

    @Override
    public String toString() {
        return TenMau;
    }
    
    
}
