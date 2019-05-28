package net.noprefix.GGAddon.commands.implement;

import net.labymod.labyconnect.packets.Packet;
import net.labymod.labyconnect.packets.PacketActionPlay;
import net.labymod.labyconnect.packets.PacketPlayServerStatus;
import net.labymod.main.LabyMod;
import net.labymod.user.emote.keys.provider.EmoteProvider;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.noprefix.GGAddon.GGAddon;
import net.noprefix.GGAddon.commands.GCommand;
import net.noprefix.GGAddon.utils.Client;
import org.lwjgl.Sys;

import java.util.Iterator;
import java.util.Random;

public class ListAccounts extends GCommand {
    public ListAccounts(String name, String usage, String germanDescription) {
        super(name, usage, germanDescription);
    }

    @Override
    public void execute(String[] args) {
        short id = 1;
        //LabyMod.getInstance().getLabyConnect().getClientConnection().sendPacket(new PacketActionPlay(id, id, LabyMod.getInstance().getEmoteRegistry().shortToBytes(id)));
        //LabyMod.getInstance().getLabyConnect().updatePlayingOnServerState("§a§lGrieferGames <3");
        GGAddon.getInstance().getChat().sendMessage("Chat: " + Client.client);
    }
}
