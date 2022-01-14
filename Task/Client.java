import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    //client
    public static void main(String[] args) throws IOException {
        DatagramSocket s = new DatagramSocket();
        int port = 8000;
        byte [] send  = "test test ".getBytes();
        s.setSoTimeout(100);
        DatagramPacket dp_send = null ;
        for (int i = 0; i < 3; i++) {
            dp_send = new DatagramPacket(send, send.length , InetAddress.getByName("localhost") , port);
            s.send(dp_send);
            byte [] buffer = new byte[256];
            DatagramPacket rcv = new DatagramPacket(buffer, buffer.length);
            try {
                s.receive(rcv);
                String msg = new String(rcv.getData());
                System.out.println("server message = "+msg + "   ");
                s.close();
            }catch (Exception e){
            }
        }
    }
}
