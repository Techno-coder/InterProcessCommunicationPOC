package me.technocoder.socketstestbench;

import me.technocoder.socketstestbench.packets.HelloPacket;
import me.technocoder.socketstestbench.packets.Packet;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class PacketParser {

    private static Map<Integer, Packet> packetMap = new HashMap<>();
    static {
        packetMap.put(0, new HelloPacket());
    }

    public static void parseDataPacket(int type, String[] data, Socket socket, ConnectionWrapper connection) {
        packetMap.get(type).handle(data, socket, connection);
    }
}
