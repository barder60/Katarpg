package fr.esgi.kata.rpg.core.job;

import fr.esgi.kata.rpg.core.Faction;
import org.junit.jupiter.api.*;
import org.testng.Assert;

public class WarriorTest {
    Warrior warrior;

    @BeforeEach
    public void setUp() {
        warrior = new Warrior("Conan");
    }

    @AfterEach
    public void tearDown() {
        warrior = null;
    }

    @Test
    public void warrior_should_attack_until_0_from_9_and_can_attack_himself() {
        Assert.assertEquals(warrior.getHealth(), 100);
        warrior.attack(warrior);
        while(warrior.getAttackStrength() <= 0) {
            warrior.attack(warrior);
        }
        Assert.assertEquals(warrior.getHealth(), 100 - warrior.getAttackStrength());
    }

    @Test
    public void warrior_should_only_heal_itself() {
        Warrior anotherWarrior = new Warrior("Another");

        warrior.attack(anotherWarrior);
        while(warrior.getAttackStrength() <= 0) {
            warrior.attack(anotherWarrior);
        }

        warrior.heal(anotherWarrior);
        Assert.assertEquals(anotherWarrior.getHealth(), 100 - warrior.getAttackStrength());
        anotherWarrior.heal(anotherWarrior);
        Assert.assertEquals(anotherWarrior.getHealth(), 100 - warrior.getAttackStrength() + 1);
    }
}
