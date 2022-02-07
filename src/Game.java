import java.util.Random;

class Game {
    private boolean fighting = false;
    private int countOfRooms = 0;
    private static Random r = new Random();
    private static Fight f;

    private static Game game;

    public static Game getInstance() {
        if (game == null) {
            game = new Game();
        }
        return game;
    }

    public void checkInput(String inputText) {
        if (inputText.equalsIgnoreCase("Talk")) {
            Main.addText("To who?");
        } else if (inputText.equalsIgnoreCase("atk") && !isFighting()) {
            Main.addText("There is nobody you can fight");
        } else if (inputText.equalsIgnoreCase("go") && !isFighting()) {
            Main.addText("You've come to the another room");
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
                Main.addText("You're attacking the monster");
                f.attack();
            } else if (inputText.equalsIgnoreCase("esc")) {
                f.moveEnemy();
                Main.addText("You're escaping");
                this.setFighting(false);
            }
        } else {
            Main.addText("What?");
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

    public static class Fight {
        Enemy enemy = new Enemy();

        public void attack() {
            enemy.setHealth(enemy.getHealth() - (MainHero.getInstance().getAtk() + r.nextInt(MainHero.getInstance().getLevel())));
            Main.addText("Enemy's health: " + enemy.health);
            if (enemy.health <= 0) {
                Main.addText("You've killed the monster!");
                game.setFighting(false);
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
            def = (0 + MainHero.getInstance().getLevel()) / 2;
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
