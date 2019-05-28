package net.noprefix.GGAddon.utils;

import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;
import net.noprefix.GGAddon.GGAddon;
import net.noprefix.GGAddon.addons.GAddon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static Socket client;
    PrintWriter writer;
    BufferedReader reader;

    public void initChatClient() {
        if(connectToServer()) {
            Thread t = new Thread(new MessagesFromServerListener());
            t.start();
        }
    }

    public boolean connectToServer() {
        try {
            client = new Socket("128.0.120.217", 9000);
            reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            writer = new PrintWriter(client.getOutputStream());
            addPlayer();
            //LabyMod.getInstance().getGuiCustomAchievement().displayAchievement("GGAddon", "§aDie Verbindung zum Addon-Chat wurde hergestellt!");
            GGAddon.getInstance().getChat().sendMessage("§aDie verbindung zum Addon-Chat wurde hergestellt!");
            return true;
        } catch(Exception e) {
            GGAddon.getInstance().getChat().sendMessage("§cDie Verbindung zum Addon-Chat kontte nicht hergestellt werden! [Wartungen]");
            e.printStackTrace();
            return false;
        }
    }

    public void disconnectFromChat() {
        sendMessageToServer("!quit");
    }

    public void addPlayer() {
        writer.println(LabyMod.getInstance().getPlayerName());
        writer.flush();
    }

    public void sendMessageToServer(String message) {
        writer.println("&a" + LabyMod.getInstance().getPlayerName() + "&8: &7" + message);
        writer.flush();
    }

    public class MessagesFromServerListener implements Runnable {
        @Override
        public void run() {
            String message;
            try {
                while((message = reader.readLine()) != null)
                    GGAddon.getInstance().getChat().sendOnlineChat(message.replace('&', '§'));
            } catch (IOException e) {
                GGAddon.getInstance().getChat().sendOnlineChat("Nachricht konnte nicht empfangen werden!");
                e.printStackTrace();
            }
        }
    }
}