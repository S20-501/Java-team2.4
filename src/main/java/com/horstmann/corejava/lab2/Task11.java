package com.horstmann.corejava.lab2;

import java.time.LocalDate;
import java.util.List;

import static java.lang.System.out;
import static java.time.DayOfWeek.SUNDAY;

public class Task11 {
    public static class Calendar {

        public static void show() {
            LocalDate date = java.time.LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), 3);
            showNamesOfWeekDays();
            printDaysOfMonth(date);
        }

        private static void printDaysOfMonth(LocalDate date) {
            int value = date.getDayOfWeek().getValue();
            for (int i = 1; i < value + 1; i++)
                out.print("    ");

            while (date.getMonthValue() == LocalDate.now().getMonthValue()) {
                if (date.getDayOfWeek() == SUNDAY) {
                    out.println();
                }
                out.printf("%4d", date.getDayOfMonth());
                date = date.plusDays(1);
            }
        }

        private static void showNamesOfWeekDays() {
            for (int i = 0; i < 7; i++) {
                out.printf("%4s", List.of((i + 6) % 7 + 1).toString().substring(0, 3));
            }
            out.println();
        }
    }

    public static void main(String[] args) {
        Calendar.show();
    }
}
