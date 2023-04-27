package org.example.ws.messaging;

import org.example.Main;
import org.example.ws.WebSocketClient;
import org.example.ws.WebSocketEndpoint;

import java.util.Timer;
import java.util.TimerTask;

public class MessageHandler implements javax.websocket.MessageHandler.Whole<String> {
    private final Timer pingTimer = new Timer();
    private long lastPong = System.currentTimeMillis();
    private final WebSocketEndpoint webSocketEndpoint;
    private static long ping;

    public MessageHandler(WebSocketEndpoint webSocketEndpoint) {
        this.webSocketEndpoint = webSocketEndpoint;

        pingTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                sendPing();
            }
        }, 0, 3000);
    }

    @Override
    public void onMessage(String s) {
        if(s.equals("pong")) {
            setPong();
            return;
        }

        String[] sharedMessage = s.split(";");

        if(sharedMessage[0].equals("t")) {
            Main.mainWindow.updateWaitingTimeText(sharedMessage[1]);
            return;
        }

        if(sharedMessage[0].equals("gs")) {
            Main.mainWindow.resetWaitingTimeText();
        }
    }

    public static long getPing() {
        return ping;
    }

    private void setPong() {
        MessageHandler.ping = System.currentTimeMillis() - lastPong;
    }

    private void sendPing() {
        try {
            webSocketEndpoint.sendMessage("ping");
            lastPong = System.currentTimeMillis();
        } catch (Exception e) {
            e.printStackTrace();
            WebSocketClient.connect();
            pingTimer.cancel();
        }
    }
}
