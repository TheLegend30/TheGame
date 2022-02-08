import java.io.*;
import java.util.ArrayList;
import java.util.Random;

class Game {
    private static final ArrayList<String> GAMETEXTCONTENTLIST = new ArrayList<>();
    private static String townName = null;
    private static final Random r = new Random();

    static {
        {
            try {
                BufferedReader textReader = new BufferedReader(new FileReader("src/textContent.txt"));
                while (textReader.ready()) {
                    GAMETEXTCONTENTLIST.add(textReader.readLine());
                }
                townName = GAMETEXTCONTENTLIST.get(r.nextInt(11, 30));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean fighting = false;
    private int countOfRooms = 0;
    private static Fight f;

    private static Game game;

    public static Game getInstance() {
        if (game == null) {
            game = new Game();
        }
        return game;
    }

    public void checkInput(String inputText) {
        if (MainHero.getInstance().getLocation().getName().equalsIgnoreCase(Location.DUNGEON.getName())) {
            if (inputText.equalsIgnoreCase("Talk")) {
                Main.addText("To who?");
            } else if (inputText.equalsIgnoreCase("clr")) {
                Main.frame.mainTextArea.clear();
            } else if (inputText.equalsIgnoreCase("town")) {
                Main.addText("You get back to your town " + townName + "\n You can visit the tavern");
                MainHero.getInstance().setLocation(Location.TOWN);
                MainHero.getInstance().updateHeroInfo();
            } else if (inputText.equalsIgnoreCase("atk") && !isFighting()) {
                Main.addText("There is nobody you can fight.");
            } else if (inputText.equalsIgnoreCase("go") && !isFighting()) {
                Main.addText("You've come to the another room.");
                Main.addText(GAMETEXTCONTENTLIST.get(r.nextInt(0, 10)));
                this.setFighting(r.nextBoolean());
                countOfRooms++;
                if (countOfRooms == 5) {
                    countOfRooms = 0;
                    Main.addText("Level up!");
                    MainHero.getInstance().levelUp();
                }
                if (this.isFighting()) {
                    Main.addText("You found a monster!");
                    f = new Fight();
                }
            } else if (isFighting()) {
                if (inputText.equalsIgnoreCase("atk")) {
                    Main.addText("You're attacking the monster.");
                    f.attack();
                } else if (inputText.equalsIgnoreCase("esc")) {
                    f.moveEnemy();
                    Main.addText("You're escaping.");
                    this.setFighting(false);
                }
            } else {
                Main.addText("What?");
            }
        } else if (MainHero.getInstance().getLocation().getName().equalsIgnoreCase(Location.TOWN.getName())) {
            if (inputText.equalsIgnoreCase("dung")) {
                Main.addText("You came back to dungeon");
                MainHero.getInstance().setLocation(Location.DUNGEON);
                MainHero.getInstance().updateHeroInfo();
            } else if (inputText.equalsIgnoreCase("tavern")) {
                Main.addText("You enter to the local tavern. You can drink here or talk to the bartender, for some cash of course");
                MainHero.getInstance().setLocation(Location.TAVERN);
                MainHero.getInstance().updateHeroInfo();
            } else {
                Main.addText("What?");
            }
        } else if (MainHero.getInstance().getLocation().getName().equalsIgnoreCase(Location.TAVERN.getName())) {
            if (inputText.equalsIgnoreCase("town")) {
                Main.addText("You get back to main street of the town");
                MainHero.getInstance().setLocation(Location.TOWN);
                MainHero.getInstance().updateHeroInfo();
            } else if (inputText.equalsIgnoreCase("drink")) {
                if (MainHero.getInstance().getGold() == 0) {
                    Main.addText("Leave the tavern, you filth beggar!");
                } else {
                    MainHero.getInstance().setGold(MainHero.getInstance().getGold()-1);
                    Main.addText("YAPPY! (somehow you've restored your health)");
                    MainHero.getInstance().heal();
                    MainHero.getInstance().updateHeroInfo();
                }
            } else if (inputText.equalsIgnoreCase("talk")) {
                if (MainHero.getInstance().getGold() == 0) {
                    Main.addText("I won't talk for free. Leave me alone, " + MainHero.getInstance().getName());
                } else {
                    MainHero.getInstance().setGold(MainHero.getInstance().getGold()-1);
                    Main.addText(GAMETEXTCONTENTLIST.get(r.nextInt(33,35)));
                    MainHero.getInstance().updateHeroInfo();
                }
            } else {
                Main.addText("What?");
            }
        }
    }

    private Game() {

    }

    public boolean isFighting() {
        return fighting;
    }

    public void setFighting(boolean fighting) {
        this.fighting = fighting;
    }

    public static String getTownName() {
        return townName;
    }

    public static class Fight {
        Enemy enemy = new Enemy();

        public void attack() {
            enemy.setHealth(enemy.getHealth() - (MainHero.getInstance().getAtk() + r.nextInt(MainHero.getInstance().getLevel())));
            Main.addText("Enemy's health: " + enemy.health);
            if (enemy.health <= 0) {
                Main.addText("You've killed the monster!");
                Main.addText("You've won!");
                int coinsWonCount = r.nextInt(10);
                MainHero.getInstance().setGold(coinsWonCount);
                Main.addText("You've found a few coins in the monster corpse: " + coinsWonCount);
                game.setFighting(false);
                MainHero.getInstance().updateHeroInfo();
                return;
            }
            moveEnemy();
        }

        public void moveEnemy() {
            Main.addText("Enemy is attacking you!");
            enemy.attack();
            MainHero.getInstance().updateHeroInfo();
            MainHero.getInstance().death();
        }
    }

    public static class Enemy {
        private int health;
        private int atk;
        private int def;

        public Enemy() {
            health = (5 * MainHero.getInstance().getLevel());
            atk = (1 + MainHero.getInstance().getLevel());
            def = (MainHero.getInstance().getLevel()) / 2;
        }

        public void attack() {
            MainHero.getInstance().setHealth(MainHero.getInstance().getHealth() - (atk + r.nextInt(MainHero.getInstance().getLevel())));
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
}
