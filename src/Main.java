import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        Character char1 = new Wizard("Yahel", 14, 200, 15);
        Character enemy1 = new Elf("Bog", 371, 200, 15);
        Character enemy2 = new Dwarf("Zig", 57, 150, 20);
        startLevel(char1, new Level(1, new Character[]{enemy1, enemy2}));
    }

    public static void startMatch(Character goodCharacter, Character badCharacter) {
        while (!goodCharacter.isDead() && !badCharacter.isDead()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What attack would you like to do? Magic/Melee/Ranged");
            String input = scanner.nextLine().toLowerCase(Locale.ROOT);
            switch (input) {
                case "magic" -> goodCharacter.magicAttack(badCharacter);
                case "melee" -> goodCharacter.meleeAttack(badCharacter);
                case "ranged" -> goodCharacter.rangedAttack(badCharacter);
                default -> System.out.println("You didn't enter an attack so you gave your turn up.");
            }
            int rnd1 = new Random().nextInt(3);
            switch (rnd1) {
                case 0 -> badCharacter.magicAttack(goodCharacter);
                case 1 -> badCharacter.meleeAttack(goodCharacter);
                case 2 -> badCharacter.rangedAttack(goodCharacter);
            }
        }
    }

    public static void startLevel(Character mainCharacter, Level level) {
        for (int i=0; i<level.getEnemies().length; i++) {
            boolean victory = startFight(mainCharacter, level.getEnemies()[i]);
            if (victory) {
                System.out.println("Congratulations! You have won this fight. ");
                mainCharacter.setHealth((mainCharacter.getBaseHealth()/10)*9);
            }
            else {
                System.out.println("You lost this level.");
                exit(0);
            }
        }
        System.out.println("You passed this level!");
    }

    public static boolean startFight(Character mainCharacter, Character badCharacter) {
        while (!mainCharacter.isDead() && !badCharacter.isDead()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What attack would you like to do? Magic/Melee/Ranged");
            String input = scanner.nextLine().toLowerCase(Locale.ROOT);
            switch (input) {
                case "magic" -> mainCharacter.magicAttack(badCharacter);
                case "melee" -> mainCharacter.meleeAttack(badCharacter);
                case "ranged" -> mainCharacter.rangedAttack(badCharacter);
                default -> System.out.println("You didn't enter an attack so you gave your turn up.");
            }
            int rnd2 = new Random().nextInt(3);
            switch (rnd2) {
                case 0 -> badCharacter.magicAttack(mainCharacter);
                case 1 -> badCharacter.meleeAttack(mainCharacter);
                case 2 -> badCharacter.rangedAttack(mainCharacter);
            }
        }

        if (mainCharacter.isDead()) {
            System.out.println("You were defeated!");
            return false;
        }
        else {
            System.out.println("You have defeated this foe!");
            return true;
        }
    }
}