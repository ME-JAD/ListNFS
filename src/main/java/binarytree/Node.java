package binarytree;

import java.util.ArrayList;
import java.util.List;

public class Node<E extends Comparable<E>> implements INode<E> {
    private final E value;
    private Node<E> left;
    private Node<E> right;

    public Node(final E value) {
        this.value = value;
    }

    @Override
    public void add(final E value) {
        if (!this.value.equals(value)) {
            final int comparaison = this.value.compareTo(value);
            if (comparaison > 0) {
                if (this.left == null) {
                    this.left = new Node<>(value);
                } else {
                    this.left.add(value);
                }
            } else if (comparaison < 0) {
                if (this.right == null) {
                    this.right = new Node<>(value);
                } else {
                    this.right.add(value);
                }
            }
        }
    }

    @Override
    public Node<E> getLeft() {
        return this.left;
    }

    @Override
    public void setLeft(final Node<E> left) {
        this.left = left;
    }

    @Override
    public Node<E> getRight() {
        return this.right;
    }

    @Override
    public void setRight(final Node<E> right) {
        this.right = right;
    }

    @Override
    public E getValue() {
        return this.value;
    }

    @Override
    public boolean contains(final E value) {
        if (this.value.equals(value)) {
            return true;
        }
        boolean result = false;
        if (this.left != null) {
            result = this.left.contains(value);
        }
        if (this.right != null) {
            result = result || this.right.contains(value);
        }
        return result;
    }

    @Override
    public int getHeight() {
        int leftHeight = 0;
        int rightHeight = 0;
        if (this.left != null) {
            leftHeight = this.left.getHeight();
        }
        if (this.left != null) {
            rightHeight = this.right.getHeight();
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }

    @Override
    public List<E> toPrefixList() {
        final ArrayList<E> infixList = new ArrayList<>();
        infixList.add(this.value);
        if (this.left != null) {
            infixList.addAll(this.left.toInfixList());
        }

        if (this.right != null) {
            infixList.addAll(this.right.toInfixList());
        }
        return infixList;
    }

    @Override
    public List<E> toInfixList() {
        final ArrayList<E> infixList = new ArrayList<>();
        if (this.left != null) {
            infixList.addAll(this.left.toInfixList());
        }
        infixList.add(this.value);
        if (this.right != null) {
            infixList.addAll(this.right.toInfixList());
        }
        return infixList;
    }

    @Override
    public List<E> toPostfixList() {
        final ArrayList<E> infixList = new ArrayList<>();
        if (this.left != null) {
            infixList.addAll(this.left.toInfixList());
        }

        if (this.right != null) {
            infixList.addAll(this.right.toInfixList());
        }
        infixList.add(this.value);
        return infixList;
    }

    @Override
    public void add(final List<E> values) {
        for (final E value : values) {
            this.add(value);
        }
    }

    @Override
    public void remove(final E value, final INode<E> father) {
        if (this.value.equals(value)) {
            final List<E> children = new ArrayList<>();
            if (this.left != null) {
                children.addAll(this.left.toInfixList());
            }
            if (this.right != null) {
                children.addAll(this.right.toInfixList());
            }
            if (father.getLeft().getValue().equals(this.value)) {
                father.setLeft(null);
            } else {
                father.setRight(null);
            }
            father.add(children);
        } else {
            final int comparaison = this.value.compareTo(value);
            if (comparaison > 0) {
                if (this.left != null) {
                    this.left.remove(value, this);
                }
            } else if (comparaison < 0) {
                if (this.right != null) {
                    this.right.remove(value, this);
                }
            }
        }
    }
}

