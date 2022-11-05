/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Models.NhanVien;

/**
 *
 * @author Vuong_Ahihiiii
 */
public class Auth {

    public static NhanVien user = null;

    public static boolean isLogin() {
        return Auth.user != null; // Neu user != null tra ve true
    }

    public static boolean isManager() {
        return Auth.isLogin() && Auth.user.isVaiTro(); // Da dang naho va la chu return true
    }

    public static void clear() {
        Auth.user = null;
    }
}
