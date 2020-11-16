package edu.austral.dissis.starship.UI.Drawer;

import edu.austral.dissis.starship.Model.Components.Locationable;
import edu.austral.dissis.starship.UI.DrawTheme;
import edu.austral.dissis.starship.UI.Drawer.Drawer;
import edu.austral.dissis.starship.UI.RGBObject;
import processing.core.PGraphics;

public class ShipDrawer implements Drawer {

    private Locationable ship;
    private RGBObject colorIdentifier;

    public ShipDrawer(Locationable ship, RGBObject colorIdentifier){
        this.ship = ship;
        this.colorIdentifier = colorIdentifier;
    }

    @Override
    public void draw(PGraphics graphics, DrawTheme theme) {

        graphics.pushMatrix();

        graphics.tint(colorIdentifier.getRed(),colorIdentifier.getGreen(),colorIdentifier.getBlue(), 1000);

        drawWithImage(theme.getShipImage(), graphics, ship);

        graphics.tint(255,255);

        graphics.popMatrix();
    }

    @Override
    public Locationable getEntity() {
        return ship;
    }
}
