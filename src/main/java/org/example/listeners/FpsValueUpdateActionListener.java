package org.example.listeners;

import java.util.TimerTask;

public class FpsValueUpdateActionListener extends TimerTask {
    private double lastClipTime = System.currentTimeMillis();
    private static int framePerSeconds;

    @Override
    public void run() {
        setFpsText();
    }

    public static int getFramePerSeconds() {
        return framePerSeconds;
    }

    private void setFpsText() {
        double timeLastClip = System.currentTimeMillis() - lastClipTime;

        if(timeLastClip != 0) {
            FpsValueUpdateActionListener.framePerSeconds = (int) (1000 / timeLastClip);
        }

        lastClipTime = System.currentTimeMillis();
    }
}
