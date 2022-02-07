import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

class HeroStatTextArea extends JTextArea implements ChangeListener {
    public HeroStatTextArea() {
        this.setBackground(Color.LIGHT_GRAY);
        this.setEditable(false);
        this.setBorder(new LineBorder(Color.BLACK, 3));
        this.setFont(new Font("DejaVu Serif", Font.PLAIN, 20));
        this.setForeground(Color.BLACK);
        this.setSize(200, 400);
        this.setBounds(600, 0, 200, 400);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        MainHero.getInstance().updateHeroInfo();
    }
}
