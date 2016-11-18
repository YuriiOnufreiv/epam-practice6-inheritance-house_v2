package ua.onufreiv.inheritance;

import ua.onufreiv.inheritance.house.House;
import ua.onufreiv.inheritance.house.KeyGenerator;
import ua.onufreiv.inheritance.house.openings.Door;
import ua.onufreiv.inheritance.house.openings.LockableDoor;

/**
 * Created by yurii on 11/14/16.
 *
 * 15. Создать объект класса Дом, используя классы Окно, Дверь.
 * Методы: закрыть на ключ, вывести на консоль количество окон, дверей.
 */
public class Runner {
    public static void main(String[] args) {
        House.HouseBuilder kyivBuilder = new House.HouseBuilder("Kyiv, Khreschatyk", 3, 1, 75);
        kyivBuilder.setEntryDoor(new LockableDoor());
        kyivBuilder.addRoomDoors(5);
        kyivBuilder.addWindows(12);

        House.HouseBuilder lvivBuilder = new House.HouseBuilder("Lviv, prosp. Svobody", 5, 2, 125);
        lvivBuilder.setEntryDoor(new LockableDoor("Metal", "Brown", Door.OpeningType.SLIDING, true));
        lvivBuilder.addRoomDoors(8);
        lvivBuilder.addWindows(16);

        House kyivHouse = kyivBuilder.getHouse();
        House lvivHouse = lvivBuilder.getHouse();

        System.out.println("kyivHouse: " + kyivHouse);
        System.out.println("lvivHouse: " + lvivHouse);
        System.out.println("\nkyivHouse.equals(kyivHouse): " + kyivHouse.equals(kyivHouse));
        System.out.println("kyivHouse.equals(lvivHouse): " + kyivHouse.equals(lvivHouse));
        System.out.println("\nkyivHouse.hashCode(): " + kyivHouse.hashCode());
        System.out.println("lvivHouse.hashCode(): " + lvivHouse.hashCode());

        System.out.println("\nkyivHouse.getWindowsAmount(): " + kyivHouse.getWindowsAmount());
        System.out.println("kyivHouse.getDoorsAmount(): " + kyivHouse.getDoorsAmount());

        System.out.println("\nlvivHouse.getWindowsAmount(): " + lvivHouse.getWindowsAmount());
        System.out.println("lvivHouse.getDoorsAmount(): " + lvivHouse.getDoorsAmount() + "\n");

        kyivHouse.openSomeWindow();
        KeyGenerator.Key kyivKey = kyivHouse.lockWithKey();
        KeyGenerator.Key lvivKey = lvivHouse.lockWithKey();
        System.out.println("\nkyivKey: " + kyivKey);
        System.out.println("lvivKey: " + lvivKey);

        System.out.println("\nkyivHouse.unlockWithKey(lvivKey): " + kyivHouse.unlockWithKey(lvivKey));
        System.out.println("kyivHouse.unlockWithKey(kyivKey): " + kyivHouse.unlockWithKey(kyivKey));
    }
}
