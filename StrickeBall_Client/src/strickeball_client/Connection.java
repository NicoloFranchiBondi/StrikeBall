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
 
    int port = 25000;
    String messaggio;
    
    
    Connection(){
        this.port = port;   
    }
    
    public void connectionClient() {
        try {
            Socket socket = new Socket("localhost",port);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            out.println("Ciao");
            messaggio = in.readLine();
            System.out.println("Messaggio dal Server : " + messaggio);
            
        } catch (IOException ex) {
            System.err.println("Error opening socket");
        }
    }
}

