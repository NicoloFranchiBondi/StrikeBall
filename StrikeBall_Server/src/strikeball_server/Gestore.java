/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strikeball_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nico
 */
public class Gestore implements Runnable{
    
    Socket s;
    BufferedReader in = null;
    PrintWriter out = null;  
    String send;
    String receive;
    BufferedReader tastiera = null;
    
    public Gestore(Socket s) throws IOException{
       
       tastiera = new BufferedReader(new InputStreamReader(System.in));
       in = new BufferedReader(new InputStreamReader(s.getInputStream()));
       out = new PrintWriter(s.getOutputStream(),true);
        this.s = s; 
    }
    @Override
    public void run() {
        
        
        try {
            do{

                receive = in.readLine();
                System.out.println("Client message: " + receive);
                System.out.println("Inserire il messaggio da inviare");
                send = tastiera.readLine();
                out.println("Server message: "+send);
            
            
            }while(!receive.equals("End") && !send.equals("End"));
            
            
        } catch (IOException ex) {
            Logger.getLogger(Gestore.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
            try {
                in.close();
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(Gestore.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
   
    
}
