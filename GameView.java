package com.ditedo.kagenoshinobi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.FrameLayout;


import com.ditedo.kagenoshinobi.naruto.GamePhase;
import com.ditedo.kagenoshinobi.naruto.VillagePhase;

/**
 * Created by ditedo on 31/05/15.
 */
public class GameView extends SurfaceView {
    private GamePhase phase;
    private long lastClick;
    private SurfaceHolder holder;
    private GameLoopThread gameLoopThread;

    public GameView(Context context) {
        super(context);
        gameLoopThread = new GameLoopThread(this);
        holder = getHolder();
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                boolean retry = true;
                gameLoopThread.setRunning(false);
                while (retry) {
                    try {
                        gameLoopThread.join();
                        retry = false;
                    } catch (InterruptedException e) {

                    }
                }
            }

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                gameLoopThread.setRunning(true);
                gameLoopThread.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }
        });

        phase = new VillagePhase(this);
    }

    public void update() {
        phase.update();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.drawColor(Color.BLACK);
        phase.draw(canvas);
        canvas.restore();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
            synchronized (getHolder()) {
                phase.onTouch(event);
            }
        return true;
    }
}