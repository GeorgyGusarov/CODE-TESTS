package AlgorithmsAndDatastructures.DataStructures;

import java.util.Objects;

public class RelatedList {
    // класс узла (головной элемент)
    private class Node {
        Cat c;
        Node next; // ссылка на следующий Node (узел)

        public Node(Cat c) {
            this.c = c;
        }

        @Override
        public String toString() {
            return c.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return c.equals(node.c);
        }

        @Override
        public int hashCode() {
            return Objects.hash(c);
        }
    }

    private Node head; // содержит ссылку на самый первый узел

    public RelatedList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(Cat c) {
         Node n = new Node(c);
         n.next = head;
         head = n;
    }

    public Cat pop() {
        if (isEmpty()) return null;
        Cat temp = head.c;
        head = head.next;
        return temp;
    }

    @Override
    public String toString() {
        Node current = head;
        StringBuilder sb = new StringBuilder("[");
        while (current != null) {
            sb.append(current);
            current = current.next;
            sb.append((current == null) ? "]" : ", ");
        }
        return sb.toString();
    }

    public boolean contains(Cat c) {
        if (isEmpty()) return false;
        return find(c) == null;
    }

    public Node find(Cat c) {
        if (isEmpty()) return null;
        Node current = head;
        while (!current.c.equals(c)) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    public boolean delete(Cat c) {
        Node current = head;
        Node previous = head;
        while (!current.c.equals(c)) {
            if (current.next == null) {
                return false;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == head) {
            head = head.next;
        } else {
            previous.next = current.next;
        }
        return true;
    }
}

class RelatedListMain {
    public static void main(String[] args) {
        RelatedList rl = new RelatedList();
        rl.push(new Cat(2, "cat1"));
        rl.push(new Cat(3, "cat2"));
        rl.push(new Cat(4, "cat3"));
        rl.push(new Cat(5, "cat4"));
        rl.push(new Cat(6, "cat5"));
        System.out.println(rl);
        System.out.println(rl.pop());
        System.out.println(rl);
        Cat cat6 = new Cat(7, "cat6");
        rl.push(cat6);
        System.out.println(rl);
        System.out.println(rl.find(cat6));
        rl.delete(cat6);
        System.out.println(rl);
    }
}
