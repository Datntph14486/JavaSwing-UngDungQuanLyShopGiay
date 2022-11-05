/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.DanhMuc_Dao;
import DAO.HoaDon_Dao;
import DAO.SanPhamChiTiet_Dao;
import DAO.SanPham_Dao;
import DAO.ThongKe_Dao;
import Models.DanhMuc;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Cell;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author admin
 */
public class ThongKe extends javax.swing.JPanel {

    ThongKe_Dao ThongKe_Dao = new ThongKe_Dao();
    DanhMuc_Dao DanhMuc_Dao = new DanhMuc_Dao();
    HoaDon_Dao hoaDon_Dao = new HoaDon_Dao();
    SanPhamChiTiet_Dao SanPhamChiTiet_Dao = new SanPhamChiTiet_Dao();
    ArrayList<Models.ThongKe> arrayListSanPham = new ArrayList<>();
    DefaultComboBoxModel<DanhMuc> ComBoDanhMuc;
    DefaultComboBoxModel<String> ComBoNam;
    DefaultTableModel tableModelThongKe;

    public ThongKe() {
        initComponents();
        initTable();
//        getData();

        pnDate.setVisible(false);
        ComBoDanhMuc = (DefaultComboBoxModel) cbbDanhMuc.getModel();
        ComBoNam = (DefaultComboBoxModel) cbbNam.getModel();
        ThongKe_Dao = new ThongKe_Dao();
        SanPhamChiTiet_Dao = new SanPhamChiTiet_Dao();
        DanhMuc_Dao = new DanhMuc_Dao();
        LoadDanhMuc();
        fillCbb();
        getData();
        rdTatCa.setSelected(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbDoanhThu = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbSoLuong = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lbKhachHang = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbHoaDon = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        ccc = new javax.swing.JLabel();
        lbHuy = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongKe = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        rdTatCa = new javax.swing.JRadioButton();
        rdNamThang = new javax.swing.JRadioButton();
        pnDate = new javax.swing.JPanel();
        DateBatDau = new com.toedter.calendar.JDateChooser();
        DateKetThuc = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnLoc = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cbbNam = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cbbDanhMuc = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lbTuNgay = new javax.swing.JLabel();
        lbDenNgay = new javax.swing.JLabel();
        lbTuNgayNgay = new javax.swing.JLabel();
        lbDenNgayNgay = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(950, 760));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(950, 760));
        jPanel1.setPreferredSize(new java.awt.Dimension(950, 760));

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Doanh Thu");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("VND");

        lbDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbDoanhThu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDoanhThu.setText("0");
        lbDoanhThu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 77, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(68, 68, 68))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(28, 28, 28))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(lbDoanhThu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Số Sản Phẩm Đã Bán");

        lbSoLuong.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbSoLuong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSoLuong.setText("0");
        lbSoLuong.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                    .addComponent(lbSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addGap(26, 26, 26)
                .addComponent(lbSoLuong)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 204));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Tổng Khách Hàng");

        lbKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbKhachHang.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(26, 26, 26)
                .addComponent(lbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Số HĐ Thành Công");

        lbHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHoaDon.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 27, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addComponent(lbHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 204));

        ccc.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        ccc.setText("Số HĐ Hủy");

        lbHuy.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbHuy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHuy.setText("0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHuy, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addComponent(ccc)
                .addGap(69, 69, 69))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ccc)
                .addGap(29, 29, 29)
                .addComponent(lbHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        tblThongKe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblThongKe);

        jPanel7.setBackground(new java.awt.Color(255, 255, 204));

        buttonGroup1.add(rdTatCa);
        rdTatCa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        rdTatCa.setSelected(true);
        rdTatCa.setText("Tất Cả");
        rdTatCa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdTatCaItemStateChanged(evt);
            }
        });
        rdTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdTatCaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdNamThang);
        rdNamThang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        rdNamThang.setText("Theo Tháng Năm");
        rdNamThang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdNamThangItemStateChanged(evt);
            }
        });
        rdNamThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdNamThangActionPerformed(evt);
            }
        });

        pnDate.setBackground(new java.awt.Color(255, 204, 51));
        pnDate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        DateBatDau.setDateFormatString("yyyy-MM-dd");
        DateBatDau.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                DateBatDauAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        DateKetThuc.setDateFormatString("yyyy-MM-dd");

        jLabel9.setText("Từ");

        jLabel12.setText("Đến");

        javax.swing.GroupLayout pnDateLayout = new javax.swing.GroupLayout(pnDate);
        pnDate.setLayout(pnDateLayout);
        pnDateLayout.setHorizontalGroup(
            pnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(pnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DateBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DateKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        pnDateLayout.setVerticalGroup(
            pnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDateLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DateBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DateKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btnLoc.setBackground(new java.awt.Color(255, 204, 51));
        btnLoc.setText("Lọc");
        btnLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(pnDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(rdTatCa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdNamThang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                        .addComponent(btnLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdNamThang)
                    .addComponent(rdTatCa)
                    .addComponent(btnLoc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jButton1.setText("Gửi Báo Cáo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Xuất Excel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(255, 255, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("Năm");

        cbbNam.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cbbNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Danh Mục");

        cbbDanhMuc.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cbbDanhMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả" }));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("Tìm kiếm");

        jButton3.setBackground(new java.awt.Color(255, 204, 51));
        jButton3.setText("Lọc");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbNam, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbbDanhMuc, cbbNam, txtTimKiem});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbNam, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbbDanhMuc, cbbNam, txtTimKiem});

        lbTuNgay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTuNgay.setText("Từ ngày: ");

        lbDenNgay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbDenNgay.setText("Đến ngày: ");

        lbTuNgayNgay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTuNgayNgay.setForeground(new java.awt.Color(0, 204, 0));
        lbTuNgayNgay.setText("00-00-00");

        lbDenNgayNgay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbDenNgayNgay.setForeground(new java.awt.Color(0, 204, 0));
        lbDenNgayNgay.setText("00-00-00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTuNgay)
                                    .addComponent(lbDenNgay))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbDenNgayNgay)
                                    .addComponent(lbTuNgayNgay, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel2, jPanel3, jPanel4, jPanel5, jPanel6});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTuNgay)
                            .addComponent(lbTuNgayNgay))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbDenNgay)
                            .addComponent(lbDenNgayNgay))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel2, jPanel3, jPanel4, jPanel5, jPanel6, jPanel7});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1213, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rdTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdTatCaActionPerformed
        pnDate.setVisible(false);
        minDate();
        tongKhachHang();
        tongHoaDon();
        tongHoaDonHuy();
        TongDoanhThu();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("dd-MM-yyy");
        String format = simpleDateFormat.format(date);
        lbDenNgayNgay.setText(format);
        DateBatDau.setDate(null);
        DateKetThuc.setDate(null);
//        System.out.println("tat_ca");
    }//GEN-LAST:event_rdTatCaActionPerformed

    private void rdNamThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdNamThangActionPerformed

        pnDate.setVisible(true);
        TongDoanhThuTheoThangNam();
        tongHoaDonThangNam();
        tongHoaDonHuyThangNam();
        tongKhachHangThangNam();
        lbTuNgayNgay.setText("00-00-00");
        lbDenNgayNgay.setText("00-00-00");
