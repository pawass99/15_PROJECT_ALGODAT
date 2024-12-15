public class StackTugas {
    Tugas top;

    public void push(Tugas task) {
        task.next = top;
        top = task;
    }

    Tugas pop() {
        if (top == null) {
            System.out.println("Stack kosong");
            return null;
        }
        Tugas task = top;
        top = top.next;
        return task;
    }
}
