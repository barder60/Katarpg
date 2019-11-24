package fr.esgi.kata.rpg.core.job;

import fr.esgi.kata.rpg.core.Character;

import java.util.Random;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
    }

    @Override
    public void attack(Character enemy) {
        Random rand = new Random();
        this.setAttackStrength(rand.nextInt(9));
        if (enemy.isAlive() && (this == enemy || !this.isSameFaction(enemy))) {
            enemy.setHealth(enemy.getHealth() - this.getAttackStrength());
        }
    }

    @Override
    public void heal(Character poto) {
        if(this == poto){
            super.heal(poto);
        }
    }
}
