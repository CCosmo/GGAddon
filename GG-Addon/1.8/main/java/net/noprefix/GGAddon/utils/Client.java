package net.noprefix.GGAddon.utils;

import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;
import net.noprefix.GGAddon.GGAddon;
import net.noprefix.GGAddon.addons.GAddon;

import java.io.*;
import java.net.Socket;

public class Client {

    public static Socket client;
    PrintWriter writer;
    BufferedReader reader;

    public void sendMessage(String message) {
        Client client = new Client();
        try {
            client.test(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void test(String message) throws IOException {
        String ip = "127.0.0.1"; // localhost
        int port = 8357;
        java.net.Socket socket = new java.net.Socket(ip,port); // verbindet sich mit Server
        String zuSendendeNachricht = LabyMod.getInstance().getPlayerName() + ";" + message;
        schreibeNachricht(socket, zuSendendeNachricht);
        String empfangeneNachricht = leseNachricht(socket);
        GGAddon.getInstance().getChat().sendOnlineChat(empfangeneNachricht.replace("&", "§"));
        socket.close();
    }
    void schreibeNachricht(java.net.Socket socket, String nachricht) throws IOException {
        PrintWriter printWriter =
                new PrintWriter(
                        new OutputStreamWriter(
                                socket.getOutputStream()));
        printWriter.print(nachricht);
        printWriter.flush();
    }
    String leseNachricht(java.net.Socket socket) throws IOException {
        BufferedReader bufferedReader =
                new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream()));
        char[] buffer = new char[200];
        int anzahlZeichen = bufferedReader.read(buffer, 0, 200); // blockiert bis Nachricht empfangen
        String nachricht = new String(buffer, 0, anzahlZeichen);
        return nachricht;
    }
}