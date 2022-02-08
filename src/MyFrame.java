import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrame extends JFrame {
    public MainTextArea mainTextArea;
    public HeroStatTextArea heroStatTextArea;
    public HeroTextInput heroTextInput;
    private JScrollPane scrollPane;
    private Button helpButton;
    private final String helpText = """
            This is a roguelike game controlled by console input. There are several commands.
             * go - (obviously) to go
             * atk - to attack
             * esc - to escape
             * clr - to clear main console
             * town/dung - to go to town/dungeon
            This is arcade, so game doesn't have final or plot.
            The goal is to pass more levels of the dungeon
            This is a very alpha version of game (0.01b)""";

    public MyFrame() {

        helpButton = new Button("HELP");
        helpButton.setBounds(650, 425, 100, 100);
        helpButton.addActionListener((e -> JOptionPane.showMessageDialog(null, helpText, "Help", JOptionPane.INFORMATION_MESSAGE)));

        mainTextArea = new MainTextArea();

        heroStatTextArea = new HeroStatTextArea();

        heroTextInput = new HeroTextInput();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("The great ballad of the fallen in the darkest of all dungeons");
        this.setSize(800, 600);
        this.setIconImage(new ImageIcon("sword.png").getImage());

        scrollPane = new JScrollPane(mainTextArea);
        scrollPane.setSize(new Dimension(600, 400));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


        this.add(scrollPane);
        this.add(heroStatTextArea);
        this.add(helpButton);
        this.add(heroTextInput);

        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
    }
}
