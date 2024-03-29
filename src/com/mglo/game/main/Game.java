package com.mglo.game.main;

import com.mglo.framework.util.InputHandler;
import com.mglo.game.state.LoadState;
import com.mglo.game.state.State;

import javax.swing.JPanel;
import java.awt.*;

@SuppressWarnings("serial")

public class Game extends JPanel implements Runnable {
    private int gameWidth;
    private int gameHeight;
    private Image gameImage;

    private Thread gameThread;
    private volatile boolean running;
    private volatile State currentState;

    private InputHandler inputHandler;

    public Game(int gameWidth, int gameHeight){
        this.gameWidth = gameWidth;
        this.gameHeight = gameHeight;
        setPreferredSize(new Dimension(gameWidth, gameHeight));
        setBackground(Color.BLACK);
        setFocusable(true);
        requestFocus();
    }

    public void setCurrentState(State newState){
        System.gc();
        newState.init();
        currentState = newState;
        inputHandler.setCurrentState(currentState);
    }

    @Override
    public void addNotify() { //method which is invoked when Jframe open JPanel - good starting point for application
        super.addNotify();
        initInput();
        setCurrentState(new LoadState());
        initGame();
    }

    private void initInput(){
        inputHandler = new InputHandler();
        addKeyListener(inputHandler);
        addMouseListener(inputHandler);
    }

    private void initGame(){
        running = true;
        gameThread = new Thread(this, "Game Thread");
        gameThread.start();
    }

    @Override
    public void run() {
        //These variables should sum up to 17 on every iteration
        long updateDurationMillis = 0;
        long sleepDurationMillis = 0;

        while(running) {
            long beforeUpdateRender = System.nanoTime();
            long deltaMillis = updateDurationMillis + sleepDurationMillis;

            updateAndRender(deltaMillis);

            updateDurationMillis = (System.nanoTime() - beforeUpdateRender) / 1000000L;
            sleepDurationMillis = Math.max(2, 17 - updateDurationMillis);

            try {
                Thread.sleep(sleepDurationMillis); //Dynamic time counting to get 60FPS we need 17 miliseconds)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        //exit game immediately when running is false
        System.exit(0);
    }

    private void updateAndRender(long deltaMillis) {
        currentState.update(deltaMillis / 1000f);
        prepareGameImage();
        currentState.render(gameImage.getGraphics());
        repaint();
        renderGameImage(getGraphics());
    }

    private void renderGameImage(Graphics g){
        if (gameImage != null){
            g.drawImage(gameImage, 0, 0, null);
        }
        g.dispose();
    }

    private void prepareGameImage(){
        if (gameImage == null){
            gameImage = createImage(gameWidth, gameHeight);
        }
        Graphics g = gameImage.getGraphics();
        g.clearRect(0, 0, gameWidth, gameHeight);
    }

    public void exit(){
        running = false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(gameImage == null){
            return;
        }
        g.drawImage(gameImage, 0 ,0, null);
    }
}
