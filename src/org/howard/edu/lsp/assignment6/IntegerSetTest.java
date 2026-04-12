package org.howard.edu.lsp.assignment6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegerSetTest {

    @Test
    public void testAddNormal() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        assertTrue(set.contains(5));
    }

    @Test
    public void testAddDuplicate() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        set.add(5);
        assertEquals(1, set.length());
    }

    @Test
    public void testClear() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.clear();
        assertTrue(set.isEmpty());
    }

    @Test
    public void testLength() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        assertEquals(2, set.length());
    }

    @Test
    public void testContainsPresent() {
        IntegerSet set = new IntegerSet();
        set.add(10);
        assertTrue(set.contains(10));
    }

    @Test
    public void testContainsAbsent() {
        IntegerSet set = new IntegerSet();
        set.add(10);
        assertFalse(set.contains(5));
    }

    @Test
    public void testIsEmptyTrue() {
        IntegerSet set = new IntegerSet();
        assertTrue(set.isEmpty());
    }

    @Test
    public void testIsEmptyFalse() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        assertFalse(set.isEmpty());
    }

    @Test
    public void testRemoveNormal() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        set.remove(5);
        assertFalse(set.contains(5));
    }

    @Test
    public void testRemoveNotPresent() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        set.remove(10);
        assertEquals(1, set.length());
    }

    @Test
    public void testEqualsSameElementsDifferentOrder() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(3);
        set2.add(2);
        set2.add(1);

        assertTrue(set1.equals(set2));
    }

    @Test
    public void testEqualsDifferentSets() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);

        set2.add(1);
        set2.add(3);

        assertFalse(set1.equals(set2));
    }

    // ---------- SET OPERATIONS ----------

    @Test
    public void testUnionNormal() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);

        set2.add(2);
        set2.add(3);

        IntegerSet result = set1.union(set2);

        assertTrue(result.contains(1));
        assertTrue(result.contains(2));
        assertTrue(result.contains(3));
    }

    @Test
    public void testUnionWithEmptySet() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);

        IntegerSet result = set1.union(set2);

        assertEquals(2, result.length());
    }

    @Test
    public void testIntersectNoCommonElements() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);

        set2.add(3);
        set2.add(4);

        IntegerSet result = set1.intersect(set2);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testDiffIdenticalSets() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);

        set2.add(1);
        set2.add(2);

        IntegerSet result = set1.diff(set2);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testComplementDisjointSets() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);

        set2.add(3);
        set2.add(4);

        IntegerSet result = set1.complement(set2);

        assertTrue(result.contains(3));
        assertTrue(result.contains(4));
    }

    @Test
    public void testToStringEmptySet() {
        IntegerSet set = new IntegerSet();
        assertEquals("[]", set.toString());
    }
}