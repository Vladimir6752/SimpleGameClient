package org.example.ws;

import org.example.ws.messaging.MessageHandler;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import java.io.IOException;
import java.net.URI;

public class WebSocketClient {
    private static final URI uri = URI.create("ws://localhost:8090/socket");
    private static WebSocketEndpoint endpoint;
    private static Session session;

    private WebSocketClient() {}

    public static void connect() {
        WebSocketClient.endpoint = new WebSocketEndpoint();

        try {
            session = tryConnect();
            session.addMessageHandler(String.class, new MessageHandler(endpoint));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void sendMessage(String message) {
        if(!session.isOpen()) return;

        try {
            endpoint.sendMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
            connect();
        }
    }

    private static Session tryConnect() {
        Session session = null;

        while (session == null) {
            try {
                session = ContainerProvider.getWebSocketContainer().connectToServer(endpoint, uri);
            } catch (Exception ignored) {}
        }

        return session;
    }
}
