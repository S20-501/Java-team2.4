//"Если метод изменяет объект, для которого он вызывается, то такой метод называется модифицирующим"

//"А если вызываемый метод оставляет объект без изменения, то он называется методом доступа"


package com.horstmann.corejava.lab2;
public class Task3 {

    public static class SheepCounter{
        private int number = 0;

        public int addSheeps(int i){//модифицирующий метод с возвращаемым начением
            number = number + i;
            return number; //возвращает получившийся результат
        }

        public void upToHundred(){//метод доступа, у которого тип возвращаемого значения void
            if(number >= 100)
                System.out.println("Already 100 or more");
            else
                System.out.println("It remains to add " + (100-number) + " Sheeps");
        }
    }
    public static void main(String[] args){
        SheepCounter firstOne = new SheepCounter();
        firstOne.addSheeps(5);
        System.out.println(firstOne.addSheeps(1));
        firstOne.upToHundred();
    }
}
