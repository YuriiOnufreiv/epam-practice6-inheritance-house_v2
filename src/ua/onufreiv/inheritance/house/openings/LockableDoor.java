package ua.onufreiv.inheritance.house.openings;

import ua.onufreiv.inheritance.house.House;
import ua.onufreiv.inheritance.house.KeyGenerator;

import java.util.Objects;

/**
 * This class represents 'locked door' object extending the {@code Door} class.
 * It inherits all functionality of {@code Door} and by implementing {@code ILockable}
 * interface add possibilities to 'locking the door with key'
 *
 * @author Yurii Onufreiv
 * @version 1.0
 */
public class LockableDoor extends Door implements ILockable {
    /**
     * Indicates whether it is in 'locked' state
     */
    private boolean isLocked;

    /**
     * Default constructor.
     * <p/> Initializes the fields with the predefined values:
     * ({@code material} = "Metal"),
     * ({@code color} = "Black"),
     * ({@code type} = "OpeningType.CASUAL"),
     * ({@code isWithGlass} = "false").
     */
    public LockableDoor() {
        this("Metal", "Black", OpeningType.CASUAL, false);
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
    public LockableDoor(String material, String color, OpeningType type, boolean isWithGlass) {
        super(material, color, type, isWithGlass);
    }

    /**
     * Switches the door into 'locked' state, generates
     * the key for unlocking and returns generated key
     *
     * @param house house object, entry door of which must be locked
     * @return generated {@code KeyGenerator.Key} object for further unlocking
     */
    @Override
    public KeyGenerator.Key lock(House house) {
        isLocked = true;
        return KeyGenerator.generateKey(house, this);
    }

    /**
     * Switches the door into 'unlocked' state.
     *
     * @param house house object, entry door of which must be unlocked
     * @param key   key for unlocking the door
     * @return {@code true} if door where successfully unlocked, {@code false} otherwise
     */
    @Override
    public boolean unlock(House house, KeyGenerator.Key key) {
        if (key.isValidForDoor(house, this)) {
            isLocked = false;
            return true;
        }
        return false;
    }

    /**
     * Getter for {@code isLocked} field
     * @return true, if this door object is in 'locked' state, false otherwise
     */
    @Override
    public boolean isLocked() {
        return isLocked;
    }

    /**
     * Checks this object for the equality with the {@code otherObject}.
     * <p/>The equality condition is checked using the following conditions:
     * {@code super.equals(otherObject)} and
     * {@code isLocked} values in both objects are equals.
     *
     * @param   otherObject the object to compare with.
     * @return  {@code true} if the objects are the same;
     *          {@code false} otherwise.
     */
    @Override
    public boolean equals(Object otherObject) {
        return super.equals(otherObject)
                && Objects.equals(isLocked, ((LockableDoor) otherObject).isLocked);
    }

    /**
     * Returns a hash code for this lockable door.
     * <p/>Based on {@code super.hashCode()} and {@code isLocked} values
     *
     * @return a hash code value for this lockable door object
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isLocked);
    }

    /**
     * Returns a {@code String} object representing this {@code LockableDoor} object's value.
     * Includes it's class name, call to {@code super.toString()} and {@code isLocked} values
     *
     * @return a string representation of fields values of this object
     */
    @Override
    public String toString() {
        return "LockableDoor[" +
                super.toString() +
                ", isLocked=" + isLocked +
                ']';
    }
}
