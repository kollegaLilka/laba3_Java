package com.example.entity;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class 2PointTest {

    @Test
    public void testPointCreation() {
        Point point = new Point(1.0, 2.0);
        assertEquals(point.getX(), 1.0);
        assertEquals(point.getY(), 2.0);
    }

    @Test
    public void testPointEquality() {
        Point point1 = new Point(1.0, 2.0);
        Point point2 = new Point(1.0, 2.0);
        Point point3 = new Point(2.0, 3.0);

        assertTrue(point1.equals(point2));
        assertFalse(point1.equals(point3));
    }

    @Test
    public void testPointHashCode() {
        Point point1 = new Point(1.0, 2.0);
        Point point2 = new Point(1.0, 2.0);
        Point point3 = new Point(2.0, 3.0);

        assertEquals(point1.hashCode(), point2.hashCode());
        assertTrue(point1.hashCode() != point3.hashCode());
    }

    @Test
    public void testPointToString() {
        Point point = new Point(1.0, 2.0);
        assertEquals(point.toString(), "Point{x=1.0, y=2.0}");
    }
}