/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strickeball_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Connection {
 
    int port = 2000;
    String messaggio;
    String send;
    public static final String ANSI_GREEN = "\u001B[32m";
    
    
    Connection(int port){
        this.port = port;   
    }
    
    public void connectionClient() {
        do{
        try {
            BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
            Socket socket = new Socket("localhost",port);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            System.out.println("Digitare messaggio da inviare al server");
            send = tastiera.readLine();
            out.println("Messaggio dal Client");
            messaggio = in.readLine();
            System.out.println("Messaggio dal Server : " + messaggio);
            
        } catch (IOException ex) {
            System.err.println("Error opening socket");
        }
        }while(!messaggio.equals("End") && !send.equals("End"));
    }
}

