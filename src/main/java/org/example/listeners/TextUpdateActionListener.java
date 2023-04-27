package org.example.listeners;

import org.example.visual.abstractcomponents.Window;
import org.example.ws.messaging.MessageHandler;

import java.util.TimerTask;

public class TextUpdateActionListener extends TimerTask {
    private final Window window;

    public TextUpdateActionListener(Window window) {
        this.window = window;
    }

    @Override
    public void run() {
        setPingText();
        setFpsText();
    }

    private void setFpsText() {
        window.updateFpsText(String.valueOf(FpsValueUpdateActionListener.getFramePerSeconds()));
    }

    private void setPingText() {
        window.updatePingText(String.valueOf(MessageHandler.getPing()));
    }
}
