package TCP;
import java.io.*;
import java.net.*;

public class tcp_client {
    public static void main(String[] args) throws IOException {
        int port = 7777 ;
        String ip = "localhost";

        //establishing tcp connection with server
        Socket s = new Socket(ip,port) ;

        //the next line is executed when the code in client class is run
        System.out.println("tcp connection established ... ");
        String msg = "hello server";

        //preparing msg to be sent
        OutputStream os = s.getOutputStream()  ;
        PrintWriter pw = new PrintWriter(os);
        pw.println(msg);
        pw.flush();

        //prepare to receive message from server
        BufferedReader br = new BufferedReader(new InputStreamReader( s.getInputStream()));
        //print message from server
        System.out.println("Received text from server : " +br.readLine());

        //close connection
        s.close();
    }
}
