package net.noprefix.GGAddon.commands;

import net.noprefix.GGAddon.GGAddon;
import net.noprefix.GGAddon.commands.implement.*;

import java.util.ArrayList;
import java.util.List;

public class GCommandManager {

    private List<GCommand> commands = new ArrayList();

    public GCommandManager() {
        addCommand(new Help("help", "#gg help <command>", "Zeigt diese Hilfe, Benutze #gg help <Command> für eine Commandbeschreibung"));
        addCommand(new ScammerList("scammer", "#gg scammer <add/remove/list/search>", "Zeigt deine Scammerliste"));
        addCommand(new TrustList("trust", "#gg trust <add/remove/list/search>", "Zeigt deine Vertrautenliste"));
        addCommand(new Notes("note", "#gg note <add/show/list/remove>", "Verwaltet deine Notizen"));
        addCommand(new Chat("chat", "#gg chat <Nachricht/!online>", "Sendet eine Nachricht an alle Addon-Nutzer"));
        addCommand(new ClearChat("cclear", "#gg cclear", "Leert den Chat"));
        addCommand(new PlotClear("ppclear", "#gg ppclear", "Leert dein Plot ohne \"Confirm\""));
        addCommand(new Price("price", "#gg price", "Zeigt den Grieferwert Item Preis vom Item in deiner Hand"));
        addCommand(new ListAccounts("accounts", "#gg accounts", "Listet deine Accounts"));
    }

    public void addCommand(GCommand command) {
        this.commands.add(command);
    }

    public void execute(String text) {
        System.out.println(text);
        System.out.println(GGAddon.getInstance().commandPrefix);
        text = text.substring(GGAddon.getInstance().commandPrefix.length()+1);
        String[] args = text.split(" ");
        for(GCommand command : this.commands) {
            if(args[0].trim().toLowerCase().equals(command.getName().trim().toLowerCase())) {
                command.execute(args);
            }
        }
        return;
    }

    public List<GCommand> getCommands() { return commands; }
}
