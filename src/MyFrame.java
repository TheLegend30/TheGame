import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrame extends JFrame implements ActionListener {
    public MainTextArea mainTextArea;
    public HeroStatTextArea heroStatTextArea;
    public HeroTextInput heroTextInput;
    private Button helpButton;
    private final String helpText = "This is a roguelike game controlled by console input. There are several commands." +
            "\n * go - (obviously) to go" +
            //"\n * inv - for inventory" +
            "\n * atk - to attack" +
            //"\n * def - to defend" +
            "\n * esc - to escape" +
            "\nThis is arcade, so game doesn't have final or plot." +
            "\nThe goal is to pass more levels of the dungeon" +
            "\nThis is a very alpha version of game (0.01a)";

    public MyFrame() {

        helpButton = new Button("HELP");
        helpButton.setBounds(650, 425, 100, 100);
        helpButton.addActionListener(this);

        mainTextArea = new MainTextArea();

        heroStatTextArea = new HeroStatTextArea();

        heroTextInput = new HeroTextInput();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Little text game");
        this.setSize(800, 600);

        this.add(mainTextArea);
        this.add(heroStatTextArea);
        this.add(helpButton);
        this.add(heroTextInput);

        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == helpButton) {
            JOptionPane.showMessageDialog(null, helpText, "Help", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
