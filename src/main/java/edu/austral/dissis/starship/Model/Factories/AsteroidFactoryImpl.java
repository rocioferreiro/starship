package edu.austral.dissis.starship.Model.Factories;

import edu.austral.dissis.starship.Controllers.GameFlow;
import edu.austral.dissis.starship.Model.Components.Asteroid;
import edu.austral.dissis.starship.Model.Factories.AsteroidFactory;
import edu.austral.dissis.starship.Model.Visitors.AsteroidCollisionVisitor;
import edu.austral.dissis.starship.base.vector.Vector2;

import java.util.concurrent.ThreadLocalRandom;

import static edu.austral.dissis.starship.base.vector.Vector2.vector;

public class AsteroidFactoryImpl implements AsteroidFactory {

    @Override
    public Asteroid create(GameFlow gameFramework) {

        Vector2 position = vector(ThreadLocalRandom.current().nextInt(0, 1)*gameFramework.getWorld().getWidth(),
                ThreadLocalRandom.current().nextInt(0, (int) (gameFramework.getWorld().getHeight() + 1)));

        int size = ThreadLocalRandom.current().nextInt(50, 150);

        Asteroid asteroid = new Asteroid(position, size/2, new AsteroidCollisionVisitor());
        postCreationSettings(gameFramework, asteroid);

        asteroid.getInfo().setRotation(0.1f);

        return asteroid;
    }

    private void postCreationSettings(GameFlow game, Asteroid asteroid){
        game.getUIController().addAsteroidDrawer(asteroid);
        asteroid.getInfo().setHeading((float) ThreadLocalRandom.current().nextDouble(0, Math.PI*2));
        asteroid.getInfo().setSpeed(vector(ThreadLocalRandom.current().nextInt(-3, 3 + 1), ThreadLocalRandom.current().nextInt(-3, 3 + 1)));
        game.getWorld().addEntity(asteroid);
    }
}
