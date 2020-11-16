package edu.austral.dissis.starship.Model.Components;

import edu.austral.dissis.starship.Model.Visitors.Visitor;
import edu.austral.dissis.starship.Model.Weapons.Weapon;
import edu.austral.dissis.starship.base.vector.Vector2;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class PowerUp extends GameObject {

    private Shape shape;
    private final Weapon weapon;

    public PowerUp(Vector2 position, int radius, Visitor collisionVisitor, Weapon weapon) {
        super(position, radius, collisionVisitor);
        shape = new Ellipse2D.Double(position.getX(), position.getY(), radius*2, radius*2);
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
    public void collisionedWith(GameObject collisionable) {
        if(canCollide && collisionable.canCollide){
            collisionable.accept(collisionVisitor);
        }
    }

    @Override
    public void updateShape() {
        shape = new Ellipse2D.Double(getInfo().getPosition().getX(), getInfo().getPosition().getY(), getWidth(), getHeight());
    }

    @Override
    public int getWidth() {
        return getInfo().getRadius()*2;
    }

    @Override
    public int getHeight() {
        return getWidth();
    }

    public Weapon getWeapon() {
        return weapon;
    }
}
