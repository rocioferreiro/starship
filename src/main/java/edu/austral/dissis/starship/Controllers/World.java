package edu.austral.dissis.starship.Controllers;

import edu.austral.dissis.starship.Model.Components.GameObject;
import edu.austral.dissis.starship.Model.Components.Player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class World {

    private final float width;
    private final float height;

    private final EntityController entityManager;
    private final List<Player> players;
    private final InputController inputController;

    public World(float width, float height) {
        this.width = width;
        this.height = height;
        entityManager = new EntityController();
        players = new ArrayList<>();
        inputController = new InputController();
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public float getWidth(){
        return width;
    }

    public float getHeight(){
        return height;
    }

    public void registerListener(int playerId, int code, KeyCommand command){
        inputController.registerListener(playerId, code, command);
    }

    public void deregisterListener(int playerId, int code){
        inputController.deregisterListener(playerId, code);
    }

    public void keyPressed(int event){
        inputController.keyPressed(event);
    }

    public void keyReleased(int event){
        inputController.keyReleased(event);
    }

    public void update(UIController ui, float timePassed){
        for(Player player : players){
            player.move();
        }
        entityManager.update(ui, timePassed);
    }

    public void addEntity(GameObject entity){
        entityManager.addEntity(entity);
    }

    public List<Player> getPlayers(){
        return players;
    }

    public List<GameObject> getEntities(){
        return entityManager.getEntities();
    }

    public Player getWinner(){
        return players.stream().max(Comparator.comparingInt(Player::getScore)).get();
    }
}
