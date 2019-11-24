package fr.esgi.kata.rpg.core;

import java.util.ArrayList;
import java.util.List;

public abstract class Character {

    private String name;
    private int health;
    private boolean alive;
    private int attackStrength;
    private int healStrength;
    private List<Faction> factions;

    public Character(String name) {
        this.name = name;
        this.health = 100;
        this.alive = true;
        this.attackStrength = 1;
        this.healStrength = 1;
        this.factions = new ArrayList<Faction>();
    }

    public void setHealth(int health) {
        if (health <= 100) {
            this.health = health;
        }
        if (health <= 0) {
            this.alive = false;
        }
    }

    public void attack(Character enemy) {
        if (enemy.alive && this != enemy && (!this.isSameFaction(enemy) || this.getFactions().isEmpty())) {
            enemy.setHealth(enemy.health - this.attackStrength);
        }
    }

    public void heal(Character poto) {

        if (this.isSameFaction(poto) || this.getFactions().isEmpty()){
            poto.setHealth(poto.health + this.healStrength);
            if (poto.health > 0) {
                poto.alive = true;
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getAttackStrength() {
        return attackStrength;
    }

    public int getHealStrength() {
        return healStrength;
    }

    public List<Faction> getFactions() {
        return factions;
    }

    private boolean isSameFaction(Character player) {

        for (int i = 0; i < player.factions.size(); i++) {
            if (this.factions.contains(player.factions.get(i))) {
                return true;
            }
        }

        return false;
    }

    public void setAttackStrength(int attackStrength) {
        this.attackStrength = attackStrength;
    }

    public void setHealStrength(int healStrength) {
        this.healStrength = healStrength;
    }

    public void addFaction(Faction faction) {

        if (!this.factions.contains(faction)) {
            this.factions.add(faction);
        }
    }

    public void removeFaction(Faction faction) {
        this.factions.remove(faction);
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", alive=" + alive +
                ", attackStrength=" + attackStrength +
                ", healStrength=" + healStrength +
                ", factions=" + factions +
                '}';
    }
}
