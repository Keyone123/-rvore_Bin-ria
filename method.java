import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Arvore<T extends Comparable<T>> {
    private Node<T> root;
    private int size;

    public Arvore() {
        root = null;
        size = 0;
    } 
    public Arvore(String fieldText) {
        this();
        String[] keys = fieldText.split("\\s+");
        for (String key : keys) {
            insert((T) key);
        }
    }

    public Arvore(String filename, boolean fromFile) throws IOException {
        this();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        while (line != null) {
            String[] keys = line.split("\\s+");
            for (String key : keys) {
                insert((T) key);
            }
            line = reader.readLine();
        }
        reader.close();
    }

    public void insert(T key) {
        root = insert(root, key);
    }

    private Node<T> insert(Node<T> node, T key) {
        if (node == null) {
            size++;
            return new Node<T>(key);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = insert(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            node.right = insert(node.right, key);
        }

        return node;
    }

    public boolean contains(T key) {
        return contains(root, key);
    }

    private boolean contains(Node<T> node, T key) {
        if (node == null) {
            return false;
        }

        if (key.compareTo(node.key) < 0) {
            return contains(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            return contains(node.right, key);
        } else {
            return true;
        }
    }

    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node<T> node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.key + "\n");
            printInOrder(node.right);
        }
    }

    public void printPreOrder() {
        printPreOrder(root);
    }

    private void printPreOrder(Node<T> node) {
        if (node != null) {
            System.out.print(node.key + "\n");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    public void printPostOrder() {
        printPostOrder(root);
    }

    private void printPostOrder(Node<T> node) {
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(node.key + "\n");
        }
    }

    public void printLevelOrder() {
        Queue<Node<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            System.out.print(node.key + " ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public int getSize() {
        return size;
    }
    public void maior(){
       Node<T> maior = root;
       while(maior.right != null){
           maior = maior.right;
       }
       System.out.println("\nO maior será: " + maior.key);
    }

    public void menor(){
        Node<T> menor = root;
        while(menor.left != null){
            menor = menor.left;
        }
        System.out.println("\nO menor será: " + menor.key);
    }
    public int height() {
        return height(root);
    }
    private int height(Node<T> x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }
    public int internal_Path(){
        return internal_Path(this.root, -1);
    }
    private int internal_Path(Node<T> node, int deph){
        if(node == null)
            return 0;
        deph++;
        if(node.right != null && node.left != null)
            return deph + internal_Path(node.left, deph) + internal_Path(node.right, deph);
        else if(node.left == null)
            return deph + internal_Path(node.right, deph);
        else
            return deph + internal_Path(node.left, deph);

    }
]
