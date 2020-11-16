 package edu.austral.dissis.starship.Model.Components;

 public class PlayerObserver {

    private final Player player;

    public PlayerObserver(Player player) {
        this.player = player;
    }

    public boolean updateLives(){
        return player.looseLife();
    }

    public void updatePoints(int points){
        player.addScore(points);
    }

    public Player getPlayer(){
        return player;
    }

}
