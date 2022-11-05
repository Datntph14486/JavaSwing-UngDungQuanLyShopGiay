/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.HoaDonChiTiet_Dao;
import DAO.HoaDon_Dao;
import Models.DanhMuc;
import Models.HoaDonChiTiet;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Thang
 */
public class HoaDon extends javax.swing.JPanel {

    DefaultComboBoxModel<String> ComBoTrangThai;
    DefaultComboBoxModel<String> ComBoHinhThucThanhToan;
    DefaultComboBoxModel<String> ComBoHinhThucBan;

    HoaDon_Dao hoaDon_Dao = new HoaDon_Dao();
    HoaDonChiTiet_Dao hoaDonChiTiet_Dao = new HoaDonChiTiet_Dao();
    DefaultTableModel tableModelHoaDon;
    DefaultTableModel tableModelHoaDonChiTiet;

    ArrayList<Models.HoaDon> arrayListHoaDon = new ArrayList<>();
    ArrayList<HoaDonChiTiet> arrayListHoaDonChiTiet = new ArrayList<>();

    /**
     * Creates new form HoaDon
     */
    public HoaDon() {
        initComponents();
        initTable();
//        getData();
        ComBoTrangThai = (DefaultComboBoxModel) cbbTThai.getModel();
        ComBoHinhThucThanhToan = (DefaultComboBoxModel) cbbThanhToan.getModel();
        ComBoHinhThucBan = (DefaultComboBoxModel) cbbHinhBanHang.getModel();
        hoaDon_Dao = new HoaDon_Dao();
        fillHTTT();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cbbTThai = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbbHinhBanHang = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbbThanhToan = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        DateNgayTao = new com.toedter.calendar.JDateChooser();
        DateNgayThanhToan = new com.toedter.calendar.JDateChooser();
        btnLoc = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDonChiTiet = new javax.swing.JTable();
        btnExcel = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 153));

        jLabel1.setText("Tìm kiếm");

        txtTimKiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusLost(evt);
            }
        });
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setText("Trạng thái");

        cbbTThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTThaiActionPerformed(evt);
            }
        });

        jLabel5.setText("Bán Hàng");

        cbbHinhBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbHinhBanHangActionPerformed(evt);
            }
        });

        jLabel6.setText("Thanh toán");

        cbbThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbThanhToanActionPerformed(evt);
            }
        });

        jLabel7.setText("Từ");

        jLabel8.setText("Đến");

        DateNgayTao.setDateFormatString("yyyy-MM-dd");

        DateNgayThanhToan.setDateFormatString("yyyy-MM-dd");

        btnLoc.setText("Lọc");
        btnLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cbbHinhBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbTThai, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(DateNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(DateNgayThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbbHinhBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(DateNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(8, 8, 8)))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(cbbTThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(DateNgayThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbbThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoc))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tblHoaDon.setBackground(new java.awt.Color(255, 255, 204));
        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblHoaDon.setGridColor(new java.awt.Color(255, 255, 255));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblHoaDonMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
        );

        jLabel2.setText("Hóa đơn");

        jLabel3.setText("Hóa đơn chi tiết");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tblHoaDonChiTiet.setBackground(new java.awt.Color(204, 255, 255));
        tblHoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblHoaDonChiTiet);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
        );

        btnExcel.setText("Xuất Excel");
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 1105, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(47, 47, 47)
                                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(35, 35, 35))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnExcel)
                                .addGap(92, 92, 92)))
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(90, 90, 90)
                        .addComponent(btnExcel)
                        .addGap(34, 34, 34))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbbTThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTThaiActionPerformed

    }//GEN-LAST:event_cbbTThaiActionPerformed

    private void tblHoaDonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMousePressed
        // TODO add your handling code here:
        String maHD = (String) tableModelHoaDon.getValueAt(tblHoaDon.getSelectedRow(), 0);
        System.out.println(maHD);
        arrayListHoaDonChiTiet = getHoaDonChiTiets(arrayListHoaDonChiTiet, maHD);
        fillToTableHDCT(arrayListHoaDonChiTiet);
    }//GEN-LAST:event_tblHoaDonMousePressed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        if (txtTimKiem.getText().length() == 0) {
            getData();
        } else {
            String maHd = txtTimKiem.getText();
            ArrayList<Models.HoaDon> listHd = hoaDon_Dao.TimKiem(maHd);

            tableModelHoaDon.setRowCount(0);
            for (Models.HoaDon hd : listHd) {
                tableModelHoaDon.addRow(new Object[]{hd.getMaHD(), hd.getMaNV(), hd.getMaKH(), hd.getDChi(), hd.getSDT(), hd.getNgayTao(), hd.getNgayThanhToan(), hd.getTongTien(), hd.getTienLai(), hd.isHinhThucThanhToan() ? "Trực Tiếp" : "Chuyển Khoản", hd.isTrangThai() ? "Đã Thanh Toán" : "Đã Hủy", hd.isDangGiaoHang() ? "Giao Hàng" : "Trực Tiếp", hd.getGhiChu()});
//                System.out.println("test " + listHd);
            }
        }
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void txtTimKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusGained

    }//GEN-LAST:event_txtTimKiemFocusGained

    private void txtTimKiemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusLost

    }//GEN-LAST:event_txtTimKiemFocusLost

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed

        if (DateNgayTao.getDate() == null && DateNgayThanhToan.getDate() == null) {
            filterNoDate();
        } else {
            if (DateNgayTao.getDate() == null) {
                getData();
                JOptionPane.showMessageDialog(this, "ngày bắt đầu không được trống -- MỜI NHẬP LẠI NGÀY BẮT ĐẦU VÀ NGÀY KẾT THÚC");
                DateNgayTao.setBackground(Color.ORANGE);
                DateNgayTao.requestFocus();
            } else if (DateNgayThanhToan.getDate() == null) {
                getData();
                JOptionPane.showMessageDialog(this, "ngày kết thúc không được trống -- MỜI NHẬP LẠI NGÀY BẮT ĐẦU VÀ NGÀY KẾT THÚC");
                DateNgayThanhToan.setBackground(Color.ORANGE);
                DateNgayThanhToan.requestFocus();
            } else if (DateNgayTao.getDate().getTime() > DateNgayThanhToan.getDate().getTime()) {
                getData();
                JOptionPane.showMessageDialog(this, "Ngày bắt đầu không được quá ngày kết thúc");
                DateNgayThanhToan.setBackground(Color.ORANGE);
                DateNgayTao.setBackground(Color.ORANGE);
            } else {
                filterAll();
                DateNgayThanhToan.setBackground(null);
                DateNgayTao.setBackground(null);
            }
        }
        tableModelHoaDonChiTiet.setRowCount(0);
        clear();
    }//GEN-LAST:event_btnLocActionPerformed

    private void cbbThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbThanhToanActionPerformed

    }//GEN-LAST:event_cbbThanhToanActionPerformed

    private void cbbHinhBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbHinhBanHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbHinhBanHangActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("dd-MM-yyy" + "__" + "hh:mm:ss");
        String format = simpleDateFormat.format(date);
        try {
            //https://stackoverflow.com/questions/3148535/how-to-read-excel-cell-having-date-with-apache-poi
//            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat();
//            simpleDateFormat.applyPattern("dd-MM-yyy" + "__" + "hh:mm:ss");
//            String ngayTao = simpleDateFormat2.format(h);

            XSSFWorkbook wordkbook = new XSSFWorkbook();
            XSSFSheet sheet = wordkbook.createSheet("thongke");
            XSSFRow row = null;
            XSSFRow row2 = null;
            XSSFCell cell = null;

            row2 = sheet.createRow(1);
            cell = row2.createCell(0);
            cell.setCellValue("THỐNG KÊ HÓA ĐƠN " + "[Thời gian " + format + "]");

            row = sheet.createRow(3); //tạo ở hàng thứ 3
            DataFormatter dataFormatter = new DataFormatter();

            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Mã hóa đơn");
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Mã nhân viên");
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Mã khách hàng");
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Địa chỉ");
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Số điện thoại");
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Ngày tạo");
            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("Ngày thanh toán");
            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue("Tổng tiền");
            cell = row.createCell(9, CellType.STRING);
            cell.setCellValue("Tiền lãi");
            cell = row.createCell(10, CellType.STRING);
            cell.setCellValue("Thanh toán");
            cell = row.createCell(11, CellType.STRING);
            cell.setCellValue("Trạng Thái");
            cell = row.createCell(12, CellType.STRING);
            cell.setCellValue("Bán Hàng");
            cell = row.createCell(13, CellType.STRING);
            cell.setCellValue("Ghi chú");

            for (int i = 0; i < arrayListHoaDon.size(); i++) {
                Models.HoaDon hd = arrayListHoaDon.get(i);
                row = sheet.createRow(4 + i);

                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(i + 1);
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(arrayListHoaDon.get(i).getMaHD());
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(arrayListHoaDon.get(i).getMaNV());
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(arrayListHoaDon.get(i).getMaKH());
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(arrayListHoaDon.get(i).getDChi());
                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(arrayListHoaDon.get(i).getSDT());
                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(arrayListHoaDon.get(i).getNgayTao());
                cell = row.createCell(7, CellType.STRING);
                String cellStringValue = dataFormatter.formatCellValue(row.getCell(6));
                System.out.println("check date++" + cellStringValue);
                cell.setCellValue(arrayListHoaDon.get(3).getNgayThanhToan());
                cell = row.createCell(8, CellType.STRING);
                cell.setCellValue(arrayListHoaDon.get(i).getTongTien());
                cell = row.createCell(9, CellType.STRING);
                cell.setCellValue(arrayListHoaDon.get(i).getTienLai());
                cell = row.createCell(10, CellType.STRING);
                cell.setCellValue(arrayListHoaDon.get(i).isHinhThucThanhToan() ? "Trực Tiếp" : "Chuyển Khoản");
                cell = row.createCell(11, CellType.STRING);
                cell.setCellValue(arrayListHoaDon.get(i).isTrangThai() ? "Đã Thanh Toán" : "Đã Hủy");
                cell = row.createCell(12, CellType.STRING);
                cell.setCellValue(arrayListHoaDon.get(i).isDangGiaoHang() ? "Giao Hàng" : "Trực Tiếp");
                cell = row.createCell(13, CellType.STRING);
                cell.setCellValue(arrayListHoaDon.get(i).getGhiChu());
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
            } else if (values == JFileChooser.ERROR_OPTION) {
                System.out.println("Lỗi!");
            } else if (file == null) {
                JOptionPane.showMessageDialog(this, "Không có file nào được lưu");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnExcelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateNgayTao;
    private com.toedter.calendar.JDateChooser DateNgayThanhToan;
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnLoc;
    private javax.swing.JComboBox<String> cbbHinhBanHang;
    private javax.swing.JComboBox<String> cbbTThai;
    private javax.swing.JComboBox<String> cbbThanhToan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblHoaDonChiTiet;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

    private void initTable() {
        String headerHoaDon[] = {"Mã hóa đơn", "Mã NV", "Mã KH", "Địa chỉ", "Số điện thoại", "Ngày tạo", "Ngày thanh toán", "Tổng tiền", "Tiền lãi", "Thanh toán", "Trạng thái", "Bán hàng", "Ghi chú"};
        String headerHoaDonChiTiet[] = {"Mã HDCT", "Mã SPCT", "Số lượng", "Giá tiền"};
        tableModelHoaDon = new DefaultTableModel(headerHoaDon, 0);
        tableModelHoaDonChiTiet = new DefaultTableModel(headerHoaDonChiTiet, 0);
        tblHoaDon.setModel(tableModelHoaDon);
        tblHoaDonChiTiet.setModel(tableModelHoaDonChiTiet);
        tblHoaDon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblHoaDonChiTiet.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void getData() {
        arrayListHoaDon = hoaDon_Dao.getAll();
        fillToTableHD(arrayListHoaDon);
    }

    private ArrayList<HoaDonChiTiet> getHoaDonChiTiets(ArrayList<HoaDonChiTiet> list, String maHD) {
        list = hoaDonChiTiet_Dao.getByHoaDon(maHD);
        return list;
    }

    private void fillToTableHDCT(ArrayList<HoaDonChiTiet> list) {
        tableModelHoaDonChiTiet.setRowCount(0);
        for (HoaDonChiTiet hoaDonChiTiet : list) {
            tableModelHoaDonChiTiet.addRow(new Object[]{
                hoaDonChiTiet.getMaHDCT(), hoaDonChiTiet.getMaSPCT(), hoaDonChiTiet.getSoLuong(), hoaDonChiTiet.getGiaTien()
            });
        }
    }

    private void fillToTableHD(ArrayList<Models.HoaDon> list) {
        tableModelHoaDon.setRowCount(0);
        for (Models.HoaDon hoaDon : list) {
            tableModelHoaDon.addRow(new Object[]{
                hoaDon.getMaHD(), hoaDon.getMaNV(), hoaDon.getMaKH(), hoaDon.getDChi(), hoaDon.getSDT(), hoaDon.getNgayTao(), hoaDon.getNgayThanhToan(), hoaDon.getTongTien(), hoaDon.getTienLai(), hoaDon.isHinhThucThanhToan() ? "Trực Tiếp" : "Chuyển Khoản", hoaDon.isTrangThai() ? "Đã Thanh Toán" : "Đã Hủy", hoaDon.isDangGiaoHang() ? "Giao Hàng" : "Trực Tiếp", hoaDon.getGhiChu()
            });
        }
    }

    private void fillHTTT() {
        ComBoHinhThucThanhToan.removeAllElements();
        String manghtTT[] = {"Tất cả", "Chuyển Khoản", "Trực Tiếp"};
        for (String httt : manghtTT) {
            ComBoHinhThucThanhToan.addElement(httt);
        }

        ComBoTrangThai.removeAllElements();
        String mangTT[] = {"Tất cả", "Đã hủy", "Đã Thanh Toán"};
        for (String tt : mangTT) {
            ComBoTrangThai.addElement(tt);
        }

        ComBoHinhThucBan.removeAllElements();
        String mangb[] = {"Tất cả", "Giao Hàng", "Trực Tiếp"};
        for (String btt : mangb) {
            ComBoHinhThucBan.addElement(btt);
        }
    }

    private void filterAll() {
        int tThai;
        int httThai;
        int htBanHang;
        if (cbbTThai.getSelectedIndex() == 0) {
            tThai = 2;
            System.out.println("tất cả");
        } else if (cbbTThai.getSelectedIndex() == 1) {
            tThai = 1;
            System.out.println("Đã hủy");
        } else {
            tThai = 0;
            System.out.println("Đã thanh toán");
        }
        System.out.println("------------");
        if (cbbHinhBanHang.getSelectedIndex() == 0) {
            htBanHang = 2;
            System.out.println("tất cả");
        } else if (cbbThanhToan.getSelectedIndex() == 1) {
            htBanHang = 1;
            System.out.println("Giao Hàng");
        } else {
            htBanHang = 0;
            System.out.println("Trực Tiếp");
        }
        System.out.println("------------");
        if (cbbThanhToan.getSelectedIndex() == 0) {
            httThai = 2;
            System.out.println("tất cả");
        } else if (cbbThanhToan.getSelectedIndex() == 1) {
            httThai = 1;
            System.out.println("Trực tiếp");
        } else {
            httThai = 0;
            System.out.println("Chuyển khoản");
        }

        Date ngayTao = DateNgayTao.getDate();
        Date KetThuc = DateNgayThanhToan.getDate();
        //--------------------------------

//        LocalDate ngayTao = LocalDate.parse("2022-03-26");
//        LocalDate KetThuc = LocalDate.parse("2022-04-20");
        //------------------------
        ArrayList<Models.HoaDon> listHd = hoaDon_Dao.select(tThai, httThai, htBanHang, ngayTao, KetThuc);
//        System.out.println("tren" + listHd);
        tableModelHoaDon.setRowCount(0);

        for (Models.HoaDon hd : listHd) {
            tableModelHoaDon.addRow(new Object[]{hd.getMaHD(), hd.getMaNV(), hd.getMaKH(), hd.getDChi(), hd.getSDT(), hd.getNgayTao(), hd.getNgayThanhToan(), hd.getTongTien(), hd.getTienLai(), hd.isHinhThucThanhToan() ? "Trực Tiếp" : "Chuyển Khoản", hd.isTrangThai() ? "Đã Thanh Toán" : "Đã Hủy", hd.isDangGiaoHang() ? "Giao Hàng" : "Trực Tiếp", hd.getGhiChu()});
//            System.out.println("trong" + listHd);
        }
//        System.out.println("ngoai" + listHd);

    }

    private void filterNoDate() {
        int tThai;
        int httThai;
        int htBanHang;
        if (cbbTThai.getSelectedIndex() == 0) {
            tThai = 2;
            System.out.println("tất cả");
        } else if (cbbTThai.getSelectedIndex() == 1) {
            tThai = 1;
            System.out.println("Đã hủy");
        } else {
            tThai = 0;
            System.out.println("Đã thanh toán");
        }
        System.out.println("------------");
        if (cbbHinhBanHang.getSelectedIndex() == 0) {
            htBanHang = 2;
            System.out.println("tất cả");
        } else if (cbbHinhBanHang.getSelectedIndex() == 1) {
            htBanHang = 1;
            System.out.println("Giao Hàng");
        } else {
            htBanHang = 0;
            System.out.println("Trực Tiếp");
        }
        System.out.println("------------");
        if (cbbThanhToan.getSelectedIndex() == 0) {
            httThai = 2;
            System.out.println("tất cả");
        } else if (cbbThanhToan.getSelectedIndex() == 1) {
            httThai = 1;
            System.out.println("Trực tiếp");
        } else {
            httThai = 0;
            System.out.println("Chuyển khoản");
        }

        ArrayList<Models.HoaDon> listHd = hoaDon_Dao.selectNoDate(tThai, httThai, htBanHang);
//        System.out.println("tren" + listHd);
        tableModelHoaDon.setRowCount(0);
        for (Models.HoaDon hd : listHd) {
            tableModelHoaDon.addRow(new Object[]{hd.getMaHD(), hd.getMaNV(), hd.getMaKH(), hd.getDChi(), hd.getSDT(), hd.getNgayTao(), hd.getNgayThanhToan(), hd.getTongTien(), hd.getTienLai(), hd.isHinhThucThanhToan() ? "Trực Tiếp" : "Chuyển Khoản", hd.isTrangThai() ? "Đã Thanh Toán" : "Đã Hủy", hd.isDangGiaoHang() ? "Giao Hàng" : "Trực Tiếp", hd.getGhiChu()});
//            System.out.println("trong" + listHd);
        }
//        System.out.println("ngoai" + listHd);
        DateNgayThanhToan.setBackground(null);
        DateNgayTao.setBackground(null);

    }

    private void clear() {
        txtTimKiem.setText("");
        cbbTThai.setSelectedIndex(0);
        cbbHinhBanHang.setSelectedIndex(0);
        cbbThanhToan.setSelectedIndex(0);
        DateNgayTao.setDate(null);
        DateNgayThanhToan.setDate(null);
    }

    void changeCard() {
        tableModelHoaDon.setRowCount(0);
        tableModelHoaDonChiTiet.setRowCount(0);
        getData();
        clear();
    }

}
