package com.horstmann.corejava.lab4.additional;

import java.util.Iterator;
import java.util.ServiceLoader;

public class Demo {
    public static void main(String[] args) {

        DIServiceLoader<Interface> loader = DIServiceLoader.load(Interface.class);
        Interface bean1 = loader.getBean("Bean1");
        Interface bean2 = loader.getBean(Implementation2.class);

        for (Interface printer : loader) {
            printer.print();
        }

        System.out.println("\n\n");

//        bean2.print();
//        bean1.print();

    }
}
