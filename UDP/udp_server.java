package UDP;

import java.io.*;
import java.net.*;


public class udp_server {
    public static void main(String[] args) throws IOException {
        int port = 7777 ;
        //start listening on port for udp connections
        DatagramSocket ds = new DatagramSocket(port  );
        System.out.println("Server listening  on port :"+port);

        // creating a buffer manually of size 512 to store incoming request data
        byte [] buffer  = new byte[512];

        //creating data packet for incoming data
        DatagramPacket  dp = new DatagramPacket(buffer, buffer.length); //buffer.length =512

        //accepting incoming data and storing it in data packet
        ds.receive(dp);

        //the next line is executed when data is received
        System.out.println("tcp connection established ... ");

        // parse incoming bits of data from machine code to text
        String txt = new String(dp.getData());
        //print incoming message
        System.out.println("text received is " +txt);

        //preparing reply message to be sent
        byte [] rep = "A replay from server".getBytes() ;

        //you will notice we don`t need to add an address or port here since
        //when we initialize datagram socket it automatically bound to port
        //and since we start ds.receive it bound to the localhost
        dp = new DatagramPacket(rep, rep.length); //buffer.length =512

        //sending replay
        ds.send(dp);

        //closing server
        ds.close();

    }
}
