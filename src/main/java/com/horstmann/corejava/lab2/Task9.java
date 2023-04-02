package com.horstmann.corejava.lab2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Task9 {
    public static class car{
        private final float fuelVolume;
        private float fuelRemain = 0;
        private float fuelConsumption;
        private float XaxisPoint = 0;
        private float YaxisPoint = 0;
        private float totalDistance=0;
        public car(float volume, float consumption){
            fuelVolume = volume;
            fuelConsumption = consumption;
        }

        public void drive(float km,float direction){// direction - angle
            if(km < 0) {
                System.out.println("Incorrect distance");
                return;
            }
            if(fuelRemain < fuelConsumption*km){
                System.out.println("Not enough fuel, there only " + fuelRemain/fuelConsumption+ " km left");
                return;
            }

            fuelRemain -= fuelConsumption*km;

            XaxisPoint+=km*Math.cos(Math.toRadians(direction));
            YaxisPoint+=km*Math.sin(Math.toRadians(direction));

            totalDistance+=km;
        }

        public void returnHome(){
            float distance = (float)Math.sqrt(XaxisPoint*XaxisPoint+YaxisPoint*YaxisPoint);
            float arccos = (float)Math.toDegrees(Math.acos(XaxisPoint/distance));
            float arcsin = (float)Math.toDegrees(Math.asin(YaxisPoint/distance));
            float drive_dist;

            if(fuelRemain < fuelConsumption*distance){
                drive_dist = fuelRemain/fuelConsumption;//если топлива не хватает, едем сколько можем
            }else{
                drive_dist = distance;//если хватает, едем до конца
            }

            if(arcsin>0){
                if(arccos>0){//1
                    drive(drive_dist,arccos-180);
                }else{//2
                    drive(drive_dist,arccos);
                }
            }else{
                if(arccos<0){//3
                    drive(drive_dist,-arcsin);
                }else{//4
                    drive(drive_dist,180+arcsin);
                }
            }
        }

        public void refuel(float liters){
            if(liters < 0) {
                System.out.println("Incorrect volume");
                return;
            }
            if(fuelRemain + liters > fuelVolume){
                System.out.println("Too much fuel!  "+ (liters -(fuelVolume-fuelRemain)) + " liters have spilled");
                fuelRemain = fuelVolume;
                return;
            }
            fuelRemain = fuelRemain + liters;
        }

        public float getTotalDistance(){
            return totalDistance;
        }
        public float getXAxisPoint(){return XaxisPoint;}
        public float getYAxisPoint(){return YaxisPoint;}
        public float getFuelRemain(){
            return fuelRemain;
        }
    }
    public static void main(String[] args) throws Exception{
        String menu = "1.drive\n2.refuel\n3.get home\n4.info\n5.exit\n";
        //создание машины
        System.out.print("Enter volume and consumption:");
        Scanner scanner = new Scanner(System.in);
        float volume = scanner.nextInt();
        float consumption = scanner.nextInt();
        car regularCar = new car(volume,consumption);// 100 1


        float km,direction;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;

        while (true) {
            System.out.print(menu);
            s = reader.readLine();
            if (s.equals("5"))
                break;
            if (s.equals("1")) {
                System.out.println("Enter km and direction:");
                km = scanner.nextInt();
                direction = scanner.nextInt();
                regularCar.drive(km,direction);
                continue;
            }
            if (s.equals("2")) {
                volume = scanner.nextInt();
                regularCar.refuel(volume);
                continue;
            }
            if (s.equals("3")) {
                regularCar.returnHome();
                continue;
            }
            if (s.equals("4")) {
                System.out.println("Total distance: "+ regularCar.getTotalDistance());
                System.out.println("Fuel remains: "+ regularCar.getFuelRemain());
                System.out.println("X Axis point: "+ regularCar.getXAxisPoint());
                System.out.println("Y Axis point: "+ regularCar.getYAxisPoint());
                continue;
            }
            System.out.print("Wrong input");
        }
    }
}
