package edu.austral.dissis.starship.UI;

import edu.austral.dissis.starship.base.framework.ImageLoader;
import processing.core.PGraphics;

public interface Background {

    public void draw(PGraphics graphics, int width, int height);
    public void setImage(ImageLoader loader);

}
