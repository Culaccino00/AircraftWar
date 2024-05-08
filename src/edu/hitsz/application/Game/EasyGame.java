package edu.hitsz.application.Game;

import edu.hitsz.application.ImageManager;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class EasyGame extends Game {


    public EasyGame() {
        difficulty = 1;
        try {
            ImageManager.BACKGROUND_IMAGE = ImageIO.read(new FileInputStream("src/images/bg.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
