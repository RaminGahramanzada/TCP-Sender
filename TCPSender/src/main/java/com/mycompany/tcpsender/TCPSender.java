/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.tcpsender;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import util.FileUtil;

/**
 *
 * @author Lenovo
 */
public class TCPSender {
   
  
      
  
    public static void main(String[] args)throws IOException,Exception {
        SenderMenu u  = new SenderMenu();
        
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter  your name:");
        String s =u.name = scan.nextLine();
        System.out.println("Enter your surname:");
        String surname = scan.nextLine();
       
            System.out.println("Enter your file path:");
            u.fpath = scan.nextLine();
            System.out.println("Enter server ip and port:");
            u.serverip= scan.nextLine();
            String[] arr = u.serverip.split(":");
            u.ip = arr[0];
            u.port= Integer.parseInt(arr[1]);
            System.out.println(u.ip+","+u.port+","+u.fpath);
            
             Socket socket = new Socket(u.ip,u.port);
       
       OutputStream outputStream = socket.getOutputStream();
       DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
       //fayli goturmek istediyimiz yeri qeyd edirik
        byte[] bytes= FileUtil.readBytes(u.fpath);
       
        dataOutputStream.writeInt(bytes.length);
        dataOutputStream.write(bytes);
        System.out.println("Message send succesfully!");
       
       socket.close();
        
      
    }
  

}
