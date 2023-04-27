package org.example;

import org.example.visual.MainWindow;
import org.example.visual.abstractcomponents.Window;
import org.example.ws.WebSocketClient;

public class Main {
    public static Window mainWindow;

    public static void main(String[] args) {
        WebSocketClient.connect();

        String nickName = "Vova123";

        if(args.length != 0)
            nickName = args[0];

        mainWindow = new MainWindow(nickName).getWindow();
    }
}