package edu.austral.dissis.starship.Model.Weapons;

import edu.austral.dissis.starship.Model.Factories.LaserFactory;
import edu.austral.dissis.starship.Model.Components.PlayerObserver;
import edu.austral.dissis.starship.base.vector.Vector2;

public class DoubleShotWeapon implements Weapon {

    private float laserSize;
    private final LaserFactory laserFactory;

    public DoubleShotWeapon(LaserFactory laserFactory) {
        laserSize = 5;
        this.laserFactory = laserFactory;
    }

    @Override
    public void shoot(Vector2 position, float heading, PlayerObserver observer) {
        laserFactory.create(position, laserSize, (float)(heading - Math.PI/8), observer);
        laserFactory.create(position, laserSize, (float)(heading + Math.PI/8), observer);
    }

    @Override
    public LaserFactory getLaserFactory() {
        return laserFactory;
    }

    @Override
    public float getLaserSize() {
        return laserSize;
    }

    @Override
    public void setLaserSize(float laserSize) {
        this.laserSize = laserSize;
    }
}
