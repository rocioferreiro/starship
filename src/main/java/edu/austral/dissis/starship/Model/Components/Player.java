package edu.austral.dissis.starship.Model.Components;

import edu.austral.dissis.starship.Controllers.PlayerMovementManager;
import edu.austral.dissis.starship.Controllers.World;

public class Player {

    private final int id;
    private final String name;
    private Controlled controlled;
    private int score;
    private int lives;
    private boolean dead;
    private final PlayerMovementManager manager;

    public Player(World world, int id, String name, int moveForward, int moveBackwards, int turnRight, int turnLeft, int shoot) {
        this.id = id;
        this.name = name;
        this.score = 0;
        this.dead = false;
        this.lives = 3;
        this.manager = new PlayerMovementManager(world, moveForward, moveBackwards, turnRight, turnLeft, shoot, id);
    }

    public void move(){
        if(!dead){
            controlled.moveForward(manager.isMoveForward());
            controlled.moveBackwards(manager.isMoveBackwards());
            controlled.turnLeft(manager.isTurnLeft());
            controlled.turnRight(manager.isTurnRight());
            controlled.shoot(manager.isShoot());
        }
    }

    public void setControlled(Controlled controlled){
        this.controlled = controlled;
    }

    public Controlled getControlled(){
        return controlled;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public int getLives(){
        return lives;
    }

    public boolean looseLife(){
        lives -= 1;
        if(lives == 0){
            setDead(true);
            return true;
        }
        return false;
    }
}
