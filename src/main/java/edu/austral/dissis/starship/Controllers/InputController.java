package edu.austral.dissis.starship.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InputController {

    List<KeyListener> listeners = new ArrayList<>();

    public void registerListener(int id, int key, KeyCommand command){
        if(listeners.stream().noneMatch(l -> l.getKey() == key)){
            listeners.add(new KeyListener(id, key, command));
        } else {
            KeyListener listener = listeners.stream().filter(l -> l.getPlayerId() == id && l.getKey() == key).findAny().get();
            listener.setCommand(command);
        }
    }

    public void deregisterListener(int id, int key){
        listeners = listeners.stream().filter(l -> l.getKey() != key || l.getPlayerId() != id).collect(Collectors.toList());
    }

    public void keyReleased(int key){
        handleEvent(key, false);
    }

    public void keyPressed(int key){
        handleEvent(key, true);
    }

    private void handleEvent(int key, boolean press) {
        if(listeners.stream().anyMatch(l -> l.getKey() == key)) {
            KeyListener listener = listeners.stream().filter(l -> l.getKey() == key).findFirst().get();
            listener.getCommand().run(listener.getPlayerId(), listener.getKey(), press);
        }
    }

}
