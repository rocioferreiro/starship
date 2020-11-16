package edu.austral.dissis.starship.Model.Weapons;

import edu.austral.dissis.starship.Model.Components.PlayerObserver;
import edu.austral.dissis.starship.Model.Factories.LaserFactory;
import edu.austral.dissis.starship.base.vector.Vector2;

public interface Weapon{

    void shoot(Vector2 position, float heading, PlayerObserver observer);

    LaserFactory getLaserFactory();

    float getLaserSize();

    void setLaserSize(float laserSize);
}
