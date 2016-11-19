package ua.onufreiv.inheritance.house.openings;

import java.util.Objects;

/**
 * This class represents 'window' object that couldn't be opened/closed.
 *
 * @author Yurii Onufreiv
 * @version 1.0
 */
public class Window {

    /**
     * This enum represents possible types of windows
     */
    public enum WindowType {
        SLIDING, SINGLE, DOUBLE, SKYLIGHTS
    }

    /**
     * Material of window
     */
    private String material;
    /**
     * Color of window
     */
    private String color;
    /** Type of window */
    private WindowType type;
    /** Direction that is seen through this window */
    private Direction lookAtDirection;

    /**
     * Default constructor.
     * <p/> Initializes the fields with the predefined values:
     * ({@code material} = "Wood"),
     * ({@code color} = "Brown"),
     * ({@code type} = "WindowType.SINGLE"),
     * ({@code isWithGlass} = Direction.NORTH).
     */
    public Window() {
        this("Wood", "Brown", WindowType.SINGLE, Direction.NORTH);
    }

    /**
     * Parametrized constructor.
     * <p/>Initializes fields with the specified values
     *
     * @param material        material of window
     * @param color           color of window
     * @param type            type of window
     * @param lookAtDirection direction that is seen through this window
     */
    public Window(String material, String color, WindowType type, Direction lookAtDirection) {
        this.material = material;
        this.color = color;
        this.type = type;
        this.lookAtDirection = lookAtDirection;
    }

    /**
     * Getter for {@code material} field
     *
     * @return {@code material} field value
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Getter for {@code color} field
     *
     * @return {@code color} field value
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter for {@code color} field
     *
     * @param color new color value
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Getter for {@code type} field
     *
     * @return {@code type} field value
     */
    public WindowType getType() {
        return type;
    }

    /**
     * Getter for {@code lookAtDirection} field
     *
     * @return {@code lookAtDirection} field value
     */
    public Direction getLookAtDirection() {
        return lookAtDirection;
    }

    /**
     * Checks this object for the equality with the {@code otherObject}.
     * <p/>The equality condition is checked using the following fields:
     * {@code material},
     * {@code color},
     * {@code type} and
     * {@code lookAtDirection}.
     *
     * @param otherObject the object to check with.
     * @return {@code true} if the objects are the same;
     * {@code false} otherwise.
     */
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

    /**
     * Returns a hash code for this window.
     * <p/>Based on {@code material}, {@code color}, {@code type}
     * and {@code lookAtDirection} values
     *
     * @return a hash code value for this window object
     */
    @Override
    public int hashCode() {
        return Objects.hash(material, color, type, lookAtDirection);
    }

    /**
     * Returns a {@code String} object representing this {@code Window} object's value.
     * Includes it's class name, {@code material}, {@code color}, {@code type},
     * and {@code lookAtDirection} values
     *
     * @return a string representation of fields values of this object
     */
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
