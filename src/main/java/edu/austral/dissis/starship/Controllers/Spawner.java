package edu.austral.dissis.starship.Controllers;

import edu.austral.dissis.starship.Model.Components.Player;
import edu.austral.dissis.starship.Model.Factories.*;
import edu.austral.dissis.starship.Model.Factories.AsteroidFactoryImpl;

@SuppressWarnings("unused")
public class Spawner {

    private final AsteroidFactory asteroidFactory;
    private final PowerUpFactory powerUpFactory;
    private final ShipFactory spaceshipFactory;

    public Spawner() {
        powerUpFactory = new PowerUpFactoryImpl();
        spaceshipFactory = new ShipFactoryImpl();
        asteroidFactory = new AsteroidFactoryImpl();
    }

    public void spawnAsteroid(GameFlow gameFramework){
        asteroidFactory.create(gameFramework);
    }

    public void createShip(GameFlow gameFramework, Player player){
        spaceshipFactory.create(gameFramework, player);
    }

    public void createPowerUp(GameFlow gameFramework){
        powerUpFactory.create(gameFramework);
    }

}
