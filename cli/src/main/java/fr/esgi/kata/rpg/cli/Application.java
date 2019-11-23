package fr.esgi.kata.rpg.cli;

import fr.esgi.kata.rpg.core.*;

public class Application {
    public static void main(String[] args) {
        Warrior lucas = new Warrior("Lucas");
        Warrior masa = new Warrior("Masa");
        Mage baptiste = new Mage("Baptiste");
        Entity entity = new Entity("Entité");

        System.out.println(masa);
        System.out.println(lucas);
        System.out.println(baptiste);

        // test add factions
        System.out.println("---Test add faction ---");
        lucas.addFaction(new Faction("Toto"));
        masa.addFaction(new Faction("Toto"));
        masa.addFaction(new Faction("Tata"));
        baptiste.addFaction(new Faction("Tata"));
        System.out.println(masa);
        System.out.println(lucas);
        System.out.println(baptiste);
        System.out.println();

        // test attack don't reduce health if character is same faction
        System.out.println("---Test attack don't reduce health if character is same faction---");
        lucas.attack(masa);
        masa.attack(baptiste);
        lucas.attack(baptiste);
        System.out.println(masa);
        System.out.println(lucas);
        System.out.println(baptiste);
        System.out.println();

        // test remove faction can damage character that had same faction
        System.out.println("---Test remove faction can damage character that had same faction---");
        masa.removeFaction(new Faction("Toto"));
        masa.attack(lucas);
        System.out.println(masa);
        System.out.println(lucas);
        System.out.println(baptiste);
        System.out.println();

        // test entity
        System.out.println("---Test entity---");
        System.out.println(lucas);
        System.out.println(entity);
        // test entity can't attack and can't join faction
        System.out.println("-Test entity can't attack and can't join faction-");
        lucas.attack(entity);
        entity.attack(lucas);
        entity.attack(entity);
        entity.addFaction(new Faction("Toto"));
        System.out.println(lucas);
        System.out.println(entity);
        // test entity can't heal and can't be healed
        System.out.println("-Test can't heal and can't be healed-");
        entity.heal(lucas);
        baptiste.heal(entity);
        System.out.println(lucas);
        System.out.println(entity);
        System.out.println();

        // test

        // intense battle
        System.out.println("---INSANE BATTLE !!!---");
        for(var i = 0; i < 100; i++){
            lucas.attack(masa);
            baptiste.heal(masa);
            masa.attack(baptiste);
            baptiste.attack(lucas);
            masa.attack(lucas);
            lucas.attack(baptiste);
            baptiste.heal(baptiste);
        }

        System.out.println(masa);
        System.out.println(lucas);
        System.out.println(baptiste);
    }
}
