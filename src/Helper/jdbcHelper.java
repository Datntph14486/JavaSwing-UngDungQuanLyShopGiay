/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author THINKPAD
 */
public class jdbcHelper {

    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String url = "jdbc:sqlserver://DESKTOP-L1KQT23\\SQLEXPRESS:1433;databaseName=QL_SHOP_GIAY2";
    static String user = "sa";
    static String pass = "dat18092002";

    static {
        try {
            Class.forName(driver); // nap driver
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static PreparedStatement getPstm(String sql, Object... args) throws SQLException {
        Connection cn = DriverManager.getConnection(url, user, pass);
        PreparedStatement pstm;
        if (sql.trim().startsWith("{")) { // Nếu sql truyền vào bắt đầu = "{" => Câu lệnh gọi thủ tục PROC
            pstm = cn.prepareCall(sql);
        } else {                          // NGược lại => 
            pstm = cn.prepareStatement(sql);
        }

        // Đưa bao nhiêu tham số (args) thì sẽ tạo ra bấy nhiêu dấu ? trong câu lệnh SQL
        for (int i = 0; i < args.length; i++) {
            pstm.setObject(i + 1, args[i]);
        }
        return pstm;
    }

    // 2: 
    // Trả về 1 hoặc tập giá trị thông qua câu truy vấn
    public static ResultSet query(String sql, Object... args) throws SQLException { // Trả về 1 hoặc tập các câu truy vấn 
        PreparedStatement pstm = jdbcHelper.getPstm(sql, args); // sử dụng lại phương thức phía trên
        return pstm.executeQuery();
    }

    // 3:
    // Chỉ trả về 1 giá trị duy nhất 
    public static Object value(String sql, Object... args) {
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            if (rs.next()) { // Neu co gia tri
                return rs.getObject(0); // Lay gia tri dau tien
            }
            return null; // khong co gia tri tra ve null
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 4
    // Sử dụng để thay đổi dữ liệu (insert, update, delete)
    // trả về số dữ liệu được thay đổi
    public static int update(String sql, Object... args) {
        try {
            PreparedStatement pstm = jdbcHelper.getPstm(sql, args);
            try {
                return pstm.executeUpdate();
            } finally {
                pstm.getConnection().close();
            }
            // Khối finally trong là một khối được sử dụng để thực thi các phần code quan trọng như đóng kết nối, đóng stream, …
            // Khối finally luôn luôn được thực thi dù cho exception có được xử lý hay không.
            // Khối finally phải được theo sau bởi khối try hoặc khối catch.
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
