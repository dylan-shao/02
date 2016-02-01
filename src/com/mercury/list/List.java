package com.mercury.list;

import java.util.NoSuchElementException;

/**
 * Implement this interface.
 */
public interface List<E> {
    /**
     * Add an item to the end of the list.
     * @param item    item to add
     */
    void add(E item);

    /**
     * Add multiple items to the end of the list.
     * @param items    items to add
     */
    void add(E... items);

        /**
     * Add item at the position.
     * @param item    item to add
     * @param pos     position to add the item at
     * @throws IndexOutOfBoundsException
     */
    void add(E item, int pos);

    /**
     * Remove item at position.
     * @param pos    position to remove the item at
     * @throws IndexOutOfBoundsException
     */
    void remove(int pos);

    /**
     * Get item at the position.
     * @param pos    the position of the desired item
     * @return item
     * @throws IndexOutOfBoundsException
     */
    E get(int pos);

    /**
     * Get the length of the list.
     * @return length
     */
    int length();

    /**
     * Contains the target value.
     * @param target    target for value equality test
     * @return found    true if found, false otherwise
     */
    boolean contains(E target);

    /**
     * Return the position of the first item that matches the
     * target value.
     * @param target    target for value equality test
     * @return position    the position of the found item
     * @throws NoSuchElementException
     */
    int findFirst(E target);

    /**
     * Reverse the list in place.
     */
    void reverse();
}
