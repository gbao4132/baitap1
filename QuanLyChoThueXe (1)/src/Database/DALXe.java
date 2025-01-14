package Database;

import DataTransferObject.Xe;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import Interface.*;
import Process.*;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author PC
 */
public class DALXe {
    public List<Xe> layXe(){
        try {
            List<Xe> arr = new ArrayList<Xe>();
            String query = "SELECT * FROM xe";
            Connect.openConnection();
            Statement stmt = Connect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                String BienSo = rs.getString("BienSo");
                int SoCho = rs.getInt("SoCho");
                String LoaiXe = rs.getString("LoaiXe");
                Xe temp = new Xe(BienSo, SoCho, LoaiXe);
                arr.add(temp);
            }
            Connect.closeConnection();
            return arr;
        } catch (SQLException ex) {
            Logger.getLogger(DALXe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Xe> layXeTheoBienSo(String BienSoQ){
        try {
            List<Xe> arr = new ArrayList<Xe>();
            String query = String.format("SELECT * FROM xe WHERE BienSo = '%s'", BienSoQ);
            Connect.openConnection();
            Statement stmt = Connect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                String BienSo = rs.getString("BienSo");
                int SoCho = rs.getInt("SoCho");
                String LoaiXe = rs.getString("LoaiXe");
                Xe temp = new Xe(BienSo, SoCho, LoaiXe);
                arr.add(temp);
            }
            Connect.closeConnection();
            return arr;
        } catch (SQLException ex) {
            Logger.getLogger(DALXe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Xe> layXeTheoLoaiXe(String LoaiXeQ){
        try {
            List<Xe> arr = new ArrayList<Xe>();
            String query = String.format("SELECT * FROM xe WHERE LoaiXe LIKE %s + '%'", LoaiXeQ);
            Connect.openConnection();
            Statement stmt = Connect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                String BienSo = rs.getString("BienSo");
                int SoCho = rs.getInt("SoCho");
                String LoaiXe = rs.getString("LoaiXe");
                Xe temp = new Xe(BienSo, SoCho, LoaiXe);
                arr.add(temp);
            }
            Connect.closeConnection();
            return arr;
        } catch (SQLException ex) {
            Logger.getLogger(DALXe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Xe> layXeTheoSoCho(int SoChoQ){
        try {
            List<Xe> arr = new ArrayList<Xe>();
            String query = String.format("SELECT * FROM xe WHERE SoCho=%s", SoChoQ);
            Connect.openConnection();
            Statement stmt = Connect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                String BienSo = rs.getString("BienSo");
                int SoCho = rs.getInt("SoCho");
                String LoaiXe = rs.getString("LoaiXe");
                Xe temp = new Xe(BienSo, SoCho, LoaiXe);
                arr.add(temp);
            }
            Connect.closeConnection();
            return arr;
        } catch (SQLException ex) {
            Logger.getLogger(DALXe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void themXe(Xe xe){
        try {
            String query = String.format("INSERT INTO xe VALUES('%s', '%d', '%s')",
                    xe.getBienSo(),
                    xe.getSoCho(),
                    xe.getLoaiXe());
            Connect.openConnection();
            Statement stmt = Connect.conn.createStatement();
            stmt.execute(query);
            Connect.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DALXe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void suaXe(Xe xe) {
    String query = "UPDATE xe SET SoCho = ?, LoaiXe = ? WHERE BienSo = ?";
    try {
        Connect.openConnection(); // Mở kết nối

        // Sử dụng PreparedStatement
        PreparedStatement stmt = Connect.conn.prepareStatement(query);
        stmt.setInt(1, xe.getSoCho());      // Đặt giá trị cho SoCho
        stmt.setString(2, xe.getLoaiXe()); // Đặt giá trị cho LoaiXe
        stmt.setString(3, xe.getBienSo()); // Đặt giá trị cho BienSo

        // Thực hiện câu lệnh
        int affectedRows = stmt.executeUpdate();

        if (affectedRows > 0) {
            System.out.println("Cập nhật xe thành công!");
        } else {
            System.out.println("Không tìm thấy xe để cập nhật!");
        }

        stmt.close(); // Đóng PreparedStatement sau khi sử dụng
    } catch (SQLException ex) {
        Logger.getLogger(DALXe.class.getName()).log(Level.SEVERE, "Lỗi khi cập nhật xe", ex);
    } finally {
        Connect.closeConnection(); // Đóng kết nối
    }
}

    
    
    public void xoaXe(Xe xe) {
    String query = "DELETE FROM xe WHERE BienSo = ?";
    try {
        Connect.openConnection(); 

        PreparedStatement stmt = Connect.conn.prepareStatement(query);
        stmt.setString(1, xe.getBienSo()); // Đặt giá trị cho dấu ?

        int affectedRows = stmt.executeUpdate(); // Sử dụng executeUpdate cho DELETE

        if (affectedRows > 0) {
            System.out.println("Xóa xe thành công!");
        } else {
            System.out.println("Không tìm thấy xe để xóa!");
        }
    } catch (SQLException ex) {
        Logger.getLogger(DALXe.class.getName()).log(Level.SEVERE, "Lỗi khi xóa xe", ex);
    } finally {
        Connect.closeConnection(); // Đóng kết nối sau khi hoàn thành
    }
}

}
