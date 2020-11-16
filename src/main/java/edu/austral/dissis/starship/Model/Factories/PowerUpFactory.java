package edu.austral.dissis.starship.Model.Factories;

import edu.austral.dissis.starship.Controllers.GameFlow;
import edu.austral.dissis.starship.Model.Components.PowerUp;

public interface PowerUpFactory {

    PowerUp create(GameFlow gameFramework);
}
