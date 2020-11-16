package edu.austral.dissis.starship.Controllers;

import edu.austral.dissis.starship.Model.Components.Player;
import edu.austral.dissis.starship.UI.DrawTheme;
import edu.austral.dissis.starship.UI.StandardDrawTheme;
import edu.austral.dissis.starship.base.collision.CollisionEngine;
import edu.austral.dissis.starship.base.framework.GameFramework;
import edu.austral.dissis.starship.base.framework.ImageLoader;
import edu.austral.dissis.starship.base.framework.WindowSettings;
import processing.core.PConstants;
import processing.core.PGraphics;
import processing.event.KeyEvent;

import java.util.Set;

public class CustomGameFramework implements GameFramework, GameFlow {

    private final CollisionEngine engine = new CollisionEngine();
    private int idCounter = 0;
    private boolean gameOver;
    private World world;
    private UIController uiController;
    private final Spawner spawner = new Spawner();
    private int asteroidTime = 2000;
    private int powerUpTime = 10000;
    private ImageLoader imageLoader;
    @Override
    public void setup(WindowSettings windowsSettings, ImageLoader imageLoader) {
        windowsSettings
            .setSize(1500, 780);
        this.imageLoader = imageLoader;

        reInitialize(imageLoader);
    }

    @Override
    public void draw(PGraphics graphics, float timeSinceLastDraw, Set<Integer> keySet) {
        if(!gameOver){
            uiController.update(graphics, world.getPlayers());
            world.update(uiController, timeSinceLastDraw);
            checkCollisions();
            checkGameOver();
            asteroidTime -= timeSinceLastDraw;
            if(asteroidTime <= 0){
                spawner.spawnAsteroid(this);
                asteroidTime = 2000;
            }

            powerUpTime -= timeSinceLastDraw;
            if(powerUpTime <= 0){
                spawner.createPowerUp(this);
                powerUpTime = 10000;
            }
        } else {
            uiController.renderGameOver(graphics, world.getWinner());
        }
    }

    @Override
    public void keyPressed(KeyEvent event) {
        if (!gameOver) world.keyPressed(event.getKeyCode());
        else if(event.getKeyCode() == 32) {
            gameOver = false;
            reInitialize(imageLoader);
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {
        if (!gameOver) world.keyReleased(event.getKeyCode());
    }

    @Override
    public World getWorld() {
        return world;
    }

    @Override
    public UIController getUIController() {
        return uiController;
    }

    private void checkCollisions(){
        engine.checkCollisions(world.getEntities());
    }

    private void checkGameOver(){
        for(Player player : world.getPlayers()){
            if(!player.isDead()) return;
        }
        gameOver = true;
    }

    private void reInitialize(ImageLoader imageLoader){
        world = new World(1500, 780);
        DrawTheme theme = new StandardDrawTheme();
        theme.loadImages(imageLoader);
        uiController = new UIController(theme);
        Player player = new Player(world, ++idCounter, "Player 1", PConstants.UP, PConstants.DOWN, PConstants.RIGHT, PConstants.LEFT, 32);
        world.addPlayer(player);
        spawner.createShip(this, player);

        Player player2 = new Player(world, ++idCounter, "Player 2", 87, 83, 68, 65, 9);
        world.addPlayer(player2);
        spawner.createShip(this, player2);

        spawner.spawnAsteroid(this);
        spawner.spawnAsteroid(this);
        spawner.spawnAsteroid(this);
        spawner.spawnAsteroid(this);
        spawner.spawnAsteroid(this);
    }
}
