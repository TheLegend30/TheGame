import javax.swing.*;
import java.util.Random;

class MainHero {
    private Random r;

    private static MainHero hero;

    public static MainHero getInstance() {
        if (hero == null) {
            hero = new MainHero();
            String name = JOptionPane.showInputDialog("Enter your name");
            hero.setName(name.isEmpty()? hero.getName() : name);
            hero.updateHeroInfo();
        }
        return hero;
    }

    private String name = "Unnamed";
    private int level = 1;
    private int gold = 0;
    private int health = 10;
    private int maxHealth = 10;
    private int atk = 2;
    private Location location = Location.TOWN;
    private int def = 0;
    private static final String prolog = "You are a simple peasant who works in the field all day long. One day you heard that a cave located near your town "
            + Game.getTownName()
            + " is full of treasures. But monsters and stuff hide it from prying eyes. You decide that no danger can stop you from becoming a treasure hunter. That day has come and you're ready to enter the cave.";

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
        String[] options = {"Health", "Attack", "Defense"};
        while (true) {
            int prefUpgrade = JOptionPane.showOptionDialog(Main.frame, "Congratulations! What do you want to upgrade?", "Level up", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, "Health");
            switch (prefUpgrade) {
                case 0:
                    maxHealth +=10;
                    break;
                case 1:
                    atk+=1;
                    break;
                case 2:
                    def+=1;
                    break;
                default:
                    continue;
            }
            break;
        }
        heal();
        this.updateHeroInfo();
    }

    public void death() {
        if (this.health <= 0) {
            JOptionPane.showMessageDialog(null, "You were killed.");
            System.exit(0);
        }
    }

    public void heal() {
        hero.setHealth(maxHealth);
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
