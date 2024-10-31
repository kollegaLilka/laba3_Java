package com.example.validator;

import com.example.entity.Point;
import com.example.entity.Triangle;

/* Класс для валидации треугольников. */
public class TriangleValidator {

    /*Проверяет, является ли треугольник корректным.*/

    public boolean isValidTriangle(Triangle triangle) {
        return isValidPoints(triangle.getPointA(), triangle.getPointB(), triangle.getPointC()) &&
               !triangle.arePointsCollinear();
    }

    /* Проверяет, являются ли точки корректными. */
    private boolean isValidPoints(Point... points) {
        PointValidator pointValidator = new PointValidator();
        for (Point point : points) {
            if (!pointValidator.isValidPoint(point)) {
                return false;
            }
        }
        return true;
    }
}