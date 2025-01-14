package Database;

import DataTransferObject.TaiKhoan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class DALTaiKhoan {
    
    public List<TaiKhoan> getListTaiKhoan(){
        try {
            List<TaiKhoan> arr = new ArrayList<TaiKhoan>();
            String query = "SELECT * FROM tai_khoan";
            Connect.openConnection();
            Statement stmt = Connect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                String TenDangNhap = rs.getString("TenDangNhap");
                String MatKhau = rs.getString("MatKhau");
                String Loai = rs.getString("Loai");
                TaiKhoan temp = new TaiKhoan(TenDangNhap, MatKhau, Loai);
                arr.add(temp);
            }
            Connect.closeConnection();
            return arr;
        } catch (SQLException ex) {
            Logger.getLogger(DALKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
    public List<TaiKhoan> timTaiKhoan(String TenDangNhapQ){
        try {
            List<TaiKhoan> arr = new ArrayList<TaiKhoan>();
            String query = String.format("SELECT * FROM tai_khoan WHERE TenDangNhap LIKE '%%%s%%'", TenDangNhapQ);
            Connect.openConnection();
            Statement stmt = Connect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                String TenDangNhap = rs.getString("TenDangNhap");
                String MatKhau = rs.getString("MatKhau");
                String Loai = rs.getString("Loai");
                TaiKhoan temp = new TaiKhoan(TenDangNhap, MatKhau, Loai);
                arr.add(temp);
            }
            Connect.closeConnection();
            return arr;
        } catch (SQLException ex) {
            Logger.getLogger(DALKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
    public void themTaiKhoan(TaiKhoan taiKhoan) throws SQLException{
        String query = String.format("INSERT INTO tai_khoan VALUES('%s', '%s', '%s')",
                taiKhoan.getTenDangNhap(),
                taiKhoan.getMatKhau(),
                taiKhoan.getLoai());
        Connect.openConnection();
        Statement stmt = Connect.conn.createStatement();
        stmt.execute(query);
        Connect.closeConnection();
    }
    
    public void xoaTaiKhoan(String taiKhoan) throws SQLException{
        String query = String.format("DELETE FROM tai_khoan where TenDangNhap='%s'", taiKhoan);
        Connect.openConnection();
        Statement stmt = Connect.conn.createStatement();
        stmt.execute(query);
        Connect.closeConnection();
    }
    
    public void suaTaiKhoan(TaiKhoan acc) throws SQLException{
        String query = String.format("UPDATE tai_khoan SET MatKhau='%s', Loai='%s' where TenDangNhap='%s'",
                acc.getMatKhau(),
                acc.getLoai(),
                acc.getTenDangNhap());
       Connect.openConnection();
       Statement stmt = Connect.conn.createStatement();
       stmt.execute(query);
       Connect.closeConnection();
    }
    
}
