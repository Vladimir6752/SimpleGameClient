package org.example.ws;

import javax.websocket.CloseReason;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.Session;
import java.io.IOException;

public class WebSocketEndpoint extends Endpoint {
    private Session session;

    @Override
    public void onOpen(Session session, EndpointConfig config) {
        this.session = session;
        System.out.println("Connected to WebSocket server.");
    }

    @Override
    public void onClose(Session session, CloseReason reason) {
        System.out.println("Disconnected from WebSocket server.");
    }

    public void sendMessage(String message) throws IOException {
        session.getBasicRemote().sendText(message);
    }

    public void disconnect() throws IOException {
        session.close();
    }
}

