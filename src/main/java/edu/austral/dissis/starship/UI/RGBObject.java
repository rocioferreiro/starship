package edu.austral.dissis.starship.UI;

public class RGBObject {

    private final int red;
    private final int blue;
    private final int green;

    private RGBObject(int red, int blue, int green) {
        this.red = red;
        this.blue = blue;
        this.green = green;
    }

    public static RGBObject createColor(int red, int green, int blue){
        return new RGBObject(red, green, blue);
    }

    public int getRed() {
        return red;
    }

    public int getBlue() {
        return blue;
    }

    public int getGreen() {
        return green;
    }
}
