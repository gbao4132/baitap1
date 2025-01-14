/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;
import java.util.regex.Pattern;
/**
 *
 * @author Admin
 */
public class PasswordValidator {
      // Kiểm tra mật khẩu: ít nhất 8 ký tự và chứa ít nhất 1 chữ cái viết hoa
    public static boolean isValidPassword(String password) {
        // Biểu thức chính quy kiểm tra mật khẩu
        String regex = "^(?=.*[A-Z]).{8,}$"; // Ít nhất 1 chữ cái viết hoa và dài ít nhất 8 ký tự
        
        return Pattern.matches(regex, password);
    }
}
