/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strikeball_server;
import com.sun.corba.se.spi.activation.Server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Connection {
    ServerSocket serverSocket = null;
    int port;
    String messaggio;
    ArrayList<Thread> richieste;
    Socket clientSocket;
    
    
    
    Connection(int port){
        this.port = port;
        //istruzione sopra c'è una imprecisione 
        this.richieste = new ArrayList();
    }
    
    
    
    public  void connectionServer() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Ready for connection...");  
        while(true){
        try{
                 
                
                
                 
                                    
                clientSocket = serverSocket.accept();
                
                Gestore g = new Gestore(clientSocket);
                Thread t = new Thread(g);
                t.start();
                //this.richieste.add(t);
                
                System.out.println("Connession established");
                
                
                
            }catch( IOException ex){
                  System.err.println("Error opening socket");
            }
            
            
        }
        
        /*try{
                if(this.serverSocket!=null){
                this.serverSocket.close();
                System.out.println("Connessione chiusa");
                }
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }*///metterlo in un altro metodo chiudi();
    
    }




}
