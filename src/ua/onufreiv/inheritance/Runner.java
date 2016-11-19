package ua.onufreiv.inheritance;

import ua.onufreiv.inheritance.house.House;
import ua.onufreiv.inheritance.house.KeyGenerator;
import ua.onufreiv.inheritance.house.openings.Door;
import ua.onufreiv.inheritance.house.openings.LockableDoor;

/**
 * Runner class for demonstrating of solution for the following task:
 * 15. Создать объект класса Дом, используя классы Окно, Дверь.
 * Методы: закрыть на ключ, вывести на консоль количество окон, дверей.
 */
public class Runner {
    public static void main(String[] args) {
        // create house in Kyiv
        House.HouseBuilder kyivBuilder = new House.HouseBuilder("Kyiv, Khreschatyk", 75, 3, 1);
        kyivBuilder.setEntryDoor(new LockableDoor());
        kyivBuilder.addRoomDoors(5);
        kyivBuilder.addWindows(12);

        // create house in Lviv
        House.HouseBuilder lvivBuilder = new House.HouseBuilder("Lviv, prosp. Svobody", 125, 2, 5);
        lvivBuilder.setEntryDoor(new LockableDoor("Metal", "Brown", Door.OpeningType.SLIDING, true));
        lvivBuilder.addRoomDoors(8);
        lvivBuilder.addWindows(16);

        // get created house objects
        House kyivHouse = kyivBuilder.getHouse();
        House lvivHouse = lvivBuilder.getHouse();

        // demonstration of toString() method
        System.out.println("kyivHouse: " + kyivHouse);
        System.out.println("lvivHouse: " + lvivHouse);

        // demonstration of equals() and hashCode() method
        System.out.println("\nkyivHouse.equals(kyivHouse): " + kyivHouse.equals(kyivHouse));
        System.out.println("kyivHouse.equals(lvivHouse): " + kyivHouse.equals(lvivHouse));
        System.out.println("\nkyivHouse.hashCode(): " + kyivHouse.hashCode());
        System.out.println("lvivHouse.hashCode(): " + lvivHouse.hashCode());

        // print amount of windows and doors
        System.out.println("\nkyivHouse.getWindowsAmount(): " + kyivHouse.getWindowsAmount());
        System.out.println("kyivHouse.getDoorsAmount(): " + kyivHouse.getDoorsAmount());

        System.out.println("\nlvivHouse.getWindowsAmount(): " + lvivHouse.getWindowsAmount());
        System.out.println("lvivHouse.getDoorsAmount(): " + lvivHouse.getDoorsAmount() + "\n");

        // lock both houses with key
        kyivHouse.openSomeWindow();
        KeyGenerator.Key kyivKey = kyivHouse.lockWithKey();
        KeyGenerator.Key lvivKey = lvivHouse.lockWithKey();

        // print obtained keys
        System.out.println("\nkyivKey: " + kyivKey);
        System.out.println("lvivKey: " + lvivKey);

        // unlock Kyiv house with key from Lviv house
        System.out.println("\nkyivHouse.unlockWithKey(lvivKey): " + kyivHouse.unlockWithKey(lvivKey));
        // unlock Kyiv house with key from Kyiv house
        System.out.println("kyivHouse.unlockWithKey(kyivKey): " + kyivHouse.unlockWithKey(kyivKey));
    }
}
