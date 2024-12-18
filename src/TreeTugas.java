public class TreeTugas {
    Node root;

    public class Node {
        String namaTugas;
        Node firstSubTugas;
        Node nextSibling;

        public Node(String namaTugas) {
            this.namaTugas = namaTugas;
            this.firstSubTugas = null;
            this.nextSibling = null;
        }

        public void tampilkanSubTugas(String prefix) {
            System.out.println(prefix + "- " + namaTugas);
            Node current = firstSubTugas;
            while (current != null) {
                current.tampilkanSubTugas(prefix + "  ");
                current = current.nextSibling;
            }
        }
    }

    public void addRootTugas(String namaTugas) {
        root = new Node(namaTugas);
        System.out.println("Tugas utama \"" + namaTugas + "\" berhasil ditambahkan.");
    }

    public void addSubTugas(String namaTugas, String namaSubTugas) {
        Node tugas = cariTugas(root, namaTugas);
        if (tugas != null) {
            Node subTugasBaru = new Node(namaSubTugas);
            if (tugas.firstSubTugas == null) {
                tugas.firstSubTugas = subTugasBaru;
            } else {
                Node current = tugas.firstSubTugas;
                while (current.nextSibling != null) {
                    current = current.nextSibling;
                }
                current.nextSibling = subTugasBaru;
            }
            System.out.println("Sub-tugas \"" + namaSubTugas + "\" berhasil ditambahkan ke \"" + namaTugas + "\".");
        } else {
            System.out.println("Tugas \"" + namaTugas + "\" tidak ditemukan.");
        }
    }

    public Node cariTugas(Node current, String namaTugas) {
        if (current == null) return null;
        if (current.namaTugas.equals(namaTugas)) return current;

        Node found = cariTugas(current.firstSubTugas, namaTugas);
        if (found != null) return found;

        return cariTugas(current.nextSibling, namaTugas);
    }

    public void tampilkanTree() {
        if (root == null) {
            System.out.println("Tree tugas kosong.");
        } else {
            System.out.println("Daftar Tugas dan Sub-tugas:");
            root.tampilkanSubTugas("");
        }
    }
}