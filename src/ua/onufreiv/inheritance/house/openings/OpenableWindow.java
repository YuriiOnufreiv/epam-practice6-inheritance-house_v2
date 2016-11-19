package ua.onufreiv.inheritance.house.openings;

import java.util.Objects;

/**
 * This class represents 'openable door' object extending the {@code Window} class.
 * It inherits all functionality of {@code Window} and by implementing {@code IOpenable}
 * interface add possibilities to 'opening' or 'closing' the window
 *
 * @author Yurii Onufreiv
 * @version 1.0
 */
public class OpenableWindow extends Window implements IOpenable {
    /**
     * Indicates whether it is in 'opened' state
     */
    private boolean isOpened;

    /**
     * Default constructor.
     * <p/> Initializes the fields with the same values, as in {@code super()}
     */
    public OpenableWindow() {
        super();
    }

    /**
     * Parametrized constructor.
     * <p/>Initializes fields with the specified values
     *
     * @param material        material of window
     * @param color           color of window
     * @param type            type of window
     * @param lookAtDirection direction that is seen through this window
     */
    public OpenableWindow(String material, String color, WindowType type, Direction lookAtDirection) {
        super(material, color, type, lookAtDirection);
    }

    /**
     * Switches current window to the 'opened' state
     */
    @Override
    public void open() {
        isOpened = true;
    }

    /**
     * Switches current window to the 'closed' state
     */
    @Override
    public void close() {
        isOpened = false;
    }

    /**
     * Getter for {@code isOpened} field
     *
     * @return true, if this window is in 'opened' state, false otherwise
     */
    @Override
    public boolean isOpened() {
        return isOpened;
    }

    /**
     * Checks this object for the equality with the {@code otherObject}.
     * <p/>The equality condition is checked using the following conditions:
     * {@code super.equals(otherObject)} and
     * {@code isOpened} values in both objects are equals.
     *
     * @param   otherObject the object to compare with.
     * @return  {@code true} if the objects are the same;
     *          {@code false} otherwise.
     */
    @Override
    public boolean equals(Object otherObject) {
        return super.equals(otherObject)
                && Objects.equals(isOpened, ((OpenableWindow) otherObject).isOpened);
    }

    /**
     * Returns a hash code for this openable window.
     * <p/>Based on {@code super.hashCode()} and {@code isOpened} values
     *
     * @return a hash code value for this openable window object
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isOpened);
    }

    /**
     * Returns a {@code String} object representing this {@code OpenableWindow} object's value.
     * Includes it's class name, call to {@code super.toString()} and {@code isOpened} values
     *
     * @return a string representation of fields values of this object
     */
    @Override
    public String toString() {
        return "OpenableWindow[" +
                super.toString() +
                ", isOpened=" + isOpened +
                ']';
    }
}
