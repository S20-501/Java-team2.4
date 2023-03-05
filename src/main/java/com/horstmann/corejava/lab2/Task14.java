package com.horstmann.corejava.lab2;


import java.util.ArrayList;


public class Task14 {
    public static class Network {
        public class Member { // Класс Member является внутренним
            // для класса Network
            private String name;
            private ArrayList<Member> friends;

            public Member(String name) {
                this.name = name;
                friends = new ArrayList<>();
            }

            public void leave(Network outer) {
                outer.unenroll(this);
            }

            public boolean belongsTo(Network n) {
                return Network.this == n;
            }
        }

        public Network(){
            members = new ArrayList<>();
        }

        public Member enroll(String name) {
            Member newMember = new Member(name);
            members.add(newMember);
            return newMember;
        }

        public void unenroll(Member member){
            members.remove(member);
        }
        private ArrayList<Member> members;
    }

    public static void main(String[] args){
        Network myFace = new Network();
        Network.Member fred = myFace.enroll("fred");

        fred.leave(myFace);
    }
}
