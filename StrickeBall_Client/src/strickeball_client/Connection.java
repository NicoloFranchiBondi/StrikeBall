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
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connection {
 
    int port = 2000;
    String messaggio;
    String send;
    public static final String ANSI_GREEN = "\u001B[32m";
    
    
    Connection(int port){
        this.port = port;   
    }
    
    public void connectionClient() {
        BufferedReader tastiera = null;
        PrintWriter out = null;
        Socket socket;
        BufferedReader in = null;
        try {
            socket = new Socket("localhost",port);
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            
            do{
            
     
            /*BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
            
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);*/
            System.out.println("Digitare messaggio da inviare al server");
            send = tastiera.readLine();
            out.println("Messaggio dal Client: "+send);
            messaggio = in.readLine();
            if(messaggio != null){
            System.out.println("Messaggio dal Server : " + messaggio);
            }else{System.out.println("Il server non ha risposto");}
            }while(!messaggio.equals("End") && !send.equals("End"));
            
        } catch (IOException ex) {
            System.err.println("Error opening socket");
        }
       
        
        try {
                in.close();
                out.close();
            } catch (IOException ex) {
                System.err.println("NNel Chiude");
            }
    }
}

