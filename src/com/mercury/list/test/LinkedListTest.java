package com.mercury.list.test;

import com.mercury.list.LinkedList;
import com.mercury.list.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

/**
 * Tests for LinkedList class
 */
public class LinkedListTest {

    List<Integer> testList;
    Integer[] testVals = {1, 2, 3, 4, 5, 6};

    @Before
    public void init() {
        testList = new LinkedList<Integer>();
        testList.add(testVals);
    }

    @Test
    public void addItem() {
        int prevLength = testList.length();
        Integer val = 7;

        testList.add(val);
        Assert.assertEquals((prevLength + 1), testList.length());
        Assert.assertEquals(val, testList.get(prevLength));
    }

    @Test
    public void addItems() {
        int prevLength = testList.length();
        Integer[] vals = {7, 8, 9};

        testList.add(vals);
        Assert.assertEquals(prevLength + vals.length, testList.length());
        for (int i = 0; i < vals.length; i++) {
            Assert.assertEquals(vals[i], testList.get(prevLength + i));
        }
    }

    @Test
    public void addAt() {
        int prevLength = testList.length();
        Integer val = 42;
        int pos = prevLength / 2;
        testList.add(42, pos);
        Assert.assertEquals(prevLength + 1, testList.length());
        Assert.assertEquals(val, testList.get(pos));
    }

    @Test
    public void removeAt() {
        int prevLength = testList.length();
        int pos = prevLength / 2;
        Integer oldVal = testList.get(pos);

        testList.remove(pos);
        Assert.assertEquals(prevLength - 1, testList.length());
        Assert.assertNotSame(oldVal, testList.get(pos));
    }

    @Test
    public void get() {
        int pos = testList.length() / 2;
        Integer testVal = testList.get(pos);
        Assert.assertEquals(testVals[pos], testVal);
    }

    @Test
    public void contains() {
        Integer val = testVals[testVals.length - 1];

        Assert.assertTrue(testList.contains(val));
    }

    @Test
    public void findFirst() {
        int pos = testList.length() / 2;
        Integer val = testList.get(pos);

        // Note: We're assuming that the value isn't repeated before pos
        Assert.assertEquals(pos, testList.findFirst(val));
    }

    @Test
    public void reverse() {
        int numVals = testVals.length;

        testList.reverse();
        for (int i = 0; i < numVals; i++) {
        	
        	System.out.println("ddd"+testList.get(i));
            Assert.assertEquals(testVals[i], testList.get((numVals - 1) - i));
        }
    }
}
