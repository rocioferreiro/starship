package edu.austral.dissis.starship.Model.Factories;

import edu.austral.dissis.starship.Controllers.GameFlow;
import edu.austral.dissis.starship.Model.Components.Asteroid;

public interface AsteroidFactory {

    public Asteroid create(GameFlow gameFramework);
}
