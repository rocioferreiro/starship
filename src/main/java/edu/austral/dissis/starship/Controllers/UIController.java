package edu.austral.dissis.starship.Controllers;

import edu.austral.dissis.starship.Model.Components.GameObject;
import edu.austral.dissis.starship.Model.Components.Locationable;
import edu.austral.dissis.starship.Model.Components.Player;
import edu.austral.dissis.starship.UI.DrawTheme;
import edu.austral.dissis.starship.UI.Drawer.*;
import edu.austral.dissis.starship.UI.RGBObject;
import processing.core.PGraphics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class UIController {

    private final DrawTheme theme;
    private final List<Drawer> drawers;

    public UIController(DrawTheme theme) {
        this.theme = theme;
        drawers = new ArrayList<>();
    }

    public void draw(Drawer drawer, PGraphics graphics){
        graphics.pushMatrix();
        drawer.draw(graphics, theme);
        graphics.pushMatrix();
    }

    public List<Drawer> getDrawers(){
        return drawers;
    }

    public void addShipDrawer(Locationable locationable, RGBObject color){
        drawers.add(new ShipDrawer(locationable, color));
    }

    public void addAsteroidDrawer(Locationable locationable){
        drawers.add(new AsteroidDrawer(locationable));
    }

    public void addLaserDrawer(Locationable laser){
        drawers.add(0, new LaserDrawer(laser));
    }

    public void addPowerUpDrawer(Locationable powerUp){
        drawers.add(new PowerUpDrawer(powerUp));
    }

    public void renderGameOver(PGraphics graphics, Player winner){
        RGBObject mainColor = theme.getEnvironmentScheme().getMainColor();
        RGBObject secondaryColor = theme.getEnvironmentScheme().getSecondaryColor();
        graphics.pushMatrix();
        graphics.textSize(100);
        graphics.background(secondaryColor.getRed(), secondaryColor.getGreen(), secondaryColor.getBlue());
        graphics.tint(mainColor.getRed(), mainColor.getGreen(), mainColor.getBlue(), 1);
        graphics.text("Game Over", 500, 370);
        graphics.textSize(60);
        graphics.text("Winner: " + winner.getName(), 500, 460);
        graphics.text("Score: " + winner.getScore(), 500, 550);
        graphics.tint(255);
        graphics.popMatrix();

    }

    public void renderPlayerInfo(PGraphics graphics, List<Player> players){
        graphics.textSize(12);
        renderText(graphics, 30, players.stream().map(Player::getName).collect(Collectors.toList()));
        renderText(graphics, 150, players.stream().map(p -> "Score:" + p.getScore()).collect(Collectors.toList()));
        renderText(graphics, 270, players.stream().map(p -> "Lives:" + p.getLives()).collect(Collectors.toList()));
    }

    private void renderText(PGraphics graphics,int width, List<String> text){
        int counter = 40;
        for(String entry : text){
            graphics.pushMatrix();
            graphics.text(entry, width, counter);
            counter += 50;
            graphics.popMatrix();
        }
    }

    public void update(PGraphics graphics, List<Player> players){
        drawers.forEach(d -> d.getEntity().checkEdges(graphics.width, graphics.height));
        theme.getBackground().draw(graphics, graphics.width, graphics.height);
        renderPlayerInfo(graphics, players);
        drawers.forEach(d -> d.draw(graphics, theme));
    }

    public void reportDead(List<GameObject> dead){
        List<Drawer> toRemove = new ArrayList<>();
        for(Drawer drawer : drawers){
            if(dead.contains(drawer.getEntity())){
                toRemove.add(drawer);
            }
        }
        drawers.removeAll(toRemove);
    }
}
