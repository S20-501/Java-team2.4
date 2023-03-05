package com.horstmann.corejava.lab2;
public class Task9 {
    public static class car{
        private final float fuelVolume;
        private float fuelRemain = 0;
        private float fuelConsumption;
        private float axisPoint = 0;
        private float totalDistance=0;
        public car(float volume, float consumption){
            fuelVolume = volume;
            fuelConsumption = consumption;
        }

        public void drive(float km,int direction){// 0 -- left   not 0 -- right
            if(km < 0) {
                System.out.println("Incorrect distance");
                return;
            }
            if(fuelRemain < fuelConsumption*km){
                System.out.println("Not enough fuel, there only " + fuelRemain/fuelConsumption+ " km left");
                return;
            }

            fuelRemain -= fuelConsumption*km;
            if(direction == 0)
                axisPoint -= km;
            else
                axisPoint += km;

            totalDistance+=km;
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
        public float getAxisPoint(){return axisPoint;}
        public float getFuelRemain(){
            return fuelRemain;
        }
    }
    public static void main(String[] args){
        car regularCar = new car(100,1);
        regularCar.refuel(50);
        regularCar.refuel(60);
        regularCar.drive(60,0);
        regularCar.drive(50,1);
        System.out.println("Total distance: "+ regularCar.getTotalDistance());
        System.out.println("Fuel remains: "+ regularCar.getFuelRemain());
        System.out.println("Axis point: "+ regularCar.getAxisPoint());
    }
}
