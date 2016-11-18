package ua.onufreiv.inheritance.house;

import ua.onufreiv.inheritance.house.openings.LockableDoor;

import java.util.Objects;

/**
 * Created by yurii on 11/14/16.
 */
public class KeyGenerator {

    public static Key generateKey(House house, LockableDoor door) {
        if(house == null || door == null) {
            throw new IllegalArgumentException("Null value(-s)");
        }

        return new Key(house, door);
    }

    public static class Key {

        private int hashKey;

        /**
         * Parametrized constructor; gets the value of {@code hashCode()} of
         * specified door
         * <p/>It's private for making it impossible to create key object manually
         *
         * @param house that hosts passed {@code door}
         * @param door  key is created for this door
         */
        private Key(House house, LockableDoor door) {
            this.hashKey = formHashKey(house, door);
        }

        /**
         * Checks if the key could interact (lock/unlock) with the
         * specified door. Compares the value in the {@code doorHashCode}
         * field with the {@code door.hashCode()} value
         *
         * @param house that hosts passed {@code door}
         * @param door  door for the key validation
         * @return true if key is valid to the specified door, false otherwise
         */
        public boolean isValidForDoor(House house, LockableDoor door) {
            return hashKey == formHashKey(house, door);
        }

        private int formHashKey(House house, LockableDoor door) {
            return Objects.hash(house.hashCode(), door.hashCode());
        }

        @Override
        public boolean equals(Object otherObject) {
            if (this == otherObject) return true;

            if (otherObject == null) return false;

            if (getClass() != otherObject.getClass()) return false;

            Key other = (Key) otherObject;

            return Objects.equals(hashKey, other.hashKey);
        }

        @Override
        public int hashCode() {
            return Objects.hash(hashKey);
        }

        @Override
        public String toString() {
            return "Key[" +
                    "hashKey=" + hashKey +
                    ']';
        }
    }
}
