package edu.hitsz.application.Game;

import edu.hitsz.application.ImageManager;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class HardGame extends Game{
    public HardGame() {
        difficulty = 3;
        try {
            ImageManager.BACKGROUND_IMAGE = ImageIO.read(new FileInputStream("src/images/bg3.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
