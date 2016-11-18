package ua.onufreiv.inheritance.house.openings;

import java.util.Objects;

/**
 * Created by yurii on 11/14/16.
 */
public class Window {

    public enum WindowType {
        SLIDING, SINGLE, DOUBLE, SKYLIGHTS
    }

    private String material;
    private String color;
    private WindowType type;
    private Direction lookAtDirection;

    public Window() {
        this("Wood", "Brown", WindowType.SINGLE, Direction.NORTH);
    }

    public Window(String material, String color, WindowType type, Direction lookAtDirection) {
        this.material = material;
        this.color = color;
        this.type = type;
        this.lookAtDirection = lookAtDirection;
    }

    public String getMaterial() {
        return material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public WindowType getType() {
        return type;
    }

    public Direction getLookAtDirection() {
        return lookAtDirection;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (getClass() != otherObject.getClass()) return false;

        Window other = (Window) otherObject;

        return Objects.equals(lookAtDirection, other.lookAtDirection)
                && Objects.equals(color, other.color)
                && Objects.equals(type, other.type)
                && Objects.equals(material, other.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(material, color, type, lookAtDirection);
    }

    @Override
    public String toString() {
        return "Window[" +
                "material='" + material + '\'' +
                ", color='" + color + '\'' +
                ", type=" + type +
                ", lookAtDirection=" + lookAtDirection +
                ']';
    }
}
