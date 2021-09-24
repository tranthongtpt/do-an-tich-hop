
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;


public class client {
    
    public static void main(String[] args) throws IOException {
        try (Socket client = new Socket("127.0.0.1", 9999)) {
            Scanner in = new Scanner(System.in);
            try (Scanner sc = new Scanner(client.getInputStream()); 
                PrintWriter pw = new PrintWriter(client.getOutputStream())) {
                System.out.println("Nhập a, b, c: ");                
                String str = in.nextLine();                
                String[] st = str.split(";");
                for (String s : st) {
                    pw.write(s+"\n");
                }                                
                pw.flush();
                String kq = sc.nextLine();
                System.out.println(kq);
                sc.close();
                in.close();
            }
            client.close();
        }
    }
}
