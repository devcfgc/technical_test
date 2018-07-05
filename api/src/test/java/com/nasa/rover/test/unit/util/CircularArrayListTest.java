package com.nasa.rover.test.unit.util;

import com.nasa.rover.util.CircularArrayList;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CircularArrayListTest {
    private CircularArrayList<Integer> circularArrayList;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void init() {
        circularArrayList = new CircularArrayList<>();
        circularArrayList.add(0);
        circularArrayList.add(1);
        circularArrayList.add(2);
        circularArrayList.add(3);
        circularArrayList.add(4);
    }

    @Test
    public void getNextShouldReturnIndex0() {
        Integer result = circularArrayList.getNext(4);
        assertEquals((Integer) 0, result);
    }

    @Test
    public void getNextShouldReturnIndex2() {
        Integer result = circularArrayList.getNext(1);
        assertEquals((Integer) 2, result);
    }

    @Test
    public void getNextShouldReturnIndex4() {
        Integer result = circularArrayList.getNext(3);
        assertEquals((Integer) 4, result);
    }

    @Test
    public void getNextShouldThrowException() {
        exception.expect(IndexOutOfBoundsException.class);
        circularArrayList.getNext(5);
    }

    @Test
    public void getPreviousShouldReturnIndex4() {
        Integer result = circularArrayList.getPrevious(0);
        assertEquals((Integer) 4, result);
    }

    @Test
    public void getPreviousShouldReturnIndex2() {
        Integer result = circularArrayList.getPrevious(4);
        assertEquals((Integer) 3, result);
    }

    @Test
    public void getPreviousShouldReturnIndex0() {
        Integer result = circularArrayList.getPrevious(1);
        assertEquals((Integer) 0, result);
    }

    @Test
    public void getPreviousShouldThrowException() {
        exception.expect(IndexOutOfBoundsException.class);
        circularArrayList.getPrevious(-2);
    }
}
