package edu.austral.dissis.starship.Model.Visitors;

import edu.austral.dissis.starship.Model.Components.Asteroid;
import edu.austral.dissis.starship.Model.Components.Laser;
import edu.austral.dissis.starship.Model.Components.Ship;
import edu.austral.dissis.starship.Model.Components.PowerUp;

public class LaserCollisionVisitor implements Visitor {
    Laser laser;

    public void setLaser(Laser laser) {
        this.laser = laser;
    }

    @Override
    public void visit(Asteroid asteroid) {
        boolean died = asteroid.looseLife();
        if(died) laser.getPlayerObserver().updatePoints(asteroid.getPoints());

    }

    @Override
    public void visit(Ship ship) {}

    @Override
    public void visit(Laser laser) {}

    @Override
    public void visit(PowerUp powerUp) {
        powerUp.setDead();
    }
}
