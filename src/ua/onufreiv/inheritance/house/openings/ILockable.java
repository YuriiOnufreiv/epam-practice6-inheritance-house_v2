package ua.onufreiv.inheritance.house.openings;

import ua.onufreiv.inheritance.house.House;
import ua.onufreiv.inheritance.house.KeyGenerator;

/**
 * This interface represents mechanism for locking some objects
 * (with the help of {@code KeyGenerator.Key} class)
 *
 * @author Yurii Onufreiv
 * @version 1.0
 */
public interface ILockable {
    KeyGenerator.Key lock(House house);

    boolean unlock(House house, KeyGenerator.Key key);

    boolean isLocked();
}
