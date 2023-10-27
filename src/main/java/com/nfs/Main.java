package com.nfs;

import list.List;

public class Main {
    public static void main(String[] args) {
        List<Character> myList = new List<>();
        myList.add('H');
        myList.add('E');
        myList.add('L');
        myList.add('L');
        myList.add('O');
        System.out.println(myList.length());
        System.out.println(myList.contains('H'));
        System.out.println(myList.contains('A'));
        System.out.println(myList.getString());
        myList.remove('E');
        System.out.println(myList.getString());
    }
}