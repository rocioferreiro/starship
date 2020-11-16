package edu.austral.dissis.starship.UI;

import edu.austral.dissis.starship.base.framework.ImageLoader;
import processing.core.PGraphics;
import processing.core.PImage;

public class StandardBackground implements Background {

    private PImage image;

    public void setImage(ImageLoader loader){
        String source = "background.jpg";
        image = loader.load(source);
    }

    @Override
    public void draw(PGraphics graphics, int width, int height) {
        graphics.pushMatrix();
        image.resize(width,0);
        graphics.image(image, 0, 0);
        graphics.popMatrix();
    }
}
