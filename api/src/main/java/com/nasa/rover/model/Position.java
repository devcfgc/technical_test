package com.nasa.rover.model;

import java.util.Objects;

public class Position {
    private int x;
    private int y;

    public Position() {
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void increaseX() { x++; }

    public void decreaseX() { x--; }

    public void increaseY() { y++; }

    public void decreaseY() { y--; }

    @Override
    public String toString() {
        return String.valueOf(x)
                + String.valueOf(y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Position actual = (Position) obj;

        return x == actual.x
                && y == actual.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
