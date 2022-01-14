package UDP;


import java.io.*;
import java.net.*;

public class udp_client {
    public static void main(String[] args) throws IOException {
        int port = 7777 ;//the port the server is listening on

        //creating udp socket by choosing random empty port on host
        //to use to send data
        DatagramSocket ds = new DatagramSocket();

        // creating a buffer manually from text
        byte [] buffer  = "Client message ".getBytes();

        //creating udp data packet
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length , InetAddress.getByName("localhost"),port); //buffer.length =512

        //sending packet to server
        ds.send(dp);

        //create an empty buffer for receiving data
        byte [] rcv_buffer = new byte[512];
        // creating a packet to receive data
        //you will notice we don`t need to add an address or port here since
        //when we initialize datagram socket it automatically bound to a free port
        //and since we ds.send it bound to the ip automatically
        DatagramPacket rcv_dp = new DatagramPacket(rcv_buffer, rcv_buffer.length ); //rcv_buffer.length =512

        //receive response datagram
        ds.receive(rcv_dp);

        //cast the received bytes to string
        String txt = new String(rcv_dp.getData());
        //print incoming message
        System.out.println("text received is " +txt);

        //closing server
        ds.close();

    }
}
