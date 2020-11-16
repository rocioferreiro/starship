package edu.austral.dissis.starship.Model.Components;

import edu.austral.dissis.starship.Model.Visitors.Visitor;
import edu.austral.dissis.starship.Model.Weapons.Weapon;
import edu.austral.dissis.starship.base.vector.Vector2;
import processing.core.PConstants;

import java.awt.*;


public class Ship extends GameObject implements Controlled {

    private Rectangle shape;
    private final PlayerObserver playerObserver;
    private Weapon weapon;


    public Ship(Vector2 position, int radius, Visitor collisionVisitor, PlayerObserver playerObserver, Weapon weapon) {
        super(position, radius, collisionVisitor);
        shape = new Rectangle((int)position.getX(), (int)position.getY(), radius,  (int)(radius*1.7));
        this.playerObserver = playerObserver;
        immunityTime = 4000;
        canCollide = false;
        this.weapon = weapon;
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
    public void moveForward(boolean move) {
        if (move) {
            getInfo().setPosition(getInfo().getPosition().add(Vector2.vectorFromModule(7, getInfo().getHeading())));
        }
    }

    @Override
    public void moveBackwards(boolean move) {
        if (move) {
            getInfo().setPosition(getInfo().getPosition().add(Vector2.vectorFromModule(-7, getInfo().getHeading())));
        }
    }

    @Override
    public void turnRight(boolean move) {
        MovingInformation info = getInfo();
        if(move){
            info.setRotation(PConstants.PI / 60);
        } else {
            info.setRotation(0);
        }

        info.setHeading(info.getHeading() + info.getRotation());
    }

    @Override
    public void turnLeft(boolean move) {
        MovingInformation info = getInfo();
        if(move){
            info.setRotation(PConstants.PI / -60);
        } else {
            info.setRotation(0);
        }
        info.setHeading(info.getHeading() + info.getRotation());
    }

    public void looseLife(){
        if(playerObserver.updateLives()){
            setDead();
        }
    }

    @Override
    public void updateShape(){
        shape = new Rectangle((int)getInfo().getPosition().getX(), (int)getInfo().getPosition().getY(), getInfo().getRadius(), (int)(getInfo().getRadius()*1.7));
    }

    @Override
    public void shoot(boolean doShoot) {
        if(doShoot) weapon.shoot(getInfo().getPosition(), getInfo().getHeading(), playerObserver);
    }

    @Override
    public int getWidth(){
        return shape.width;
    }

    @Override
    public int getHeight() {
        return shape.height;
    }

    @Override
    public void collisionedWith(GameObject collisionable){
        if(canCollide && collisionable.canCollide){
            collisionable.accept(collisionVisitor);
        }
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
