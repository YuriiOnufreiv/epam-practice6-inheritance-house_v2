package ua.onufreiv.inheritance.house.openings;

import java.util.Objects;

/**
 * Created by yurii on 11/14/16.
 */
public class Door implements IOpenable {

    public enum OpeningType {
        CASUAL, SLIDING
    }

    private String material;
    private String color;
    private Door.OpeningType type;
    private boolean isWithGlass;

    public Door() {
        material = "Wood";
        color = "White";
        type = OpeningType.CASUAL;
        isWithGlass = false;
    }

    public Door(String material, String color, OpeningType type, boolean isWithGlass) {
        this.material = material;
        this.color = color;
        this.type = type;
        this.isWithGlass = isWithGlass;
        isOpened = false;
    }

    private boolean isOpened;

    public String getMaterial() {
        return material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public OpeningType getType() {
        return type;
    }

    public boolean isWithGlass() {
        return isWithGlass;
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
    }

    @Override
    public void open() {
        isOpened = true;
    }

    @Override
    public void close() {
        isOpened = false;
    }

    @Override
    public boolean isOpened() {
        return isOpened;
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(material, color, type, isWithGlass, isOpened);
    }

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
