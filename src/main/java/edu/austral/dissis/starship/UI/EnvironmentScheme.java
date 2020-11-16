package edu.austral.dissis.starship.UI;

public class EnvironmentScheme {

    private final RGBObject mainColor;
    private final RGBObject secondaryColor;
    private final Background background;

    public EnvironmentScheme(RGBObject mainColor, RGBObject secondaryColor, Background background) {
        this.mainColor = mainColor;
        this.secondaryColor = secondaryColor;
        this.background = background;
    }

    public RGBObject getMainColor() {
        return mainColor;
    }

    public RGBObject getSecondaryColor() {
        return secondaryColor;
    }

    public Background getBackground() {
        return background;
    }
}
