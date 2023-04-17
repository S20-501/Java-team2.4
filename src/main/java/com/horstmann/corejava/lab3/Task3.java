package com.horstmann.corejava.lab3;

import javax.imageio.stream.ImageOutputStream;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        String str; // implements Serializable, Comparable<String>, CharSequence, Constable, ConstantDesc
        Scanner scanner; // implements Iterator<String>, Closeable
        ImageOutputStream imageOutputStream; // extends ImageInputStream, DataOutput
                                             //         ^--- extends DataInput, Closeable
    }
}
