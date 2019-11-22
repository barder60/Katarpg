package fr.esgi.kata.rpg.core;

import java.util.List;

public class Faction {
    private String name;
    private List<Characters> characters;

    public Faction(String name) {
        this.name = name;
    }

    public void join(Characters character){
        this.characters.add(character);
    }

    public void leave(Characters character){
        this.characters.remove(character);
    }


}
