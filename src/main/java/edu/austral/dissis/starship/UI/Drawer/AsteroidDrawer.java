package edu.austral.dissis.starship.UI.Drawer;

import edu.austral.dissis.starship.UI.DrawTheme;
import edu.austral.dissis.starship.Model.Components.Locationable;
import processing.core.PGraphics;
import processing.core.PImage;

public class AsteroidDrawer implements Drawer {

    Locationable asteroid;

    public AsteroidDrawer(Locationable asteroid){
        this.asteroid = asteroid;
    }

    @Override
    public void draw(PGraphics graphics, DrawTheme theme) {
        PImage image = theme.getAsteroidImage();

        drawWithImage(image, graphics, asteroid);
    }

    @Override
    public Locationable getEntity() {
        return asteroid;
    }
}
