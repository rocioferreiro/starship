package edu.austral.dissis.starship.Model.Visitors;

import edu.austral.dissis.starship.Model.Components.Asteroid;
import edu.austral.dissis.starship.Model.Components.Laser;
import edu.austral.dissis.starship.Model.Components.PowerUp;
import edu.austral.dissis.starship.Model.Components.Ship;

public class ShipCollisionVisitor implements Visitor {
    @Override
    public void visit(Asteroid asteroid) {
        asteroid.setDead();
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
