package com.example.entity;

import java.util.Objects;

/* Класс, представляющий треугольник, заданный тремя точками.*/

public class Triangle {
    private final Point pointA; 
    private final Point pointB; 
    private final Point pointC; 

    public Triangle(Point pointA, Point pointB, Point pointC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    public Point getPointA() {
        return pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    @Override
    public String toString() {
        return "Triangle{" + "pointA=" + pointA + ", pointB=" + pointB + ", pointC=" + pointC + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(pointA, triangle.pointA) &&
               Objects.equals(pointB, triangle.pointB) &&
               Objects.equals(pointC, triangle.pointC);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointA, pointB, pointC);
    }

    /*Проверяет, являются ли три точки треугольника коллинеарными. @return true, если точки коллинеарные, иначе false */
    
    public boolean arePointsCollinear() {
        double area = Math.abs((pointA.getX() * (pointB.getY() - pointC.getY()) +
                                 pointB.getX() * (pointC.getY() - pointA.getY()) +
                                 pointC.getX() * (pointA.getY() - pointB.getY())) / 2.0);
        return area == 0;
    }
}