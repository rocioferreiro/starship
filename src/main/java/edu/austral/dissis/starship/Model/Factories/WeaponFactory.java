package edu.austral.dissis.starship.Model.Factories;

import edu.austral.dissis.starship.Controllers.GameFlow;
import edu.austral.dissis.starship.Model.Weapons.Weapon;

public interface WeaponFactory {

    Weapon create(GameFlow gameFramework);
}
