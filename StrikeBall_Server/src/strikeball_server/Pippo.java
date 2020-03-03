/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strikeball_server;

import static java.lang.Thread.sleep;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nico
 */
public class Pippo implements Runnable{
    private boolean connected=false;
    private Socket s;
    public Pippo(Socket s){
        this.s=s;
    }
    
    
    @Override
    public void run() {
        
        
        for(int i=5;i>0 ;i--) {
            
            try {
                
                sleep(1000);
                System.out.print((i)+" ");
            } catch (InterruptedException ex) {
               System.out.println("Eccezione");
              }
            }
          
        }
       
        
        
    
    
 

}

    

