package org.example.visual.swingimplemetation;

import org.example.visual.abstractcomponents.Text;
import org.example.visual.abstractcomponents.VisualComponent;
import org.example.visual.abstractcomponents.Window;

import javax.swing.*;
import java.awt.*;

public class SwingWindow extends JFrame implements Window {
    public static final int WINDOW_WIDTH = 1600;
    public static final int WINDOW_HEIGHT = 900;
    public static final String WINDOW_TITLE = "Some title";
    private final Text text;
    private final Text pingText;
    private final Text waitingTimeText;

    public SwingWindow(Text text, Text pingText, Text waitingTimeText) {
        this.text = text;
        this.pingText = pingText;
        this.waitingTimeText = waitingTimeText;
        setDefaultSettings();

        //addKeyListener(new KeyListener());
        //addMouseListener(new MouseClickListenerImpl());

        setVisible(true);
    }

    @Override
    public void addComponent(VisualComponent visualComponent) {
        add((Component) visualComponent);
    }

    @Override
    public void repaintWindow() {
        repaint();
    }

    @Override
    public void updateFpsText(String fpsText) {
        this.text.setTxt(String.format("Fps: %s", fpsText));
    }

    @Override
    public void updatePingText(String pingText) {
        this.pingText.setTxt(String.format("Ping: %s", pingText));
    }

    @Override
    public void updateWaitingTimeText(String waitingTimeText) {
        this.waitingTimeText.setTxt(String.format("Wait: %s", waitingTimeText));
    }

    @Override
    public void resetWaitingTimeText() {
        this.waitingTimeText.setTxt("Not in queue");
    }

    private void setDefaultSettings() {
        setTitle(WINDOW_TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(1920 / 2 - WINDOW_WIDTH / 2, 1080 / 2 - WINDOW_HEIGHT / 2);

        getContentPane().setLayout(null);
    }
}
