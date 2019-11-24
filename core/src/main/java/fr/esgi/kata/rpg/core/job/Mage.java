package fr.esgi.kata.rpg.core.job;

import fr.esgi.kata.rpg.core.Character;

import java.util.Random;

public class Mage extends Character {

    public Mage(String name) {
        super(name);
        this.setAttackStrength(0);
    }

    @Override
    public void heal(Character poto) {
        Random rand = new Random();
        this.setHealStrength(rand.nextInt(6) + 5);
        super.heal(poto);
    }
}
