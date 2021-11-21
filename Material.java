package by.gsu.epamlab;

import java.util.Objects;

public class Material {
    private String name;
    private double DENSITY;

    public Material(String name) {
        this.name = name;
        if (Objects.equals(name, "steel"))
            DENSITY = 7850.0;
        else if (Objects.equals(name, "copper"))
            DENSITY = 8500.0;
    }

    public Material() {
    }

    public String getName() {
        return name;
    }

    public double getDensity() {
        return DENSITY;
    }

    @Override
    public String toString() {
        return name + "; " + DENSITY;
    }
}
