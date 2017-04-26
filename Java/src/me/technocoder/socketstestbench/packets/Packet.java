package me.technocoder.socketstestbench.packets;

import me.technocoder.socketstestbench.ConnectionWrapper;

import java.net.Socket;

public abstract class Packet {
    public abstract void handle(String[] data, Socket socket, ConnectionWrapper connection);
}
