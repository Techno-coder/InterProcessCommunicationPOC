package me.technocoder.socketstestbench;

import java.io.IOException;

public class Main {
    private static int SOCKET_PORT = 48042;

    public static void main(String[] args) {
        ConnectionWrapper wrapper = new ConnectionWrapper();
        try {
            wrapper.listenForConnections(SOCKET_PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
