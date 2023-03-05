package com.horstmann.corejava.lab2;

public class Task16 {
    public static class Queue{
        private static class Node{
            private final String string;
            private Node next = null;

            public Node(String string){
                this.string = string;
            }
        }

        private Node head = null;

        public Queue add(String str){
            if (head == null) {
                head = new Node(str);

                return this;
            }

            Node iterator = head;

            while (iterator.next != null) {
                iterator = iterator.next;
            }

            iterator.next = new Node(str);

            return this;
        }

        public String remove(){
            if (head == null) {
                return null;
            }

            String str = head.string;
            head = head.next;

            return str;
        }

    }


    public static void main(String[] args){
        Queue q = new Queue();

        q.add("test1").add("test2").add("test3");

        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }

}
