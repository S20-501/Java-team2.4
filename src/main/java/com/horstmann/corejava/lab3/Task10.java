package com.horstmann.corejava.lab3;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.function.Function;

public class Task10 {
    public static void main(String[] args) {
        Path path = Path.of("/Users/nikis/IdeaProjects/");
        System.out.println(Arrays.toString(takeAllSubdirectoriesByPath(path)));
        System.out.println(Arrays.toString(takeAllSubdirectoriesByPathWithLambda(path)));
        System.out.println(Arrays.toString(takeAllSubdirectoriesByPathWithAnon(path)));


    }


  /*  static void foo(Function comp){
        int f = 0;
        comp.apply(f);
    }

    */

    private static File[] takeAllSubdirectoriesByPath(Path path) {
      /*  foo((bg)->{
            System.out.println("Hello");
            return bg;
        });*/
        File file = path.toFile();
        if (file.isDirectory())
            return file.listFiles(File::isDirectory);
        return null;
    }

    private static File[] takeAllSubdirectoriesByPathWithLambda(Path path) {
        File file = path.toFile();
        if (file.isDirectory())
            return file.listFiles(s -> s.isDirectory());
        return null;
    }

    private static File[] takeAllSubdirectoriesByPathWithAnon(Path path) {
        File file = path.toFile();
        return file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
    }
}