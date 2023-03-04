package com.horstmann.corejava.lab2;

public class Task8 {
    public static class Point {
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public Point() {
            new Point(0, 0);
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        private double x;
        private double y;

    }
}
