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
public class Size {
    
    private int MaSize,SoSize;

    public Size() {
    }

    public Size(int MaSize, int SoSize) {
        this.MaSize = MaSize;
        this.SoSize = SoSize;
    }

    public int getMaSize() {
        return MaSize;
    }

    public void setMaSize(int MaSize) {
        this.MaSize = MaSize;
    }

    public int getSoSize() {
        return SoSize;
    }

    public void setSoSize(int SoSize) {
        this.SoSize = SoSize;
    }


    @Override
    public String toString() {
        return  SoSize+"";
    }
    
    
}
