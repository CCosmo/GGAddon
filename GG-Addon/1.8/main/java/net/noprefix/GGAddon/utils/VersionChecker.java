package net.noprefix.GGAddon.utils;

import net.noprefix.GGAddon.GGAddon;

import javax.net.ssl.HttpsURLConnection;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class VersionChecker {

    public static void checkVersion() {
        GGAddon.getInstance().getChat().sendMessage("§aChecking Version...");
        Scanner scanner = null;
        try {
            URL url = new URL("https://noprefix.net/addon/index.html");
            URLConnection u = url.openConnection();
            scanner = new Scanner(new InputStreamReader(u.getInputStream()));
        } catch (Exception e) {}
        int newestVersion = Integer.valueOf(scanner.nextLine());
        if(newestVersion > GGAddon.version) {
            GGAddon.getInstance().getChat().sendMessage("§aEs ist eine neue Version des Addons verfügbar: §e" + newestVersion + ".0");
            GGAddon.getInstance().getChat().sendMessage("§aLade sie unter§e https://noprefix.net/downloads/ §aherunter!");
        } else
                GGAddon.getInstance().getChat().sendMessage("§aDu bist auf dem neuesten Stand! §e(Version " + newestVersion + ".0)");
        GGAddon.getInstance().getChat().sendMessage("§aDu bist auf dem neuesten Stand! §e(Version " + newestVersion + ".0)");
    }

}
