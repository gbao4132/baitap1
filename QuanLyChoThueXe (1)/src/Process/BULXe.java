/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;
import Database.DALXe;
import DataTransferObject.Xe;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author PC
 */
public class BULXe {
    DALXe dalXe = new DALXe();
    
    public List<Xe> layXe(){
        return dalXe.layXe();
    }
    
    public List<Xe> layXeTheoBienSo(String BienSo){
        return dalXe.layXeTheoBienSo(BienSo);
    }
    
    public List<Xe> layXeTheoLoaiXe(String LoaiXe){
        return dalXe.layXeTheoLoaiXe(LoaiXe);
    }
    
    public List<Xe> layXeTheoSoCho(int SoCho){
        return dalXe.layXeTheoSoCho(SoCho);
    }
    
    public void themXe(Xe xe) throws SQLException{
        dalXe.themXe(xe);
    }
    
    public void suaXe(Xe xe) throws SQLException{
        dalXe.suaXe(xe);
    }
        
    public void xoaXe(Xe xe) throws SQLException{
        dalXe.xoaXe(xe);
    }
}
