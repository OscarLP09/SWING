package org.example;

import java.util.ArrayList;
// Esta clase nos sirve para crear un array con todos los juegos
public class Data {
    public static ArrayList<Game> games;

    static {
        games = new ArrayList<>();
        games.add(new Game("The Legend of Zelda", "Nintendo", 1986));
        games.add(new Game("Super Mario Bros.", "Nintendo", 1985));
        games.add(new Game("Sonic the Hedgehog", "Sega", 1991));
        games.add(new Game("Final Fantasy VII", "PlayStation", 1997));
        games.add(new Game("Halo: Combat Evolved", "Xbox", 2001));
        games.add(new Game("The Witcher 3", "PC", 2015));
        games.add(new Game("God of War", "PlayStation", 2018));
        games.add(new Game("Red Dead Redemption 2", "PlayStation", 2018));
        games.add(new Game("Minecraft", "PC", 2009));
        games.add(new Game("Fortnite", "PC", 2017));
    }
}
