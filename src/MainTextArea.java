import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class MainTextArea extends JTextArea {
    private static int countOfLines = 0;

    public MainTextArea() {
        this.setBackground(Color.LIGHT_GRAY);
        this.setEditable(false);
        this.setBorder(new LineBorder(Color.BLACK, 3));
        this.setFont(new Font("DejaVu Serif", Font.PLAIN, 15));
        this.setForeground(Color.BLACK);
        this.setSize(600, 400);
    }

    public void addText(String text) {
        if (countOfLines > 20) {
            this.setText("");
            countOfLines = 1;
        }
        this.setText(this.getText() +
                "[" +
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")) +
                "] " +
                text +
                "\n"
        );
        countOfLines++;
    }
}
