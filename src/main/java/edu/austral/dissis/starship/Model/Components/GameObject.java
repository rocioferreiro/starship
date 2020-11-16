package edu.austral.dissis.starship.Model.Components;

import edu.austral.dissis.starship.Model.Visitors.Visitor;
import edu.austral.dissis.starship.base.collision.Collisionable;
import edu.austral.dissis.starship.base.vector.Vector2;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

import static edu.austral.dissis.starship.base.vector.Vector2.vector;
import static edu.austral.dissis.starship.base.vector.Vector2.vectorFromModule;

@SuppressWarnings("unused")
public abstract class GameObject implements Collisionable<GameObject>, Locationable {

    boolean canCollide;
    private boolean dead;
    float immunityTime = 0;
    private final MovingInformation info;
    final Visitor collisionVisitor;

    public GameObject(Vector2 position, int radius, Visitor collisionVisitor) {
        info = new MovingInformation(position, radius, 0, 0, vector(0,0), 0);
        canCollide = true;
        dead = false;
        this.collisionVisitor = collisionVisitor;
    }

    @Override
    public Vector2 getPosition(){
        return info.getPosition();
    }

    @Override
    public Vector2 getDirection(){
        return Vector2.vectorFromModule(1, info.getHeading());
    }

    @Override
    public void setPosition(Vector2 vector2){
        info.setPosition(vector2);
    }

    @Override
    public Shape getShape(){
        final Path2D.Float path = new Path2D.Float();
        path.append(shape(), false);


        final AffineTransform transform = new AffineTransform();
        transform.translate(getInfo().getPosition().getX(), getInfo().getPosition().getY());
        transform.rotate(getInfo().getRotation());

        path.transform(transform);

        return path;
    }

    public abstract Shape shape();

    public MovingInformation getInfo() {
        return info;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead() {
        this.dead = true;
    }
    
    public boolean update(float timePassed){
        if(!dead){
            info.setHeading(info.getHeading()+ info.getRotation());
            
            Vector2 force = vectorFromModule(1, info.getHeading());
            force = force.multiply(info.getAcceleration());
            info.addSpeed(force);
            info.updatePosition();
            immunityTime -= timePassed;
            if(immunityTime <= 0){
                immunityTime = 0;
                canCollide = true;
            }
            updateShape();
            return true;
        }
        return false;
    }


    public abstract void accept(Visitor visitor);

    @Override
    public abstract void collisionedWith(GameObject collisionable);

    public abstract void updateShape();

}
