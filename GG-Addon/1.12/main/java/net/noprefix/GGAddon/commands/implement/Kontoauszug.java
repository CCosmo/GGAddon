package net.noprefix.GGAddon.commands.implement;

import net.labymod.core.LabyModCore;
import net.labymod.labyplay.LabyPlay;
import net.labymod.main.LabyMod;
import net.minecraft.client.Minecraft;
import net.noprefix.GGAddon.commands.GCommand;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Kontoauszug extends GCommand {

    public Kontoauszug(String name, String usage, String germanDescription) {
        super(name, usage, germanDescription);
    }

    @Override
    public void execute(String[] args) {
    }

    private void payMoney() { //Geld an Spieler XY bezahlen

    }

    private void receiveMoney() { //Geld von Spieler XY bekommen

    }

    private void payBank() //Geld auf Bank einzahlen
    {

    }

    private void receiveBank() //Geld von Bank abheben
    {

    }
}
