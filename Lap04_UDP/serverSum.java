package Lap04_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.zip.DataFormatException;

public class serverSum {
     public static void main(String[] args) throws IOException{
        //b1: tao socket server 
        try(DatagramSocket serverSocket=new DatagramSocket(9999)) {
            System.out.println("server da khoi dong");
            //b2:tao mang byte de chua du lieu goi len tu client
        byte inFromClient1[];
        inFromClient1=new byte[100];
        byte inFromClient2[];
        inFromClient2=new byte[100];
        //lay kich thuoc mang
        int leng1=inFromClient1.length;
        int leng2=inFromClient2.length;
        //dong goi mang byte dc nhan du lieu tu client
        DatagramPacket fromClient1=new DatagramPacket(inFromClient1, leng1); 
        DatagramPacket fromClient2=new DatagramPacket(inFromClient2, leng2); 
        //b3 nhan goi tu client goi ve tu server
        serverSocket.receive(fromClient1);
        serverSocket.receive(fromClient2);
        String data1,data2;
        //b4: nhan du lieu va tinh tong
        // lay du lieu vao bien data
        data1=(new String(fromClient1.getData(),0,leng1)).trim();
        data2=(new String(fromClient2.getData(),0,leng2)).trim();
            int a,b,tong;
            a=Integer.parseInt(data1);
            b=Integer.parseInt(data2);
            // xu ly yeu cau
            tong=a+b;
            //b5: chuyen du lieu tu kieu int -> string va truyen vao bien data
            data1=String.valueOf(tong);//data chuoi chua tong a+b
            //dong goi ket qua
            byte outToClient[];
            outToClient=data1.getBytes();//chuyen chuoi ve amng  byte
            //lay kich thuoc mang
            leng1=outToClient.length;
            //laydia chi cua client, no nam luo trong goi da gui len server
            InetAddress addresss=fromClient1.getAddress();
            //aly so port cua client
            int port=fromClient1.getPort();
            //tao goi de gui ve client
            DatagramPacket toClient=new DatagramPacket(outToClient, leng1,addresss,port);
            //gui oi ve client
            serverSocket.send(toClient);
            serverSocket.close();
        } //ket thuc try 1 
        catch (IOException err) {
            //TODO: handle exception
            System.out.println("ko tao dc server");
        }
    }
    
}//ket thuc class
