package com.mglo.game.state;

import com.mglo.game.main.GameMain;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class GameOverState extends State {

    private String playerScore;
    private Font font;

    public GameOverState(int playerScore) {
        this.playerScore = playerScore + "";
        font = new Font("SansSerif", Font.BOLD,50);
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {

    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(0,0, GameMain.GAME_WIDTH, GameMain.GAME_HEIGHT);
        g.setColor(Color.DARK_GRAY);
        g.setFont(font);
        g.drawString("Game Over", 257,175);
        g.drawString(playerScore, 385,250);
        g.drawString("Press any key.", 240, 350);
    }

    @Override
    public void onClick(MouseEvent e) {

    }

    @Override
    public void onKeyPress(KeyEvent e) {
        setCurrentState(new MenuState());
    }

    @Override
    public void onKeyRelease(KeyEvent e) {

    }
}
