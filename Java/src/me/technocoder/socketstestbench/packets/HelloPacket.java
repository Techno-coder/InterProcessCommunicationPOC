package me.technocoder.socketstestbench.packets;

import me.technocoder.socketstestbench.ConnectionWrapper;

import java.net.Socket;

public class HelloPacket extends Packet {
    @Override
    public void handle(String[] data, Socket socket, ConnectionWrapper connection) {
        System.out.println("Hello packet received! Sending one back ...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        connection.writePacket(0, new String[0]);
    }
}
