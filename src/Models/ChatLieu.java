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
public class ChatLieu {
    private String TenChatLieu;
    private int MaChatLieu;

    public ChatLieu() {
    }

    public ChatLieu(String TenChatLieu, int MaChatLieu) {
        this.TenChatLieu = TenChatLieu;
        this.MaChatLieu = MaChatLieu;
    }

    public String getTenChatLieu() {
        return TenChatLieu;
    }

    public void setTenChatLieu(String TenChatLieu) {
        this.TenChatLieu = TenChatLieu;
    }

    public int getMaChatLieu() {
        return MaChatLieu;
    }

    public void setMaChatLieu(int MaChatLieu) {
        this.MaChatLieu = MaChatLieu;
    }

  

    @Override
    public String toString() {
        return TenChatLieu;
    }
    
    
}
