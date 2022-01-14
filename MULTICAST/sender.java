package MULTICAST;

import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class sender {
    public static void main(String[] args) throws IOException {
        //use a free socket to send data
        MulticastSocket m = new MulticastSocket();
        // prepare group ip
        InetAddress group =  InetAddress.getByName("225.4.5.6");
        // the port the receiver use to receive data
        int port  = 6789;
        //join the group to send data
        m.joinGroup(group);
        // message to be sent
        String msg = "hello ";
        //the data-packet to be sent
        DatagramPacket dp = new DatagramPacket(msg.getBytes(StandardCharsets.UTF_8), msg.length(),group,port);
        //sending the packet
        m.send(dp);
        m.close();
    }
}
