package com.horstmann.corejava.lab4;

public class Task45 {
    static class Point implements Cloneable{
        double x, y;

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public Point clone() throws CloneNotSupportedException {
            return (Point) super.clone();
        }
    }

    abstract static class Shape implements Cloneable{
        Point center;

        Shape(){
            center = new Point();
        }

        public void moveBy(double dx, double dy){
            center.x += dx;
            center.y += dy;
        }

        abstract public Point getCenter();

        @Override
        public Shape clone() throws CloneNotSupportedException {
            Shape cloned = (Shape) super.clone();
            cloned.center = center.clone();

            return cloned;
        }
    }

    static class Circle extends Shape {
        Circle(Point center, double radius){
            this.center = center;
        }

        @Override
        public Point getCenter() {
            return center;
        }

        @Override
        public Circle clone() throws CloneNotSupportedException {
            return (Circle) super.clone();
        }
    }

    static class Rectangle extends Shape {
        Rectangle(Point topLeft, double width, double height){
            center.x = (topLeft.x + width) / 2;
            center.y = (topLeft.y + height) / 2;
        }

        @Override
        public Point getCenter() {
            return center;
        }

        @Override
        public Rectangle clone() throws CloneNotSupportedException {
            return (Rectangle) super.clone();
        }
    }

    static class Line extends Shape {
        Line(Point from, Point to){
            center.x = (from.x + to.x) / 2;
            center.y = (from.y + to.y) / 2;
        }

        @Override
        public Point getCenter() {
            return center;
        }

        @Override
        public Line clone() throws CloneNotSupportedException {
            return (Line) super.clone();
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Point p1 = new Point(), p2 = new Point();
        Shape shape;
        Shape shapeClone;


        p1.x = 1;
        p1.y = 2;

        p2.x = 13;
        p2.y = 14;

        shape = new Circle(p1, 3);
        shapeClone = shape.clone();
        shapeClone.moveBy(3, 7);
        System.out.println("Circle center: " + shape.getCenter());
        System.out.println("Circle clone center: " + shapeClone.getCenter());
        System.out.println();

        shape = new Rectangle(p1, 3, 8);
        shapeClone = shape.clone();
        shapeClone.moveBy(3, 7);
        System.out.println("Rectangle center: " + shape.getCenter());
        System.out.println("Rectangle clone center: " + shapeClone.getCenter());
        System.out.println();

        shape = new Line(p1, p2);
        shapeClone = shape.clone();
        shapeClone.moveBy(3, 7);
        System.out.println("Line center: " + shape.getCenter());
        System.out.println("Line clone center: " + shapeClone.getCenter());
        System.out.println();


        Line l1 = new Line(p1, p2);
        Line l2 = l1.clone();
        l2.moveBy(40, 30);
        System.out.println("Line center: " + l1.getCenter());
        System.out.println("Line clone center: " + l2.getCenter());
        System.out.println();
    }
}
