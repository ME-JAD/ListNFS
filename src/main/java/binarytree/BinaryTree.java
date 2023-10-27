package binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<E extends Comparable<E>> implements INode<E> {
    private Node<E> root;

    public BinaryTree() {
        this.root = null;
    }

    public void remove(final E value) {
        if (!this.isEmpty()) {
            if (this.root.getValue().equals(value)) {
                final List<E> children = new ArrayList<>();
                if (this.root.getLeft() != null) {
                    children.addAll(this.root.getLeft().toInfixList());
                }
                if (this.root.getRight() != null) {
                    children.addAll(this.root.getRight().toInfixList());
                }
                this.root = null;
                this.add(children);
            }
            this.root.remove(value, this);
        }
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public void add(final E value) {
        if (this.root == null) {
            this.root = new Node<E>(value);
        } else {
            this.root.add(value);
        }
    }

    @Override
    public Node<E> getLeft() {
        return this.isEmpty() ? null : this.root.getLeft();
    }

    @Override
    public void setLeft(final Node<E> left) {
        if (!this.isEmpty()) {
            this.root.setLeft(left);
        }
    }

    @Override
    public Node<E> getRight() {
        return this.isEmpty() ? null : this.root.getRight();
    }

    @Override
    public void setRight(final Node<E> right) {
        if (!this.isEmpty()) {
            this.root.setRight(right);
        }
    }

    @Override
    public E getValue() {
        return this.isEmpty() ? null : this.root.getValue();
    }

    @Override
    public boolean contains(final E value) {
        if (this.root == null) {
            return false;
        }
        return this.root.contains(value);
    }

    @Override
    public int getHeight() {
        if (this.root == null) {
            return 0;
        }
        return this.root.getHeight();
    }

    @Override
    public List<E> toPrefixList() {
        if (this.root == null) {
            return null;
        }
        return this.root.toPrefixList();
    }

    @Override
    public List<E> toInfixList() {
        if (this.root == null) {
            return null;
        }
        return this.root.toInfixList();
    }

    @Override
    public List<E> toPostfixList() {
        if (this.root == null) {
            return null;
        }
        return this.root.toPostfixList();
    }

    @Override
    public void add(final List<E> values) {
        for (final E value : values) {
            this.add(value);
        }
    }

    @Override
    public void remove(E value, INode<E> father) {

    }

    public List<E> toByWidthList() {
        return null;
    }
}
