package com.horstmann.corejava.lab5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Task5 {

    public static void DoEverything(){
        Scanner in = null;
        PrintWriter out = null;
        try {
            in = new Scanner(System.in);
            out = new PrintWriter(System.out);
            out.println(in.nextInt());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(in != null)
                try{
                    in.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            if(out != null)
                try{
                    out.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
        }
    }

    public static void main(String[] args) {
        DoEverything();
    }
}
