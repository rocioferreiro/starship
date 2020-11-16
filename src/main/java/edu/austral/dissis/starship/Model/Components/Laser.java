package edu.austral.dissis.starship.Model.Components;

import edu.austral.dissis.starship.Model.Visitors.Visitor;
import edu.austral.dissis.starship.base.vector.Vector2;

import java.awt.*;

public class Laser extends GameObject {

    private Shape shape;
    private final int size;
    private final PlayerObserver playerObserver;


    public Laser(Vector2 position, int radius, float heading, Visitor collisionVisitor, int size, int speed, PlayerObserver playerObserver) {
        super(position, radius, collisionVisitor);
        shape = new Rectangle((int)position.getX(), (int)position.getY(), radius, radius*3);
        getInfo().setHeading(heading);
        getInfo().setSpeed(Vector2.vectorFromModule(speed, heading));
        this.size = size;
        this.playerObserver = playerObserver;
    }

    @Override
    public Shape shape() {
        return shape;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }


    @Override
    public int getWidth() {
        return size;
    }

    @Override
    public int getHeight() {
        return size;
    }

    @Override
    public void collisionedWith(GameObject collisionable){
        if(canCollide && collisionable.canCollide){
            collisionable.accept(collisionVisitor);
        }
    }

    @Override
    public void updateShape() {
        shape = new Rectangle((int)getInfo().getPosition().getX(), (int)getInfo().getPosition().getY(), getInfo().getRadius(),getInfo().getRadius()*3);
    }

    public PlayerObserver getPlayerObserver() {
        return playerObserver;
    }

    @Override
    public void checkEdges(float width, float height){
        if (getPosition().getX() > width + getWidth())
            setDead();
        else if (getPosition().getX() < -getWidth())
            setDead();
        if (getPosition().getY() > height + getHeight())
            setDead();
        else if (getPosition().getY() < -getHeight())
            setDead();

    }
}
