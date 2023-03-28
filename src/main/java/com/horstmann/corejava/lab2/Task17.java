package com.horstmann.corejava.lab2;

public class Task17 {
    public static class Queue{
        public class Node{
            private final String string;
            private Node next = null;

            private Node(String string){
                this.string = string;

                if (head == null) {
                    head = this;
                    return;
                }

                Node currentNode = head;

                while (currentNode.next != null) {
                    currentNode = currentNode.next;
                }

                currentNode.next = this;
            }
        }

        private class Iterator{
            private Node before = null;
            private Node current = head;

            public String next(){
                if (current == null) {
                    throw new IndexOutOfBoundsException("Reached end of queue.");
                }

                before = current;
                current = current.next;

                return before.string;
            }

            public String remove(){
                if (current == null) {
                    throw new IndexOutOfBoundsException("Reached end of queue.");
                }

                String str = current.string;

                if (current == head) {
                    head = current.next;
                } else {
                    before.next = current.next;
                }

                return str;
            }

            public boolean hasNext(){
                return current != null;
            }
        }

        private Node head = null;

        public Queue add(String str){
            new Node(str);

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

        public String toString(){
            StringBuilder stringBuilder = new StringBuilder();

            Iterator iterator = iterator();

            while (iterator.hasNext()){
                stringBuilder.append('[');
                stringBuilder.append(iterator.next());
                stringBuilder.append(']');

                if (iterator.hasNext()){
                    stringBuilder.append(" -> ");
                }
            }

            return stringBuilder.toString();
        }
    }

    public static void main(String[] args){
        Queue q = new Queue();

        q.add("test1").add("test2").add("test3");

        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());

        System.out.println();

        q.add("test4").add("test5").add("test6").add("test7");

        System.out.println(q);


        System.out.println("Remove second elem");

        Queue.Iterator iteratorRem = q.iterator();
        iteratorRem.next();
        System.out.println(iteratorRem.remove() + " removed");

        System.out.println(q);


        System.out.println("Remove first elem");

        iteratorRem = q.iterator();
        System.out.println(iteratorRem.remove() + " removed");

        System.out.println(q);


        System.out.println("Remove second elem");

        iteratorRem = q.iterator();
        iteratorRem.next();
        System.out.println(iteratorRem.remove() + " removed");

        System.out.println(q);
    }
}
