package org.example.visual;

import org.example.listeners.FpsValueUpdateActionListener;
import org.example.listeners.RepaintActionListener;
import org.example.listeners.TextUpdateActionListener;
import org.example.visual.abstractcomponents.*;
import org.example.visual.swingimplemetation.*;
import org.example.ws.WebSocketClient;

import java.util.Timer;

public class MainWindow {
    private final Text fpsText = new SwingText(0, 0, 150, 35);
    private final Text pingText = new SwingText(150, 0, 150, 35);
    private final Text waitingTimeText = new SwingText("Not in queue", 300, 0, 150, 35);
    private final Button startGameButton = new SwingButton(100, 35, 200, 35);
    private final ComboBox gameModesMenu = new SwingComboBox(new String[]{"PVP", "1v1"});
    private final Window window = new SwingWindow(fpsText, pingText, waitingTimeText);
    private boolean isWaitingGame = false;

    public MainWindow(String nickName) {
        window.addComponent(fpsText);
        window.addComponent(pingText);
        window.addComponent(startGameButton);
        window.addComponent(gameModesMenu);
        window.addComponent(waitingTimeText);

        startGameButton.setText("Start: " + nickName);

        startGameButton.addOnClickListener(o -> {
                    String quitOrAddQueueEvent = "aq";
                    if (isWaitingGame) {
                        window.resetWaitingTimeText();
                        quitOrAddQueueEvent = "rq";
                    }

                    WebSocketClient.sendMessage(
                            String.format(
                                    "pe;%s;%s;%s", quitOrAddQueueEvent, nickName, gameModesMenu.getSelectedElement()
                            )
                    );
                }
        );

        new Timer().scheduleAtFixedRate(new RepaintActionListener(window), 0, 16);
        new Timer().scheduleAtFixedRate(new FpsValueUpdateActionListener(), 0, 16);
        new Timer().scheduleAtFixedRate(new TextUpdateActionListener(window), 0, 500);
    }

    public Window getWindow() {
        return window;
    }
}
