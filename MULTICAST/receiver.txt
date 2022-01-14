package MULTICAST;

import java.net.*;
import java.io.*;


public class receiver {
    public static void main(String[] args) throws IOException {
        //prepare group ip address to join and the port to receive on
        InetAddress group =  InetAddress.getByName("225.4.5.6");
        int port  = 6789;
        //open receiving connection on port
        MulticastSocket m = new MulticastSocket(port);
        //join group to receive
        m.joinGroup(group);
        //create a buffer to receive incoming data
        byte [] buffer = new byte[512];
        //create packet to receive data
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
        //receive data and store in packet
        m.receive(dp);
        //print received data
        System.out.println("Message received : "+ new String(dp.getData()));

        m.close();
    }
}
