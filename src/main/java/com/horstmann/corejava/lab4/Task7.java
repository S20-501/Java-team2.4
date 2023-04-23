package com.horstmann.corejava.lab4;

public class Task7 {

    enum Colors {
        BLACK, RED, BLUE, GREEN, CYAN, MAGENTA, YELLOW, WHITE;

        static Colors getRed() {
            return RED;
        }

        static Colors getGreen() {
            return GREEN;
        }

        static Colors getBlue() {
            return BLUE;
        }
    }

    public static void main(String[] args) {
        System.out.println(Colors.getBlue() + "\n");

        for (Colors color : Colors.values()) {
            System.out.println(color);
        }
    }

}
