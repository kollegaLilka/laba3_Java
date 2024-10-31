package com.example.action;

import com.example.entity.Point;
import com.example.entity.Triangle;

public class TriangleAction {

    /* Вычисляет площадь треугольника. @param triangle треугольник @return площадь треугольника */

    public double calculateArea(Triangle triangle) {
        double x1 = triangle.getPointA().getX();
        double y1 = triangle.getPointA().getY();
        double x2 = triangle.getPointB().getX();
        double y2 = triangle.getPointB().getY();
        double x3 = triangle.getPointC().getX();
        double y3 = triangle.getPointC().getY();

        return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
    }

    /* Вычисляет периметр треугольника. @param triangle треугольник @return периметр треугольника */

    public double calculatePerimeter(Triangle triangle) {
        double a = calculateDistance(triangle.getPointA(), triangle.getPointB());
        double b = calculateDistance(triangle.getPointB(), triangle.getPointC());
        double c = calculateDistance(triangle.getPointC(), triangle.getPointA());
        return a + b + c;
    }

    /* Проверяет, является ли треугольник прямоугольным. @param triangle треугольник @return true, если треугольник прямоугольный, иначе false */
    public boolean isRightTriangle(Triangle triangle) {
        double a = calculateDistance(triangle.getPointA(), triangle.getPointB());
        double b = calculateDistance(triangle.getPointB(), triangle.getPointC());
        double c = calculateDistance(triangle.getPointC(), triangle.getPointA());
        return Math.abs(a * a + b * b - c * c) < 1e-9 || 
               Math.abs(b * b + c * c - a * a) < 1e-9 || 
               Math.abs(c * c + a * a - b * b) < 1e-9;
    }

    /*Проверяет, является ли треугольник равнобедренным. @param triangle треугольник @return true, если треугольник равнобедренный, иначе false */

    public boolean isIsoscelesTriangle(Triangle triangle) {
        double a = calculateDistance(triangle.getPointA(), triangle.getPointB());
        double b = calculateDistance(triangle.getPointB(), triangle.getPointC());
        double c = calculateDistance(triangle.getPointC(), triangle.getPointA());
        return Math.abs(a - b) < 1e-9 || Math.abs(b - c) < 1e-9 || Math.abs(c - a) < 1e-9;
    }

    /*Проверяет, является ли треугольник равносторонним. @param triangle треугольник @return true, если треугольник равносторонний, иначе false */
    public boolean isEquilateralTriangle(Triangle triangle) {
        double a = calculateDistance(triangle.getPointA(), triangle.getPointB());
        double b = calculateDistance(triangle.getPointB(), triangle.getPointC());
        double c = calculateDistance(triangle.getPointC(), triangle.getPointA());
        return Math.abs(a - b) < 1e-9 && Math.abs(b - c) < 1e-9;
    }

    /* Вычисляет расстояние между двумя точками. */
    private double calculateDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
    }
}