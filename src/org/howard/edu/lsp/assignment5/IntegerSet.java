package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a mathematical set of integers.
 * Supports standard set operations such as union, intersection, difference, and complement.
 * No duplicate elements are allowed.
 */
public class IntegerSet {

    private ArrayList<Integer> set;

    /** Initializes an empty IntegerSet */
    public IntegerSet() {
        set = new ArrayList<>();
    }

    /** Removes all elements from the set */
    public void clear() {
        set.clear();
    }

    /** Returns the number of elements in the set */
    public int length() {
        return set.size();
    }

    /** Checks if this set is equal to another set */
    public boolean equals(IntegerSet b) {
        if (b == null || this.length() != b.length()) return false;
        ArrayList<Integer> copy1 = new ArrayList<>(this.set);
        ArrayList<Integer> copy2 = new ArrayList<>(b.set);
        Collections.sort(copy1);
        Collections.sort(copy2);
        return copy1.equals(copy2);
    }

    /** Returns true if the set contains the specified value */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /** Returns the largest element in the set */
    public int largest() {
        if (set.isEmpty()) throw new IllegalStateException("Set is empty");
        return Collections.max(set);
    }

    /** Returns the smallest element in the set */
    public int smallest() {
        if (set.isEmpty()) throw new IllegalStateException("Set is empty");
        return Collections.min(set);
    }

    /** Adds an element if it is not already present */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /** Removes the specified element from the set */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /** Returns a new set containing all elements from this set and another set */
    public IntegerSet union(IntegerSet b) {
        IntegerSet result = new IntegerSet();
        result.set.addAll(this.set);
        for (Integer val : b.set) {
            if (!result.set.contains(val)) result.set.add(val);
        }
        return result;
    }

    /** Returns a new set containing only elements common to this set and another set */
    public IntegerSet intersect(IntegerSet b) {
        IntegerSet result = new IntegerSet();
        for (Integer val : this.set) {
            if (b.set.contains(val)) result.set.add(val);
        }
        return result;
    }

    /** Returns a new set containing elements in this set but not in another set */
    public IntegerSet diff(IntegerSet b) {
        IntegerSet result = new IntegerSet();
        for (Integer val : this.set) {
            if (!b.set.contains(val)) result.set.add(val);
        }
        return result;
    }

    /** Returns a new set containing elements in another set but not in this set */
    public IntegerSet complement(IntegerSet b) {
        IntegerSet result = new IntegerSet();
        for (Integer val : b.set) {
            if (!this.set.contains(val)) result.set.add(val);
        }
        return result;
    }

    /** Returns true if the set has no elements */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /** Returns a string representation of the set in ascending order */
    @Override
    public String toString() {
        ArrayList<Integer> copy = new ArrayList<>(set);
        Collections.sort(copy);
        return copy.toString();
    }
}