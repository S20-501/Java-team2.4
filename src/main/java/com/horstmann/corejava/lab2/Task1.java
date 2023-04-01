package com.horstmann.corejava.lab2;

import java.time.LocalDate;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.print("Enter start day of week:");
        Scanner scanner = new Scanner(System.in);
        int numberOfDay = scanner.nextInt();

        if(numberOfDay < 1 || numberOfDay > 7){
            System.out.println("Incorrect day of week");
            return;
        }

        //берем начало года
        LocalDate date = LocalDate.of(2023, 1, 1);
        for(int i=1; i<=12; i++) {
            //отступ в начале месяца
            int value =date.getDayOfWeek().getValue();

            int shift = value - numberOfDay;
            if(shift<0)
                shift = 7 + shift;

            for (int j = 0; j < shift; j++)
                System.out.print("\t");

            //вывод дней
            for(int g=0; g<date.lengthOfMonth(); g++) {
                if(date.getDayOfWeek().getValue() == numberOfDay)
                    System.out.print("\n");
                System.out.printf("%4d", date.getDayOfMonth());
                date = date.plusDays(1);
            }

            //конец месяца
            System.out.print("\n");
        }
    }
}