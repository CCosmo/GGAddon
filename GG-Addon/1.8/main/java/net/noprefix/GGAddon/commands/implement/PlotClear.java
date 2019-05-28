package net.noprefix.GGAddon.commands.implement;

import net.minecraft.client.Minecraft;
import net.noprefix.GGAddon.GGAddon;
import net.noprefix.GGAddon.commands.GCommand;

public class PlotClear extends GCommand {

    public PlotClear(String name, String usage, String germanDescription) {
        super(name, usage, germanDescription);
    }

    @Override
    public void execute(String[] args) {
        //Minecraft.getMinecraft().thePlayer.sendChatMessage("/p -f clear");
        GGAddon.getInstance().getChat().sendMessage("§cDieses Feature wurde in der 1.12 deaktiviert.");
    }
}
