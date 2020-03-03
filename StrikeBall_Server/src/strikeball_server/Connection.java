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
    int port = 2000;
    String messaggio;
    ArrayList<Socket> richieste;
    Connection(){
        this.port = port;
        this.richieste = new ArrayList();
    }
     public  void connectionServer() throws IOException {
        while(true){
        try{
                 
                serverSocket = new ServerSocket(port);
                System.out.println("Ready for connection...");   
                Socket clientSocket= new Socket();
                
                
                /*Pippo p = new Pippo(clientSocket);
                Thread count=new Thread(p);
                count.start();
                    
                //serverSocket.setSoTimeout(5000);*/
                    
                clientSocket = serverSocket.accept();
                
                System.out.println("Connessione stabilita");
                
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out =
                    new PrintWriter(clientSocket.getOutputStream(),true);
                messaggio = in.readLine();
                System.out.println("Messaggio del client: " + messaggio);
                out.println("Messaggio dal Server");
                
            }catch( IOException ex){
                  System.err.println("Error opening socket");
            }
            
            try {
                if(this.serverSocket!=null){
                this.serverSocket.close();
                System.out.println("Connessione chiusa");
                }
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }}}
