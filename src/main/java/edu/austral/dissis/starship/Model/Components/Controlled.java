package edu.austral.dissis.starship.Model.Components;

import edu.austral.dissis.starship.Model.Weapons.Weapon;

public interface Controlled {

    public void moveForward(boolean move);
    public void moveBackwards(boolean move);
    public void turnRight(boolean move);
    public void turnLeft(boolean move);
    public void shoot(boolean doShoot);
    public void setWeapon(Weapon weapon);
}
