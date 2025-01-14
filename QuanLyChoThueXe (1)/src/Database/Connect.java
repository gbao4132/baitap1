
package Database;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author PC
 */
public class Connect {
    public static Connection conn = null;
    private static String user = "root";
    private static String password = "gbao4132";


    public static void openConnection() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connect.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QuanLyChoThueXe", Connect.user, Connect.password);
//            System.out.println("Ket noi CSDL thanh cong");
            
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
    
    public static void closeConnection(){
        try{
            Connect.conn.close();
//            System.out.println("Dong ket noi CSDL thanh cong");
            
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    } 
}
