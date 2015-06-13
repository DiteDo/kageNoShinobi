package com.ditedo.kagenoshinobi;

import android.graphics.Canvas;

/**
 * Created by ditedo on 31/05/15.
 */
public class GameLoopThread extends Thread {
    static final long FPS = 20;
    private GameView view;
    private boolean running = false;

    public GameLoopThread(GameView view) {
        this.view = view;
    }

    public void setRunning(boolean run) {
        this.running = run;
    }

    @Override
    public void run() {

        while (running) {
            long ticksPS = 1000 / FPS;
            long startTime;
            long sleepTime;
            Canvas c = null;
            startTime = System.currentTimeMillis();

            try {
                c = view.getHolder().lockCanvas();
                synchronized (view.getHolder()) {
                    view.onDraw(c);
                }
            } finally {
                if (c != null) {
                    view.getHolder().unlockCanvasAndPost(c);
                }
            }

            sleepTime = ticksPS -(System.currentTimeMillis() - startTime);
            try {
                if (sleepTime > 0)
                    sleep(sleepTime);
                else
                    sleep(10);
            } catch (Exception e) {

            }
        }
    }
}
