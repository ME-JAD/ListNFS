package list;

public class List<E> {
    private Cell<E> head;


    public List() {
        this.head = null;
    }

    public void add(final E value) {
        if (this.isEmpty()) {
            this.head = new Cell<>(value);
        } else {
            this.head.add(value);
        }
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int length() {
        if (this.isEmpty()) {
            return 0;
        }
        return this.head.getLength();
    }

    public boolean contains(final E value) {
        if (this.isEmpty()) {
            return false;
        }
        return this.head.contains(value);
    }

    public void remove(final E value) {
        if (!this.isEmpty()) {
            this.head.remove(value, this.head);
        }
    }

    public String getString() {
        if (this.isEmpty()) {
            return "";
        }
        return this.head.getString();
    }
}
