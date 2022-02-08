import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

class MainTextArea extends JTextArea {
    private ArrayList<String> allText = new ArrayList<>();

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
        if (allText.size() > 20) {
            allText.remove(0);
        }
        allText.add(
                "[" +
                        LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")) +
                        "] " +
                        text +
                        "\n");

        text = "";
        for (String s : allText) {
            text += s;
        }
        this.setText(text);
    }

    public void clear() {
        allText.clear();
        this.setText("");
    }
}
