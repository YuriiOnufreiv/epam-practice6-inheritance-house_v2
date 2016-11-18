package ua.onufreiv.inheritance.house;

import ua.onufreiv.inheritance.house.openings.Door;
import ua.onufreiv.inheritance.house.openings.LockableDoor;
import ua.onufreiv.inheritance.house.openings.OpenableWindow;
import ua.onufreiv.inheritance.house.openings.Window;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by yurii on 11/14/16.
 */
public class House {

    public static class HouseBuilder {
        private House house;

        public HouseBuilder(House house) {
            this.house = house;
        }

        public HouseBuilder(String address, int roomsAmount, int floorsAmount, double square) {
            house = new House(address, roomsAmount, floorsAmount, square);
        }

        public void setEntryDoor(LockableDoor lockableDoor) {
            if(house.entryDoor != null && house.entryDoor.isLocked()) {
                throw new IllegalStateException("Entry door is in 'locked' state");
            }
            house.entryDoor = lockableDoor;
        }

        public void addRoomDoor(Door door) {
            house.roomDoors.add(door);
        }

        public void addWindow(Window window) {
            house.windows.add(window);
        }

        public void addRoomDoors(int amount) {
            if (amount < 0) {
                throw new IllegalArgumentException("Negative value");
            }

            for (int i = 0; i < amount; i++) {
                house.roomDoors.add(new Door());
            }
        }

        public void addWindows(int amount) {
            if (amount < 0) {
                throw new IllegalArgumentException("Negative value");
            }

            for (int i = 0; i < amount; i++) {
                if(i % 2 == 0) {
                    house.windows.add(new Window());
                } else {
                    house.windows.add(new OpenableWindow());
                }
            }
        }

        public House getHouse() {
            return house;
        }

    }

    private final String address;
    private double square;
    private int roomsAmount;
    private int floorsAmount;
    private LockableDoor entryDoor;
    private ArrayList<Door> roomDoors;
    private ArrayList<Window> windows;

    private House(String address, int roomsAmount, int floorsAmount, double square) {
        this.address = address;
        this.roomsAmount = roomsAmount;
        this.floorsAmount = floorsAmount;
        this.square = square;

        roomDoors = new ArrayList<>();
        windows = new ArrayList<>();
    }

    public int getWindowsAmount() {
        return windows.size();
    }

    public int getDoorsAmount() {
        return roomDoors.size() + 1;
    }

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

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (getClass() != otherObject.getClass()) return false;

        House other = (House) otherObject;

        return Objects.equals(address, other.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }

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
}
