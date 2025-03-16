/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package IU;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class QuanLySinhVien extends javax.swing.JFrame {

     Connection conn; ///kết nối sql
    Statement stm; /// chậy lệnh sql
    ResultSet rs; ///kết quả dẫn đến sau nhập liệu
    DefaultTableModel model; //chứa dữ liệu bảng

    /**
     * Creates new form QuanLySinhVien
     */
    public QuanLySinhVien() {
        initComponents();
        setLocationRelativeTo(null);
        ketNoi();
         model = (DefaultTableModel) tblDsSinhVien.getModel();
        sqlServer2table();
        xoaForm();
        //
        //saveStudent();
//        insertStudent();
    }

    void sqlServer2table() {
    try {
        String sql = "SELECT * FROM STUDENTS ORDER BY MaSV";
        rs = stm.executeQuery(sql); ////chạy lệnh đổ dữ liệu trả về 
        DefaultTableModel model = (DefaultTableModel) tblDsSinhVien.getModel();
        model.setRowCount(0); // Xóa tất cả các dòng hiện có trong bảng
        
        while (rs.next()) {
            String maSV = rs.getString("MaSV");
            String hoTen = rs.getString("Hoten");
            String email = rs.getString("Email");
            String soDT = rs.getString("SoDT");
            String gioiTinh = rs.getBoolean("Gioitinh") ? "Nam" : "Nữ"; // Chuyển giới tính thành chuỗi "Nam" hoặc "Nữ"
            String diaChi = rs.getString("Diachi");
            String hinh = rs.getString("Hinh");
            
            // Thêm dòng dữ liệu mới vào bảng
            model.addRow(new Object[]{maSV, hoTen, email, soDT, gioiTinh, diaChi, hinh});
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
//void saveStudent() {
//    try {
//        // Lấy dữ liệu từ các trường nhập liệu
//        String maSV = txtMaSV.getText();
//        String hoTen = txtHoTen.getText();
//        String email = txtEmail.getText();
//        String soDT = txtSDT.getText();
//        int gioiTinh = rdoNam.isSelected() ? 1 : 0; // Chuyển đổi giá trị boolean thành 1 hoặc 0
//        String diaChi = txtDiaChi.getText();
//        String hinh = ""; // Bạn cần cung cấp cách để lấy đường dẫn của hình ảnh từ giao diện
//        
//        // Tạo câu lệnh SQL INSERT
//        String sql = "INSERT INTO STUDENTS (MaSV, Hoten, Email, SoDT, Gioitinh, Diachi, Hinh) "
//                   + "VALUES ('" + maSV + "', '" + hoTen + "', '" + email + "', '" + soDT + "', "
//                   + gioiTinh + ", '" + diaChi + "', '" + hinh + "')";
//
//        // Thực thi câu lệnh INSERT
//        int rowsAffected = stm.executeUpdate(sql);
//        
//        if (rowsAffected > 0) {
//            // Thêm sinh viên mới vào bảng hiển thị
//            DefaultTableModel model = (DefaultTableModel) tblDsSinhVien.getModel();
//            model.addRow(new Object[]{maSV, hoTen, email, soDT, gioiTinh == 1 ? "Nam" : "Nữ", diaChi, hinh});
//            
//            // Xóa dữ liệu trong các trường nhập liệu sau khi thêm thành công
//            txtMaSV.setText("");
//            txtHoTen.setText("");
//            txtEmail.setText("");
//            txtSDT.setText("");
//            txtDiaChi.setText("");
//            // Xóa chọn radio button
//            buttonGroup1.clearSelection();
//            
//            // Hiển thị thông báo thành công
//            JOptionPane.showMessageDialog(btnSave, "Thêm sinh viên thành công!");
//        } else {
//            JOptionPane.showMessageDialog(btnSave, "Thêm sinh viên thất bại!");
//        }
//    } catch (Exception e) {
//        e.printStackTrace();
//        JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
//    }
//}



     void xoaForm(){
        txtMaSV.setText("");
        txtHoTen.setText("");
        txtEmail.setText("");
        txtSDT.setText("");
        rdoNam.setSelected(rootPaneCheckingEnabled);
        txtDiaChi.setText("");
    }
      void ketNoi(){
          String url;
        try {
            url = "jdbc:sqlserver://localhost:1433;databaseName=Fpoly_QLSV;user=thuan;password=123456;encrypt=false";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Đã Tải Driver");
            conn = DriverManager.getConnection(url);
             stm = conn.createStatement();
           // String sql = "select * from SinhVien";
          System.out.println("Kết nối ok ");
            //3 sua
             
            
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Kết nối thất bại: " + ex.getMessage());
        }
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDsSinhVien = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        lblHinh = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        txtDiaChi = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ SINH VIÊN");

        tblDsSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SV", "Họ tên", "Email", "Số ĐT", "Giới tính", "Địa Chỉ", "Hình"
            }
        ));
        tblDsSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDsSinhVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDsSinhVien);

        jLabel2.setText("Mã Sinh Viên:");

        jLabel3.setText("Họ tên:");

        jLabel4.setText("Email:");

        jLabel5.setText("Số ĐT:");

        jLabel6.setText("Giới Tính");

        jLabel7.setText("Địa chỉ:");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        lblHinh.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 0)));

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(135, 135, 135))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5)))
                        .addGap(8, 8, 8))
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtEmail)
                    .addComponent(txtMaSV)
                    .addComponent(txtHoTen)
                    .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rdoNam)
                        .addGap(18, 18, 18)
                        .addComponent(rdoNu))
                    .addComponent(txtDiaChi))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDelete)
                                .addGap(45, 45, 45)
                                .addComponent(btnUpdate))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNew)
                                .addGap(45, 45, 45)
                                .addComponent(btnSave)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(rdoNam)
                            .addComponent(rdoNu))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(85, 85, 85))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNew)
                            .addComponent(btnSave))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete)
                            .addComponent(btnUpdate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblDsSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDsSinhVienMouseClicked
        // TODO add your handling code here:
        int hangduocchon = tblDsSinhVien.getSelectedRow();
    // Lấy giá trị từ model
    Object MaSVObject = model.getValueAt(hangduocchon, 0);
    Object HotenObject = model.getValueAt(hangduocchon, 1);
    Object EmailObject = model.getValueAt(hangduocchon, 2);
    Object SoDTObject = model.getValueAt(hangduocchon, 3);
    Object GioiTinhObject = model.getValueAt(hangduocchon, 5);
    Object DiachiObject = model.getValueAt(hangduocchon, 6);
    //Object HinhObject = model.getValueAt(hangduocchon, 7);
    
     if (MaSVObject instanceof String) {
        txtMaSV.setText((String) MaSVObject);
    } else {
        txtMaSV.setText("");
    }
     if (HotenObject instanceof String) {
        txtHoTen.setText((String) HotenObject);
    } else {
        txtHoTen.setText("");
    }
     if (EmailObject instanceof String) {
        txtEmail.setText((String) EmailObject);
    } else {
        txtEmail.setText("");
    }
     if (SoDTObject instanceof String) {
        txtSDT.setText((String) SoDTObject);
    } else {
        txtSDT.setText("");
    }
     rdoNam.setSelected(rootPaneCheckingEnabled);
      if (DiachiObject instanceof String) {
        txtDiaChi.setText((String) DiachiObject);
    } else {
        txtDiaChi.setText("");
    }
     lblHinh.setText(model.getValueAt(hangduocchon, 0).toString());

        sqlServer2table();
    }//GEN-LAST:event_tblDsSinhVienMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
          String maSV = txtMaSV.getText();
        String hoTen = txtHoTen.getText();
        String email = txtEmail.getText();
        String soDT = txtSDT.getText();
        int gioiTinh = rdoNam.isSelected() ? 1 : 0; // Chuyển đổi giá trị boolean thành 1 hoặc 0
        String diaChi = txtDiaChi.getText();
        String hinh = ""; 
        try{
             String them =  "INSERT INTO STUDENTS VALUES(?,?,?,?,?,?,?)";
             PreparedStatement pre = conn.prepareStatement(them);
             pre.setString(1, maSV);
             pre.setString(2, hoTen);
             pre.setString(3, email);
             pre.setString(4, soDT);
             pre.setInt(5, gioiTinh);
             pre.setString(6, diaChi);
             pre.setString(7, hinh);
             int r = pre.executeUpdate();
             JOptionPane.showMessageDialog(this, "Da Them" +r+"Sinh Vien");
        }catch(Exception e){
            e.printStackTrace();
        }
         xoaForm();
        
        sqlServer2table();
      
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        xoaForm();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int id =0;
        try{
          id=  Integer.parseInt(txtMaSV.getText());
        } catch (Exception e) {
              System.out.println("Loi  " + e);
        }
        
        //2. chạy sql 
        try {
            String sql ="DELETE STUDENTS WHERE MaSV=?";
            PreparedStatement pStm = conn.prepareStatement(sql);
            pStm.setInt(1, id);
            int r = pStm.executeUpdate();
            JOptionPane.showMessageDialog(this,"Đã xóa "+r+" sinh viên" );
            sqlServer2table();
            xoaForm();
        } catch (Exception e) {
              System.out.println("Loi  " + e);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:   
        String maSV = txtMaSV.getText();
        String hoTen = txtHoTen.getText();
        String email = txtEmail.getText();
        String soDT = txtSDT.getText();
        int gioiTinh = rdoNam.isSelected() ? 1 : 0; // Chuyển đổi giá trị boolean thành 1 hoặc 0
        String diaChi = txtDiaChi.getText();
        String hinh = ""; 
        try{
             String them =  "UPDATE STUDENTS set Hoten=?, Email=?, SoDT=?, Gioitinh=?,"
                     + "Diachi=?, Hinh=? where MaSV=? ";
             PreparedStatement pre = conn.prepareStatement(them);
             
             pre.setString(1, hoTen);
             pre.setString(2, email);
             pre.setString(3, soDT);
             pre.setInt(4, gioiTinh);
             pre.setString(5, diaChi);
             pre.setString(6, hinh);
             pre.setString(7, maSV);
             int r = pre.executeUpdate();
             JOptionPane.showMessageDialog(this, "Da Sua" +r+"Sinh Vien");
        }catch(Exception e){
            e.printStackTrace();
        }
         xoaForm();
        
        sqlServer2table();
    }//GEN-LAST:event_btnUpdateActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLySinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLySinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLySinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLySinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLySinhVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblDsSinhVien;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtSDT;
    // End of variables declaration//GEN-END:variables
}
