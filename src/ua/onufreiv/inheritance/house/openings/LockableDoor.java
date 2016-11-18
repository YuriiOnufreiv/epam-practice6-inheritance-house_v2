package ua.onufreiv.inheritance.house.openings;

import ua.onufreiv.inheritance.house.House;
import ua.onufreiv.inheritance.house.KeyGenerator;

import java.util.Objects;

/**
 * Created by yurii on 11/14/16.
 */
public class LockableDoor extends Door implements ILockable {

    private boolean isLocked;

    public LockableDoor() {
        super("Metal", "Black", OpeningType.CASUAL, false);
    }

    public LockableDoor(String material, String color, OpeningType type, boolean isWithGlass) {
        super(material, color, type, isWithGlass);
    }

    @Override
    public KeyGenerator.Key lock(House house) {
        isLocked = true;
        return KeyGenerator.generateKey(house, this);
    }

    @Override
    public boolean unlock(House house, KeyGenerator.Key key) {
        if (key.isValidForDoor(house, this)) {
            isLocked = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean isLocked() {
        return isLocked;
    }

    @Override
    public boolean equals(Object otherObject) {
        return super.equals(otherObject)
                && Objects.equals(isLocked, ((LockableDoor) otherObject).isLocked);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isLocked);
    }

    @Override
    public String toString() {
        return "LockableDoor[" +
                super.toString() +
                ", isLocked=" + isLocked +
                ']';
    }
}
