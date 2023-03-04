package com.horstmann.corejava.lab2;

public class Task5 {

    /**
     * Object of class <code>Point</code> represents point
     * with floating point coordinates
     *
     * @author evezers
     * @version 1.0
     */
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
            new Point(0, 0);
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
         * @return new moved point
         */
        public Point translate(double dX, double dY){
            return new Point(x + dX, y + dY);
        }

        /**
         * Scales point distance from start of coordinate system
         * @param scale how much to increase distance
         * @return new scaled point
         */
        public Point scale(double scale){
            return new Point(x * scale, y * scale);
        }

    }

    public static void main(String[] args){
        Point p = new Point(3, 4).translate(1, 3).scale(0.5);

        System.out.printf("(%.1f, %.1f)", p.getX(), p.getY());
    }
}

