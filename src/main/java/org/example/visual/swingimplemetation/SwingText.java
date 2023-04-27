package org.example.visual.swingimplemetation;

import org.example.visual.abstractcomponents.Text;

import javax.swing.*;
import java.awt.*;

public class SwingText extends JLabel implements Text {
    public SwingText(int x, int y, int width, int height) {
        setBounds(x, y, width, height);
        setBackground(Color.white);
        setFont(new Font("arial", Font.BOLD, 25));
        setBorder(BorderFactory.createLineBorder(Color.blue));
    }

    public SwingText(String text, int x, int y, int width, int height) {
        this(x, y, width, height);
        setTxt(text);
    }

    @Override
    public void setTxt(String text) {
        setText(text);
    }
}
