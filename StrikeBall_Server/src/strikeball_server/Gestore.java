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
           
    
    public Gestore(Socket s){
       //this.s = new Socket();
        this.s = s; 
    }
    @Override
    public void run() {
        BufferedReader in = null;
        try {
            in = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));
            PrintWriter out =
                    new PrintWriter(s.getOutputStream(),true);
            String messaggio = in.readLine();
            System.out.println("Client message: " + messaggio);
            out.println("Server message");
        } catch (IOException ex) {
            Logger.getLogger(Gestore.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(Gestore.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
   
    
}
