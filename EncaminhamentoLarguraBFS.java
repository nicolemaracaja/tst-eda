import java.util.Scanner;

public class EncaminhamentoLarguraBFS {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] entrada = sc.nextLine().split(" ");
        int[] values = new int[entrada.length];

        for (int i = 0; i < entrada.length; i++){
            values[i] = Integer.parseInt(entrada[i]);
        }

        BST tree = new BST();

        for (int i = 0; i < entrada.length; i++){
            tree.add(values[i]);
        }

        System.out.println(tree.bfs());
        
        sc.close();
    }
}

class BST {

    Node root;

    public BST(){
        this.root = null;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public void add(int v){
        if (isEmpty()){
            this.root = new Node(v);
        } else {
            recursiveAdd(this.root, v);
        }
    }

    public void recursiveAdd(Node current, int v){
        if (v < current.value){
            if (current.left == null){
                Node newNode = new Node(v);
                current.left = newNode;
                newNode.parent = current;
                return;
            } else {
                recursiveAdd(current.left, v);
            }
        } else {
            if (current.right == null){
                Node newNode = new Node(v);
                current.right = newNode;
                newNode.parent = current;
                return;
            } else {
                recursiveAdd(current.right, v);
            }
        }
    }

    public int height(){
        return height(this.root);
    }

    private int height(Node current){
        if (current == null){
            return 0;
        } else {
            return 1 + Math.max(height(current.left), height(current.right));
        }
    }

    public String bfs(){
        if (this.root == null){
            return "";
        }

        String saida = "";
        int altura = height(this.root);

        for (int i = 1; i <= altura; i++){
            saida += bfs(this.root, i);
        }

        return saida.trim();
    }

    private String bfs(Node current, int index){
        if (current == null){
            return "";
        }
        if (index == 1){
            return current.value + " ";
        } else if (index > 1) {
            return bfs(current.left, index - 1) + bfs(current.right, index - 1);
        }
        return "";
    }
}

class Node {

    int value;
    Node left;
    Node right;
    Node parent;

    public Node(int v){
        this.value = v;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}