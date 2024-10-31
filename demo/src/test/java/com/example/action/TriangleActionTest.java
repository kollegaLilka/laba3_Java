package com.example.action;

import com.example.entity.Point;
import com.example.entity.Triangle;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class TriangleActionTest {

    private final TriangleAction triangleAction = new TriangleAction();

    @Test
    public void testCalculateArea() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(4, 0), new Point(0, 3));
        double expectedArea = 6.0; // Площадь = 1/2 * основание * высота
        assertEquals(triangleAction.calculateArea(triangle), expectedArea, 0.0001);
    }

    @Test
    public void testCalculatePerimeter() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4));
        double expectedPerimeter = 12.0; // Периметр = a + b + c
        assertEquals(triangleAction.calculatePerimeter(triangle), expectedPerimeter, 0.0001);
    }

    @Test
    public void testIsRightTriangle() {
        Triangle rightTriangle = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4));
        assertTrue(triangleAction.isRightTriangle(rightTriangle));

        Triangle notRightTriangle = new Triangle(new Point(0, 0), new Point(1, 2), new Point(2, 3));
        assertFalse(triangleAction.isRightTriangle(notRightTriangle));
    }
    
    @Test
    public void testIsEquilateralTriangle() {
        Triangle equilateralTriangle = new Triangle(new Point(0, 0), new Point(1, Math.sqrt(3)), new Point(2, 0));
        assertTrue(triangleAction.isEquilateralTriangle(equilateralTriangle));

        Triangle notEquilateralTriangle = new Triangle(new Point(0, 0), new Point(1, 1), new Point(2, 0));
        assertFalse(triangleAction.isEquilateralTriangle(notEquilateralTriangle));
    }
}