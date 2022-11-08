public class Level {
    private int levelNumber;
    private Character[] enemies;

    Level(int levelNumber, Character[] enemies) {
        this.setLevelNumber(levelNumber);
        this.setEnemies(enemies);
    }

    public Character[] getEnemies() {
        return enemies;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public void setEnemies(Character[] enemies) {
        this.enemies = enemies;
    }

}
