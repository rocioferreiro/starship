package edu.austral.dissis.starship.Model.Factories;

import edu.austral.dissis.starship.Controllers.GameFlow;
import edu.austral.dissis.starship.Model.Components.PowerUp;
import edu.austral.dissis.starship.Model.Visitors.PowerUpCollisionVisitor;
import edu.austral.dissis.starship.base.vector.Vector2;

import java.util.concurrent.ThreadLocalRandom;

import static edu.austral.dissis.starship.base.vector.Vector2.vector;

public class PowerUpFactoryImpl implements PowerUpFactory {

    private final WeaponFactory weaponFactory = new WeaponFactoryImpl();

    @Override
    public PowerUp create(GameFlow gameFramework) {

        Vector2 position = vector(ThreadLocalRandom.current().nextInt(0, (int) (gameFramework.getWorld().getWidth() + 1)),
                ThreadLocalRandom.current().nextInt(0, (int) (gameFramework.getWorld().getHeight() + 1)));

        int size = ThreadLocalRandom.current().nextInt(20, 50);

        PowerUpCollisionVisitor visitor = new PowerUpCollisionVisitor();
        PowerUp powerUp = new PowerUp(position, size/2, visitor, weaponFactory.create(gameFramework));
        visitor.setPowerUp(powerUp);
        postCreationSettings(gameFramework, powerUp);
        return powerUp;
    }

    private void postCreationSettings(GameFlow game, PowerUp powerUp){
        game.getUIController().addPowerUpDrawer(powerUp);
        game.getWorld().addEntity(powerUp);
    }
}
