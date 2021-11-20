package com.mglo.game.state;

import com.mglo.game.model.Block;
import com.mglo.game.model.Cloud;
import com.mglo.game.model.Player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PlayState extends State {

    private Player payer;
    private ArrayList<Block> blocks;
    private Cloud cloud, cloud2;

    private Font scoreFont;
    private int playerScore = 0;

    private static final int BLOCK_HEIGHT = 50;
    public static final int BLOCK_WIDTH = 20;
    private int blockSpeed = -200;

    private static final int PLAYER_WIDTH = 66;

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
    public void render(Graphics G) {

    }

    @Override
    public void onClick(MouseEvent e) {

    }

    @Override
    public void onKeyPress(KeyEvent e) {

    }

    @Override
    public void onKeyRelease(KeyEvent e) {

    }
}
