package org.example.visual.swingimplemetation;

import org.example.visual.abstractcomponents.ComboBox;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class SwingComboBox extends JComboBox<String> implements ComboBox {
    public SwingComboBox(String[] items) {
        super(items);

        setBounds(0, 35, 100, 35);
        setBackground(Color.white);
        setFont(new Font("arial", Font.BOLD, 25));
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    @Override
    public void addOnSubmitListener(Consumer<?> listener) {
        addActionListener(e -> listener.accept(null));
    }

    @Override
    public String getSelectedElement() {
        return (String) getSelectedItem();
    }
}
