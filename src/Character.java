abstract public class Character {

    // normal attributes
    private String name;
    private double age;
    private double health;
    private double baseHealth = health;
    private double level;
    private boolean dead = false;
    private String race;

    // damage shield
    private double magicShield;
    private double meleeShield;
    private double rangedShield;

    // damage boost
    private double magicBoost;
    private double rangedBoost;
    private double meleeBoost;

    Character (String name, double age, double health, double level) {
        this.setAge(age);
        this.setName(name);
        this.setHealth(health);
        this.setLevel(level);
        this.setBaseHealth(health);
    }

    public void died() {
        this.setDead(true);
        System.out.println(this.getName() + " has died!");
    }

    public void checkHealth() {
        if (this.getHealth() <= 0 ) {
            this.died();
        }
        else {
            this.setHealth(Math.round(this.getHealth()));
            System.out.println(this.getName() + " has " + this.getHealth() + "hp left. ");
        }
    }

    public void magicAttack(Character toAttack) {
        MagicDamage damage = new MagicDamage();
        if (this.isDead()) {
        }
        else if (toAttack.isDead()) {
            System.out.println("You can't attack a dead character! ");
        }
        else {
            if (damage.allowsCrit()) {
                damage.setFinalDamage(Math.round((damage.getBaseDamage() + damage.getCritDamage() + this.getMagicBoost()) - ((damage.getBaseDamage() + damage.getCritDamage() + this.getMagicBoost())/100*toAttack.getMagicShield())));
                System.out.println(this.getName() + " has attacked " + toAttack.getName() + " and has dealt \033[0;31m" + damage.getFinalDamage() + " critical \033[0;35m" + damage.getDamageType() + "\033[0m damage!");
            }
            else {
                damage.setFinalDamage(Math.round((damage.getBaseDamage() + this.getMagicBoost()) - ((damage.getBaseDamage() + this.getMagicBoost())/100*toAttack.getMagicShield())));
                System.out.println(this.getName() + " has attacked " + toAttack.getName() + " and has dealt \033[0;31m" + damage.getFinalDamage() + " \033[0;35m" + damage.getDamageType() + "\033[0m damage!");
            }
            toAttack.setHealth(toAttack.getHealth() - damage.getFinalDamage());
            toAttack.checkHealth();
        }
    }
    public void meleeAttack(Character toAttack) {
        MeleeDamage damage = new MeleeDamage();
        if (this.isDead()) {
        }
        else if (toAttack.isDead()) {
            System.out.println("You can't attack a dead character! ");
        }
        else {
            if (damage.allowsCrit()) {
                damage.setFinalDamage(Math.round((damage.getBaseDamage() + damage.getCritDamage() + this.getMeleeBoost()) - ((damage.getBaseDamage() + damage.getCritDamage() + this.getMeleeBoost())/100*toAttack.getMeleeShield())));
                System.out.println(this.getName() + " has attacked " + toAttack.getName() + " and has dealt \033[0;31m" + damage.getFinalDamage() + " critical \033[0;33m" + damage.getDamageType() + "\033[0m damage!");
            }
            else {
                damage.setFinalDamage(Math.round((damage.getBaseDamage() + this.getMeleeBoost()) - ((damage.getBaseDamage() + this.getMeleeBoost())/100*toAttack.getMeleeShield())));
                System.out.println(this.getName() + " has attacked " + toAttack.getName() + " and has dealt \033[0;31m" + damage.getFinalDamage() + " \033[0;33m" + damage.getDamageType() + "\033[0m damage!");
            }
            toAttack.setHealth(toAttack.getHealth() - damage.getFinalDamage());
            toAttack.checkHealth();
        }
    }
    public void rangedAttack(Character toAttack) {
        RangedDamage damage = new RangedDamage();
        if (this.isDead()) {
        }
        else if (toAttack.isDead()) {
            System.out.println("You can't attack a dead character! ");
        }
        else {
            if (damage.allowsCrit()) {
                damage.setFinalDamage(Math.round((damage.getBaseDamage() + damage.getCritDamage() + this.getRangedBoost()) - ((damage.getBaseDamage() + damage.getCritDamage() + this.getRangedBoost())/100*toAttack.getRangedShield())));                System.out.println(this.getName() + " has attacked " + toAttack.getName() + " and has dealt \033[0;31m" + damage.getFinalDamage() + " critical \033[036m" + damage.getDamageType() + "\033[0m damage!");
            }
            else {
                damage.setFinalDamage(Math.round((damage.getBaseDamage() + this.getRangedBoost()) - ((damage.getBaseDamage() + this.getRangedBoost())/100*toAttack.getRangedShield())));
                System.out.println(this.getName() + " has attacked " + toAttack.getName() + " and has dealt \033[0;31m" + damage.getFinalDamage() + " \033[0;36m" + damage.getDamageType() + "\033[0m damage!");
            }
            toAttack.setHealth(toAttack.getHealth() - damage.getFinalDamage());
            toAttack.checkHealth();
        }
    }

    public String getName() {
        return name;
    }
    public double getAge() {
        return age;
    }
    public double getHealth() {
        return health;
    }
    public double getLevel() {
        return level;
    }
    public boolean isDead() {
        return dead;
    }
    public String getRace() {
        return race;
    }
    public double getBaseHealth() {
        return baseHealth;
    }
    public double getRangedShield() {
        return rangedShield;
    }
    public double getMeleeShield() {
        return meleeShield;
    }
    public double getMagicShield() {
        return magicShield;
    }
    public double getMagicBoost() {
        return magicBoost;
    }
    public double getMeleeBoost() {
        return meleeBoost;
    }
    public double getRangedBoost() {
        return rangedBoost;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDead(boolean dead) {
        this.dead = dead;
    }
    public void setAge(double age) {
        this.age = age;
    }
    public void setLevel(double level) {
        this.level = level;
    }
    public void setHealth(double health) {
        this.health = health;
    }
    public void setRace(String race) {
        this.race = race;
    }
    public void setBaseHealth(double baseHealth) {
        this.baseHealth = baseHealth;
    }
    public void setRangedShield(double rangedShield) {
        this.rangedShield = rangedShield;
    }
    public void setMeleeShield(double meleeShield) {
        this.meleeShield = meleeShield;
    }
    public void setMagicShield(double magicShield) {
        this.magicShield = magicShield;
    }
    public void setMagicBoost(double magicBoost) {
        this.magicBoost = magicBoost;
    }
    public void setMeleeBoost(double meleeBoost) {
        this.meleeBoost = meleeBoost;
    }
    public void setRangedBoost(double rangedBoost) {
        this.rangedBoost = rangedBoost;
    }

    @Override
    public String toString() {
        return "\033[0;32mCharacter{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", health=" + health +
                ", level=" + level +
                ", dead=" + dead +
                ", race='" + race + '\'' +
                "}\033[0;0m";
    }
}
class Wizard extends Character {
    Wizard(String name, int age, int health, int level) {
        super(name, age, health, level);
        this.setRace("Wizard");
        this.setMagicBoost(30);
        this.setMeleeBoost(20);
        this.setRangedBoost(10);
        this.setMagicShield(30);
        this.setMeleeShield(20);
        this.setRangedShield(10);
    }
}
class Elf extends Character {
    Elf(String name, int age, int health, int level) {
        super(name, age, health, level);
        this.setRace("Elf");
        this.setMagicBoost(5);
        this.setMeleeBoost(20);
        this.setRangedBoost(20);
        this.setMagicShield(5);
        this.setMeleeShield(20);
        this.setRangedShield(20);
    }
}
class Demon extends Character {
    Demon(String name, int age, int health, int level) {
        super(name, age, health, level);
        this.setRace("Demon");
        this.setMagicBoost(10);
        this.setMeleeBoost(10);
        this.setRangedBoost(10);
        this.setMagicShield(10);
        this.setMeleeShield(10);
        this.setRangedShield(10);
    }
}
class Human extends Character {
    Human(String name, int age, int health, int level) {
        super(name, age, health, level);
        this.setRace("Human");
        this.setMagicBoost(0);
        this.setMeleeBoost(10);
        this.setRangedBoost(5);
        this.setMagicShield(0);
        this.setMeleeShield(10);
        this.setRangedShield(5);
    }
}
class Dwarf extends Character {
    Dwarf(String name, double age, double health, double level) {
        super(name, age, health, level);
        this.setRace("Dwarf");
        this.setMagicBoost(5);
        this.setMeleeBoost(25);
        this.setRangedBoost(15);
        this.setMagicShield(5);
        this.setMeleeShield(25);
        this.setRangedShield(15);
    }
}
