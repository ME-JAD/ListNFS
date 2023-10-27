package com.nfs;

import binarytree.BinaryTree;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> myBinaryTree = new BinaryTree<>();
        myBinaryTree.add(10);
        myBinaryTree.add(5);
        myBinaryTree.add(3);
        myBinaryTree.add(12);
        myBinaryTree.add(15);
        myBinaryTree.add(13);
        List<Integer> infixList = myBinaryTree.toInfixList();
        myBinaryTree.remove(3);
        infixList = myBinaryTree.toInfixList();
        myBinaryTree.remove(10);
        infixList = myBinaryTree.toInfixList();
    }
}