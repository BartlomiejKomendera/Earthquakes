package com.bkomendera.earthquakes.domain.util;

import java.awt.*;

public class Coords extends Point {
    private float a;
    private float b;

    public Coords(float a, float b){
        this.a = a;
        this.b = b;
    }

    public float getA() {
        return a;
    }

    public float getB() {
        return b;
    }

    @Override
    public String toString() {
        return "[ " + getA() + " , " + getB() + " ] ";
    }
}
