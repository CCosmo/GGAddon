package net.noprefix.GGAddon.events;

import net.labymod.api.LabyModAddon;
import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.api.events.MessageSendEvent;
import net.labymod.main.LabyMod;
import net.labymod.utils.Consumer;
import net.labymod.utils.ServerData;
import net.minecraft.client.Minecraft;
import net.noprefix.GGAddon.GGAddon;
import net.noprefix.GGAddon.addons.GAddonManager;
import net.noprefix.GGAddon.addons.implement.AntiFakeMoney;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.TimeUnit;

public class LabyEventHandler {

    public void registerEvents() {
        rJoinEvent();
        rQuitEvent();
        rChatEvent();
        rIncomingMessageEvent();
    }

    public void rJoinEvent() {
        GGAddon.getInstance().getApi().getEventManager().registerOnJoin(new Consumer<ServerData>() {
            @Override
            public void accept(final ServerData serverData) {
                /*GGAddon.getInstance().getExecutor().schedule(() -> {
                    GGAddon.getInstance().setServerIP(serverData.getIp());
                    GGAddon.getInstance().connect();
                    GGAddon.getInstance().loadConfig();
                }, 2, TimeUnit.SECONDS);*/
                GGAddon.getInstance().getExecutor().schedule(new Runnable() {
                    @Override
                    public void run() {
                        GGAddon.getInstance().setServerIP(serverData.getIp());
                        GGAddon.getInstance().connect();
                        GGAddon.getInstance().loadConfig();
                    }
                }, 2, TimeUnit.SECONDS);
            }
        });
    }

    public void rQuitEvent() {
        GGAddon.getInstance().getApi().getEventManager().registerOnQuit(new Consumer<ServerData>() {
            @Override
            public void accept(final ServerData serverData) {
                //GGAddon.getInstance().getClient().disconnectFromChat();
            }
        });
    }

    public void rChatEvent() {
        GGAddon.getInstance().getApi().getEventManager().register(new MessageSendEvent() {
            @Override
            public boolean onSend(String s) {
                if(s.startsWith(GGAddon.getInstance().commandPrefix) && s.split(" ").length > 1) {
                    GGAddon.getInstance().getCommandManager().execute(s);
                    return true;
                } else if(s.startsWith(GGAddon.getInstance().commandPrefix)) {
                    GGAddon.getInstance().getChat().noCommand(GGAddon.getInstance().getLanguage());
                    return true;
                }
                return false;
            }
        });
    }

    public void rIncomingMessageEvent() {
        GGAddon.getInstance().getApi().getEventManager().register(new MessageReceiveEvent() {
            @Override
            public boolean onReceive(String s, String s1) {
                if(GGAddon.getInstance().getAddonManager().getAddon(AntiFakeMoney.class).isEnabled()) {
                    if ((s.endsWith("gegeben.§r") || s.endsWith("§agegeben§r")) && s.contains("§r§ahat dir") && s.contains("$")) {
                        if(!s.contains(":"))
                            GGAddon.getInstance().getChat().sendMessage("§aReal-Money von §e" + s.split(" ")[2]);
                        else
                            GGAddon.getInstance().getChat().sendMessage("§cFake-Money von §e" + s.split(" ")[2]);
                    }
                }
                return false;
            }
        });
    }
}
