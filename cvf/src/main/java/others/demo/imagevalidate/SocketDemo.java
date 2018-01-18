package others.demo.imagevalidate;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketDemo {
    public void socketfunction() {
        String host = "127.0.0.1";
        int port = 9999;
        try {
            Socket socket = new Socket(host, port);
            Writer writer = new OutputStreamWriter(socket.getOutputStream());
            writer.write("hello world");
            writer.flush();
            writer.close();
            socket.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
