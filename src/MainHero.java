import javax.swing.*;
import java.util.Random;

class MainHero {
    private Random r;

    private static MainHero hero;

    public static MainHero getInstance() {
        if (hero == null) {
            hero = new MainHero();
        }
        return hero;
    }

    private String name = "Unnamed";
    private int level = 1;
    private int gold = 0;
    private int health = 10;
    private int maxHealth = 10;
    private int atk = 2;
    private Location location = Location.DUNGEON;
    private int def = 0;
    private boolean dead = false;
    private static final String prolog = "You are a simple peasant who works in the field all day long. One day you heard that a cave located near your town "
            + Game.getTownName()
            + " is full of treasures. But monsters and stuff hide it from prying eyes. You decide that no danger can stop you from becoming a treasure hunter. That day has come and you have entered the cave.";

    private MainHero() {
        Main.addText(prolog);
        updateHeroInfo();
    }

    public void updateHeroInfo() {
        String heroStatText = "Name: " + this.getName() +
                "\nLevel: " + this.getLevel() +
                "\nHealth: " + this.getHealth() +
                "\nAttack: " + this.getAtk() +
                "\nDefense: " + this.getDef() +
                "\nGold: " + this.getGold() +
                "\nLocation: " + this.getLocation().getName();
        Main.frame.heroStatTextArea.setText(heroStatText);
    }

    public void levelUp() {
        this.level++;
        this.atk += level;
        this.def += level * 0.5;
        this.maxHealth += level * 5;
        this.health = maxHealth;
        this.updateHeroInfo();
    }

    public void death() {
        if (this.health <= 0) {
            this.dead = true;
            JOptionPane.showMessageDialog(null, "You were killed.");
            System.exit(0);
        }
    }

    public void heal() {
        hero.setHealth(maxHealth);
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
