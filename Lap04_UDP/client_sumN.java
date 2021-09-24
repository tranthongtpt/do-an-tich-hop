package Lap04_UDP;
import java.util.Random;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
public class client_sumN {
    public static void main(String[] args) throws IOException{
        try {
            //b1: tao socket tren client
            DatagramSocket ClientSocket = new DatagramSocket();
            System.out.println("client da connect with server");
           
            try {
                DataInputStream inFromUser=new DataInputStream(System.in);
                Random generator = new Random();
                int max=100,min=10;
                int value =generator.nextInt((max-min)+1)+min;
                //System.out.print("random: "+n);
                byte outToClient1[];
                String s1=String.valueOf(value);
                outToClient1=s1.getBytes();
                int leng=outToClient1.length;
                InetAddress address=InetAddress.getByName("LocalHost");
                int port=9999;

                DatagramPacket toServer=new DatagramPacket(outToClient1, leng,address,port);
                ClientSocket.send(toServer);

                /////// goi roi chu nhan ve
                byte inFromServer[]=new byte[100];
                leng=inFromServer.length;
                DatagramPacket fromServer=new DatagramPacket(inFromServer, leng);
                ClientSocket.receive(fromServer);
                String data=(new String(fromServer.getData(),0,fromServer.getLength())).trim();
                System.out.println("ket qua "+data);
                ClientSocket.close();

            } //close try2 
                catch (UnknownHostException e) {
                    System.out.println("server ko tiim thay");
                    System.exit(1);
                //TODO: handle exception
            } 
        } catch (IOException e) {
            System.out.println("client disconnect with server");
            System.exit(1);
            //TODO: handle exception
        }
    }
}
