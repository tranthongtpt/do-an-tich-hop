
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9999)) {
            System.out.println("Server đã khởi động");
            try (Socket client = server.accept()) {
                System.out.println("Đã kết nối thành công với Client");
                //sc: đọc dữ liệu ở Socket Client
                //pw: ghi dữ liệu lên Socket Client
                try (Scanner sc = new Scanner(client.getInputStream()); 
                        PrintWriter pw = new PrintWriter(client.getOutputStream())) {
                    String str1 = sc.nextLine();
                    String str2 = sc.nextLine();
                    String str3 = sc.nextLine();
                    //Server nhận chuỗi từ Client
                    double a = Double.parseDouble(str1);
                    double b = Double.parseDouble(str2);
                    double c = Double.parseDouble(str3);
                    //thực hiện công việc
                    String kq = giaiPTBac2(a, b, c);
                    //trả kết quả về client                    
                    pw.write(kq+"\n");
                    pw.flush();
                    sc.close();
                    pw.close();
                    server.close();
                }
            }
        }
    }

    public static String giaiPTBac2(double a, double b, double c) {
        String kq = "";
        double delta = b * b - 4 * a * c;
        double x1, x2;
        if (a == 0) {
            if (b == 0 && c == 0) {
                kq = "Phương trình vô số nghiệm!";
            } else if (b == 0) {
                kq = "Phương trình vô nghiệm!";
            } else {
                kq = "Phương trình có 1 nghiệm: " + "x = " + (-c / b);
            }
        } else if (delta > 0) {
            x1 = (double) ((-b + Math.sqrt(delta)) / (2 * a));
            x2 = (double) ((-b - Math.sqrt(delta)) / (2 * a));
            kq = "Phương trình có 2 nghiệm là: " + "x1 = " + x1 + " và x2 = " + x2;            
        } else if (delta == 0) {
            x1 = (-b / (2 * a));
            kq = "Phương trình có nghiệm kép: " + "x1 = x2 = " + x1;            
        } else {
            kq = "Phương trình vô nghiệm!";
        }
        return kq;
    }
}
