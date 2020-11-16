package edu.austral.dissis.starship.Model.Visitors;

import edu.austral.dissis.starship.Model.Components.Asteroid;
import edu.austral.dissis.starship.Model.Components.Laser;
import edu.austral.dissis.starship.Model.Components.PowerUp;
import edu.austral.dissis.starship.Model.Components.Ship;

public interface Visitor {

    void visit(Asteroid asteroid);
    void visit(Ship ship);
    void visit(Laser laser);
    void visit(PowerUp powerUp);
}
