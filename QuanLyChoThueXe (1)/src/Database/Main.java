package Database;

public class Main {
    public static void main(String[] args) {
        try {
            Connect.openConnection();

            if (Connect.conn != null && !Connect.conn.isClosed()) {
                System.out.println("Ket noi thanh cong!");
            } else {
                System.out.println("Ket noi that bai!");
            }
        } catch (Exception ex) {
            System.out.println("Loi: " + ex.getMessage());
        } 
    }
}