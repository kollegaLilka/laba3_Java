package com.example.entity;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class TriangleTest {

    @Test
    public void testTriangleCreation() {
        Point a = new Point(0, 0);
        Point b = new Point(1, 0);
        Point c = new Point(0, 1);
        Triangle triangle = new Triangle(a, b, c);
        
        assertEquals(triangle.getPointA(), a);
        assertEquals(triangle.getPointB(), b);
        assertEquals(triangle.getPointC(), c);
    }

    @Test
    public void testTriangleEquality() {
        Point a = new Point(0, 0);
        Point b = new Point(1, 0);
        Point c = new Point(0, 1);
        Triangle triangle1 = new Triangle(a, b, c);
        Triangle triangle2 = new Triangle(a, b, c);
        Triangle triangle3 = new Triangle(b, c, a); // Разные вершины, но тот же треугольник

        assertTrue(triangle1.equals(triangle2));
        assertFalse(triangle1.equals(triangle3));
    }

    @Test
    public void testTriangleHashCode() {
        Point a = new Point(0, 0);
        Point b = new Point(1, 0);
        Point c = new Point(0, 1);
        Triangle triangle1 = new Triangle(a, b, c);
        Triangle triangle2 = new Triangle(a, b, c);
        Triangle triangle3 = new Triangle(b, c, a); // Разные вершины, но тот же треугольник

        assertEquals(triangle1.hashCode(), triangle2.hashCode());
        assertTrue(triangle1.hashCode() != triangle3.hashCode());
    }

    @Test
    public void testTriangleToString() {
        Point a = new Point(0, 0);
        Point b = new Point(1, 0);
        Point c = new Point(0, 1);
        Triangle triangle = new Triangle(a, b, c);
        
        assertEquals(triangle.toString(), "Triangle{pointA=Point{x=0.0, y=0.0}, pointB=Point{x=1.0, y=0.0}, pointC=Point{x=0.0, y=1.0}}");
    }

    @Test
    public void testArePointsCollinear() {
        Point a = new Point(0, 0);
        Point b = new Point(1, 1);
        Point c = new Point(2, 2); // Коллинеарные точки
        Triangle collinearTriangle = new Triangle(a, b, c);
        assertTrue(collinearTriangle.arePointsCollinear());

        Point d = new Point(0, 0);
        Point e = new Point(1, 0);
        Point f = new Point(0, 1); // Неколлинеарные точки
        Triangle nonCollinearTriangle = new Triangle(d, e, f);
        assertFalse(nonCollinearTriangle.arePointsCollinear());
    }
}