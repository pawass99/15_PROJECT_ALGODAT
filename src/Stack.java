class Stack {
    private class Node {
        Tugas tugas;
        Node next;

        Node(Tugas tugas) {
            this.tugas = tugas;
            this.next = null;
        }
    }
    private Node top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }
    public void push(Tugas tugas) {
        if (tugas.status.equals("Selesai")) {
            Node newNode = new Node(tugas);
            newNode.next = top;
            top = newNode;
            size++;
        }
    }
    public Tugas pop() {
        if (isEmpty()) {
            return null;
        }
        Tugas tugas = top.tugas;
        top = top.next;
        size--;
        return tugas;
    }
    public boolean isEmpty() {
        return top == null;
    }
    public int getSize() {
        return size;
    }
    public void printHistory() {
        if (isEmpty()) {
            System.out.println("Belum ada tugas yang selesai.");
            return;
        }
        System.out.println("\nHistory Tugas Selesai:");
        System.out.println("====================");
        Node current = top;
        int count = 1;
        while (current != null) {
            System.out.printf("%d. %s (Deadline: %s)\n", 
                count++, 
                current.tugas.nama, 
                current.tugas.deadline
            );
            current = current.next;
        }
        System.out.println("====================");
    }
    public void updateHistory(Tree tree) {
        updateHistoryRecursive(tree.root);
    }
    private void updateHistoryRecursive(Tugas current) {
        if (current == null) return;
        if (current.firstChild == null && current.status.equals("Selesai")) {
            if (!isTaskInStack(current)) {
                push(current);
            }
        }
        updateHistoryRecursive(current.firstChild);
        updateHistoryRecursive(current.nextSibling);
    }
    private boolean isTaskInStack(Tugas tugas) {
        Node current = top;
        while (current != null) {
            if (current.tugas.nama.equals(tugas.nama)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}