package fr.esgi.kata.rpg.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class FactionTest {

    private Faction faction;

    @BeforeEach
    public void setUp() {
        faction = new Faction("1st Faction");
    }

    @AfterEach
    public void tearDown() {
        faction = null;
    }

}
