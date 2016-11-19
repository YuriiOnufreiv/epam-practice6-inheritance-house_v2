package ua.onufreiv.inheritance.house.openings;

/**
 * This interface represents mechanism for opening some objects
 *
 * @author Yurii Onufreiv
 * @version 1.0
 */
public interface IOpenable {
    void open();

    void close();

    boolean isOpened();
}
