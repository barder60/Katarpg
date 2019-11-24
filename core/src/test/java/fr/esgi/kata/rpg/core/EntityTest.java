package fr.esgi.kata.rpg.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class EntityTest {
    Entity entity;

    @BeforeEach
    public void setUp() {
        entity = new Entity("The entity");
    }

    @AfterEach
    public void tearDown() {
        entity = null;
    }

    @Test
    public void character_can_damage_entity() {
        Character attacker = new Character("Attacker") {
        };

        attacker.attack(entity);
        Assert.assertEquals(entity.getHealth(), 99);
    }

    @Test
    public void entity_can_t_damage_and_can_t_heal_and_be_heal() {
        Character character = new Character("Character") {
        };

        character.attack(entity);
        Assert.assertEquals(entity.getHealth(), 99);

        entity.attack(character);
        entity.attack(entity);
        Assert.assertEquals(character.getHealth(), 100);
        Assert.assertEquals(entity.getHealth(), 99);

        entity.heal(entity);
        character.heal(entity);
        Assert.assertEquals(entity.getHealth(), 99);
    }

    @Test
    public void entity_can_t_belong_faction() {
        Faction faction = new Faction("Useless Faction");
        entity.addFaction(faction);
        Assert.assertTrue(entity.getFactions().isEmpty());
    }

    
}
