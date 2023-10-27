package binarytree;

import java.util.List;

public interface INode<E extends Comparable<E>> {
    void add(E value);

    Node<E> getLeft();

    void setLeft(Node<E> left);

    Node<E> getRight();

    void setRight(Node<E> right);

    E getValue();

    boolean contains(E value);

    int getHeight();

    List<E> toPrefixList();

    List<E> toInfixList();

    List<E> toPostfixList();

    void add(List<E> values);

    void remove(E value, INode<E> father);
}
