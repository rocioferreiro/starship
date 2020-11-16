package edu.austral.dissis.starship.UI.Drawer;

import edu.austral.dissis.starship.Model.Components.Locationable;
import edu.austral.dissis.starship.UI.DrawTheme;
import edu.austral.dissis.starship.UI.Drawer.Drawer;
import processing.core.PGraphics;

public class PowerUpDrawer implements Drawer {

    Locationable powerUp;

    public PowerUpDrawer(Locationable powerUp) {
        this.powerUp = powerUp;
    }

    @Override
    public void draw(PGraphics graphics, DrawTheme theme) {
        drawWithImage(theme.getPowerUpImage(), graphics, powerUp);
    }

    @Override
    public Locationable getEntity() {
        return powerUp;
    }
}
