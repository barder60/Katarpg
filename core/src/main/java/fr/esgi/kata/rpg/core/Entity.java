package fr.esgi.kata.rpg.core;

public class Entity extends Characters {

    public Entity(String name) {
        super(name);
        this.setAttackStrength(0);
        this.setHealStrength(0);
    }

    @Override
    public void addFaction(String faction) {}
}
