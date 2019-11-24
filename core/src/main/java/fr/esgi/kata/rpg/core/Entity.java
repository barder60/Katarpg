package fr.esgi.kata.rpg.core;

public class Entity extends Character {

    public Entity(String name) {
        super(name);
        this.setAttackStrength(0);
        this.setHealStrength(0);
    }

    @Override
    public void addFaction(Faction faction) {}

    @Override
    public void setHealth(int health) {
        if (health < this.getHealth()) {
            super.setHealth(health);
        }
    }
}
