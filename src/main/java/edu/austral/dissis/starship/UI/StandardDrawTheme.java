package edu.austral.dissis.starship.UI;

import edu.austral.dissis.starship.base.framework.ImageLoader;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import static edu.austral.dissis.starship.UI.RGBObject.createColor;

public class StandardDrawTheme implements DrawTheme {

    private final Map<String, String> sources;
    private Map<String, PImage> loaded;

    private final EnvironmentScheme environmentScheme;

    public StandardDrawTheme() {
        sources = new LinkedHashMap<>();
        sources.put("asteroid", "asteroid.png");
        sources.put("ship", "spaceship.png");
        sources.put("powerUp", "powerup.png");
        environmentScheme = new EnvironmentScheme(createColor(95, 196, 198), createColor(50,50,50), new StandardBackground());
    }

    @Override
    public EnvironmentScheme getEnvironmentScheme() {
        return environmentScheme;
    }

    @Override
    public void loadImages(ImageLoader loader) {
        Map<String, PImage> result = new LinkedHashMap<>();
        environmentScheme.getBackground().setImage(loader);
        for (int i = 0; i < sources.size(); i++) {
            result.put(new ArrayList<>(sources.keySet()).get(i), loader.load(new ArrayList<>(sources.values()).get(i)));
        }
        loaded = result;
    }

    @Override
    public PImage getAsteroidImage() {
        return loaded.get("asteroid");
    }

    @Override
    public PImage getShipImage() {
        return loaded.get("ship");
    }

    @Override
    public PImage getPowerUpImage() {
        return loaded.get("powerUp");
    }

    @Override
    public Background getBackground() {
        return environmentScheme.getBackground();
    }


}
