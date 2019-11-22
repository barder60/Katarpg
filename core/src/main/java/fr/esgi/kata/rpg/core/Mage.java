package fr.esgi.kata.rpg.core;

import java.util.Random;

public class Mage extends Characters {

    public Mage(String name) {
        super(name);
        this.setAttackStrength(0);
    }

    @Override
    public void heal(Characters poto) {
        Random rand = new Random();
        this.setHealStrength(rand.nextInt(6) + 5);
        super.heal(poto);
    }
}
