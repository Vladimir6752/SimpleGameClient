package org.example.listeners;

import org.example.visual.abstractcomponents.Window;

import java.util.TimerTask;

public class RepaintActionListener extends TimerTask {
    private final Window window;

    public RepaintActionListener(Window window) {
        this.window = window;
    }

    @Override
    public void run() {
        window.repaintWindow();
    }
}