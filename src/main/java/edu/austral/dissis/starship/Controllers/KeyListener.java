package edu.austral.dissis.starship.Controllers;

import edu.austral.dissis.starship.Controllers.KeyCommand;

public class KeyListener {

    private int playerId;
    private int key;
    private KeyCommand command;

    public KeyListener(int playerId, int key, KeyCommand command) {
        this.playerId = playerId;
        this.key = key;
        this.command = command;
    }

    public int getPlayerId() {
        return playerId;
    }

    public int getKey() {
        return key;
    }

    public KeyCommand getCommand() {
        return command;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setCommand(KeyCommand command) {
        this.command = command;
    }
}
