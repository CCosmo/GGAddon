package net.noprefix.GGAddon.commands.implement;

import net.noprefix.GGAddon.GGAddon;
import net.noprefix.GGAddon.commands.GCommand;

public class Chat extends GCommand {
    public Chat(String name, String description, String germanDescription) {
        super(name, description, germanDescription);
    }

    @Override
    public void execute(String[] args) {
        /*String message = "";
        for(int i = 1; i < args.length; ++i)
            message = message + args[i] + " ";
        System.out.println(message);
        GGAddon.getInstance().getClient().sendMessage(message);*/
        GGAddon.getInstance().getChat().sendMessage("§cDer Chat wurde kurzzeitig aufgrund von Fehlerbehebung deaktiviert.");
    }
}
