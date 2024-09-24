import java.util.Scanner;

class BalanceBST {
    
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

        System.out.println(tree.preOrder());
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

    public Node getRoot(){
        return this.root;
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
            } else {
                recursiveAdd(current.left, v);
            }
        } else {
            if (current.right == null){
                Node newNode = new Node(v);
                current.right = newNode;
                newNode.parent = current;
            } else {
                recursiveAdd(current.right, v);
            }
        }
    }

    public int height(){
        return height(this.root);
    }

    public int height(Node node){
        if (node == null){
            return -1;
        } else {
            return 1 + Math.max(height(node.left), height(node.right));
        }
    }

    public int calculaBalance(Node current){
        int alturaEsquerda = height(current.left);
        int alturaDireita = height(current.right);
        return alturaEsquerda - alturaDireita;
    }

    //nó, esquerda, direita
    public String preOrder(){
        return preOrder(this.root).trim();
    }

    public String preOrder(Node current){
        String saida = "";
        if (current != null){
            saida += current.value + "," + calculaBalance(current) + " "; 
            saida += preOrder(current.left);
            saida += preOrder(current.right);
        }
        return saida;
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