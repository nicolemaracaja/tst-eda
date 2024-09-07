public class ArvoreBinaria {

    public static void main(String[] args){
        BST arvore = new BST();

        System.out.println(arvore.toStringPreOrder()); //vazio

        arvore.add(10);
        arvore.add(5);
        arvore.add(15);

        System.out.println(arvore.toStringPreOrder()); // 10 5 15

    }
}

class BST{

    Node root; //raiz

    /**
     * Verifica se a árvore é vazia
     */
    public boolean isEmpty(){
        return this.root == null;
    }

    /**
     * Adiciona um elemento à árvore de forma iterativa
     */
    public void add (int k){  
        Node newNode = new Node(k);

        if (isEmpty()){
            this.root = newNode;
        } else {
            Node aux = this.root;

            while (aux != null){
                if (k < aux.value){
                    if (aux.left == null){
                        aux.left = newNode;
                        return;
                    } else {
                        aux = aux.left;
                    }                   
                } else {
                    if (aux.right == null){
                        aux.right = newNode;
                        return;
                    } else {
                        aux = aux.right;
                    }
                }
            }
        }
    }

    /**
     * Adiciona um elemento à árvore de forma recursiva
     */
    public void recursiveAdd(int v){
        if (isEmpty()){
            this.root = new Node(v);
        } else {
            rAdd(this.root, v);
        }
    }

    private void rAdd(Node current, int v){
        if (v < current.value){
            if (current.left == null){
                current.left = new Node(v);
                return;
            } else {
                rAdd(current.left, v);
            }
        } else {
            if (current.right == null){
                current.right = new Node (v);
                return;
            } else {
                rAdd(current.right, v);
            }
        }
    }

    /**
     * Procura por um elemento v na árvore de forma recursiva
     */
    public Node search(int v){
        if (isEmpty()){
            return null;
        } else {
            return recursiveSearch(this.root, v);
        }
    }

    private Node recursiveSearch(Node current, int v){
        if (current == null){
            return null;
        }
        if (current.value == v){
            return current;
        }
        if (current.value > v){
            return recursiveSearch(current.left, v);
        } else {
            return recursiveSearch(current.right, v);
        }
    }

    /**
     * Retorna a altura da árvore de forma recursiva
     */
    public int height(){
        return height(this.root);
    }

    private int height(Node current){
        if (current == null){
            return -1;
        } else {
            return 1 + Math.max(height(current.left), height(current.right));
        }
    }

    /**
     * Retorna o valor mínimo da árvore de forma recursiva
     */
    public Node min(){
        if (isEmpty()){
            return null;
        }
        return min(this.root);
    }

    private Node min(Node current){
        if (current.left == null){
            return current;
        } else {
            return min(current.left);
        }
    }

    /**
     * Retorna o valor máximo da árvore de forma recursiva
     */
    public Node max(){
        if (isEmpty()){
            return null;
        }
        return max(this.root);
    }

    private Node max(Node current){
        if (current.right == null){
            return current;
        } else {
            return max(current.right);
        }
    }

    /**
     * Retorna a quantidade de elementos na árvore
     */
    public int size(){
        return size(this.root);
    }

    private int size(Node current){
        if (isEmpty()){
            return 0;
        } else {
            return 1 + size(current.left) + size(current.right);
        }
    }

    /**
     * Classifica a árvore em pré ordem
     */
    public void preOrder(){
        preOrder(this.root);
    }

    /*
     * nó, esquerda, direita
     */
    private void preOrder(Node current){
        if (current != null){
            System.out.println(current.value + " ");
            preOrder(current.left);
            preOrder(current.right);
        }
    }

    /**
     * Classifica a árvore em ordem
     */
    public void inOrder(){
        inOrder(this.root);
    }

    /*
     * esquerda, nó, direita
     */
    private void inOrder(Node current){
        if (current != null){
            inOrder(current.left);
            System.out.println(current.value + " ");
            inOrder(current.right);
        }
    }

    /*
     * Classifica a árvore em pós ordem
     */
    public void posOrder(){
        posOrder(this.root);
    }

    /**
     * esquerda, direita, nó
     */
    private void posOrder(Node current){
        if (current != null){
            posOrder(current.left);
            posOrder(current.right);
            System.out.println(current.value + " ");
        }
    }

    public String toStringPreOrder(){
        return toStringPreOrder(this.root).trim();
    }

    private String toStringPreOrder(Node current){
        if (current == null){
            return "";
        }
        return current.value + " " + toStringPreOrder(current.left) + toStringPreOrder(current.right);
    }

}

class Node {

    int value;
    Node left;
    Node right;

    Node (int v){
        this.value = v;
    }
}
