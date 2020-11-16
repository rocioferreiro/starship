package edu.austral.dissis.starship.UI.Drawer;

import edu.austral.dissis.starship.Model.Components.Locationable;
import edu.austral.dissis.starship.UI.DrawTheme;
import edu.austral.dissis.starship.UI.Drawer.Drawer;
import processing.core.PGraphics;

public class LaserDrawer implements Drawer {

    Locationable laser;

    public LaserDrawer(Locationable laser) {
        this.laser = laser;
    }

    @Override
    public void draw(PGraphics graphics, DrawTheme theme) {

        final float angle = calculateRotation(laser);
        graphics.pushMatrix();

        graphics.translate(laser.getPosition().getX(), laser.getPosition().getY());
        graphics.rotate(angle);

        graphics.rect(laser.getWidth() / -2f, laser.getHeight()/-2f, laser.getWidth(), laser.getHeight());

        graphics.popMatrix();
    }

    @Override
    public Locationable getEntity() {
        return laser;
    }
}
