
package Helper;

import java.awt.Component;
import javax.swing.JOptionPane;


public class messengerHelper {
    public static void alert(Component parent, String message) {
    JOptionPane.showMessageDialog(parent, message,
    "Hệ Thống Quản Lý Shop Giày ", JOptionPane.INFORMATION_MESSAGE);
 }

 public static boolean confirm(Component parent, String message) {
    int result = JOptionPane.showConfirmDialog(parent, message,
    "Hệ Thống Quản Lý Shop Giày",
    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    return result == JOptionPane.YES_OPTION;
 }

 public static String prompt(Component parent, String message) {
    return JOptionPane.showInputDialog(parent, message,
    "Hệ Thống Quản Lý Shop Giày", JOptionPane.INFORMATION_MESSAGE);
 }
 public static void showMessengerDialog(Component parent, String message, String title){
     JOptionPane.showMessageDialog(parent, message, title, JOptionPane.INFORMATION_MESSAGE);
 }
 public static void showError(Component parent, String message, String title){
     JOptionPane.showMessageDialog(parent, message, title, JOptionPane.ERROR_MESSAGE);
 }

}
