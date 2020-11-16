package edu.austral.dissis.starship.Model.Components;

import edu.austral.dissis.starship.base.vector.Vector2;

public class MovingInformation {

    private Vector2 position;
    private int radius;
    private float heading;
    private float rotation;
    private Vector2 speed;
    private float acceleration;

    public MovingInformation(Vector2 position, int radius, int heading, int rotation, Vector2 speed, int acceleration) {
        this.position = position;
        this.radius = radius;
        this.heading = heading;
        this.rotation = rotation;
        this.speed = speed;
        this.acceleration = acceleration;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public float getHeading() {
        return heading;
    }

    public void setHeading(float heading) {
        this.heading = heading;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public Vector2 getSpeed() {
        return speed;
    }

    public void setSpeed(Vector2 speed) {
        this.speed = speed;
    }

    public float getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(float acceleration) {
        this.acceleration = acceleration;
    }

    public void addSpeed(Vector2 force){
        speed = speed.add(force);
    }

    public void updatePosition(){
        position = position.add(speed);
    }
}
