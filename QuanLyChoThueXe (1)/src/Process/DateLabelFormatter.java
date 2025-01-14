/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;
import java.text.SimpleDateFormat;
import javax.swing.text.DateFormatter;

/**
 *
 * @author Admin
 */
public class DateLabelFormatter extends DateFormatter {
    public DateLabelFormatter() {
        super(new SimpleDateFormat("yyyy-MM-dd"));
    }
}
