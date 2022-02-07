public class Main {
    public static MyFrame frame;
    public static MainHero mainHero;
    public static Game game;
    static {
        frame = new MyFrame();
        MainHero.getInstance();
        Game.getInstance();
    }

    public static void main(String[] args) {
    }

    public static void addText(String text) {
        Main.frame.mainTextArea.addText(text);
    }
}

