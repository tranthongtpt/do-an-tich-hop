import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class sum_client {
    public static void main(String[] args) throws IOException{
        //b1: tao socket
        Socket client1 =new Socket("127.0.0.1",9999);
        Socket client2 = new Socket("127.0.0.1",3333);
        Scanner in=new Scanner(System.in); /// doc du lieu tu ban phim
        Scanner br1=new Scanner(client1.getInputStream());//doc du lieu o socket client 1
        Scanner br2 = new Scanner(client2.getInputStream());// do du lieu o socket client2
        PrintWriter pw1=new PrintWriter(client1.getOutputStream());//ghi du lieu o socket client 1
        PrintWriter pw2=new PrintWriter(client2.getOutputStream());//ghi du lieu o socket client 2
        //b2 nhap chuoi tu ban phim
        System.out.println("nhap 3 so nguyen cach boi dau ; ");
        //b3: goi du lieu cho server 1 va server 2 
        String st=in.nextLine();
        //goi du lieu ho server1
        pw1.write(st);
        pw1.write("\n");
        pw1.flush();

         //goi du lieu ho server2
         pw1.write(st);
         pw1.write("\n");
         pw1.flush();
         
         // b4: nhan ket qua tra ve tu server1 va server2 
         String kq1=br1.nextLine();
         int sum1=Integer.parseInt(kq1);
         String kq2=br2.nextLine();
         int sum2=Integer.parseInt(kq2);
         int sum=2*sum1+4*sum2;
         //b5 in kq ra srceen
         System.out.println("s=2*(3a+2b)+4*(7c-8d)="+sum);
         //b6 ket thuc
         br1.close();
         pw1.close();
         in.close();
    }
        
}
