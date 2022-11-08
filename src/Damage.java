import java.util.Random;

abstract public class Damage {

    private boolean allowCrit;
    private double baseDamage;
    private double critDamage;
    private double critChance;
    private String damageType;
    private double finalDamage;


    public double getBaseDamage() {
        return baseDamage;
    }
    public double getCritChance() {
        return critChance;
    }
    public double getCritDamage() {
        return critDamage;
    }
    public boolean allowsCrit() {
        return allowCrit;
    }
    public String getDamageType() {
        return damageType;
    }
    public double getFinalDamage()
    {
        return finalDamage;
    }

    public void setBaseDamage(double baseDamage) {
        this.baseDamage = baseDamage;
    }
    public void setCritChance(double critChance) {
        this.critChance = critChance;
    }
    public void setCritDamage(double critDamage) {
        this.critDamage = critDamage;
    }
    public void setAllowCrit(boolean allowCrit) {
        this.allowCrit = allowCrit;
    }
    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }
    public void setFinalDamage(double finalDamage) {
        this.finalDamage = finalDamage;
    }
}

class MagicDamage extends Damage {
    MagicDamage () {
        this.setDamageType("Magic");
        this.setCritChance(17.5);
        this.setCritDamage(new Random().nextInt(10, 41));
        this.setBaseDamage(new Random().nextInt(25, 56));
        double rnd = new Random().nextFloat(100);
        if (rnd+1 <= this.getCritChance()) {
            setAllowCrit(true);
        }
        else {
            setAllowCrit(false);
        }
    }
}
class MeleeDamage extends Damage {
    MeleeDamage() {
        this.setDamageType("Melee");
        this.setCritChance(15);
        this.setCritDamage(new Random().nextInt(10, 36));
        this.setBaseDamage(new Random().nextInt(25, 51));
        double rnd = new Random().nextInt(100);
        if (rnd+1 <= this.getCritChance()) {
            setAllowCrit(true);
        }
        else {
            setAllowCrit(false);
        }
    }
}
class RangedDamage extends Damage {
    RangedDamage() {
        this.setDamageType("Ranged");
        this.setCritChance(15);
        this.setCritDamage(new Random().nextInt(10, 36));
        this.setBaseDamage(new Random().nextInt(25, 51));
        double rnd = new Random().nextInt(100);
        if (rnd+1 <= this.getCritChance()) {
            setAllowCrit(true);
        }
        else {
            setAllowCrit(false);
        }
    }
}