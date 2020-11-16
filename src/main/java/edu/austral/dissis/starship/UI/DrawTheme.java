package edu.austral.dissis.starship.UI;

import edu.austral.dissis.starship.base.framework.ImageLoader;
import processing.core.PImage;

import java.util.Map;

public interface DrawTheme {

    EnvironmentScheme getEnvironmentScheme();
    void loadImages(ImageLoader loader);
    PImage getAsteroidImage();
    PImage getShipImage();
    PImage getPowerUpImage();
    Background getBackground();
}
