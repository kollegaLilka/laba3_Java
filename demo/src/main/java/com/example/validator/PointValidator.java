package com.example.validator;

import com.example.entity.Point;

public class PointValidator {

    public boolean isValidPoint(Point point) {
        return point != null && isValidCoordinate(point.getX()) && isValidCoordinate(point.getY());
    }

    private boolean isValidCoordinate(double value) {
        return !Double.isInfinite(value) && !Double.isNaN(value);
    }
}