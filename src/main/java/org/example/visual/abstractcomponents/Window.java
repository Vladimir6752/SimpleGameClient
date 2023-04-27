package org.example.visual.abstractcomponents;

public interface Window {
    void addComponent(VisualComponent visualComponent);

    default void repaintWindow() {}

    void updateFpsText(String fpsText);

    void updatePingText(String pingText);

    void updateWaitingTimeText(String pingText);

    void resetWaitingTimeText();
}
