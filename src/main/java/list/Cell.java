package list;

public class Cell<E> {
    private final E value;
    private Cell<E> next;

    public Cell(final E value) {
        this.value = value;
        this.next = null;
    }

    public E getValue() {
        return this.value;
    }

    public Cell<E> getNext() {
        return this.next;
    }

    public void setNext(final Cell<E> next) {
        this.next = next;
    }

    public void add(final E value) {
        if (this.next == null) {
            this.next = new Cell<>(value);
        } else {
            this.next.add(value);
        }
    }

    public int getLength() {
        if (this.next == null) {
            return 1;
        }
        return 1 + this.next.getLength();
    }

    public boolean contains(final E value) {
        if (this.value.equals(value)) {
            return true;
        }
        if (this.next == null) {
            return false;
        }
        return this.next.contains(value);
    }

    public void remove(final E value, final Cell<E> previous) {
        if (this.value.equals(value)) {
            previous.setNext(this.next);
        } else if (this.next != null) {
            this.next.remove(value, this);
        }
    }

    public String getString() {
        if (this.next == null) {
            return this.value.toString();
        } else {
            return this.value.toString() + this.next.getString();
        }
    }
}
