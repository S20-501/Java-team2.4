package com.horstmann.corejava.lab2;

public class Task6 {

    public static class Point{
        /**
         * X coordinate
         */
        private double x;

        /**
         * Y coordinate
         */
        private double y;

        /**
         * Constructs point in start of coordinate system
         */
        public Point(){
            new Task5.Point(0, 0);
        }

        /**
         * Constructs point in defined position on coordinate system
         */
        public Point(double x, double y){
            this.x = x;
            this.y = y;
        }

        /**
         * Get X coordinate
         *
         * @return X coordinate
         */
        public double getX(){
            return x;
        }

        /**
         * Get Y coordinate
         *
         * @return Y coordinate
         */
        public double getY(){
            return y;
        }


        /**
         * Moves point to a distance
         * @param dX distance of X to move
         * @param dY distance of Y to move
         * @return modified point, moved to a distance
         */
        public Point translate(double dX, double dY){
            x += dX;
            y += dY;

            return this;
        }

        /**
         * Scales point distance from start of coordinate system
         * @param scale how much to increase distance
         * @return modified scaled point
         */
        public Point scale(double scale){
            x *= scale;
            y *= scale;

            return this;
        }

    }

    public static void main(String[] args){
        Point p = new Point(3, 4).translate(1, 3).scale(0.5);

        System.out.printf("(%.1f, %.1f)", p.getX(), p.getY());
    }
}

