/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;
import Database.DALKhachHang;
import DataTransferObject.KhachHang;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author PC
 */
public class BULKhachHang {
    DALKhachHang dalKhachHang = new DALKhachHang();
    
    public List<KhachHang> layKhachHang(){
        return dalKhachHang.layKhachHang();
    }
    
    public List<KhachHang> layKhachHangTheoMa(int MaKH){
        return dalKhachHang.layKhachHangTheoMa(MaKH);
    }
    
    public List<KhachHang> layKhachHangTheoTen(String HoTen){
        return dalKhachHang.layKhachHangTheoTen(HoTen);
    }
    
    public void themKhachHang(KhachHang khachHang) throws SQLException{
        dalKhachHang.themKhachHang(khachHang);
    }
    
    public void suaKhachHang(KhachHang khachHang) throws SQLException{
        dalKhachHang.suaKhachHang(khachHang);
    }
        
    public void xoaKhachHang(int MaKHQ) throws SQLException{
        dalKhachHang.xoaKhachHang(MaKHQ);
    }
}
