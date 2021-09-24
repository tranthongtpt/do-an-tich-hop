import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * sum_server
 */
public class sum_server {

     public static void main(String[] args) throws IOException {
     try (ServerSocket server=new ServerSocket(9999)){
         System.out.println("server dang hoat dong");
         Socket client=server.accept();
         System.out.println("ket noi thanh cong");
         Scanner br;
         try (PrintWriter pw=new PrintWriter(client.getOutputStream())){
             br=new Scanner(client.getInputStream());
             // xu ly yeu cau client
             String st=br.nextLine();
             String arr[]=st.split(";");
             int a=Integer.parseInt(arr[0]);
             int b=Integer.parseInt(arr[1]);
             int kq=tong1(a,b);
             //goi ket qua cho client
             pw.write(String.valueOf(kq));
             pw.write("\n");
             pw.flush();
             //dong ket noi
         } 
         br.close();
         server.close();   
         }
    }
        public static int tong1(int a,int b) {
            return 3*a+2*b;
        }
}