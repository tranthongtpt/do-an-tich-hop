package Lap04_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;

/**
 * server_sumN
 */
public class server_sumN {
public static void main(String[] args) throws IOException{
    try (DatagramSocket serverSocket=new DatagramSocket(9999)){
        System.out.println("server da khoi dong");
        byte inFromClient[];
        inFromClient=new byte[100];
        int leng=inFromClient.length;
        DatagramPacket fromClient=new DatagramPacket(inFromClient, leng);
        serverSocket.receive(fromClient);
        String data;

        // nhan du lieu va tinh tong
        data=(new String(fromClient.getData(),0,leng)).trim();
        int value,tong,sum=0;
        value=Integer.parseInt(data);
        for(int i = 1; i <= value; i++) {
            sum += i;
        }
        data=String.valueOf(sum);
        byte outToClient[];
        outToClient=data.getBytes();
        leng=outToClient.length;
        InetAddress address=fromClient.getAddress();
        int port=fromClient.getPort();
        DatagramPacket toClient=new DatagramPacket(outToClient, leng,address,port);
        serverSocket.send(toClient);
        serverSocket.close();
        
    } catch (IOException err) {
        //TODO: handle exception
        System.out.println("dont creative server");
    }
}
}