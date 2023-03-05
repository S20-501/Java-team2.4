package com.horstmann.corejava.lab2;

public class Task17 {
    public static class Queue{
        private static class Node{
            private final String string;
            private Node next = null;

            public Node(String string){
                this.string = string;
            }
        }

        private class Iterator{
            public String next(){
                return remove();
            }

            public boolean hasNext(){
                return head != null;
            }
        }

        private Node head = null;

        public Queue add(String str){
            if (head == null) {
                head = new Node(str);

                return this;
            }

            Node currentNode = head;

            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }

            currentNode.next = new Node(str);

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


        public Iterator iterator(){
            return new Iterator();
        }

    }


    public static void main(String[] args){
        Queue q = new Queue();

        q.add("test1").add("test2").add("test3");

        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());

        Queue.Iterator iterator = q.iterator();
        q.add("test4").add("test5").add("test6").add("test7");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