//        System.out.println("theo thang");
    }//GEN-LAST:event_rdNamThangActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        if (txtTimKiem.getText().length() == 0) {
            getData();
        } else {
            String tenSP = txtTimKiem.getText();
            ArrayList<Models.ThongKe> list = ThongKe_Dao.TimKiem(tenSP);

            tableModelThongKe.setRowCount(0);
            for (Models.ThongKe tk : list) {
                tableModelThongKe.addRow(new Object[]{tk.getTenSP(), tk.getSoLuong(), tk.getDonGia(), tk.getDoanhThu()});
            }
        }
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (cbbDanhMuc.getSelectedIndex() == 0) {
            filterDanhMuc2();
        } else {
            filterDanhMuc();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Socket sock = new Socket();
        InetSocketAddress adr = new InetSocketAddress("www.google.com.vn", 80);
        try {
            sock.connect(adr, 3000);
            sendEmail();
//            JOptionPane.showMessageDialog(this, "Có kết nối Internet");

        } catch (NullPointerException ec) {
            JOptionPane.showMessageDialog(this, "Gửi không thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Không có kết nối Internet");
        } finally {
            try {
                sock.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Không có kết nối Internet2");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void DateBatDauAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_DateBatDauAncestorAdded

    }//GEN-LAST:event_DateBatDauAncestorAdded

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed
        // TODO add your handling code here:
        if (rdTatCa.isSelected()) {
            minDate();
            tongKhachHang();
            tongHoaDon();
            tongHoaDonHuy();
            TongDoanhThu();
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
            simpleDateFormat.applyPattern("dd-MM-yyy");
            String format = simpleDateFormat.format(date);
            lbDenNgayNgay.setText(format);
        } else {
            if (DateBatDau.getDate() == null || DateKetThuc.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Không được để trống NGÀY CHỌN và phải đúng kiểu ngày");
            } else if (DateBatDau.getDate().getTime() >= DateKetThuc.getDate().getTime()) {
                JOptionPane.showMessageDialog(this, "Ngày bắt đầu không được QUÁ hoặc TRÙNG ngày kết thúc");
            } else {
                TongDoanhThuTheoThangNam();
                tongHoaDonThangNam();
                tongHoaDonHuyThangNam();
                tongKhachHangThangNam();
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat();
                simpleDateFormat2.applyPattern("dd-MM-yyy");
                String tuNgay = simpleDateFormat2.format(DateBatDau.getDate());
                String denNgay = simpleDateFormat2.format(DateKetThuc.getDate());
                lbTuNgayNgay.setText(tuNgay);
                lbDenNgayNgay.setText(denNgay);
                DateBatDau.setDate(null);
                DateKetThuc.setDate(null);
            }
        }
    }//GEN-LAST:event_btnLocActionPerformed

    private void rdTatCaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdTatCaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_rdTatCaItemStateChanged

    private void rdNamThangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdNamThangItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_rdNamThangItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("dd-MM-yyy" + "    " + "hh:mm:ss");
        String format = simpleDateFormat.format(date);
        try {
            XSSFWorkbook wordkbook = new XSSFWorkbook();
            XSSFSheet sheet = wordkbook.createSheet("thongke");
            XSSFRow row = null;
            XSSFRow row2 = null;
            XSSFCell cell = null;
            row2 = sheet.createRow(1);
            cell = row2.createCell(0);
            cell.setCellValue("THÔNG KÊ SẢN PHẨM " + "[Thời gian " + format + "]");

            row = sheet.createRow(3); //tạo ở hàng thứ 3

            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("ID");

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Tên Sản Phẩm");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Số Lượng");

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Đơn Giá");

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Doanh Thu");

            for (int i = 0; i < arrayListSanPham.size(); i++) {
                Models.ThongKe tk = arrayListSanPham.get(i);
                row = sheet.createRow(4 + i);

                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(i + 1);

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(arrayListSanPham.get(i).getTenSP());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(arrayListSanPham.get(i).getSoLuong());

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(arrayListSanPham.get(i).getDonGia());

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(arrayListSanPham.get(i).getDoanhThu());
            }

            JFileChooser fl = new JFileChooser();
            int values = fl.showOpenDialog(null);
            File file = fl.getSelectedFile();

            if (values == JFileChooser.APPROVE_OPTION) {
                System.out.println(file.getPath());
                try {
                    FileOutputStream fis = new FileOutputStream(file + ".xlsx");
                    wordkbook.write(fis);
                    fis.close();
                    JOptionPane.showMessageDialog(this, "Lưu Excel thành công");
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else if (values == JFileChooser.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(this, "Không có file nào được lưu");
                System.out.println("Không có file nào được lưu");
            } else if (values == JFileChooser.ERROR_OPTION) {
                System.out.println("Lỗi!");
            } else if (file == null) {
                JOptionPane.showMessageDialog(this, "Không có file nào được lưu");
                System.out.println("không có file nào được lưu null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateBatDau;
    private com.toedter.calendar.JDateChooser DateKetThuc;
    private javax.swing.JButton btnLoc;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbDanhMuc;
    private javax.swing.JComboBox<String> cbbNam;
    private javax.swing.JLabel ccc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbDenNgay;
    private javax.swing.JLabel lbDenNgayNgay;
    private javax.swing.JLabel lbDoanhThu;
    private javax.swing.JLabel lbHoaDon;
    private javax.swing.JLabel lbHuy;
    private javax.swing.JLabel lbKhachHang;
    private javax.swing.JLabel lbSoLuong;
    private javax.swing.JLabel lbTuNgay;
    private javax.swing.JLabel lbTuNgayNgay;
    private javax.swing.JPanel pnDate;
    private javax.swing.JRadioButton rdNamThang;
    private javax.swing.JRadioButton rdTatCa;
    private javax.swing.JTable tblThongKe;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
    private void initTable() {
        String headerSanPham[] = {"Tên Sản Phẩm", "Số Lượng", "Đơn Giá", "Doanh Thu"};
        tableModelThongKe = new DefaultTableModel(headerSanPham, 0);
        tblThongKe.setModel(tableModelThongKe);
    }

    private void getData() {
        arrayListSanPham = ThongKe_Dao.getAll();
        fillToTableHD(arrayListSanPham);
    }

    private void fillToTableHD(ArrayList<Models.ThongKe> list) {
        tableModelThongKe.setRowCount(0);
        for (Models.ThongKe tk : list) {
            tableModelThongKe.addRow(new Object[]{tk.getTenSP(), tk.getSoLuong(), tk.getDonGia(), tk.getDoanhThu()
            });
        }
    }

    private void fillCbb() {
        ComBoNam.removeAllElements();
        String mangTT[] = {"Tất cả", "2020", "2021", "2022"};
        for (String tt : mangTT) {
            ComBoNam.addElement(tt);
        }
    }

    private void LoadDanhMuc() {
        ArrayList<DanhMuc> listDM = DanhMuc_Dao.all();
//        ComBoDanhMuc.removeAllElements();
        for (int i = 0; i < listDM.size(); i++) {
            ComBoDanhMuc.addElement(listDM.get(i));
        }
    }

    private void filterDanhMuc() {
        String nam;
        String nam2;
        String danhMuc;
//        cbbNam.setSelectedIndex(3);
//        cbbDanhMuc.setSelectedIndex(2);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("yyyy");
        String format = simpleDateFormat.format(date);
        if (cbbNam.getSelectedIndex() == 1) {
            nam = cbbNam.getSelectedItem().toString();
            nam2 = cbbNam.getSelectedItem().toString();
//            System.out.println("2020 " + nam);
        } else if (cbbNam.getSelectedIndex() == 2) {
            nam = cbbNam.getSelectedItem().toString();
            nam2 = cbbNam.getSelectedItem().toString();
//            System.out.println("2021 " + nam);
        } else if (cbbNam.getSelectedIndex() == 3) {
            nam = cbbNam.getSelectedItem().toString();
            nam2 = cbbNam.getSelectedItem().toString();
//            System.out.println("2022 " + nam);
        } else {
            nam = "2020";
            nam2 = format;
//            System.out.println("rong " + format);
        }
//        System.out.println("------------");
        if (cbbDanhMuc.getSelectedIndex() == 1) {
            danhMuc = cbbDanhMuc.getSelectedItem().toString();
//            System.out.println("Giày thể thao " + danhMuc);
        } else if (cbbDanhMuc.getSelectedIndex() == 2) {
            danhMuc = cbbDanhMuc.getSelectedItem().toString();
//            System.out.println("Giày lười " + danhMuc);
        } else {
            danhMuc = cbbDanhMuc.getSelectedItem().toString();
//            System.out.println("rong " + danhMuc);
        }
//        System.out.println("------------");

        ArrayList<Models.ThongKe> listTk = ThongKe_Dao.Loc(danhMuc, nam, nam2);
//        System.out.println("tren" + listHd);
        tableModelThongKe.setRowCount(0);
        for (Models.ThongKe tk : listTk) {
            tableModelThongKe.addRow(new Object[]{tk.getTenSP(), tk.getSoLuong(), tk.getDonGia(), tk.getDoanhThu()
            });//            System.out.println("trong" + listHd);
        }
//        System.out.println("ngoai" + listHd);
    }

    private void filterDanhMuc2() {
        String nam;
        String nam2;

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("yyyy");
        String format = simpleDateFormat.format(date);
        if (cbbNam.getSelectedIndex() == 1) {
            nam = cbbNam.getSelectedItem().toString();
            nam2 = cbbNam.getSelectedItem().toString();
//            System.out.println("2020 " + nam);
        } else if (cbbNam.getSelectedIndex() == 2) {
            nam = cbbNam.getSelectedItem().toString();
            nam2 = cbbNam.getSelectedItem().toString();
//            System.out.println("2021 " + nam);
        } else if (cbbNam.getSelectedIndex() == 3) {
            nam = cbbNam.getSelectedItem().toString();
            nam2 = cbbNam.getSelectedItem().toString();
//            System.out.println("2022 " + nam);
        } else {
            nam = "2020";
            nam2 = format;
//            System.out.println("rong " + nam);
        }
        ArrayList<Models.ThongKe> listTk = ThongKe_Dao.LocDanhMuc(nam, nam2);
//        System.out.println("tren" + listHd);
        tableModelThongKe.setRowCount(0);
        for (Models.ThongKe tk : listTk) {
            tableModelThongKe.addRow(new Object[]{tk.getTenSP(), tk.getSoLuong(), tk.getDonGia(), tk.getDoanhThu()
            });//            System.out.println("trong" + listHd);
        }
    }

    private void minDate() {
        ArrayList<Models.ThongKe> listTk = ThongKe_Dao.minDate();
        for (Models.ThongKe tk : listTk) {
            lbTuNgayNgay.setText(String.valueOf(tk.getMinDate()));
            String minDate = (String.valueOf(tk.getMinDate()));
//            System.out.println("minDate: "+ minDate);
        }

    }

    private void TongDoanhThu() {
        ArrayList<Models.ThongKe> listTk = ThongKe_Dao.doanhThuTatCa();
        for (Models.ThongKe tk : listTk) {
            lbSoLuong.setText(String.valueOf(tk.getDoanhThu()));
            lbDoanhThu.setText(String.valueOf(tk.getSoLuong()));
//            System.out.println("doanhthu");
        }
    }

    private void tongHoaDonHuy() {
        ArrayList<Models.ThongKe> listTk = ThongKe_Dao.tongHoaDonHuy();
        for (Models.ThongKe tk : listTk) {
            lbHuy.setText(String.valueOf(tk.getBienThien()));
//            System.out.println("hoadonhuy");
        }
    }

    private void tongHoaDon() {
        ArrayList<Models.ThongKe> listTk = ThongKe_Dao.tongHoaDon();
        for (Models.ThongKe tk : listTk) {
            lbHoaDon.setText(String.valueOf(tk.getBienThien()));
//            System.out.println("hoadon");
        }
    }

    private void tongKhachHang() {
        ArrayList<Models.ThongKe> listTk = ThongKe_Dao.tongKhachHang();
        for (Models.ThongKe tk : listTk) {
            lbKhachHang.setText(String.valueOf(tk.getBienThien()));
//            System.out.println("kachhang");
        }
    }
//theo nam thang

    private void TongDoanhThuTheoThangNam() {
        Date batDau = DateBatDau.getDate();
        Date ketTDate = DateKetThuc.getDate();
        ArrayList<Models.ThongKe> listTk = ThongKe_Dao.doanhThuTatCaTheoThangNam(batDau, ketTDate);
        for (Models.ThongKe tk : listTk) {
            lbSoLuong.setText(String.valueOf(tk.getDoanhThu()));
            lbDoanhThu.setText(String.valueOf(tk.getSoLuong()));
//            System.out.println("doanhthu");
        }
    }

    private void tongHoaDonHuyThangNam() {
        Date batDau = DateBatDau.getDate();
        Date ketTDate = DateKetThuc.getDate();
        ArrayList<Models.ThongKe> listTk = ThongKe_Dao.tongHoaDonHuyThangNam(batDau, ketTDate);
        for (Models.ThongKe tk : listTk) {
            lbHuy.setText(String.valueOf(tk.getBienThien()));
//            System.out.println("hoadonhuy");
        }
    }

    private void tongHoaDonThangNam() {
        Date batDau = DateBatDau.getDate();
        Date ketTDate = DateKetThuc.getDate();
        ArrayList<Models.ThongKe> listTk = ThongKe_Dao.tongHoaDonThangNam(batDau, ketTDate);
        for (Models.ThongKe tk : listTk) {
            lbHoaDon.setText(String.valueOf(tk.getBienThien()));
//            System.out.println("hoadon");
        }
    }

    private void tongKhachHangThangNam() {
        Date batDau = DateBatDau.getDate();
        Date ketTDate = DateKetThuc.getDate();
        ArrayList<Models.ThongKe> listTk = ThongKe_Dao.tongKhachHangThangNam(batDau, ketTDate);
        for (Models.ThongKe tk : listTk) {
            lbKhachHang.setText(String.valueOf(tk.getBienThien()));
//            System.out.println("kachhang");
        }
    }

    //theo nam thang
    public void test() {
        getData();
        rdTatCa.setSelected(true);
        pnDate.setVisible(false);
        cbbDanhMuc.setSelectedIndex(0);
        cbbNam.setSelectedIndex(0);
        txtTimKiem.setText("");
        minDate();
        tongKhachHang();
        tongHoaDon();
        tongHoaDonHuy();
        TongDoanhThu();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("dd-MM-yyy");
        String format = simpleDateFormat.format(date);
        lbDenNgayNgay.setText(format);
        DateBatDau.setDate(null);
        DateKetThuc.setDate(null);
    }

    public void sendEmail() {
        int dialogButton = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn gửi báo cáo chứ?", "WARNING", JOptionPane.YES_NO_OPTION);
        if (dialogButton == JOptionPane.YES_OPTION) {
            String regex = "^[a-zA-Z]+[a-z0-9]*@{1}\\w+mail.com$";
            String emailT = JOptionPane.showInputDialog(this, "Nhập email nhận báo cáo");
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(emailT);
            if (matcher.find()) //check dinh dang email
            {
                String doanhThu;
                String sanPham;
                String hoaDonThanhCong;
                String hoaDonHuy;
                String KhachHang;
                String batDau;
                String ketThuc;
                final String username = "dungndmph19187@fpt.edu.vn";
                final String password = "D@ngmanh2kk";

                Properties prop = new Properties();
                prop.put("mail.smtp.host", "smtp.gmail.com");
                prop.put("mail.smtp.port", "587");
                prop.put("mail.smtp.auth", "true");
                prop.put("mail.smtp.starttls.enable", "true"); //TLS

                Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
                try {
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress("dungndmph19187@fpt.edu.vn", "Shop giày Teddy"));
                    message.setRecipients(
                            Message.RecipientType.BCC, // CC là mail người nhận có thể nhìn thấy những người khác cùng nhận giống mình còn BCC thì người lại
                            InternetAddress.parse("manhdung6112000@gmail.com," + emailT) //emaill nhận ,thangtqph17586@fpt.edu.vn
                    );
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
                    simpleDateFormat.applyPattern("dd-MM-yyy" + "   " + "hh:mm:ss");
                    String format = simpleDateFormat.format(date);
                    String batDau1 = lbTuNgayNgay.getText();
                    String ketThuc1 = lbDenNgayNgay.getText();

                    message.setSubject("Báo Cáo Thống Kê Shop Giày Teddy");
                    doanhThu = "\nSố doanh thu: " + lbDoanhThu.getText() + " VND";
                    sanPham = "\nSố lượng SP đã bán: " + lbSoLuong.getText();
                    hoaDonThanhCong = "\nSố hóa đơn thành công: " + lbHoaDon.getText();
                    hoaDonHuy = "\nSố hóa đơn hủy: " + lbHuy.getText();
                    KhachHang = "\nSố khách hàng: " + lbKhachHang.getText();
                    if (rdTatCa.isSelected()) {
                        Date date2 = new Date();
                        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat();
                        simpleDateFormat2.applyPattern("dd-MM-yyy");
                        String format2 = simpleDateFormat2.format(date2);
                        batDau = "\nTừ ngày: " + batDau1;
                        message.setText("THỜI GIAN BÁO CÁO: " + format + "\n----------\n" + batDau + "\nĐến ngày: " + format2 + doanhThu + sanPham + hoaDonThanhCong + hoaDonHuy + KhachHang);
                    } else {
                        batDau = "\nTừ ngày: " + batDau1;
                        ketThuc = "\nĐến ngày: " + ketThuc1;
                        message.setText("THỜI GIAN BÁO CÁO: " + format + "\n----------\n" + batDau + ketThuc + doanhThu + sanPham + hoaDonThanhCong + hoaDonHuy + KhachHang);
                    }
                    Transport.send(message);
                    JOptionPane.showMessageDialog(this, "gửi email thành công!!");
                } catch (MessagingException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Lỗi kết nối Internet");
                    System.out.println("loi gui bao cao__ " + e);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Lỗi kết nối Internet");
                    System.out.println("loi gui bao cao__ " + ex);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Email không hợp lệ vui lòng kiểm tra lại !!");
            }
        } else {
            remove(this);
        }

    }
}
