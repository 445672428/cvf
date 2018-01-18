package others.demo.imagevalidate;

import java.io.IOException;
import java.net.ServerSocket;

public class SocketServiceDemo {
    public void socketServiceDemo() {
        int port = 9999;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.accept();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
