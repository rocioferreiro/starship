package edu.austral.dissis.starship.Model.Factories;

import edu.austral.dissis.starship.Controllers.GameFlow;
import edu.austral.dissis.starship.Model.Weapons.DefaultWeapon;
import edu.austral.dissis.starship.Model.Weapons.DoubleShotWeapon;
import edu.austral.dissis.starship.Model.Weapons.Weapon;

public class WeaponFactoryImpl implements WeaponFactory {

    private static final int BIG_SHOT = 15;


    @Override
    public Weapon create(GameFlow gameFramework) {
        int random = (int) (Math.random()*100);
        if(random < 50){
            return new DefaultWeapon(new LaserFactoryImpl(gameFramework));
        }else if(random < 75){
            return new DefaultWeapon(new LaserFactoryImpl(gameFramework), BIG_SHOT);
        } else {
            return new DoubleShotWeapon(new LaserFactoryImpl(gameFramework));
        }
    }
}
