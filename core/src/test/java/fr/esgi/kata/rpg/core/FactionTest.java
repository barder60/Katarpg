package fr.esgi.kata.rpg.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class FactionTest {

    Character character;

    @BeforeEach
    public void setUp() {
        character = new Character("First") {
        };
    }

    @AfterEach
    public void tearDown() {
        character = null;
    }

    @Test
    public void new_character_should_not_belong_to_any_faction() {
        Assert.assertTrue(character.getFactions().isEmpty());
    }

    @Test
    public void new_character_should_join_and_leave_faction() {

    }
}
