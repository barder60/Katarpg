package fr.esgi.kata.rpg.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

class CharacterTest {
    private Character character;

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

    @Test
    public void new_character_should_not_belong_to_any_faction() {
        Assert.assertTrue(character.getFactions().isEmpty());
    }

    @Test
    public void character_should_join_and_leave_faction() {
        var faction = new Faction("Toto");

        character.addFaction(faction);
        Assert.assertTrue(character.getFactions().contains(faction));
        character.removeFaction(faction);
        Assert.assertFalse(character.getFactions().contains(faction));
    }

    @Test
    public void character_can_t_damage_another_character_of_same_faction() {
        Character brotherFaction = new Character("Bro") {
        };
        var faction = new Faction("1st faction");

        character.addFaction(faction);
        brotherFaction.addFaction(faction);

        character.attack(brotherFaction);
        brotherFaction.attack(character);
        Assert.assertEquals(character.getHealth(), 100);
        Assert.assertEquals(brotherFaction.getHealth(), 100);
    }

    @Test
    public void character_should_only_heal_character_of_same_faction() {
        Character brotherFaction = new Character("Bro") {
        };
        Character notBro = new Character("No Bro") {
        };
        var faction = new Faction("The faction");
        var enemyFaction = new Faction("The enemyFaction");

        character.addFaction(faction);
        brotherFaction.addFaction(faction);
        notBro.addFaction(enemyFaction);

        notBro.attack(brotherFaction);
        notBro.attack(character);
        brotherFaction.attack(notBro);
        Assert.assertEquals(brotherFaction.getHealth(), 99);
        Assert.assertEquals(character.getHealth(), 99);
        Assert.assertEquals(notBro.getHealth(), 99);

        brotherFaction.heal(notBro);
        Assert.assertNotEquals(notBro.getHealth(), 100);
        notBro.heal(character);
        Assert.assertNotEquals(character.getHealth(), 100);
        brotherFaction.heal(character);
        Assert.assertEquals(character.getHealth(), 100);
    }

}