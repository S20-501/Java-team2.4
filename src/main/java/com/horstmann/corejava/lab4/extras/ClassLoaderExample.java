package com.horstmann.corejava.lab4.extras;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.URLClassLoader;

class MyClassLoader extends ClassLoader {
    String path;

    MyClassLoader(String path){
        this.path = path;
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException{
        InputStream fis;

        String new_path = name.replace(".", "/");

        try {
            fis = new FileInputStream(path + new_path + ".class");
        } catch (FileNotFoundException e) {
            throw new ClassNotFoundException();
        }

        int currentBytes;
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();

        while(true){
            try {
                if (!((currentBytes=fis.read()) > -1)) break;
            } catch (IOException e) {
                throw new ClassNotFoundException();
            }
            byteBuffer.write(currentBytes);
        }

        byte[] byteArray = byteBuffer.toByteArray();

        try {
            fis.close();
        } catch (IOException e) {
            throw new ClassNotFoundException();
        }

        return defineClass(name, byteArray, 0, byteArray.length);
    }
}


public class ClassLoaderExample {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        URL [] urls = {
//                new URL("file:///home/evezers/IdeaProjects/Java-team2.4/target/classes")
//        };

//        ClassLoader myClassLoader = ClassLoaderExample.class.getClassLoader();
        ClassLoader myClassLoader = new MyClassLoader("/home/evezers/IdeaProjects/myclass/");

        Class<?> class1;
        Class<?> class2;

        Object obj1 = null;
        Object obj2 = null;

        try  { //(URLClassLoader loader = new URLClassLoader(urls))
            class1 = Class.forName("com.horstmann.corejava.lab4.extras.Class1", true, myClassLoader);
            class2 = Class.forName("com.horstmann.corejava.lab4.extras.Class2", true, myClassLoader);

//            class1 = loader.loadClass("com.horstmann.corejava.lab4.extras.Class1");
//            class2 = loader.loadClass("com.horstmann.corejava.lab4.extras.Class2");

            obj1 = class1.getDeclaredConstructor().newInstance();
            obj2 = class2.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException |
                 IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e){
            System.err.println(e.getMessage());
        }

        System.out.println(obj1);
        System.out.println(obj2);
    }
}
