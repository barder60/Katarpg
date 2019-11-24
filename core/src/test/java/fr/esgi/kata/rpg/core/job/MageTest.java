package fr.esgi.kata.rpg.core.job;

import org.junit.jupiter.api.*;
import org.testng.Assert;

public class MageTest {

    Mage mage;

    @BeforeEach
    public void setUp() {
        mage = new Mage("Mage");
    }

    @AfterEach
    public void tearDown() {
        mage = null;
    }

    @Test
    public void mage_should_not_deal_any_damage() {
        Mage anotherMange = new Mage("Another");

        Assert.assertEquals(anotherMange.getHealth(), 100);
        mage.attack(anotherMange);
        Assert.assertEquals(anotherMange.getHealth(), 100);
    }

    @Test
    public void mage_should_heal_another_character_heal() {
        Warrior warrior = new Warrior("Barbar");

        Assert.assertEquals(warrior.getHealth(), 100);
        warrior.attack(warrior);
        while(warrior.getAttackStrength() <= 0) {
            warrior.attack(warrior);
        }
        Assert.assertEquals(warrior.getHealth(), 100 - warrior.getAttackStrength());
        mage.heal(warrior);
        Assert.assertTrue(warrior.getHealth() > 100 - warrior.getAttackStrength());
    }
}
