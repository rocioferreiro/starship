package edu.austral.dissis.starship.Model.Factories;

import edu.austral.dissis.starship.Controllers.GameFlow;
import edu.austral.dissis.starship.Model.Components.Player;
import edu.austral.dissis.starship.Model.Components.PlayerObserver;
import edu.austral.dissis.starship.Model.Components.Ship;
import edu.austral.dissis.starship.Model.Visitors.ShipCollisionVisitor;
import edu.austral.dissis.starship.Model.Weapons.DefaultWeapon;
import edu.austral.dissis.starship.UI.RGBObject;
import edu.austral.dissis.starship.Model.Weapons.Weapon;
import edu.austral.dissis.starship.base.vector.Vector2;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static edu.austral.dissis.starship.UI.RGBObject.createColor;
import static edu.austral.dissis.starship.base.vector.Vector2.vector;

public class ShipFactoryImpl implements ShipFactory {

    private final List<RGBObject> colors;
    private int pointer = 0;

    public ShipFactoryImpl() {
        colors = new ArrayList<>();
        colors.add(createColor(0, 220, 255));
        colors.add(createColor(0, 255, 19));
        colors.add(createColor(255, 158, 0));
        colors.add(createColor(97, 0, 255));
        colors.add(createColor(205, 255, 0));
    }

    @Override
    public Ship create(GameFlow game, Player player) {
        int size = 107;
        Vector2 position = createRandomPosition();

        ShipCollisionVisitor visitor = new ShipCollisionVisitor();
        Weapon gun = new DefaultWeapon(new LaserFactoryImpl(game));

        PlayerObserver observer = new PlayerObserver(player);
        Ship ship = new Ship(position, size, visitor, observer, gun);
        postWorkWithShip(game, ship, player);
        return ship;
    }

    private Vector2 createRandomPosition(){
        int posX = ThreadLocalRandom.current().nextInt(600, 1000 + 1);
        int posY = ThreadLocalRandom.current().nextInt(400, 580 + 1);
        return vector(posX, posY);
    }

    private void postWorkWithShip(GameFlow game, Ship ship, Player player){
        player.setControlled(ship);
        game.getWorld().addEntity(ship);
        game.getUIController().addShipDrawer(ship, colors.get(pointer));
        if(pointer == colors.size()-1) pointer = 0;
        else pointer += 1;
    }
}
