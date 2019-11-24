package fr.esgi.kata.rpg.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static org.junit.jupiter.api.Assertions.fail;

class CharacterTest {
    Character character;

    @BeforeEach
    void setUp() {
        this.character = new Character("First") {
        };
    }

    @AfterEach
    void tearDown() {
        this.character = null;
    }

    @Test
    public void character_should_initiate_health_100() {
        Assert.assertEquals(character.getHealth(), 100);
    }

    @Test
    public void character_should_dead_when_it_reaches_0_health() {
        Assert.assertTrue(character.isAlive());
        character.setHealth(0);
        Assert.assertFalse(character.isAlive());
    }

    @Test
    public void character_should_attack_another_character_and_deal_1_and_not_deal_if_enemy_is_dead() {
        Character enemy = new Character("Enemy") {
        };

        character.attack(enemy);
        Assert.assertEquals(enemy.getHealth(), 99);

        enemy.setHealth(0);
        character.attack(enemy);
        Assert.assertEquals(enemy.getHealth(), 0);
    }

    @Test
    public void character_should_not_attack_itself() {
        Assert.assertEquals(character.getHealth(), 100);

        character.attack(character);
        Assert.assertEquals(character.getHealth(), 100);
    }

    @Test
    public void character_should_heal_another_character_to_1_and_can_heal_itself() {
        Character friend = new Character("Friend") {
        };

        character.attack(friend);
        friend.attack(character);
        Assert.assertEquals(character.getHealth(), 99);
        Assert.assertEquals(friend.getHealth(), 99);

        character.heal(friend);
        character.heal(character);
        Assert.assertEquals(friend.getHealth(), 100);
        Assert.assertEquals(character.getHealth(), 100);
    }
}