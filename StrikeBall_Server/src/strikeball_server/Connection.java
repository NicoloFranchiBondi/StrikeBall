/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strikeball_server;
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


public class Connection {

    int port = 25000;
    String messaggio;
    
    Connection(){
        this.port = port;
        
    }
     public  void connectionServer() throws IOException {

        try{
                 
                ServerSocket serverSocket = new ServerSocket(port);
                System.out.println("Ready for connection...");   
                Socket clientSocket;
                clientSocket = serverSocket.accept();
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out =
                    new PrintWriter(clientSocket.getOutputStream(),true);
                messaggio = in.readLine();
                System.out.println("Messaggio del client: " + messaggio);
                out.println("Ciao :)");          
            }catch( IOException ex){
                System.err.println("Error opening socket");
            }
     }}
