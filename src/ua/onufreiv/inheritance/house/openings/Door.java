package ua.onufreiv.inheritance.house.openings;

import java.util.Objects;

/**
 * This class represents 'door' object. It implements the {@link IOpenable}
 * interface tu support door opening/closing mechanism
 *
 * @author Yurii Onufreiv
 * @version 1.0
 */
public class Door implements IOpenable {

    /**
     * This enum represents possible types of door opening mechanism
     */
    public enum OpeningType {
        CASUAL, SLIDING
    }

    /**
     * Material of door
     */
    private String material;
    /**
     * Color of door
     */
    private String color;
    /**
     * The way of door's opening/closing
     */
    private Door.OpeningType type;
    /**
     * Indicates whether the door has some glass captions
     */
    private boolean isWithGlass;
    /**
     * Indicates whether the door is in 'opened' state
     */
    private boolean isOpened;

    /**
     * Default constructor.
     * <p/> Initializes the fields with the predefined values:
     * ({@code material} = "Wood"),
     * ({@code color} = "White"),
     * ({@code type} = "OpeningType.CASUAL"),
     * ({@code isWithGlass} = "false").
     */
    public Door() {
        this("Wood", "White", OpeningType.CASUAL, false);
    }

    /**
     * Parametrized constructor.
     * <p/>Initializes fields with the specified values
     *
     * @param material    material of door
     * @param color       color of door
     * @param type        type of door's opening/closing mechanism
     * @param isWithGlass indicates whether the door contains glass captions
     */
    public Door(String material, String color, OpeningType type, boolean isWithGlass) {
        this.material = material;
        this.color = color;
        this.type = type;
        this.isWithGlass = isWithGlass;
        isOpened = false;
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
    public OpeningType getType() {
        return type;
    }

    /**
     * Getter for {@code isWithGlass} field
     *
     * @return true, if this door contains glass captions, false otherwise
     */
    public boolean isWithGlass() {
        return isWithGlass;
    }

    /**
     * Switches current door to the 'opened' state
     */
    @Override
    public void open() {
        isOpened = true;
    }

    /**
     * Switches current door to the 'closed' state
     */
    @Override
    public void close() {
        isOpened = false;
    }

    /**
     * Getter for {@code isOpened} field
     *
     * @return true, if this door is in 'opened' state, false otherwise
     */
    @Override
    public boolean isOpened() {
        return isOpened;
    }

    /**
     * Checks this object for the equality with the {@code otherObject}.
     * <p/>The equality condition is checked using the following fields:
     * {@code material},
     * {@code color},
     * {@code type},
     * {@code isWithGlass} and
     * {@code isOpened}.
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

        Door other = (Door) otherObject;

        return Objects.equals(material, other.material)
                && Objects.equals(color, other.color)
                && Objects.equals(type, other.type)
                && Objects.equals(isWithGlass, other.isWithGlass)
                && isOpened == other.isOpened;
    }

    /**
     * Returns a hash code for this door.
     * <p/>Based on {@code material}, {@code color}, {@code type},
     * {@code isWithGlass} and {@code isOpened} values
     *
     * @return a hash code value for this door object
     */
    @Override
    public int hashCode() {
        return Objects.hash(material, color, type, isWithGlass, isOpened);
    }

    /**
     * Returns a {@code String} object representing this {@code Door} object's value.
     * Includes it's class name, {@code material}, {@code color}, {@code type},
     * {@code isWithGlass} and {@code isOpened} values
     *
     * @return a string representation of fields values of this object
     */
    @Override
    public String toString() {
        return "Door[" +
                "material='" + material + '\'' +
                ", color='" + color + '\'' +
                ", type=" + type +
                ", isWithGlass=" + isWithGlass +
                ", isOpened=" + isOpened +
                ']';
    }
}
