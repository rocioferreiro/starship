package edu.austral.dissis.starship.UI.Drawer;

import edu.austral.dissis.starship.UI.DrawTheme;
import edu.austral.dissis.starship.Model.Components.Locationable;
import edu.austral.dissis.starship.base.vector.Vector2;
import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;

public interface Drawer {

    void draw(PGraphics graphics, DrawTheme theme);

    default float calculateRotation(Locationable locationable) {
        return locationable.getDirection().rotate(PConstants.PI / 2).getAngle();
    }

    default void drawWithImage(PImage image, PGraphics graphics, Locationable locationable){

        final Vector2 position = locationable.getPosition();
        final float angle = calculateRotation(locationable);

        graphics.pushMatrix();

        graphics.translate(position.getX(), position.getY());
        graphics.rotate(angle);

        graphics.image(image, locationable.getWidth() / -2f, locationable.getHeight() / -2f, locationable.getWidth(), locationable.getHeight());

        graphics.popMatrix();

    }

    Locationable getEntity();

}
