package fr.esgi.kata.rpg.core;

import java.util.Random;

public class Warrior extends Characters{

    public Warrior(String name) {
        super(name);
    }

    @Override
    public void attack(Characters enemy) {
        Random rand = new Random();
        this.setAttackStrength(rand.nextInt(9));
        super.attack(enemy);
    }

    @Override
    public void heal(Characters poto) {
        if(this == poto){
            super.heal(poto);
        }
    }
}
