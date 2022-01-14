package TCP;

import java.io.*;
import java.net.*;

public class tcp_server {
    public static void main(String[] args) throws IOException {
        int port = 7777 ;

        //creating server
        ServerSocket ss = new ServerSocket(port);
        System.out.println("Server listening  on port :"+port);

        //accepting tcp connection
        Socket s = ss.accept() ;

        //the next line is executed when the code in client class is run
        System.out.println("tcp connection established ... ");

        // prepare incoming data to be printed
        InputStream is = s.getInputStream() ;
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader( isr);
        String txt = br.readLine() ;

        //print incoming message
        System.out.println("text received is " +txt);


        //preparing reply message to be sent
        OutputStream os = s.getOutputStream();
        PrintWriter pw = new PrintWriter(os);
        pw.println("hello client");

        //sending reply message
        pw.flush();

        //close server
        ss.close();
    }
}
