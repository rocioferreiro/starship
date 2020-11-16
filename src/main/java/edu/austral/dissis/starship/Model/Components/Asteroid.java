package edu.austral.dissis.starship.Model.Components;

import edu.austral.dissis.starship.Model.Visitors.Visitor;
import edu.austral.dissis.starship.base.vector.Vector2;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Asteroid extends GameObject {

    private Shape shape;
    private int lives;
    private final int points;


    public Asteroid(Vector2 position, int radius, Visitor collisionVisitor) {
        super(position, radius, collisionVisitor);
        shape = new Ellipse2D.Double(position.getX(), position.getY(), radius*2, radius*2);
        lives = 1 + radius/50;
        points = 1000/radius;
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
        return getInfo().getRadius()*2;
    }

    @Override
    public int getHeight() {
        return getWidth();
    }

    public int getPoints() {
        return points;
    }

    public boolean looseLife(){
        lives -= 1;
        getInfo().setSpeed(getInfo().getSpeed().multiply(-1f));
        if(lives <= 0) {
            setDead();
            return true;
        }
        return false;
    }

    @Override
    public void collisionedWith(GameObject collisionable){
        if(canCollide && collisionable.canCollide){
            collisionable.accept(collisionVisitor);
        }
    }

    @Override
    public void updateShape(){
        shape = new Ellipse2D.Double(getInfo().getPosition().getX(), getInfo().getPosition().getY(), getInfo().getRadius()*2, getInfo().getRadius()*2);
    }
}
