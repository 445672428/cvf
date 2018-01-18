package others.demo.imagevalidate;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchorServiceDemo {
   public static void main(String[] args) {
    ServerSocket serverSocket = null;
    String line;
    DataInputStream inputStream;
    PrintStream printStream;
    Socket clientSocket = null;
    
    try {
        serverSocket= new ServerSocket(9999);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    
    try {
        clientSocket = serverSocket.accept();
        inputStream = new DataInputStream(clientSocket.getInputStream());
        printStream = new PrintStream(clientSocket.getOutputStream());
        while (true) {
            line = inputStream.readLine();
            printStream.println(line);
        }
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
}
