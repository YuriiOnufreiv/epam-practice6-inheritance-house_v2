package ua.onufreiv.inheritance.house.openings;

import java.util.Objects;

/**
 * Created by yurii on 11/14/16.
 */
public class OpenableWindow extends Window implements IOpenable {
    private boolean isOpened;

    public OpenableWindow() {
        super();
    }

    public OpenableWindow(String material, String color, WindowType type, Direction lookAtDirection) {
        super(material, color, type, lookAtDirection);
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
        return super.equals(otherObject)
                && Objects.equals(isOpened, ((OpenableWindow) otherObject).isOpened);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isOpened);
    }

    @Override
    public String toString() {
        return "OpenableWindow[" +
                super.toString() +
                ", isOpened=" + isOpened +
                ']';
    }
}
