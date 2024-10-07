import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class AVL {

    private Node root;
    private int size;

    public boolean isAVL() {
        if (isEmpty()){
            return true;
        }
        return isBalanced();
    }

    //verifica se a árvore pende para a esquerda
    public boolean isLeftPending(Node node){
        return balance(node) > 1;
    }

    //verifica se a árvore pende para a direita
    public boolean isRightPending(Node node){
        return balance(node) < 1;
    }

    //verifica se a árvore está balanceada com recursão
    public boolean isBalanced(){
        return isBalanced(this.root);
    }

    private boolean isBalanced(Node node){
        if (node == null){
            return true;
        }
        int balanceFactor = balance(node);
        return Math.abs(balanceFactor) <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }

    /**
     * Retorna a altura da árvore.
     */
    public int height() {
        return height(this.root);
    }

    /**
     * Retorna a altura de um determinado nó. Auxiliar
     * para recursão e para o balance.
     */
    private int height(Node node) {
        if (node == null){
            return -1;
        } else {
            return 1 + Math.max(height(node.left), height(node.right));
        }
    }

    public Node verificaDesbalanceamento(Node node){
        Node aux = node;

        while (aux != null){
            if (!isBalanced(aux)){
                return aux;
            } else if (aux.parent != null){
                aux = aux.parent;
            } else {
                break;
            }
        }

        return null;
    }

    //calcula o balance dos nós
    private int balance(Node node) {
        if (node == null){
            return 0;
        } else {
            return height(node.left) - height(node.right);
        }
    }

    //rotação para a esquerda
    public Node rotateLeft(Node current){
        Node pivot = current.right;
        pivot.parent = current.parent;

        current.right = pivot.left;
        pivot.left = current;

        current.parent = pivot;

        if (pivot.parent != null){
            if (pivot.parent.right == current){
                pivot.parent.right = pivot;
            } else {
                pivot.parent.left = pivot;
            }
        } else {
            this.root = pivot;
        }

        return pivot;
    }

    //rotação para a direita
    public Node rotateRight(Node current){
        Node pivot = current.left;
        pivot.parent = current.parent;

        current.left = pivot.right;
        pivot.right = current;

        current.parent = pivot;

        if (pivot.parent != null){
            if (pivot.parent.left == current){
                pivot.parent.left = pivot;
            } else {
                pivot.parent.right = pivot;
            } 
        } else {
            this.root = pivot;
        }

        return pivot;
    }

    public void chamaMelhorRotacao(Node desbalanceado){
        Node pivot = desbalanceado;

        if (isLeftPending(pivot)){
            Node x = pivot.left;

            if (x.left != null){
                rotateRight(pivot);
            } else {
                rotateLeft(x);
                rotateRight(pivot);
            }
        } else {
            Node x = pivot.right;

            if (x.right != null){
                rotateLeft(pivot);
            } else {
                rotateRight(x);
                rotateLeft(pivot);
            }
        }
    }

    public void rebalance(Node current){
        int balanceFactor = balance(current);

        if (Math.abs(balanceFactor) > 1){
            chamaMelhorRotacao(current);
        }
    }

    /**
     * Busca o nó cujo valor é igual ao passado como parâmetro. Essa é a implementação 
     * iterativa clássica da busca binária em uma árvore binária de pesquisa.
     * @param element O elemento a ser procurado.
     * @return O nó contendo o elemento procurado. O método retorna null caso
     * o elemento não esteja presente na árvore.
     */
    public Node search(int element) {
        
        Node aux = this.root;
        
        while (aux != null) {   
            if (aux.value == element) return aux;
            if (element < aux.value) aux = aux.left;
            if (element > aux.value) aux = aux.right;
        }
        
        return null;

    }

    public boolean isEmpty() {
        return this.root == null;
    }
    
    /**
     * Implementação iterativa da adição de um elemento em uma árvore binária de pequisa.
     * @param element o valor a ser adicionado na árvore.
     */
    public void add(int element) {
        this.size += 1;
        if (isEmpty())
            this.root = new Node(element);
        else {
            
            Node aux = this.root;
            
            while (aux != null) {
                
                if (element < aux.value) {
                    if (aux.left == null) { 
                        Node newNode = new Node(element);
                        aux.left = newNode;
                        newNode.parent = aux;

                        Node desbalanceado = verificaDesbalanceamento(newNode);
                        if (desbalanceado != null){
                            chamaMelhorRotacao(desbalanceado);
                        }

                        return;
                    }
                    
                    aux = aux.left;
                } else {
                    if (aux.right == null) { 
                        Node newNode = new Node(element);
                        aux.right = newNode;
                        newNode.parent = aux;

                        Node desbalanceado = verificaDesbalanceamento(newNode);
                        if (desbalanceado != null){
                            chamaMelhorRotacao(desbalanceado);
                        }

                        return;
                    }
                    
                    aux = aux.right;
                }
            }
        }

    }
    
    
    /**
     * Retorna o nó que contém o valor máximo da árvore. Implementação recursiva.
     * @return o nó contendo o valor máximo da árvore ou null se a árvore estiver vazia.
     */
    public Node min() {
        if (isEmpty()) return null;
        return min(this.root);
    }
    
    /**
     * Retorna o nó que contém o valor máximo da árvore cuja raiz é passada como parâmetro. Implementação recursiva.
     * @param a raiz da árvore.
     * @return o nó contendo o valor máximo da árvore ou null se a árvore estiver vazia.
     */
    private Node min(Node node) {
        if (node.left == null) return node;
        else return min(node.left);
    }

    /**
     * Retorna o nó que contém o valor máximo da árvore. Implementação iterativa.
     * @return o nó contendo o valor máximo da árvore ou null se a árvore estiver vazia.
     */
    public Node max() {
        if (isEmpty()) return null;
        
        Node node = this.root;
        while(node.right != null)
            node = node.right;
        
        return node;
    }
    
    /**
     * Retorna o nó que contém o valor máximo da árvore cuja raiz é passada como parâmetro. Implementação recursiva.
     * @param raiz da árvore.
     * @return o nó contendo o valor máximo da árvore ou null se a árvore estiver vazia.
     */
    
    private Node max(Node node) {
        if (node.right == null) return node;
        else return max(node.right);
    }
    
    /**
     * Retorna o nó cujo valor é predecessor do valor passado como parâmetro. 
     * @param valor O nó para o qual deseja-se identificar o predecessor.
     * @return O nó contendo o predecessor do valor passado como parâmetro. O método retorna null caso não haja 
     * predecessor.
     */
    public Node predecessor(Node node) {
        if (node == null) return null;
        
        if (node.left != null)
            return max(node.left);
        else {
            Node aux = node.parent;
            
            while (aux != null && aux.value > node.value)
                aux = aux.parent;
            
            return aux;
        }
    }
    
    /**
     * Retorna o nó cujo valor é sucessor do valor passado como parâmetro. 
     * @param valor O valor para o qual deseja-se identificar o sucessor.
     * @return O nó contendo o sucessor do valor passado como parâmetro. O método retorna null
     * caso não haja sucessor.
     */
    public Node sucessor(Node node) {
        if (node == null) return null;
        
        if (node.right != null)
            return min(node.right);
        else {
            Node aux = node.parent;
            
            while (aux != null && aux.value < node.value)
                aux = aux.parent;
            
            return aux;
        }
    }
    
    
    /**
     * Implementação recursiva do método de adição.
     * @param element elemento a ser adicionado.
     */
    public void recursiveAdd(int element) {
        
        if (isEmpty())
            this.root = new Node(element);
        else {
            Node aux = this.root;
            recursiveAdd(aux, element);
        }
        this.size += 1;
        
    }

    /**
     * Método para auxiliar na implementação recursiva do método de adição.
     * @param node a raíz da árvore.
     * @param element elemento a ser adicionado.
     */
    private void recursiveAdd(Node node, int element) {
        
        if (element < node.value) {
            if (node.left == null) {
                Node newNode = new Node(element);
                node.left = newNode;
                newNode.parent = node;

                rebalance(node);

                return;
            }
            recursiveAdd(node.left, element);
            rebalance(node);

        } else {
            if (node.right == null) {
                Node newNode = new Node(element);
                node.right = newNode;
                newNode.parent = node;

                rebalance(node);

                return;
            }
            recursiveAdd(node.right, element);
            rebalance(node);
        }
        
    }
    
    /**
     * Remove the node with the value.
     * @param value
     */
    public void remove(int value) {
        Node toRemove = search(value);
        if (toRemove != null) {
            remove(toRemove);
            this.size -= 1;
        }
        
    }
    
    /**
     * Remove node. Private method to control recursion.
     * @param toRemove
     */
    private void remove(Node toRemove) {
        
        // First case: node is leaf.
        if (toRemove.isLeaf()) {
            if (toRemove == this.root)
                this.root = null;
            else {
                if (toRemove.value < toRemove.parent.value)
                    toRemove.parent.left = null;
                else
                    toRemove.parent.right = null;
            }
        
        // Second case: node has only left child or only right child
        } else if (toRemove.hasOnlyLeftChild()) {
            if (toRemove == this.root)  {
                this.root = toRemove.left;
                this.root.parent = null;
            } else {
                toRemove.left.parent = toRemove.parent;
                if (toRemove.value < toRemove.parent.value)
                    toRemove.parent.left = toRemove.left;
                else
                    toRemove.parent.right = toRemove.left;
            }
        } else if (toRemove.hasOnlyRightChild()) {
            if (toRemove == this.root) {
                this.root = toRemove.right;
                this.root.parent = null;
            } else {
                toRemove.right.parent = toRemove.parent;
                if (toRemove.value < toRemove.parent.value)
                    toRemove.parent.left = toRemove.right;
                else
                    toRemove.parent.right = toRemove.right;
            }
            
        // Third case: node has two children
        } else {
            Node sucessor = sucessor(toRemove);
            toRemove.value = sucessor.value;
            remove(sucessor);
        }
            
    }

    
    
    /**
     * Busca o nó cujo valor é igual ao passado como parâmetro. Essa é a implementação 
     * recursiva clássica da busca binária em uma árvore binária de pesquisa.
     * @param element O elemento a ser procurado.
     * @return O nó contendo o elemento procurado. O método retorna null caso
     * o elemento não esteja presente na árvore.
     */
    public Node recursiveSearch(int element) {
        return recursiveSearch(this.root, element);
    }
    
    /**
     * Busca o nó cujo valor é igual ao passado como parâmetro na sub-árvore cuja raiz é node. Trata-se de um método auxiliar
     * para a busca recursiva.
     * @param node a raiz da árvore.
     * @param element O elemento a ser procurado.
     * @return O nó contendo o elemento procurado. O método retorna null caso
     * o elemento não esteja presente na árvore.
     */
    private Node recursiveSearch(Node node, int element) {
        if (node == null) return null;
        if (element == node.value) return node;
        if (element < node.value) return recursiveSearch(node.left, element);
        else return recursiveSearch(node.right, element);
    }

    /**
     * Percorre a árvore em pré-ordem.
     */
    public void preOrder() {
        preOrder(this.root);
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.value);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * Percorre a árvore em-ordem.
     */
    public void inOrder() {
        inOrder(this.root);
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.value);
            inOrder(node.right);
        }
        
    }

    /**
     * Percorre a árvore em pos-ordem.
     */
    public void posOrder() {
        posOrder(this.root);
    }

    private void posOrder(Node node) {
        if (node != null) {
            posOrder(node.left);
            posOrder(node.right);
            System.out.println(node.value);
        }
        
    }
    
    /**
     * Percorre a árvore em largura. 
     * @return Uma lista com a os elementos percorridos em largura.
     */
    public ArrayList<Integer> bfs() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Deque<Node> queue = new LinkedList<Node>();
        
        if (!isEmpty()) {
            queue.addLast(this.root);
            while (!queue.isEmpty()) {
                Node current = queue.removeFirst();
                
                list.add(current.value);
                
                if(current.left != null) 
                    queue.addLast(current.left);
                if(current.right != null) 
                    queue.addLast(current.right);   
            }
        }
        return list;
    }

    /**
     * @return o tamanho da árvore.
     */
    public int size() {
        return this.size;
    }
    
}


class Node {
    
    int value;
    Node left;
    Node right;
    Node parent;
    
    Node(int v) {
        this.value = v;
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }

    public Node getParent() {
        return this.parent;
    }

    public boolean hasOnlyLeftChild() {
        return (this.left != null && this.right == null);
    }
    
    public boolean hasOnlyRightChild() {
        return (this.left == null && this.right != null);
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }
    
}
