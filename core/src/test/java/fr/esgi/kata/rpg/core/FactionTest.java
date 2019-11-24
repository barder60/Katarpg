package fr.esgi.kata.rpg.core;

import fr.esgi.kata.rpg.core.job.Warrior;
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


    @Test
    public void new_character_should_not_belong_to_any_faction() {
        Character character = new Character("Character") {
        };

        Assert.assertTrue(character.getFactions().isEmpty());
    }

    @Test
    public void character_should_join_and_leave_faction() {
        Character character = new Character("Character") {
        };

        character.addFaction(faction);
        Assert.assertTrue(character.getFactions().contains(faction));
        character.removeFaction(faction);
        Assert.assertFalse(character.getFactions().contains(faction));
    }

    @Test
    public void character_can_t_damage_another_character_of_same_faction() {
        Character character = new Character("Character") {
        };
        Character brotherFaction = new Character("Bro") {
        };

        character.addFaction(faction);
        brotherFaction.addFaction(faction);

        character.attack(brotherFaction);
        brotherFaction.attack(character);
        Assert.assertEquals(character.getHealth(), 100);
        Assert.assertEquals(brotherFaction.getHealth(), 100);
    }

    @Test
    public void character_should_only_heal_character_of_same_faction() {
        Character character = new Character("Character") {
        };
        Character brotherFaction = new Character("Bro") {
        };
        Character notBro = new Character("No Bro") {
        };
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

    @Test
    public void faction_may_declare_one_or_more_faction_friends() {
        Faction friend1 = new Faction("1st friend");
        Faction friend2 = new Faction("2nd friend");

        faction.addAlliedFaction(friend1);
        Assert.assertTrue(faction.isAlliedFaction(friend1));

        faction.addAlliedFaction(friend2);
        Assert.assertTrue(faction.isAlliedFaction(friend1));
        Assert.assertTrue(faction.isAlliedFaction(friend2));
    }

    @Test
    public void character_can_t_damage_another_character_same_faction() {
        Character character = new Character("Character") {
        };
        Warrior conan = new Warrior("Conan") {
        };

        character.addFaction(faction);
        conan.addFaction(faction);

        character.attack(conan);
        conan.attack(character);
        while(conan.getAttackStrength() <= 0) {
            conan.attack(character);
        }

        Assert.assertEquals(character.getHealth(), 100);
        Assert.assertEquals(conan.getHealth(), 100);
    }

    @Test
    public void character_can_only_heal_another_character_of_same_faction() {
        Warrior hero = new Warrior("Musashi") {
        };
        Character ally = new Character("Ally") {
        };
        Character enemy = new Character("Enemy") {
        };
        var enemyFaction = new Faction("Enemy Faction");

        hero.addFaction(faction);
        ally.addFaction(faction);
        enemy.addFaction(enemyFaction);

        enemy.attack(hero);
        ally.attack(enemy);

        ally.heal(enemy);
        Assert.assertEquals(enemy.getHealth(), 99);
        ally.heal(hero);
        Assert.assertEquals(hero.getHealth(), 100);
    }

    @Test
    public void character_may_now_belong_one_or_more_factions() {
        Character isFriendHero = new Character("Two sides Hero") {
        };
        var darkFaction = new Faction("DarkSide");
        var goodFaction = new Faction("GoodSide");

        isFriendHero.addFaction(darkFaction);
        isFriendHero.addFaction(goodFaction);

        Assert.assertEquals(isFriendHero.getFactions().size(), 2);
        Assert.assertTrue(isFriendHero.getFactions().contains(darkFaction));
        Assert.assertTrue(isFriendHero.getFactions().contains(goodFaction));
    }
}
