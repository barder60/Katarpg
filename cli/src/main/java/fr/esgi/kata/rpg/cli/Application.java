package fr.esgi.kata.rpg.cli;

import fr.esgi.kata.rpg.core.Characters;
import fr.esgi.kata.rpg.core.Mage;
import fr.esgi.kata.rpg.core.Warrior;

public class Application {
    public static void main(String[] args) {
        Warrior lucas = new Warrior("Lucas");
        Warrior masa = new Warrior("Masa");
        Mage baptiste = new Mage("Baptiste");

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
