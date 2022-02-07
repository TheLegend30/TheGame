import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class HeroTextInput extends JTextField implements KeyListener {
    private String inputText = "";

    public HeroTextInput() {
        this.setBackground(Color.LIGHT_GRAY);
        this.setBorder(new LineBorder(Color.BLACK, 3));
        this.setFont(new Font("DejaVu Serif", Font.PLAIN, 50));
        this.setForeground(Color.BLACK);
        this.addKeyListener(this);
        this.setSize(200, 400);
        this.setBounds(0, 400, 600, 200);
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText() {
        this.inputText = this.getText();
        this.setText("");
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            setInputText();
            Game.getInstance().checkInput(this.getInputText());
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
