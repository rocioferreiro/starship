package edu.austral.dissis.starship.Controllers;

public class PlayerMovementManager {

    private boolean moveForward;
    private boolean moveBackwards;
    private boolean turnRight;
    private boolean turnLeft;
    private boolean shoot;

    public PlayerMovementManager(World world, int moveForward, int moveBackwards, int turnRight, int turnLeft, int shoot, int playerId) {
        this.moveForward = false;
        this.moveBackwards = false;
        this.turnRight = false;
        this.turnLeft = false;
        this.shoot = false;
        registerForward(world, playerId, moveForward);
        registerBackwards(world, playerId, moveBackwards);
        registerTurnRight(world, playerId, turnRight);
        registerTurnLeft(world, playerId, turnLeft);
        registerShoot(world, playerId, shoot);
    }

    private void registerShoot(World world, int playerId, int sKey) {
        world.registerListener(playerId, sKey, (id, key, press) -> {
            if(id == playerId && key == sKey) shoot = press;
        });
    }

    private void registerForward(World world, int playerId, int fKey){
        world.registerListener(playerId, fKey, (id, key, press) -> {
            if(id == playerId && key == fKey) moveForward = press;
        });
    }

    private void registerBackwards(World world, int playerId, int bKey){
        world.registerListener(playerId, bKey, (id, key, press) -> {
            if(id == playerId && key == bKey) moveBackwards = press;
        });
    }

    private void registerTurnRight(World world, int playerId, int trKey){
        world.registerListener(playerId, trKey, (id, key, press) -> {
            if(id == playerId && key == trKey) turnRight = press;
        });
    }

    private void registerTurnLeft(World world, int playerId, int tlKey) {
        world.registerListener(playerId, tlKey, (id, key, press) -> {
            if(id == playerId && key == tlKey) turnLeft = press;
        });
    }

    public boolean isMoveForward() {
        return moveForward;
    }

    public boolean isMoveBackwards() {
        return moveBackwards;
    }

    public boolean isTurnRight() {
        return turnRight;
    }

    public boolean isTurnLeft() {
        return turnLeft;
    }

    public boolean isShoot() {
        return shoot;
    }
}
