package org.example.visual.swingimplemetation;

import org.example.visual.abstractcomponents.Button;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class SwingButton extends JButton implements Button {
    public SwingButton(String text, int x, int y, int width, int height) {
        setBounds(x, y, width, height);
        setBackground(Color.white);
        setFont(new Font("arial", Font.BOLD, 25));
        setBorder(BorderFactory.createLineBorder(Color.black));
        setText(text);
    }

    public SwingButton(int x, int y, int width, int height) {
        this("", x, y, width, height);
    }

    @Override
    public void addOnClickListener(Consumer<?> consumer) {
        addActionListener(e -> consumer.accept(null));
    }
}
