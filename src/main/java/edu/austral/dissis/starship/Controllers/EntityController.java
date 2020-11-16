package edu.austral.dissis.starship.Controllers;

import edu.austral.dissis.starship.Model.Components.GameObject;

import java.util.ArrayList;
import java.util.List;

public class EntityController {

    private final List<GameObject> entities;
    private List<GameObject> toBeDestroyed;

    public EntityController(){
        entities = new ArrayList<>();
        toBeDestroyed = new ArrayList<>();
    }

    public void addEntity(GameObject entity){
        entities.add(entity);
    }

    public void update(UIController ui, float timePassed){
        for(GameObject entity : entities){
            boolean isAlive = entity.update(timePassed);
            if(!isAlive) toBeDestroyed.add(entity);
        }
        ui.reportDead(toBeDestroyed);
        entities.removeAll(toBeDestroyed);
        toBeDestroyed = new ArrayList<>();
    }

    public List<GameObject> getEntities(){
        return entities;
    }


}
