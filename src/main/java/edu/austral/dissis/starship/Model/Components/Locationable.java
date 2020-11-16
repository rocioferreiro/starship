package edu.austral.dissis.starship.Model.Components;

import edu.austral.dissis.starship.base.vector.Vector2;

import static edu.austral.dissis.starship.base.vector.Vector2.vector;

public interface Locationable {

    Vector2 getPosition();
    void setPosition(Vector2 vector);
    Vector2 getDirection();
    int getWidth();
    int getHeight();

    default void checkEdges(float width, float height) {
        if (getPosition().getX() > width + getWidth())
            setPosition(vector(-getWidth(), getPosition().getY()));
        else if (getPosition().getX() < -getWidth())
            setPosition(vector(width + getWidth(), getPosition().getY()));
        if (getPosition().getY() > height + getHeight())
            setPosition(vector(getPosition().getX(), -getHeight()));
        else if (getPosition().getY() < -getHeight())
            setPosition(vector(getPosition().getX(), height + getHeight()));
    }


}
