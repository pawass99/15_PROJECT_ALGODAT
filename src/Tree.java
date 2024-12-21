class Tree {
    Tugas root;
    Queue queue;
    public Tree(String nama) {
        this.root = new Tugas(nama);
        this.queue = new Queue();
    }
    public void addChild(String parent, String child) {
        Tugas parentNode = findNode(root, parent);
        if (parentNode == null) {
            parentNode = new Tugas(parent, "", "");
            root.firstChild = parentNode;
        }
        Tugas childNode = new Tugas(child, "", "");
        if (parentNode.firstChild == null) {
            parentNode.firstChild = childNode;
        } else {
            Tugas temp = parentNode.firstChild;
            while (temp.nextSibling != null) {
                temp = temp.nextSibling;
            }
            temp.nextSibling = childNode;
        }
    }
    public void addTask(String matkul, String tugas, String deadline, String status) {
        Tugas matkulNode = findNode(root, matkul);
        if (matkulNode == null) {
            matkulNode = new Tugas(matkul, "", "");
            root.firstChild = matkulNode;
        }
        Tugas taskNode = new Tugas(tugas, deadline, status);
        if (matkulNode.firstChild == null) {
            matkulNode.firstChild = taskNode;
        } else {
            Tugas temp = matkulNode.firstChild;
            while (temp.nextSibling != null) {
                temp = temp.nextSibling;
            }
            temp.nextSibling = taskNode;
        }
    }
    public void updateTaskStatus(String tugas, String status) {
        Tugas taskNode = findNode(root, tugas);
        if (taskNode != null) {
            taskNode.status = status;
            if (status.equals("Sedang Dikerjakan")) {
                queue.enqueue(taskNode);
            }
        }
    }
    public void UpdateComplete(String tugas, String status, double nilai) {
        Tugas taskNode = findNode(root, tugas);
        if (taskNode != null) {
            taskNode.status = status;
            if (status.equals("Selesai")) {
                taskNode.nilai = nilai;
            }
        }
    }
    public void deleteNode(String nodeName) {
        deleteNodeRecursive(root, nodeName);
    }
    private void deleteNodeRecursive(Tugas parent, String nodeName) {
        Tugas current = parent.firstChild;
        Tugas prev = null;
        while (current != null) {
            if (current.nama.equals(nodeName)) {
                if (prev == null) {
                    parent.firstChild = current.nextSibling;
                } else {
                    prev.nextSibling = current.nextSibling;
                }
                return;
            }
            prev = current;
            current = current.nextSibling;
        }
    }
    private Tugas findNode(Tugas current, String nodeName) {
        if (current == null) return null;
        if (current.nama.equals(nodeName)) return current;
        Tugas foundNode = findNode(current.firstChild, nodeName);
        return foundNode != null ? foundNode : findNode(current.nextSibling, nodeName);
    }
    public void printTree(Tugas current, String indent, boolean isLast) {
        if (current == null) return;
        if (!current.nama.isEmpty()) {
            if (!indent.isEmpty()) {
                System.out.print(indent + (isLast ? "└─" : "├─"));
            }
            System.out.print(current.nama);
            if (current.firstChild == null) {
                System.out.print(" (Deadline: " + current.deadline + ", Status: " + current.status + ")");
            }
            System.out.println();
        }
        String childIndent = indent;
        if (!current.nama.isEmpty()) {
            childIndent = indent + (isLast ? "  " : "│ ");
        }
        Tugas child = current.firstChild;
        while (child != null) {
            boolean isChildLast = (child.nextSibling == null);
            printTree(child, childIndent, isChildLast);
            child = child.nextSibling;
        }
    }
    public void printIncompleteTasks() {
        System.out.println("\nTugas yang Belum Selesai:");
        System.out.println("=============================");
        printIncompleteTasksRecursive(root);
        System.out.println("=============================");
    }
    
    private void printIncompleteTasksRecursive(Tugas current) {
        if (current == null) return;
    
        if (current.firstChild == null && !current.status.equals("Selesai")) {
            System.out.println("- " + current.nama + " (Deadline: " + current.deadline + ", Status: " + current.status + ")");
        }
        Tugas child = current.firstChild;
        while (child != null) {
            printIncompleteTasksRecursive(child);
            child = child.nextSibling;
        }
    }
    
}