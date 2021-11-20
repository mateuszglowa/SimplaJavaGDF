package com.mglo.game.main;

import com.mglo.animation.Animation;
import com.mglo.animation.Frame;


import javax.imageio.ImageIO;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Resources {

    public static BufferedImage welcome, iconimage, block, cloud1, cloud2,
                    duck, grass, jump, run1, run2, run3, run4, run5, selector;
    public static AudioClip hit, onJump;
    public static Color skyBlue;
    public static Animation runAnim;

    public static void load(){
        welcome = loadImage("welcome.png");
        iconimage = loadImage("iconimage.png");
        block = loadImage("block.png");
        cloud1 = loadImage("cloud1.png");
        cloud2 = loadImage("cloud2.png");
        duck = loadImage("duck.png");
        grass = loadImage("grass.png");
        jump = loadImage("jump.png");
        run1 = loadImage("run1.png");
        run2 = loadImage("run2.png");
        run3 = loadImage("run3.png");
        run4 = loadImage("run4.png");
        run5 = loadImage("run5.png");
        selector = loadImage("selector.png");
        hit = loadSound("hit.wav");
        onJump = loadSound("oonjump.wav");
        skyBlue = new Color(208, 244,247);

        Frame f1 = new Frame(run1, .1f);
        Frame f2 = new Frame(run2, .1f);
        Frame f3 = new Frame(run3, .1f);
        Frame f4 = new Frame(run4, .1f);
        Frame f5 = new Frame(run5, .1f);
        runAnim = new Animation(f1, f2,f3,f4,f5, f3,f2);
    }

    public static AudioClip loadSound(String fileName){
        URL fileURL = Resources.class.getResource("/resources/sounds/" + fileName);
        return Applet.newAudioClip(fileURL);
    }

    public static BufferedImage loadImage(String fileName){
        BufferedImage img = null;
        try {
            img = ImageIO.read(Resources.class.getResource("/resources/images/" + fileName));
        } catch (IOException e) {
            System.out.println("Error while reading: resources/" + fileName);
            e.printStackTrace();
        }
        return img;
    }
}
