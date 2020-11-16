package edu.austral.dissis.starship.Model.Factories;

import edu.austral.dissis.starship.Controllers.GameFlow;
import edu.austral.dissis.starship.Model.Components.Laser;
import edu.austral.dissis.starship.Model.Visitors.LaserCollisionVisitor;
import edu.austral.dissis.starship.Model.Components.PlayerObserver;
import edu.austral.dissis.starship.base.vector.Vector2;

public class LaserFactoryImpl implements LaserFactory {

    private final GameFlow gameFramework;

    public LaserFactoryImpl(GameFlow gameFramework) {
        this.gameFramework = gameFramework;
    }

    @Override
    public Laser create(Vector2 position, float size, float heading, PlayerObserver observer) {

        LaserCollisionVisitor visitor = new LaserCollisionVisitor();
        Laser laser = new Laser(position, (int)size, heading, visitor, (int) size, 10, observer);
        visitor.setLaser(laser);
        gameFramework.getWorld().addEntity(laser);
        gameFramework.getUIController().addLaserDrawer(laser);
        return laser;
    }
}
