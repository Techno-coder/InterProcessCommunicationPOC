package me.technocoder.socketstestbench;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class ConnectionWrapper {
    private ServerSocket serverSocket;
    private Socket socket;
    private BufferedWriter output;
    private BufferedReader input;

    public void writePacket(int type, String[] data) { //TODO Client interface will likely differ from server interface
        StringJoiner line = new StringJoiner(" ", "", "\n");
        line.add(String.valueOf(type));
        for (String string : data) {
            line.add(string);
        }
        try {
            output.write(line.toString());
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listenForConnections(int port) throws IOException {
        serverSocket = new ServerSocket(port, 0, InetAddress.getByName(null));

        System.out.println("Waiting for connection ...");
        socket = serverSocket.accept();
        System.out.println("Connection established");

        output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        output.flush();
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        this.writePacket(0, new String[0]);
        while (!socket.isClosed()) {
            String line = input.readLine();
            String[] data = line.split(" ");
            int type = Integer.valueOf(data[0]);
            PacketParser.parseDataPacket(type, Arrays.copyOfRange(data, 1, data.length), socket, this);
        }
    }
}
