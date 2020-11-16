package edu.austral.dissis.starship.Model.Visitors;

import edu.austral.dissis.starship.Model.Components.Asteroid;
import edu.austral.dissis.starship.Model.Components.Laser;
import edu.austral.dissis.starship.Model.Components.PowerUp;
import edu.austral.dissis.starship.Model.Components.Ship;

public class PowerUpCollisionVisitor implements Visitor {

    private PowerUp powerUp;

    @Override
    public void visit(Asteroid asteroid) {}

    @Override
    public void visit(Ship ship) {
        ship.setWeapon(powerUp.getWeapon());
    }

    @Override
    public void visit(Laser laser) {
        laser.getPlayerObserver().getPlayer().getControlled().setWeapon(powerUp.getWeapon());
    }

    @Override
    public void visit(PowerUp powerUp) {}

    public void setPowerUp(PowerUp powerUp){
        this.powerUp = powerUp;
    }
}
