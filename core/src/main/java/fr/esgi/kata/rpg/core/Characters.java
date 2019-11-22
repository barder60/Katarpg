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

    public void setName(String name) {
        this.name = name;
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

/*      for(int i = 0; i < enemy.factions.size(); i++){
            for(int j = 0; j < fa)
        }*/

        if (enemy.alive && this != enemy) {
            enemy.setHealth(enemy.health - this.attackStrength);
        }
    }

    public void heal(Characters poto){
        poto.setHealth(poto.health + 1);
        if (poto.health > 0) {
            poto.alive = true;
        }
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

    public int getAttackStrength() {
        return attackStrength;
    }

    public void setAttackStrength(int attackStrength) {
        this.attackStrength = attackStrength;
    }

    public void setHealStrength(int healStrength) {
        this.healStrength = healStrength;
    }

    public void addFaction(String faction){
        if (this.factions.contains(faction)){
            this.factions.add(faction);
        }
    }

    public void removeFaction(String faction){
        this.factions.remove(faction);
    }
}
