package com.mglo.game.main;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Resources {

    public static BufferedImage welcome, iconimage, block, cloud1, cloud2,
                    duck, grass, jump, run1, run2, run3, run4, run5, selector;
    public static AudioClip hit, onJump;

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
    }

    public static AudioClip loadSound(String fileName){
        URL fileURL = Resources.class.getResource("/resources/" + fileName);
        return Applet.newAudioClip(fileURL);
    }

    public static BufferedImage loadImage(String fileName){
        BufferedImage img = null;
        try {
            img = ImageIO.read(Resource.class.getResourceAsStream("/resources/" + fileName));
        } catch (IOException e) {
            System.out.println("Error while reading: /resources/" + fileName);
            e.printStackTrace();
        }
        return img;
    }
}
