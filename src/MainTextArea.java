import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

class MainTextArea extends JTextArea {

    public MainTextArea() {
        this.setBackground(Color.LIGHT_GRAY);
        this.setEditable(false);
        this.setBorder(new LineBorder(Color.BLACK, 3));
        this.setFont(new Font("DejaVu Serif", Font.PLAIN, 15));
        this.setForeground(Color.BLACK);
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.setSize(600, 400);
    }

    public void addText(String text) {
        text = ("[" +
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")) +
                "] " +
                text +
                "\n");
        this.append(text);
    }

    public void clear() {
        this.setText("");
    }
}
