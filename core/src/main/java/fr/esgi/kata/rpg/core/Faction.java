package fr.esgi.kata.rpg.core;

import java.util.ArrayList;
import java.util.List;

public class Faction {
    private String name;
    private List<Faction> factionAllies;

    public Faction(String name) {
        this.name = name;
        this.factionAllies = new ArrayList<Faction>();
    }

    public void addAlliedFaction(Faction ally) {
        if (this != ally && !this.name.equals(ally.name)) {
            this.factionAllies.add(ally);
        }
    }

    public void removeAlliedFaction(Faction faction) {
        if (this.factionAllies != null) {
            this.factionAllies.remove(faction);
        }
    }

    public boolean isAlliedFaction(Faction faction) {
        return this.factionAllies.contains(faction);
    }

    @Override
    public String toString() {
        return "Faction{" +
                "name='" + name + '\'' +
                ", factionAllies=" + factionAllies +
                '}';
    }
}
