package edu.austral.dissis.starship.Model.Factories;

import edu.austral.dissis.starship.Controllers.GameFlow;
import edu.austral.dissis.starship.Model.Components.Player;
import edu.austral.dissis.starship.Model.Components.Ship;

public interface ShipFactory {

    public Ship create(GameFlow game, Player player);
}
