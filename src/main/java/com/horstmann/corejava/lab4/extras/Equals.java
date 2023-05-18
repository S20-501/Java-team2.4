package com.horstmann.corejava.lab4.extras;


//Евгений: какое соглашение работы методов equals() и hashCode(). Как внутри
//equals использовать методы hashCode. С примером в коде.

public class Equals {

    static class A{
        int a = 0;
        int key = 0;

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;

            if (obj == null) return false;

            if (getClass() != obj.getClass()) return false;

            A other = (A) obj;

            return hashCode() == other.hashCode();
        }

        @Override
        public int hashCode() {
            int hash = 2139062143;

            hash = 37 * hash + key;

            return hash;
        }
    }

    public static void main(String[] args) {
        A a1 = new A();
        a1.a = 9;
        a1.key = 7;

        A a2 = new A();
        a2.a = 9;
        a2.key = 7;

        System.out.println(a2.equals(a1));

        a2.a = 89;
        System.out.println(a2.equals(a1));

        a2.key = 77;
        System.out.println(a2.equals(a1));
    }
}
