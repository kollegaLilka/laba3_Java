package com.example.validator;

import com.example.entity.Point;
import com.example.entity.Triangle;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class TriangleValidatorTest {

    private final TriangleValidator triangleValidator = new TriangleValidator();

    @Test
    public void testValidTriangle() {
        Triangle validTriangle = new Triangle(new Point(0, 0), new Point(1, 0), new Point(0, 1));
        assertTrue(triangleValidator.isValidTriangle(validTriangle));
    }

    @Test
    public void testInvalidTriangle_CollinearPoints() {
        Triangle collinearTriangle = new Triangle(new Point(0, 0), new Point(1, 1), new Point(2, 2));
        assertFalse(triangleValidator.isValidTriangle(collinearTriangle));
    }

    @Test
    public void testInvalidTriangle_InvalidPoint() {
        Triangle invalidTriangle = new Triangle(new Point(0, 0), new Point(Double.NaN, 1), new Point(0, 1));
        assertFalse(triangleValidator.isValidTriangle(invalidTriangle));
    }

    @Test
    public void testInvalidTriangle_NegativeInfinityPoint() {
        Triangle invalidTriangle = new Triangle(new Point(0, 0), new Point(Double.NEGATIVE_INFINITY, 1), new Point(0, 1));
        assertFalse(triangleValidator.isValidTriangle(invalidTriangle));
    }

    @Test
    public void testInvalidTriangle_PositiveInfinityPoint() {
        Triangle invalidTriangle = new Triangle(new Point(0, 0), new Point(Double.POSITIVE_INFINITY, 1), new Point(0, 1));
        assertFalse(triangleValidator.isValidTriangle(invalidTriangle));
    }
}