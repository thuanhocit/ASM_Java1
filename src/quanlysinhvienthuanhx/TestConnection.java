/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysinhvienthuanhx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ASUS
 */
public class TestConnection {
    Connection conn; ///kết nối sql
    Statement stm; /// chậy lệnh sql
    ResultSet rs; ///kết quả dẫn đến sau nhập liệu
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
       
}
