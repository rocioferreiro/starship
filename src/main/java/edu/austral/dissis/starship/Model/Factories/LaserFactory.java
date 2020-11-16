package edu.austral.dissis.starship.Model.Factories;

import edu.austral.dissis.starship.Model.Components.Laser;
import edu.austral.dissis.starship.Model.Components.PlayerObserver;
import edu.austral.dissis.starship.base.vector.Vector2;

public interface LaserFactory {

    public Laser create(Vector2 position, float size, float heading, PlayerObserver observer);
}
