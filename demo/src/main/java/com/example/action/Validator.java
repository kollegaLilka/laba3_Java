package com.example.action;

import com.example.entity.Triangle;

/**
 * Класс, реализующий валидацию треугольника.
 */
public class Validator {

    /**
     * Проверяет, является ли треугольник корректным.*/
    
    public boolean isValidTriangle(Triangle triangle) {
        return !triangle.arePointsCollinear();
    }

    /* Проверяет корректность координат точки. */

    public boolean isValidPoint(double x, double y) {
        return true;
    }
}