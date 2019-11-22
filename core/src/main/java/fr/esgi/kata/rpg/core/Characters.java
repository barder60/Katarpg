package fr.esgi.kata.rpg.core;

import java.util.List;

public abstract class Characters {

    private String name;
    private int health;
    private boolean alive;
    private int attackStrength;
    private int healStrength;
    private List<String> factions;

    public Characters(String name) {
        this.name = name;
        this.health = 100;
        this.alive = true;
        this.attackStrength = 1;
        this.healStrength = 1;
    }

    public void setHealth(int health) {
        if (health <= 100) {
            this.health = health;
        }
        if (health <= 0) {
            this.alive = false;
        }
    }

    public void attack(Characters enemy) {
        if (enemy.alive && this != enemy && !this.isSameFaction(enemy)) {
            enemy.setHealth(enemy.health - this.attackStrength);
        }
    }

    public void heal(Characters poto){
        if(this.isSameFaction(poto)) {
            poto.setHealth(poto.health + this.healStrength);
            if (poto.health > 0) {
                poto.alive = true;
            }
        }
    }

    private boolean isSameFaction(Characters player) {
        for(int i = 0; i < player.factions.size(); i++){
            for(int j = 0; j < this.factions.size(); j++) {
                if(this.factions.get(j).equals(player.factions.get(j))){
                    return true;
                }
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

    public void addFaction(String faction){
        if (!this.factions.contains(faction)){
            this.factions.add(faction);
        }
    }

    public void removeFaction(String faction){
        this.factions.remove(faction);
    }

    @Override
    public String toString() {
        return "Characters{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", alive=" + alive +
                ", attackStrength=" + attackStrength +
                ", healStrength=" + healStrength +
                '}';
    }
}
