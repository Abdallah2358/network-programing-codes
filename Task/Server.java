import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Server {
    //server
    public static void main(String[] args) throws  IOException {
        int port = 8000;
        DatagramSocket ds = new DatagramSocket(port);
        for (int i = 0; i < 3; i++) {
          
            Thread object = new Thread(new threaded_server(ds));
            object.start();
        }
    }
}
class threaded_server implements Runnable {
    final DatagramSocket ds;
    public threaded_server(DatagramSocket ds ){
        this.ds = ds ;
    }
    public void server (long thread_n) throws  IOException {
            try {
                byte [] buffer = new byte[256];
                DatagramPacket rcv = new DatagramPacket(buffer, buffer.length);
                ds.receive(rcv);
                System.out.println("done w8ing");
                InetAddress client_address = rcv.getAddress();
                int c_port = rcv.getPort();
                String msg = new String(rcv.getData());
                System.out.println("client message = "+msg);
                String rp = "Mansoura University this is running on thread" + thread_n +"  ";
                DatagramPacket rep = new DatagramPacket(rp.getBytes(StandardCharsets.UTF_8) ,rp.length(),client_address,c_port);
                ds.send(rep);
            } catch (FileNotFoundException e) {
                System.err.println("Could not connect Serving time instead.");
            }
        }


    public void run()
    {
        try {
            // Displaying the thread that is running
            long thread_n = Thread.currentThread().getId() ;
            this.server(thread_n);
            System.out.println(
                    "Thread " + thread_n+ " is running");
        }
        catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
}
