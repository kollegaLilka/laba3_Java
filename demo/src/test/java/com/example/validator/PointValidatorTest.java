package com.example.validator;

import com.example.entity.Point;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class PointValidatorTest {

    private final PointValidator pointValidator = new PointValidator();

    @Test
    public void testValidPoint() {
        Point validPoint = new Point(1.0, 2.0);
        assertTrue(pointValidator.isValidPoint(validPoint));
    }

    @Test
    public void testInvalidPoint_NaN() {
        Point invalidPoint = new Point(Double.NaN, 2.0);
        assertFalse(pointValidator.isValidPoint(invalidPoint));
    }

    @Test
    public void testInvalidPoint_NegativeInfinity() {
        Point invalidPoint = new Point(Double.NEGATIVE_INFINITY, 2.0);
        assertFalse(pointValidator.isValidPoint(invalidPoint));
    }

    @Test
    public void testInvalidPoint_PositiveInfinity() {
        Point invalidPoint = new Point(Double.POSITIVE_INFINITY, 2.0);
        assertFalse(pointValidator.isValidPoint(invalidPoint));
    }
}