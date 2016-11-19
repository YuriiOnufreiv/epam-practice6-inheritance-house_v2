package ua.onufreiv.inheritance.house;

import ua.onufreiv.inheritance.house.openings.LockableDoor;

import java.util.Objects;

/**
 * The purpose of this class is to generate 'keys' for the 'doors' when
 * it is necessary to lock them.
 * <p/> Has {@link Key} nested class in it.
 *
 * @author Yurii Onufreiv
 * @version 1.0
 */
public class KeyGenerator {

    /**
     * Generates new {@link Key} object for the specified door
     *
     * @param house house object, entry door of which must be locked
     * @param door  door that must be locked
     * @return generated {@code KeyGenerator.Key} object for further unlocking
     */
    public static Key generateKey(House house, LockableDoor door) {
        if (house == null || door == null) {
            throw new IllegalArgumentException("Null value(-s)");
        }

        return new Key(house, door);
    }

    /**
     * This class represents key for doors locking/unlocking.
     * The lock is performed with the help of hash value of the specified door and house
     */
    public static class Key {

        /**
         * Hash code of key
         */
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

        /**
         * Forms hash key for the specified house and door
         *
         * @param house that hosts passed {@code door}
         * @param door  door for the key validation
         * @return formed 'key' hash value
         */
        private int formHashKey(House house, LockableDoor door) {
            return Objects.hash(house.hashCode(), door.hashCode());
        }

        /**
         * Checks this object for the equality with the {@code otherObject}.
         * <p/>The equality condition is checked using the following field:
         * {@code hashKey}
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

            Key other = (Key) otherObject;

            return Objects.equals(hashKey, other.hashKey);
        }

        /**
         * Returns a hash code for this key.
         * <p/>Based on {@code hashKey} value.
         *
         * @return a hash code value for this key object.
         */
        @Override
        public int hashCode() {
            return Objects.hash(hashKey);
        }

        /**
         * Returns a {@code String} object representing this {@code Key} object's value.
         * Includes it's class name and {@code hashKey} values
         *
         * @return a string representation of fields values of this object
         */
        @Override
        public String toString() {
            return "Key[" +
                    "hashKey=" + hashKey +
                    ']';
        }
    }
}
