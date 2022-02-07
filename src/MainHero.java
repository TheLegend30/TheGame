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
    private int health = 10;
    private int atk = 2;
    private int def = 0;
    private boolean dead = false;

    private MainHero() {
        Main.addText("Hello, what is your name?");
        Main.addText("To be serious, I don't care.");
        Main.addText("You trapped into scary dungeon. What you will do?");
        updateHeroInfo();
    }

    public void updateHeroInfo() {
        String heroStatText = "Name: " + this.getName() +
                "\nLevel: " + this.getLevel() +
                "\nHealth: " + this.getHealth() +
                "\nAttack: " + this.getAtk() +
                "\nDefense: " + this.getDef();
        Main.frame.heroStatTextArea.setText(heroStatText);
    }

    public void levelUp() {
        this.level++;
        this.atk += level;
        this.def += level * 0.5;
        this.health +=level*5;
        this.updateHeroInfo();
    }

    public void death() {
        if (this.health <= 0) {
            this.dead = true;
            JOptionPane.showMessageDialog(null,"You were killed");
            System.exit(0);
        }
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
}
