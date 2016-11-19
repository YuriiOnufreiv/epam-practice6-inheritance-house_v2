package ua.onufreiv.inheritance.house;

import ua.onufreiv.inheritance.house.openings.Door;
import ua.onufreiv.inheritance.house.openings.LockableDoor;
import ua.onufreiv.inheritance.house.openings.OpenableWindow;
import ua.onufreiv.inheritance.house.openings.Window;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class represents house containing it's address, square, amount of rooms,
 * amount of floors, entry door, room doors and windows.
 * <p/> Has {@link HouseBuilder} inner class in it.
 *
 * @author Yurii Onufreiv
 * @version 1.0
 */
public class House {

    /** Address of house */
    private final String address;
    /** Square of house */
    private double square;
    /** Amount of rooms in the house */
    private int roomsAmount;
    /** Amount of floors in the house */
    private int floorsAmount;
    /** Entry door of house */
    private LockableDoor entryDoor;
    /** List of room doors in the house */
    private List<Door> roomDoors;
    /** List of windows in the house */
    private List<Window> windows;

    /**
     * Parametrized constructor.
     * <p/> Creates new house object with the help of specified parameters.
     *
     * @param address      address of house
     * @param square       square of house
     * @param roomsAmount  amount of rooms in the house
     * @param floorsAmount amount of floors in the house
     */
    private House(String address, double square, int roomsAmount, int floorsAmount) {
        this.address = address;
        this.roomsAmount = roomsAmount;
        this.floorsAmount = floorsAmount;
        this.square = square;

        roomDoors = new ArrayList<>();
        windows = new ArrayList<>();
    }

    /**
     * This method return the total amount of windows in the house
     * @return amount of windows
     */
    public int getWindowsAmount() {
        return windows.size();
    }

    /**
     * This method return the total amount of room doors in the house
     * @return amount of room doors
     */
    public int getDoorsAmount() {
        return roomDoors.size() + 1;
    }

    /**
     * Switches the state of arbitrary window to the 'opened'
     * @return true, if some window was opened, false otherwise
     */
    public boolean openSomeWindow() {
        for (Window window : windows) {
            if (window instanceof OpenableWindow) {
                OpenableWindow openableWindow = (OpenableWindow) window;
                if (!openableWindow.isOpened()) {
                    openableWindow.open();
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Switches the entry door into 'locked' state if it's in 'unlocked' one.
     * Returns the generated the key for the door.
     * <p/> Prints warning message to the console in case there some window in the opened state
     *
     * @return key object if the door locking was successful; null if it is already locked
     */
    public KeyGenerator.Key lockWithKey() {
        if (entryDoor.isLocked()) {
            return null;
        }

        if (entryDoor.isOpened()) {
            entryDoor.close();
        }

        for (Window window : windows) {
            if (window instanceof OpenableWindow
                    && ((OpenableWindow) window).isOpened()) {
                System.out.printf("WARNING!!! There is opened window: %s%n", window.toString());
            }
        }

        return entryDoor.lock(this);
    }

    /**
     * Switches the door into 'unlocked' state if two conditions are satisfied:
     * <p/>1. it is in 'locked' state
     * <p/>2. passed key object is valid for this doors
     *
     * @param key key for unlocking the door
     * @return {@code true} if door where successfully unlocked, {@code false} otherwise
     */
    public boolean unlockWithKey(KeyGenerator.Key key) {
        return (entryDoor.isLocked() && entryDoor.unlock(this, key));
    }

    /**
     * Checks this object for the equality with the {@code otherObject}.
     * <p/>The equality condition is checked using the following fields:
     * {@code address}.
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

        House other = (House) otherObject;

        return Objects.equals(address, other.address);
    }

    /**
     * Returns a hash code for this house.
     * <p/>Based on {@code address} value
     *
     * @return a hash code value for this house object
     */
    @Override
    public int hashCode() {
        return Objects.hash(address);
    }

    /**
     * Returns a {@code String} object representing this {@code House} object's value.
     * Includes it's class name, {@code address}, {@code square}, {@code roomsAmount},
     * {@code floorsAmount}, whether {@code entryDoor} is locked,
     * amount of room doors and amount of windows
     *
     * @return a string representation of fields values of this object
     */
    @Override
    public String toString() {
        return "House[" +
                "address='" + address + '\'' +
                ", square=" + square +
                ", rooms=" + roomsAmount +
                ", floors=" + floorsAmount +
                ", entryDoorLocked=" + entryDoor.isLocked() +
                ", roomDoors=" + roomDoors.size() +
                ", windows=" + windows.size() +
                ']';
    }

    /**
     * This class is some kind of wrapper of {@link House} that allows to
     * perform 'building' operations, for example adding room or windows
     */
    public static class HouseBuilder {
        /**
         * House object on which 'building' operations are performed
         */
        private House house;

        /**
         * Parametrized constructor.
         * <p/> Allows to perform 'building' operation aon already existing
         * house object
         *
         * @param house
         */
        public HouseBuilder(House house) {
            this.house = house;
        }

        /**
         * Parametrized constructor.
         * <p/> Creates new house object with the help of specified parameters
         *
         * @param address      address of house
         * @param square       square of house
         * @param roomsAmount  amount of rooms in the house
         * @param floorsAmount amount of floors in the house
         */
        public HouseBuilder(String address, double square, int roomsAmount, int floorsAmount) {
            house = new House(address, square, roomsAmount, floorsAmount);
        }

        /**
         * Sets the entry door of house.
         * <p/>If the existing entry door is in 'locked' state - IllegalStateException is thrown
         *
         * @param lockableDoor new lockable door object
         */
        public void setEntryDoor(LockableDoor lockableDoor) {
            if (house.entryDoor != null && house.entryDoor.isLocked()) {
                throw new IllegalStateException("Entry door is in 'locked' state");
            } else if (lockableDoor == null) {
                throw new NullPointerException("Parameter 'lockableDoor' is null");
            }
            house.entryDoor = lockableDoor;
        }

        /**
         * Adds passed door object to the doors list
         *
         * @param door door for adding
         */
        public void addRoomDoor(Door door) {
            house.roomDoors.add(door);
        }

        /**
         * Adds passed window object to the windows list
         *
         * @param window window for adding
         */
        public void addWindow(Window window) {
            house.windows.add(window);
        }

        /**
         * Adds specified amount of room doors using the
         * default constructor of {@link Door} class
         *
         * @param amount amount of doors to add
         */
        public void addRoomDoors(int amount) {
            if (amount < 0) {
                throw new IllegalArgumentException("Negative value");
            }

            for (int i = 0; i < amount; i++) {
                house.roomDoors.add(new Door());
            }
        }

        /**
         * Adds specified amount of windows using the
         * default constructor of {@link Window} or {@link OpenableWindow} class
         *
         * @param amount amount of windows to add
         */
        public void addWindows(int amount) {
            if (amount < 0) {
                throw new IllegalArgumentException("Negative value");
            }

            for (int i = 0; i < amount; i++) {
                if (i % 2 == 0) {
                    house.windows.add(new Window());
                } else {
                    house.windows.add(new OpenableWindow());
                }
            }
        }

        /**
         * Getters for {@code house} filed
         *
         * @return house, on which 'building' operations where performed
         */
        public House getHouse() {
            return house;
        }

    }
}
