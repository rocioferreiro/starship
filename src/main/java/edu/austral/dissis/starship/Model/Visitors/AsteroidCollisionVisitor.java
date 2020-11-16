package edu.austral.dissis.starship.Model.Visitors;

import edu.austral.dissis.starship.Model.Components.Asteroid;
import edu.austral.dissis.starship.Model.Components.Laser;
import edu.austral.dissis.starship.Model.Components.Ship;
import edu.austral.dissis.starship.Model.Components.PowerUp;

public class AsteroidCollisionVisitor implements Visitor {
    @Override
    public void visit(Asteroid asteroid) {}

    @Override
    public void visit(Ship ship) {
        ship.looseLife();
    }

    @Override
    public void visit(Laser laser) {
        laser.setDead();
    }

    @Override
    public void visit(PowerUp powerUp) {
        powerUp.setDead();
    }
}
